insert into flink_property_by_stand(service_id, profile_id, stand, prop_id, prop_value)
select 'service_id_1', 'profile_id_1', 'DSO', 'flink_property_prop_id_1', 'prop_value_1' from dual union
select 'service_id_2', 'profile_id_2', 'DSO', 'flink_property_prop_id_2', 'prop_value_2' from dual
/
insert into kafka_property_by_sevice(service_id, profile_id, stand, prop_id, type_prop, env_prop_name, property_val)
select 'service_id_1', 'profile_id_1', 'DSO', 'kafka_property_prop_id_1', 'type_prop', 'kafka_property_env_prop_name_1', 'property_val_1' from dual union
select 'service_id_2', 'profile_id_2', 'DSO', 'kafka_property_prop_id_2', 'type_prop', 'kafka_property_env_prop_name_2', 'property_val_2' from dual
/
insert into service_topic_name_by_stand(graph_id, service_id, profile_id, stand, prop_id, prop_value)
select 'graph_id', 'service_id_1', 'profile_id_1', 'DSO', 'service_topic_name_prop_id_1', 'prop_value_1' from dual union
select 'graph_id', 'service_id_2', 'profile_id_2', 'DSO', 'service_topic_name_prop_id_2', 'prop_value_2' from dual
/
