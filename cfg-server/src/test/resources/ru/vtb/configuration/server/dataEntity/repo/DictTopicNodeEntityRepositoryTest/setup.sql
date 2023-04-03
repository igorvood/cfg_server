select backup_table(array [relname::varchar]) from  pdd_all_tables
where relkind_full='table' and relname not like 'tst%' and relname not in ('databasechangelog', 'databasechangeloglock', 'dual')
/