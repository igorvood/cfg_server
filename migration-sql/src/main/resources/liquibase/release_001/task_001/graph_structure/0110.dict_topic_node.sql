create table dict_topic_node
(
  id varchar(512) not null,
  constraint dict_topic_node_pk primary key (id),
  node_type varchar(256) generated always as ('topic') stored,
  constraint dict_topic_node_node_type_fk foreign key (node_type, id) references dict_abstract_graph_node(node_type, NODE_ID) on delete cascade,
  is_our numeric(1) default 1 not null,
  constraint dict_topic_node_is_our_ck check ( is_our in (0, 1) ),
  producer_prop_grp varchar(256),
  producer_prop_grp_ref varchar(256) generated always as (
    case when producer_prop_grp is null
      then 'producer_default'
      else producer_prop_grp
    end
  ) stored,
  prd_type varchar(256) generated always as ('prd') stored,
  constraint dict_topic_node_producer_fk foreign key (prd_type, producer_prop_grp_ref) references dict_kafka_property_grp(type_read, id),
  consumer_prop_grp varchar(256),
  consumer_prop_grp_ref varchar(256) generated always as (
    case when consumer_prop_grp is null
      then 'consumer_default'
      else consumer_prop_grp
    end
  ) stored not null ,
  cns_type varchar(256) generated always as ('cns') stored,
  constraint dict_topic_node_consumer_fk foreign key (cns_type, consumer_prop_grp_ref) references dict_kafka_property_grp(type_read, id),
  topic_owner_id varchar(256) not null,
  constraint dict_topic_node_topic_owner_id_fk foreign key (topic_owner_id) references dict_topic_owner(id),
  cleanup_policy varchar(16) not null default 'delete',
  constraint dict_topic_node_cleanup_policy_ck check ( cleanup_policy in ('compact', 'delete') ),
  retention numeric default 14400000,
  constraint dict_topic_node_retention_ck check (
      (cleanup_policy = 'compact' and retention is null)
      or (cleanup_policy = 'delete' and retention>0 )
  )
)
/
comment on table dict_topic_node is 'Справочник групп настроек для консьюмера топиков.'
/
comment on column dict_topic_node.node_type is 'Тип ноды.'
/
comment on column dict_topic_node.id is 'Идентификатор топика.'
/
comment on column dict_topic_node.is_our is 'Признак топика принадлежащего комманде.'
/
comment on column dict_topic_node.PRODUCER_PROP_GRP is 'Группа настроек продьюссера, заполнять только в случае отличия от дефолтной.'
/
comment on column dict_topic_node.PRODUCER_PROP_GRP_REF is 'Группа настроек продьюссера.'
/
comment on column dict_topic_node.CONSUMER_PROP_GRP is 'Группа настроек консьмера, заполнять только в случае отличия от дефолтной.'
/
comment on column dict_topic_node.CONSUMER_PROP_GRP_REF is 'Группа настроек консьмера.'
/
comment on column dict_topic_node.cns_type is 'Признак продьюсера.'
/
comment on column dict_topic_node.prd_type is 'Признак косьюмера.'
/

