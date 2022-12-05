create or replace view pdd_columns as
SELECT
    column_name,
    ordinal_position,
    data_type,
    udt_name,
    is_nullable,
    column_default,
    character_maximum_length,
    numeric_precision,
    numeric_precision_radix,
    datetime_precision,
    interval_precision,
    interval_type,
    is_generated,
    generation_expression,
    is_updatable
FROM
    information_schema.columns
where table_name='dict_topic_node'
/