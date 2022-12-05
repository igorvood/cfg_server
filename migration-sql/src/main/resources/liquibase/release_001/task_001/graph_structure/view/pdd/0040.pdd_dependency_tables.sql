with cons as
(select distinct table_schema, table_name, constraint_type, constraint_name, reference_table from pdd_constrant_column
where constraint_type = 'f'),
all_tables as (
select *
)
cons_with_parent as
(select p.table_schema, ch.table_name parent_table,  p.reference_table child_table, ch.constraint_name  from cons p
    left join cons ch on p.table_name = ch.reference_table
)



select *
from cons_with_parent;