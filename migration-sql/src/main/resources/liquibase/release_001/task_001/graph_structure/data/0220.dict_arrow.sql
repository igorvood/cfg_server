DO $$
begin

INSERT INTO DICT_ARROW (GRAPH_ID, BEG_NODE_TYPE, BEG_NODE_ID, END_NODE_TYPE, END_NODE_ID, PROPERTY_KEY)
select 'graph_1', 'flink_srv', 'Additional_enrich~case_65', 'topic', 'mutator_consumer_2', 'some_key1' from DUAL union
select 'graph_1', 'flink_srv', 'Filter~case_65', 'topic', 'Filter_producer_1', 'some_key2' from DUAL union
select 'graph_1', 'flink_srv', 'Filter~case_65', 'topic', 'Filter_producer_2', 'some_key3' from DUAL union
select 'graph_1', 'flink_srv', 'Mutator~case_65', 'topic', 'dev_ivr__uasp_realtime__business_rules__uaspdto', 'some_key4' from DUAL union
select 'graph_1', 'flink_srv', 'Mutator~case_65', 'topic', 'ivr__uasp_realtime__bussiness_rules__uaspdto__dlq', 'some_key5' from DUAL union
select 'graph_1', 'topic', 'dev_ivr__uasp_realtime__business_rules__uaspdto', 'flink_srv', 'Filter~case_65', 'some_key6' from DUAL union
select 'graph_1', 'topic', 'ivr__uasp_realtime__bussiness_rules__uaspdto__dlq', 'flink_srv', 'Additional_enrich~case_65', 'some_key7' from DUAL union
select 'graph_1', 'topic', 'mutator_consumer_2', 'flink_srv', 'Mutator~case_65', 'some_key8' from DUAL union
select 'graph_1', 'topic', 'uasp_mutator_filter_input', 'flink_srv', 'Mutator~case_65', 'some_key9' from DUAL union
select 'graph_1', 'topic', 'uasp_mutator_filter_input_2', 'flink_srv', 'Mutator~case_65', 'some_key30' from DUAL union

select 'rto_graph', 'topic', 'dev_bevents_68_after_rate_enrich', 'flink_srv', 'uasp-kriaa-bevents-case-2~main', 'enrichOne.MainEnrichProperty$.fromTopic' from DUAL union
select 'rto_graph', 'topic', 'dev_bevents_68_after_rate_enrich', 'flink_srv', 'uasp-kriaa-bevents-case-40~main', 'enrichOne.MainEnrichProperty$.fromTopic' from DUAL union
select 'rto_graph', 'topic', 'dev_multibonus_partners_program', 'flink_srv', 'uasp-kriaa-bevents-case-40~main', 'multiBonus.MultiBonusEnrichProperty$.fromTopic' from DUAL union
select 'rto_graph', 'topic', 'dev_bevents_68_after_rate_enrich', 'flink_srv', 'uasp-kriaa-bevents-case-68~main', 'enrichOne.MainEnrichProperty$.fromTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-kriaa-bevents-case-40~main', 'topic', 'dev__rto_uasp__case_40__dlq', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-kriaa-bevents-case-40~main', 'topic', 'dev__rto_uasp__case_40', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-kriaa-bevents-case-68~main', 'topic', 'dev__rto_uasp__pks', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-kriaa-bevents-case-68~main', 'topic', 'dev_bevents_udds_mdm_rate_case68_uaspdto_dlq', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-kriaa-bevents-case-2~main', 'topic', 'dev__rto_uasp__case_2', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-kriaa-bevents-case-2~main', 'topic', 'dev__rto_uasp__case_2_dlq', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from DUAL union

select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~way4', 'topic', 'dev_ivr__uasp_realtime__input_converter__mortgage__dlq', 'enrichOne.CommonEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~way4', 'topic', 'dev_ivr__uasp_realtime__mdm_enrichment__mdm_cross_link__status__dlq', 'enrichOne.GlobalIdEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~way4', 'topic', 'dev_ivr__uasp_realtime__mdm_enrichment__for_additional_enrichment__uaspdto', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~way4', 'topic', 'dev_ivr__uasp_realtime_way4_mdm_enrichment__uaspdto', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from DUAL union

