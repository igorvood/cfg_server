DO $$


    begin
INSERT INTO DICT_FLINK_PROP_VALUE (SERVICE_ID, PROFILE_ID, PROP_ID, PROP_VALUE, IS_FUNCTION)

select 'uasp-streaming-input-convertor', 'input-convertor-w4-operation', 'instance.conf.name', 'way4', 0 from dual union
select 'uasp-streaming-input-convertor', 'input-convertor-w4-operation', 'way4.message.json.path', 'payload', 0 from dual union
select 'uasp-streaming-input-convertor', 'input-convertor-w4-operation', 'way4.message.jsonschema.field', 'contentType', 0 from dual union
select 'uasp-streaming-input-convertor', 'input-convertor-w4-operation', 'way4.read.source.topic.frombeginning', 'n', 0 from dual union
select 'uasp-streaming-input-convertor', 'input-convertor-w4-operation', 'way4.schema.name', 'issuing-operation', 0 from dual union
select 'uasp-streaming-input-convertor', 'input-convertor-w4-operation', 'way4.schema.start.version', '2.3', 0 from dual union
select 'uasp-streaming-input-convertor', 'input-convertor-w4-operation', 'way4.uaspdto.type', 'way4', 0 from dual union
select 'uasp-streaming-input-convertor', 'input-convertor-w4-operation', 'way4.use.avro.serialization', 'y', 0 from dual union


select 'uasp-kriaa-bevents-case-2', 'main', 'appStreamCheckpointTimeMilliseconds', '10000', 0 from dual union
select 'uasp-kriaa-bevents-case-2', 'main', 'savepoint.pref', 'case-2', 0 from dual union
select 'uasp-kriaa-bevents-case-2', 'main', 'service.name', '${PROFILE_NAME}_${SERVICE_NAME}_${SERVICE_VERSION}', 0 from dual union
select 'uasp-kriaa-bevents-case-2', 'main', 'stateCheckpointsNumRetained', '8', 0 from dual union
select 'uasp-kriaa-bevents-case-2', 'main', 'streamCheckpointTimeoutMilliseconds', '600000', 0 from dual union
select 'uasp-kriaa-bevents-case-2', 'main', 'sync.parallelism', '${PARALLELISM}', 0 from dual union
select 'uasp-kriaa-bevents-case-40', 'main', 'appStreamCheckpointTimeMilliseconds', '10000', 0 from dual union
select 'uasp-kriaa-bevents-case-40', 'main', 'savepoint.pref', 'case-40', 0 from dual union
select 'uasp-kriaa-bevents-case-40', 'main', 'service.name', '${PROFILE_NAME}_${SERVICE_NAME}_${SERVICE_VERSION}', 0 from dual union
select 'uasp-kriaa-bevents-case-40', 'main', 'stateCheckpointsNumRetained', '8', 0 from dual union
select 'uasp-kriaa-bevents-case-40', 'main', 'streamCheckpointTimeoutMilliseconds', '600000', 0 from dual union
select 'uasp-kriaa-bevents-case-40', 'main', 'sync.parallelism', '${PARALLELISM}', 0 from dual union
select 'uasp-kriaa-bevents-case-68', 'main', 'appStreamCheckpointTimeMilliseconds', '10000', 0 from dual union
select 'uasp-kriaa-bevents-case-68', 'main', 'savepoint.pref', 'case-68', 0 from dual union
select 'uasp-kriaa-bevents-case-68', 'main', 'service.name', '${PROFILE_NAME}_${SERVICE_NAME}_${SERVICE_VERSION}', 0 from dual union
select 'uasp-kriaa-bevents-case-68', 'main', 'stateCheckpointsNumRetained', '8', 0 from dual union
select 'uasp-kriaa-bevents-case-68', 'main', 'streamCheckpointTimeoutMilliseconds', '600000', 0 from dual union
select 'uasp-kriaa-bevents-case-68', 'main', 'sync.parallelism', '${PARALLELISM}', 0 from dual union


