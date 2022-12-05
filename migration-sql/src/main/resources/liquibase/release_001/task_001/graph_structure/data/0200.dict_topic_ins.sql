DO $$
  declare
    tuple2_v record;
    v varchar;
  begin
    for tuple2_v in
      with topic as (
        select 'graph_1' as f1, 'dev_ivr__uasp_realtime__business_rules__uaspdto' as f2 from dual union
        select 'graph_1', 'Filter_producer_1' from dual union
        select 'graph_1', 'Filter_producer_2' from dual union
        select 'graph_1', 'ivr__uasp_realtime__bussiness_rules__uaspdto__dlq' from dual union
        select 'graph_1', 'mutator_consumer_2' from dual union
        select 'graph_1', 'uasp_mutator_filter_input' from dual union
        select 'graph_1', 'uasp_mutator_filter_input_2' from dual union

        select 'rto_graph', 'dev_ivr__uasp_realtime__input_converter__mortgage__dlq' from dual union
        select 'rto_graph', 'dev_ivr__uasp_realtime__input_converter__mortgage__uaspdto' from dual union
        select 'rto_graph', 'dev_ivr__uasp_realtime__mdm_enrichment__mdm_cross_link__status__dlq' from dual union
        select 'rto_graph', 'dev_ivr__uasp_realtime__input_converter__mdm_cross_link__uaspdto' from dual union
        select 'rto_graph', 'dev_ivr__uasp_realtime__mdm_enrichment__for_additional_enrichment__uaspdto' from dual union
        select 'rto_graph', 'dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__uaspdto' from dual union
        select 'rto_graph', 'dev_ivr__uasp_realtime_way4_mdm_enrichment__uaspdto' from dual union
        select 'rto_graph', 'dev_rto_batch_ca_customer_card_uaspdto__dlq' from dual union
        select 'rto_graph', 'dev__dko_uasp__card_agreement_converted' from dual union
        select 'rto_graph', 'dev_bevents_card_agreement_enrich_way4_dlq' from dual union
        select 'rto_graph', 'dev_ivr__uasp_realtime__case_48_concatenate__uaspdto' from dual union
        select 'rto_graph', 'dev_bevents_card_agreement_enrich_out_uaspdto' from dual union

        select 'rto_graph', 'dev_bevents__realtime__case_71__uaspdto' from dual union
        select 'rto_graph', 'dev_bevents_udds_mdm_rate_case68_uaspdto_dlq' from dual union
        select 'rto_graph', 'dev_bevents__batch__ca_regulatory_client_id_of_profile__json_converted' from dual union
        select 'rto_graph', 'dev_bevents_streaming_input_convertor_profile_auth_uaspdto' from dual union
        select 'rto_graph', 'dev_rto_batch_ca_customer_card68_uaspdto_dlq' from dual union
        select 'rto_graph', 'dev_bevents__realtime__enrichment__prof__transactions_first__uaspdto' from dual union
        select 'rto_graph', 'dev_rto_batch_ca_deposit_account_case_71_uaspdto__dlq' from dual union
        select 'rto_graph', 'dev_rto_batch_ca_customer_package_dlq' from dual union
        select 'rto_graph', 'dev_bevents__realtime__input_converter__prof__transactions__uaspdto' from dual union
        select 'rto_graph', 'dev__dko_uasp__pension_converted' from dual union
        select 'rto_graph', 'dev_bevents__realtime__enrichment__prof__transactions_with_contract_num__dlq' from dual union
        select 'rto_graph', 'dev_bevents__batch__ca_regulatory_contract_num_of_mdm_id_profile__uaspdto' from dual union
        select 'rto_graph', 'dev_bevents_udds_mdm_rate_case68_uaspdto' from dual union
        select 'rto_graph', 'dev_bevents_cft_way4_profile_udds_before_case68_uaspdto_dlq' from dual union
        select 'rto_graph', 'dev_rto_batch_ca_deposit_account_case_71_json_converted' from dual union
        select 'rto_graph', 'dev_input_converter_cardfl_refill_uasp_dlq' from dual union
        select 'rto_graph', 'dev_bevents__realtime__enrichment__prof__transactions_with_mdm_id__dlq' from dual union
        select 'rto_graph', 'dev_bevents_cft_way4_profile_udds_before_mdm_rate_case68_uaspdto' from dual union
        select 'rto_graph', 'dev_bevents__realtime__case_71__uaspdto_dlq' from dual union
        select 'rto_graph', 'dev_input_converter_cardfl_refill_uasp' from dual union
        select 'rto_graph', 'dev_bevents__realtime__enrichment__prof__contract_num__uaspdto' from dual union
        select 'rto_graph', 'dev_bevents_card_agreement_enrich_dlq' from dual union
        select 'rto_graph', 'dev_bevents__realtime__enrichment__prof__transactions_with_partyUId__dlq' from dual union
        select 'rto_graph', 'dev_bevents_package_nm_enrich_dlq' from dual union
        select 'rto_graph', 'dev_bevents__realtime__enrichment__prof__transactions_with_clientid__dlq' from dual union
        select 'rto_graph', 'dev_bevents_cft_way4_profile_udds_before_case68_uaspdto' from dual),
      owner as( select 'DKO_COMMAND' own from dual)
      select t.f1, t.f2, o.own from topic t
        cross join owner o
    loop
      select '1' into v from dict_topic_ins_trg(tuple2_v.f1, tuple2_v.f2, tuple2_v.own);
    end loop;
  end;
$$;
/
update dict_topic_node tn set consumer_prop_grp='latest'
where tn.id in (
    'dev_bevents_cft_way4_profile_udds_before_mdm_rate_case68_uaspdto',
    'dev_bevents_cft_way4_profile_udds_before_case68_uaspdto',
    'dev_bevents_streaming_input_convertor_profile_auth_uaspdto',
    'dev_bevents_card_agreement_enrich_out_uaspdto',
    'dev_bevents__realtime__input_converter__prof__transactions__uaspdto',
    'dev_bevents__realtime__case_71__uaspdto',
    'dev_bevents__realtime__enrichment__prof__contract_num__uaspdto',
    'dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__uaspdto',
    'dev_ivr__uasp_realtime__case_48_concatenate__uaspdto'
    );
/
commit;
/