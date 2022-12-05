DO $$
begin

INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.key.password', 'DSO', '${DSO_KAFKA_SSL_KEY_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.key.password', 'IFT', '${IFT_KAFKA_SSL_KEY_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.key.password', 'NOTEBOOK', 'kafkauasppassword');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.key.password', 'NOTEBOOK_DSO', 'kafkauasppassword');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.key.password', 'NT', '${NT_KAFKA_SSL_KEY_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.key.password', 'P0', '${P0_KAFKA_SSL_KEY_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.key.password', 'REAL', '${REAL_KAFKA_SSL_KEY_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.keystore.location', 'NOTEBOOK', 'C:\\Work\\secret\\kafka-trust.pfx');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.keystore.location', 'NOTEBOOK_DSO', 'C:\\Work\\secret\\kafka-trust.pfx');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.keystore.password', 'DSO', '${DSO_KAFKA_SSL_KEYSTORE_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.keystore.password', 'IFT', '${IFT_KAFKA_SSL_KEYSTORE_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.keystore.password', 'NOTEBOOK', 'kafkauasppassword');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.keystore.password', 'NOTEBOOK_DSO', 'kafkauasppassword');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.keystore.password', 'NT', '${NT_KAFKA_SSL_KEYSTORE_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.keystore.password', 'P0', '${P0_KAFKA_SSL_KEYSTORE_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.keystore.password', 'REAL', '${REAL_KAFKA_SSL_KEYSTORE_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.truststore.location', 'NOTEBOOK', 'C:\\Work\\secret\\APD00.13.01-USBP-kafka-cluster-uasp.pfx');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.truststore.location', 'NOTEBOOK_DSO', 'C:\\Work\\secret\\APD00.13.01-USBP-kafka-cluster-uasp.pfx');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.truststore.password', 'DSO', '${DSO_KAFKA_SSL_TRUSTSTORE_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.truststore.password', 'IFT', '${IFT_KAFKA_SSL_TRUSTSTORE_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.truststore.password', 'NOTEBOOK', 'kafkauasppassword');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.truststore.password', 'NOTEBOOK_DSO', 'kafkauasppassword');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.truststore.password', 'NT', '${NT_KAFKA_SSL_TRUSTSTORE_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.truststore.password', 'P0', '${P0_KAFKA_SSL_TRUSTSTORE_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('consumer_default', 'cns', 'ssl.truststore.password', 'REAL', '${REAL_KAFKA_SSL_TRUSTSTORE_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.key.password', 'DSO', '${DSO_KAFKA_SSL_KEY_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.key.password', 'IFT', '${IFT_KAFKA_SSL_KEY_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.key.password', 'NOTEBOOK', 'kafkauasppassword');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.key.password', 'NOTEBOOK_DSO', 'kafkauasppassword');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.key.password', 'NT', '${NT_KAFKA_SSL_KEY_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.key.password', 'P0', '${P0_KAFKA_SSL_KEY_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.key.password', 'REAL', '${REAL_KAFKA_SSL_KEY_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.keystore.location', 'NOTEBOOK', 'C:\\Work\\secret\\kafka-trust.pfx');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.keystore.location', 'NOTEBOOK_DSO', 'C:\\Work\\secret\\kafka-trust.pfx');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.keystore.password', 'DSO', '${DSO_KAFKA_SSL_KEYSTORE_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.keystore.password', 'IFT', '${IFT_KAFKA_SSL_KEYSTORE_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.keystore.password', 'NOTEBOOK', 'kafkauasppassword');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.keystore.password', 'NOTEBOOK_DSO', 'kafkauasppassword');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.keystore.password', 'NT', '${NT_KAFKA_SSL_KEYSTORE_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.keystore.password', 'P0', '${P0_KAFKA_SSL_KEYSTORE_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.keystore.password', 'REAL', '${REAL_KAFKA_SSL_KEYSTORE_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.truststore.location', 'NOTEBOOK', 'C:\\Work\\secret\\APD00.13.01-USBP-kafka-cluster-uasp.pfx');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.truststore.location', 'NOTEBOOK_DSO', 'C:\\Work\\secret\\APD00.13.01-USBP-kafka-cluster-uasp.pfx');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.truststore.password', 'DSO', '${DSO_KAFKA_SSL_TRUSTSTORE_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.truststore.password', 'IFT', '${IFT_KAFKA_SSL_TRUSTSTORE_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.truststore.password', 'NOTEBOOK', 'kafkauasppassword');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.truststore.password', 'NOTEBOOK_DSO', 'kafkauasppassword');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.truststore.password', 'NT', '${NT_KAFKA_SSL_TRUSTSTORE_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.truststore.password', 'P0', '${P0_KAFKA_SSL_TRUSTSTORE_PASSWORD}');
INSERT INTO DICT_KAFKA_PROP_VALUE_BY_STAND (GRP_ID, TYPE_PROP, PROP_ID, STAND_ID, PROP_VALUE) VALUES ('producer_default', 'prd', 'ssl.truststore.password', 'REAL', '${REAL_KAFKA_SSL_TRUSTSTORE_PASSWORD}');
end;
$$;
/

commit
/