select 'uasp-streaming-mdm-enrichment', 'way4', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.fromFieldName', 'is_mortgage', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'way4', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.fromFieldType', 'Boolean', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'way4', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.isOptionalEnrichValue', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'way4', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.toFieldName', 'is_mortgage', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'way4', 'enrichOne.CommonEnrichProperty$.inputDataFormat', 'UaspDtoFormat', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'way4', 'enrichOne.CommonEnrichProperty$.keySelectorEnrich.isId', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'way4', 'enrichOne.CommonEnrichProperty$.keySelectorMain.isId', 'true', 0 from dual union

select 'uasp-streaming-mdm-enrichment', 'way4', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.fromFieldName', 'global_id', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'way4', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.fromFieldType', 'String', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'way4', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.isOptionalEnrichValue', 'false', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'way4', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.toFieldName', 'calculate-mdm_id', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'way4', 'enrichOne.GlobalIdEnrichProperty$.inputDataFormat', 'UaspDtoFormat', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'way4', 'enrichOne.GlobalIdEnrichProperty$.keySelectorEnrich.isId', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'way4', 'enrichOne.GlobalIdEnrichProperty$.keySelectorMain.isId', 'true', 0 from dual union

select 'uasp-streaming-mdm-enrichment', 'way4', 'savepoint.pref', 'mdm_enrichment', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'way4', 'service.name', '${PROFILE_NAME}_${SERVICE_NAME}_${SERVICE_VERSION}', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'way4', 'sync.parallelism', '${PARALLELISM}', 0 from dual union

select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a01.fromFieldName','mask_card_number',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a01.fromFieldType','String',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a01.isOptionalEnrichValue','true',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a01.toFieldName','MASK_CARD_NUMBER',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a02.fromFieldName','customer_id',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a02.fromFieldType','String',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a02.isOptionalEnrichValue','true',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a02.toFieldName','customer_id',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a03.fromFieldName','source_system_cd',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a03.fromFieldType','String',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a03.isOptionalEnrichValue','true',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a03.toFieldName','source_system_cd',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a04.fromFieldName','pos_flg',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a04.fromFieldType','String',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a04.isOptionalEnrichValue','true',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a04.toFieldName','pos_flg',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a05.fromFieldName','account_num',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a05.fromFieldType','String',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a05.isOptionalEnrichValue','true',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a05.toFieldName','account_num',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a06.fromFieldName','is_virtual_card_flg',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a06.fromFieldType','String',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a06.isOptionalEnrichValue','true',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a06.toFieldName','is_virtual_card_flg',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a07.fromFieldName','card_expiration_dt',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a07.fromFieldType','String',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a07.isOptionalEnrichValue','true',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a07.toFieldName','card_expiration_dt',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a08.fromFieldName','payment_system_desc',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a08.fromFieldType','String',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a08.isOptionalEnrichValue','true',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a08.toFieldName','payment_system_desc',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a09.fromFieldName','card_type_cd',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a09.fromFieldType','String',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a09.isOptionalEnrichValue','true',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a09.toFieldName','card_type_cd',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a10.fromFieldName','salary_serv_pack_flg',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a10.fromFieldType','String',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a10.isOptionalEnrichValue','true',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a10.toFieldName','salary_serv_pack_flg',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a11.fromFieldName','salary_project_flg',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a11.fromFieldType','String',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a11.isOptionalEnrichValue','true',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a11.toFieldName','salary_project_flg',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a12.fromFieldName','salary_account_scheme_flg',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a12.fromFieldType','String',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a12.isOptionalEnrichValue','true',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a12.toFieldName','salary_account_scheme_flg',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a13.fromFieldName','salary_card_type_flg',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a13.fromFieldType','String',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a13.isOptionalEnrichValue','true',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a13.toFieldName','salary_card_type_flg',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a14.fromFieldName','contract_card_type_cd',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a14.fromFieldType','String',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a14.isOptionalEnrichValue','true',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a14.toFieldName','contract_card_type_cd',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a15.fromFieldName','hash_card_number',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a15.fromFieldType','String',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a15.isOptionalEnrichValue','true',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.fieldsList.a15.toFieldName','hash_card_number',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.inputDataFormat','UaspDtoFormat',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.keySelectorEnrich.isId','false',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.keySelectorEnrich.mapKey','customer_id_and_masked_card_number',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.keySelectorEnrich.mapType','String',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.keySelectorMain.isId','false',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.keySelectorMain.mapKey','customer_id_and_masked_card_number',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','enrichOne.CommonEnrichProperty$.keySelectorMain.mapType','String',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','savepoint.pref','mdm_enrichment',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','service.name','${PROFILE_NAME}_${SERVICE_NAME}_${SERVICE_VERSION}',0 from dual union
select 'uasp-streaming-mdm-enrichment','way4-card-agreement','sync.parallelism','${PARALLELISM}',0 from dual union