select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~way4-card-agreement', 'topic', 'dev_rto_batch_ca_customer_card_uaspdto__dlq', 'enrichOne.CommonEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~way4-card-agreement', 'topic', 'dev_bevents_card_agreement_enrich_way4_dlq', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~way4-card-agreement', 'topic', 'dev_bevents_card_agreement_enrich_out_uaspdto', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from DUAL union

select 'rto_graph', 'topic', 'dev_ivr__uasp_realtime__input_converter__mortgage__uaspdto', 'flink_srv', 'uasp-streaming-mdm-enrichment~way4', 'enrichOne.CommonEnrichProperty$.fromTopic' from DUAL union
select 'rto_graph', 'topic', 'dev_ivr__uasp_realtime__input_converter__mdm_cross_link__uaspdto', 'flink_srv', 'uasp-streaming-mdm-enrichment~way4', 'enrichOne.GlobalIdEnrichProperty$.fromTopic' from DUAL union
select 'rto_graph', 'topic', 'dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__uaspdto', 'flink_srv', 'uasp-streaming-mdm-enrichment~way4', 'enrichOne.MainEnrichProperty$.fromTopic' from DUAL union

select 'rto_graph', 'topic', 'dev__dko_uasp__card_agreement_converted', 'flink_srv', 'uasp-streaming-mdm-enrichment~way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fromTopic' from DUAL union
select 'rto_graph', 'topic', 'dev_ivr__uasp_realtime__case_48_concatenate__uaspdto', 'flink_srv', 'uasp-streaming-mdm-enrichment~way4-card-agreement', 'enrichOne.MainEnrichProperty$.fromTopic' from DUAL union


select 'rto_graph', 'topic', 'dev_bevents_cft_way4_profile_udds_before_mdm_rate_case68_uaspdto', 'flink_srv', 'uasp-streaming-mdm-enrichment~case-68', 'enrichOne.MainEnrichProperty$.fromTopic' from DUAL union
select 'rto_graph', 'topic', 'dev_input_converter_cardfl_refill_uasp', 'flink_srv', 'uasp-streaming-mdm-enrichment~case-68', 'enrichOne.CommonEnrichProperty$.fromTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~case-68', 'topic', 'dev_bevents_cft_way4_profile_udds_before_case68_uaspdto', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~case-68', 'topic', 'dev_bevents_udds_mdm_rate_case68_uaspdto_dlq', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~case-68', 'topic', 'dev_input_converter_cardfl_refill_uasp_dlq', 'enrichOne.CommonEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from DUAL union

select 'rto_graph', 'topic', 'dev_bevents_cft_way4_profile_udds_before_case68_uaspdto', 'flink_srv', 'uasp-streaming-mdm-enrichment~case-68_agrement', 'enrichOne.MainEnrichProperty$.fromTopic' from DUAL union
select 'rto_graph', 'topic', 'dev__dko_uasp__card_agreement_converted', 'flink_srv', 'uasp-streaming-mdm-enrichment~case-68_agrement', 'enrichOne.CommonEnrichProperty$.fromTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~case-68_agrement', 'topic', 'dev_bevents_cft_way4_profile_udds_before_case68_uaspdto_dlq', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~case-68_agrement', 'topic', 'dev_bevents_udds_mdm_rate_case68_uaspdto', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~case-68_agrement', 'topic', 'dev_rto_batch_ca_customer_card68_uaspdto_dlq', 'enrichOne.CommonEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from DUAL union 

select 'rto_graph', 'topic', 'dev_bevents_streaming_input_convertor_profile_auth_uaspdto', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-auth', 'enrichOne.MainEnrichProperty$.fromTopic' from DUAL union
select 'rto_graph', 'topic', 'dev__dko_uasp__card_agreement_converted', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fromTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-auth', 'topic', 'dev_bevents_card_agreement_enrich_dlq', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-auth', 'topic', 'dev_bevents_card_agreement_enrich_out_uaspdto', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-auth', 'topic', 'dev_rto_batch_ca_customer_card_uaspdto__dlq', 'enrichOne.GlobalIdEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from DUAL union

