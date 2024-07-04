create or replace function modify_constraints(in_table_list varchar[], in_option varchar)returns void as
$$
declare
    r record;
begin
    --         execute immediate 'alter session set ddl_lock_timeout = 30';

    for r in (
        select 'alter table ' || relname || ' ' || in_option || ' trigger all ' as cmd
        from pdd_constrant
        where
--             nspname = 'db_configuration_manager'          and
              conname = ANY ( in_table_list)
    )
        loop
            perform exec_immediate(r.cmd);
        null ;
        end loop;
    return ;
end;
$$ language plpgsql
/