select 'uasp-streaming-mdm-enrichment', 'case-68', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.fromFieldName', 'CrtXzFdTpCd', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'case-68', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.fromFieldType', 'String', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'case-68', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.isOptionalEnrichValue', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'case-68', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.toFieldName', 'CrtXzFdTpCd', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'case-68', 'enrichOne.CommonEnrichProperty$.fieldsList.a2.fromFieldName', 'CrtXzKkTpCd', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'case-68', 'enrichOne.CommonEnrichProperty$.fieldsList.a2.fromFieldType', 'Int', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'case-68', 'enrichOne.CommonEnrichProperty$.fieldsList.a2.isOptionalEnrichValue', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'case-68', 'enrichOne.CommonEnrichProperty$.fieldsList.a2.toFieldName', 'CrtXzKkTpCd', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'case-68', 'enrichOne.CommonEnrichProperty$.fieldsList.a3.fromFieldName', 'ZpBs144Flg', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'case-68', 'enrichOne.CommonEnrichProperty$.fieldsList.a3.fromFieldType', 'Boolean', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'case-68', 'enrichOne.CommonEnrichProperty$.fieldsList.a3.isOptionalEnrichValue', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'case-68', 'enrichOne.CommonEnrichProperty$.fieldsList.a3.toFieldName', 'ZpBs144Flg', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'case-68', 'enrichOne.CommonEnrichProperty$.keySelectorEnrich.isId', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'case-68', 'enrichOne.CommonEnrichProperty$.keySelectorMain.isId', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'case-68', 'enrichOne.CommonEnrichProperty$.inputDataFormat', 'UaspDtoFormat', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'case-68', 'savepoint.pref', 'mdm_enrichment', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'case-68', 'service.name', '${PROFILE_NAME}_${SERVICE_NAME}_${SERVICE_VERSION}', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'case-68', 'sync.parallelism', '${PARALLELISM}', 0 from dual union

select 'uasp-streaming-mdm-enrichment', 'case-68_agrement', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.fromFieldName', 'card_type_cd', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'case-68_agrement', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.fromFieldType', 'String', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'case-68_agrement', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.isOptionalEnrichValue', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'case-68_agrement', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.toFieldName', 'card_type_cd', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'case-68_agrement', 'enrichOne.CommonEnrichProperty$.keySelectorEnrich.isId', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'case-68_agrement', 'enrichOne.CommonEnrichProperty$.keySelectorMain.isId', 'false', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'case-68_agrement', 'enrichOne.CommonEnrichProperty$.keySelectorMain.mapKey', 'hash_card_number', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'case-68_agrement', 'enrichOne.CommonEnrichProperty$.keySelectorMain.mapType', 'String', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'case-68_agrement', 'enrichOne.CommonEnrichProperty$.inputDataFormat', 'UaspDtoFormat', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'case-68_agrement', 'savepoint.pref', 'mdm_enrichment', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'case-68_agrement', 'service.name', '${PROFILE_NAME}_${SERVICE_NAME}_${SERVICE_VERSION}', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'case-68_agrement', 'sync.parallelism', '${PARALLELISM}', 0 from dual union

