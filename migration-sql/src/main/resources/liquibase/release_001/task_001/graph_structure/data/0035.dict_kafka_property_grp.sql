insert into dict_kafka_property_grp(ID, TYPE_READ, DESCRIPTION)
SELECT 'consumer_default', 'cns', 'Загрузка всех сообщений топика' from DUAL union
SELECT 'latest', 'cns', 'загрузка сообщений начиная с офсета, который запомнила кафка' from DUAL union
SELECT 'producer_default', 'prd', 'Самый простой и минималистичный продюсер' from DUAL
/