select 'rto_graph', 'topic', 'dev_ivr__uasp_realtime__ca_ha_aggregate__ca__uaspdto', 'flink_srv', 'uasp-streaming-aggregate~aggregate-dko', 'consumer.ca.topic.name'  from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-aggregate~aggregate-dko', 'topic', 'dev_ivr__uasp_realtime__aggregate__uaspdto', 'producer.ha.topic.name'  from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-w4-operation', 'topic', 'dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__uaspdto', 'way4.output.topic.name'  from DUAL union
select 'rto_graph', 'topic', 'dev_ivr__uasp_realtime__mdm_enrichment__uaspdto', 'flink_srv', 'uasp-streaming-aggregate~aggregate-dko', 'consumer.ha.topic.name'  from DUAL union
select 'rto_graph', 'topic', 'dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__json', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-w4-operation', 'way4.input.topic.name'  from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-aggregate~aggregate-dko', 'topic', 'dev_ivr__uasp_realtime__aggregate__filter', 'producer.ha.filter.status.topic.name'  from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-w4-operation', 'topic', 'dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__dlq', 'way4.dlq.topic.name'  from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-aggregate~aggregate-dko', 'topic', 'dev_ivr__uasp_realtime__aggregate__dlq', 'producer.ha.dlq.topic.name'  from DUAL union



select 'rto_graph', 'topic', 'dev_bevents_card_agreement_enrich_out_uaspdto', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-auth-packNM', 'enrichOne.MainEnrichProperty$.fromTopic' from DUAL union
select 'rto_graph', 'topic', 'dev__dko_uasp__pension_converted', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-auth-packNM', 'enrichOne.CommonEnrichProperty$.fromTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-auth-packNM', 'topic', 'dev_bevents_package_nm_enrich_dlq', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-auth-packNM', 'topic', 'dev_bevents__realtime__enrichment__prof__transactions_first__uaspdto', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-auth-packNM', 'topic', 'dev_rto_batch_ca_customer_package_dlq', 'enrichOne.CommonEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from DUAL union

select 'rto_graph', 'topic', 'dev_bevents__realtime__input_converter__prof__transactions__uaspdto', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-tx-case-71', 'enrichOne.MainEnrichProperty$.fromTopic' from DUAL union
select 'rto_graph', 'topic', 'dev_rto_batch_ca_deposit_account_case_71_json_converted', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.fromTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-tx-case-71', 'topic', 'dev_bevents__realtime__case_71__uaspdto', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-tx-case-71', 'topic', 'dev_bevents__realtime__case_71__uaspdto_dlq', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-tx-case-71', 'topic', 'dev_rto_batch_ca_deposit_account_case_71_uaspdto__dlq', 'enrichOne.CommonEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from DUAL union

select 'rto_graph', 'topic', 'dev_bevents__batch__ca_regulatory_client_id_of_profile__json_converted', 'flink_srv', 'uasp-streaming-mdm-enrichment~profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.fromTopic' from DUAL union
select 'rto_graph', 'topic', 'dev_bevents__realtime__case_71__uaspdto', 'flink_srv', 'uasp-streaming-mdm-enrichment~profile-tx-step1', 'enrichOne.MainEnrichProperty$.fromTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~profile-tx-step1', 'topic', 'dev_bevents__realtime__enrichment__prof__contract_num__uaspdto', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~profile-tx-step1', 'topic', 'dev_bevents__realtime__enrichment__prof__transactions_with_clientid__dlq', 'enrichOne.GlobalIdEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~profile-tx-step1', 'topic', 'dev_bevents__realtime__enrichment__prof__transactions_with_contract_num__dlq', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from DUAL union

select 'rto_graph', 'topic', 'dev_bevents__batch__ca_regulatory_contract_num_of_mdm_id_profile__uaspdto', 'flink_srv', 'uasp-streaming-mdm-enrichment~profile-tx-step2', 'enrichOne.GlobalIdEnrichProperty$.fromTopic' from DUAL union
select 'rto_graph', 'topic', 'dev_bevents__realtime__enrichment__prof__contract_num__uaspdto', 'flink_srv', 'uasp-streaming-mdm-enrichment~profile-tx-step2', 'enrichOne.MainEnrichProperty$.fromTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~profile-tx-step2', 'topic', 'dev_bevents__realtime__enrichment__prof__transactions_first__uaspdto', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~profile-tx-step2', 'topic', 'dev_bevents__realtime__enrichment__prof__transactions_with_mdm_id__dlq', 'enrichOne.GlobalIdEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~profile-tx-step2', 'topic', 'dev_bevents__realtime__enrichment__prof__transactions_with_partyUId__dlq', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from DUAL;










end;
$$;
/
commit;
/
rollback