select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a01.fromFieldName', 'mask_card_number', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a01.fromFieldType', 'String', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a01.isOptionalEnrichValue', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a01.toFieldName', 'MASK_CARD_NUMBER', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a02.fromFieldName', 'customer_id', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a02.fromFieldType', 'String', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a02.isOptionalEnrichValue', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a02.toFieldName', 'customer_id', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a03.fromFieldName', 'source_system_cd', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a03.fromFieldType', 'String', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a03.isOptionalEnrichValue', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a03.toFieldName', 'source_system_cd', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a04.fromFieldName', 'pos_flg', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a04.fromFieldType', 'String', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a04.isOptionalEnrichValue', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a04.toFieldName', 'pos_flg', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a05.fromFieldName', 'account_num', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a05.fromFieldType', 'String', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a05.isOptionalEnrichValue', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a05.toFieldName', 'account_num', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a06.fromFieldName', 'is_virtual_card_flg', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a06.fromFieldType', 'String', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a06.isOptionalEnrichValue', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a06.toFieldName', 'is_virtual_card_flg', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a07.fromFieldName', 'card_expiration_dt', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a07.fromFieldType', 'String', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a07.isOptionalEnrichValue', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a07.toFieldName', 'card_expiration_dt', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a08.fromFieldName', 'payment_system_desc', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a08.fromFieldType', 'String', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a08.isOptionalEnrichValue', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a08.toFieldName', 'payment_system_desc', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a09.fromFieldName', 'card_type_cd', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a09.fromFieldType', 'String', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a09.isOptionalEnrichValue', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a09.toFieldName', 'card_type_cd', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a10.fromFieldName', 'salary_serv_pack_flg', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a10.fromFieldType', 'String', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a10.isOptionalEnrichValue', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a10.toFieldName', 'salary_serv_pack_flg', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a11.fromFieldName', 'salary_project_flg', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a11.fromFieldType', 'String', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a11.isOptionalEnrichValue', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a11.toFieldName', 'salary_project_flg', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a12.fromFieldName', 'salary_account_scheme_flg', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a12.fromFieldType', 'String', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a12.isOptionalEnrichValue', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a12.toFieldName', 'salary_account_scheme_flg', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a13.fromFieldName', 'salary_card_type_flg', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a13.fromFieldType', 'String', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a13.isOptionalEnrichValue', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a13.toFieldName', 'salary_card_type_flg', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a14.fromFieldName', 'contract_card_type_cd', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a14.fromFieldType', 'String', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a14.isOptionalEnrichValue', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a14.toFieldName', 'contract_card_type_cd', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a15.fromFieldName', 'hash_card_number', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a15.fromFieldType', 'String', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a15.isOptionalEnrichValue', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a15.toFieldName', 'hash_card_number', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.fromFieldName', 'mdm_id', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.fromFieldType', 'String', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.isOptionalEnrichValue', 'false', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.toFieldName', 'calculate-mdm_id', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.keySelectorEnrich.isId', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.keySelectorMain.isId', 'false', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.keySelectorMain.mapKey', 'card_number_sha_256', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.keySelectorMain.mapType', 'String', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.inputDataFormat', 'UaspDtoFormat', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'savepoint.pref', 'mdm_enrichment', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'service.name', '${PROFILE_NAME}_${SERVICE_NAME}_${SERVICE_VERSION}', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth', 'sync.parallelism', '${PARALLELISM}', 0 from dual union

