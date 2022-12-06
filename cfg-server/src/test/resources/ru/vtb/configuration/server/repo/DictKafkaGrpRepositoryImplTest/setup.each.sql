insert into dict_kafka_property_grp(id, type_read, description)
select 'test_id_1', 'prd', 'description_1' from dual union
select 'test_id_2', 'cns', 'description_2' from dual
/
insert into dict_kafka_prop_value(grp_id, type_prop, prop_id, prop_value)
SELECT 'test_id_1', 'prd', 'retries', '1' from dual union
SELECT 'test_id_2', 'cns', 'connections.max.idle.ms', '100' from dual
/