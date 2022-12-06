create or replace view rep_topic_name_by_stand
as
with t as (
select tn.id topic_id,
       coalesce(DTPBS.STAND_ID, st.ID) as STAND,
       coalesce(DTPBS.TOPIC_NAME, replace(tn.id, 'dev_', st.REPLACMENT_FOR_TOPIC_NAME))  topic_name,
       tn.retention,
       tn.cleanup_policy,
       coalesce(DTPBS.cnt_partition, st.cnt_partition) as cnt_partition
FROM DICT_TOPIC_NODE tn
   cross join META_STAND st
   left join DICT_TOPIC_PARAMS_BY_STAND DTPBS on tn.ID = DTPBS.NODE_ID and st.ID = DTPBS.STAND_ID
)
select t.topic_id, t.topic_name, t.stand, tu.USED, t.retention, t.cleanup_policy, t.cnt_partition
from t
  join rep_topic_use tu on tu.TOPIC_ID = t.topic_id

/
comment on view rep_topic_name_by_stand is 'Имена топиков в разрезе стендов.'
/
comment on column rep_topic_name_by_stand.topic_id is 'Идентификатор графа.'
/
comment on column rep_topic_name_by_stand.stand is 'Тип стенда.'
/
comment on column rep_topic_name_by_stand.topic_name is 'Имя топика.'
/
comment on column rep_topic_name_by_stand.USED is 'Признак используемого.'
/
comment on column rep_topic_name_by_stand.retention is 'retention.'
/
comment on column rep_topic_name_by_stand.cleanup_policy is 'политика очистки.'
/
comment on column rep_topic_name_by_stand.cnt_partition is 'кол-во партиций.'
/