select 'uasp-streaming-mdm-enrichment', 'prof-auth-packNM', 'enrichOne.CommonEnrichProperty$.fieldsList.a01.fromFieldName', 'package_nm', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth-packNM', 'enrichOne.CommonEnrichProperty$.fieldsList.a01.fromFieldType', 'String', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth-packNM', 'enrichOne.CommonEnrichProperty$.fieldsList.a01.isOptionalEnrichValue', 'false', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth-packNM', 'enrichOne.CommonEnrichProperty$.fieldsList.a01.toFieldName', 'package_nm', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth-packNM', 'enrichOne.CommonEnrichProperty$.keySelectorEnrich.isId', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth-packNM', 'enrichOne.CommonEnrichProperty$.keySelectorMain.isId', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth-packNM', 'enrichOne.CommonEnrichProperty$.inputDataFormat', 'UaspDtoFormat', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth-packNM', 'savepoint.pref', 'mdm_enrichment', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth-packNM', 'service.name', '${PROFILE_NAME}_${SERVICE_NAME}_${SERVICE_VERSION}', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-auth-packNM', 'sync.parallelism', '${PARALLELISM}', 0 from dual union

select 'uasp-streaming-mdm-enrichment', 'profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a1.fromFieldName', 'contract_num', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a1.fromFieldType', 'String', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a1.isOptionalEnrichValue', 'false', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a1.toFieldName', 'contract_num', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.fromFieldName', 'customer_id', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.fromFieldType', 'String', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.isOptionalEnrichValue', 'false', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.toFieldName', 'calculate-customer_id', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.keySelectorEnrich.isId', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.keySelectorMain.isId', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.inputDataFormat', 'UaspDtoFormat', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'profile-tx-step1', 'savepoint.pref', 'mdm_enrichment', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'profile-tx-step1', 'service.name', '${PROFILE_NAME}_${SERVICE_NAME}_${SERVICE_VERSION}', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'profile-tx-step1', 'sync.parallelism', '${PARALLELISM}', 0 from dual union

select 'uasp-streaming-mdm-enrichment', 'profile-tx-step2', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.fromFieldName', 'global_id', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'profile-tx-step2', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.fromFieldType', 'String', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'profile-tx-step2', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.isOptionalEnrichValue', 'false', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'profile-tx-step2', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.toFieldName', 'calculate-mdm_id', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'profile-tx-step2', 'enrichOne.GlobalIdEnrichProperty$.keySelectorEnrich.isId', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'profile-tx-step2', 'enrichOne.GlobalIdEnrichProperty$.keySelectorMain.isId', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'profile-tx-step2', 'enrichOne.GlobalIdEnrichProperty$.inputDataFormat', 'UaspDtoFormat', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'profile-tx-step2', 'savepoint.pref', 'mdm_enrichment', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'profile-tx-step2', 'service.name', '${PROFILE_NAME}_${SERVICE_NAME}_${SERVICE_VERSION}', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'profile-tx-step2', 'sync.parallelism', '${PARALLELISM}', 0 from dual union

select 'uasp-streaming-mdm-enrichment', 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.fromFieldName', 'product_nm', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.fromFieldType', 'String', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.isOptionalEnrichValue', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.toFieldName', 'product_nm', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.fieldsList.a2.fromFieldName', 'product_rate', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.fieldsList.a2.fromFieldType', 'BigDecimal', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.fieldsList.a2.isOptionalEnrichValue', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.fieldsList.a2.toFieldName', 'product_rate', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.fieldsList.a3.fromFieldName', 'period', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.fieldsList.a3.fromFieldType', 'Int', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.fieldsList.a3.isOptionalEnrichValue', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.fieldsList.a3.toFieldName', 'period', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.keySelectorEnrich.isId', 'true', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.keySelectorMain.isId', 'false', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.keySelectorMain.mapKey', 'tcmt_account_num', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.keySelectorMain.mapType', 'String', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.inputDataFormat', 'UaspDtoFormat', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-tx-case-71', 'savepoint.pref', 'mdm_enrichment', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-tx-case-71', 'service.name', '${PROFILE_NAME}_${SERVICE_NAME}_${SERVICE_VERSION}', 0 from dual union
select 'uasp-streaming-mdm-enrichment', 'prof-tx-case-71', 'sync.parallelism', '${PARALLELISM}', 0 from dual;
                                                                                                             



end;
$$;
/
commit;
/