DO $$
begin


INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.truststore.password', '${DSO_KAFKA_SSL_TRUSTSTORE_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.truststore.location', '${TRUSTSTORE_LOCATION}');
INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.keystore.password', '${DSO_KAFKA_SSL_KEYSTORE_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.keystore.location', '${KEYSTORE_LOCATION} ');
INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.key.password', '${DSO_KAFKA_SSL_KEY_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'security.protocol', 'SSL');
INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'bootstrap.servers', '${BOOTSTRAP_SERVERS}');

INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'bootstrap.servers', '${BOOTSTRAP_SERVERS}');
INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'security.protocol', 'SSL');
INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.key.password', '${DSO_KAFKA_SSL_KEY_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.keystore.location', '${KEYSTORE_LOCATION} ');
INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.keystore.password', '${DSO_KAFKA_SSL_KEYSTORE_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.truststore.location', '${TRUSTSTORE_LOCATION}');
INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.truststore.password', '${DSO_KAFKA_SSL_TRUSTSTORE_PASSWORD}');

INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'auto.offset.reset', 'earliest');
-- INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'check.crcs', 'true');
-- INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'connections.max.idle.ms', '540000');
-- INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'enable.auto.commit', 'true');
-- INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'exclude.internal.topics', 'true');
-- INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'fetch.max.bytes', '52428800');
-- INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'fetch.max.wait.ms', '500');
INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'fetch.min.bytes', '50');

INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'isolation.level', 'read_uncommitted');
INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.truststore.type', 'PKCS12');
INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.keystore.type', 'PKCS12');
INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'session.timeout.ms', '72000000');

-- INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'group.id', '${PROFILE}');
-- INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'heartbeat.interval.ms', '3000');

-- INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'acks', 'all');
-- INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'enable.idempotence', 'true');
-- INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'max.block.ms', '90000');
-- INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'retries', '1');
INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'transaction.timeout.ms', '30000');
INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'transactional.id', '${PROFILE}');
INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.truststore.type', 'PKCS12');
INSERT INTO DICT_KAFKA_PROP_VALUE (GRP_ID, TYPE_PROP, PROP_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.keystore.type', 'PKCS12');



INSERT INTO dict_kafka_prop_value (grp_id, type_prop, prop_id, prop_value) VALUES ('latest', 'cns', 'auto.offset.reset', 'earliest');
INSERT INTO dict_kafka_prop_value (grp_id, type_prop, prop_id, prop_value) VALUES ('latest', 'cns', 'bootstrap.servers', '${BOOTSTRAP_SERVERS}');
INSERT INTO dict_kafka_prop_value (grp_id, type_prop, prop_id, prop_value) VALUES ('latest', 'cns', 'fetch.min.bytes', '50');
INSERT INTO dict_kafka_prop_value (grp_id, type_prop, prop_id, prop_value) VALUES ('latest', 'cns', 'isolation.level', 'read_uncommitted');
INSERT INTO dict_kafka_prop_value (grp_id, type_prop, prop_id, prop_value) VALUES ('latest', 'cns', 'security.protocol', 'SSL');
INSERT INTO dict_kafka_prop_value (grp_id, type_prop, prop_id, prop_value) VALUES ('latest', 'cns', 'session.timeout.ms', '72000000');
INSERT INTO dict_kafka_prop_value (grp_id, type_prop, prop_id, prop_value) VALUES ('latest', 'cns', 'ssl.key.password', '${DSO_KAFKA_SSL_KEY_PASSWORD}');
INSERT INTO dict_kafka_prop_value (grp_id, type_prop, prop_id, prop_value) VALUES ('latest', 'cns', 'ssl.keystore.location', '${KEYSTORE_LOCATION} ');
INSERT INTO dict_kafka_prop_value (grp_id, type_prop, prop_id, prop_value) VALUES ('latest', 'cns', 'ssl.keystore.password', '${DSO_KAFKA_SSL_KEYSTORE_PASSWORD}');
INSERT INTO dict_kafka_prop_value (grp_id, type_prop, prop_id, prop_value) VALUES ('latest', 'cns', 'ssl.keystore.type', 'PKCS12');
INSERT INTO dict_kafka_prop_value (grp_id, type_prop, prop_id, prop_value) VALUES ('latest', 'cns', 'ssl.truststore.location', '${TRUSTSTORE_LOCATION}');
INSERT INTO dict_kafka_prop_value (grp_id, type_prop, prop_id, prop_value) VALUES ('latest', 'cns', 'ssl.truststore.password', '${DSO_KAFKA_SSL_TRUSTSTORE_PASSWORD}');
INSERT INTO dict_kafka_prop_value (grp_id, type_prop, prop_id, prop_value) VALUES ('latest', 'cns', 'ssl.truststore.type', 'PKCS12');
end;
$$;
/

commit
/