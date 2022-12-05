create or replace function restore_tables() returns void as
$$
declare
    rt record;
begin
--     execute immediate 'alter session set ddl_lock_timeout = 30';
    for rt in (
        select t.name                                                            object_name
             , STRING_AGG(tc.column_name, ', ')  list_columns
             , back.name                                                         backup_name
        from pdd_tables t
                 join tst_backedup_table_cache c on c.original_name = t.name
                 left join pdd_tables back on back.name = lower(c.backup_name)
                 join information_schema.columns tc
                      on tc.table_name = t.name and tc.is_generated != 'ALWAYS'
        group by t.name, back.name
    )
        loop
--             dbms_output.put_line('restore_table ->' || rt.object_name);
            if rt.backup_name is not null then
                perform disable_constraints(array [rt.object_name]);
                perform exec_immediate('delete ' || rt.object_name);
                perform exec_immediate('insert into jp.' || rt.object_name || '(' || rt.list_columns || ')
                             select ' || rt.list_columns || ' from jp.' || rt.backup_name);
                perform exec_immediate( 'drop table jp.' || rt.backup_name || ' purge');
            end if;
            delete from tst_backedup_table_cache c where c.original_name = rt.object_name;
        end loop;
    perform enable_constraints();
end;
$$ language plpgsql
/
