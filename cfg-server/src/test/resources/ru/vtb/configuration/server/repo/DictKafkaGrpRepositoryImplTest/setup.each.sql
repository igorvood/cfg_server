insert into dict_kafka_property_grp(id, type_read, description)
select 'test_id_1', 'prd', 'description_1' from dual union
select 'test_id_2', 'cns', 'description_2' from dual
/