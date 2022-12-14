DO $$
    declare
        tuple2_v record;
        v varchar;
    begin
        for tuple2_v in
    select 'graph_1' GRAPH_ID, 'Additional_enrich' SERVICE_ID, 'case_65' PROFILE_ID, 'MainClass1' MAIN_CLASS from dual union
    select 'graph_1', 'Filter', 'case_65', 'MainClass2' from dual union
    select 'graph_1', 'Mutator', 'case_65', 'MainClass3' from dual union
    select 'rto_graph', 'uasp-streaming-mdm-enrichment', 'way4', 'ru.vtb.uasp.mdm.enrichment.EnrichmentJob' from dual union
    select 'rto_graph', 'uasp-streaming-mdm-enrichment', 'way4-card-agreement', 'ru.vtb.uasp.mdm.enrichment.EnrichmentJob' from dual union

    select 'rto_graph', 'uasp-kriaa-bevents-case-40', 'main', 'ru.vtb.uasp.packacge.PackageServiceJob' from dual union
    select 'rto_graph', 'uasp-kriaa-bevents-case-68', 'main', 'ru.vtb.bevent.UaspStreamingCase68' from dual union
    select 'rto_graph', 'uasp-kriaa-bevents-case-2', 'main', 'ru.vtb.uasp.packacge.PackageServiceJob' from dual union

    select 'rto_graph', 'uasp-streaming-mdm-enrichment', 'case-68', 'ru.vtb.uasp.mdm.enrichment.EnrichmentJob' from dual union
    select 'rto_graph', 'uasp-streaming-mdm-enrichment', 'case-68_agrement', 'ru.vtb.uasp.mdm.enrichment.EnrichmentJob' from dual union
    select 'rto_graph', 'uasp-streaming-mdm-enrichment', 'prof-auth', 'ru.vtb.uasp.mdm.enrichment.EnrichmentJob' from dual union
    select 'rto_graph', 'uasp-streaming-mdm-enrichment', 'prof-auth-packNM', 'ru.vtb.uasp.mdm.enrichment.EnrichmentJob' from dual union
    select 'rto_graph', 'uasp-streaming-mdm-enrichment', 'prof-tx-case-71', 'ru.vtb.uasp.mdm.enrichment.EnrichmentJob' from dual union
    select 'rto_graph', 'uasp-streaming-mdm-enrichment', 'profile-tx-step1', 'ru.vtb.uasp.mdm.enrichment.EnrichmentJob' from dual union
    select 'rto_graph', 'uasp-streaming-mdm-enrichment', 'profile-tx-step2', 'ru.vtb.uasp.mdm.enrichment.EnrichmentJob' from dual

            loop
            --                 null;
--                 call DICT_SERVICE_INS_trg(tuple2_v.GRAPH_ID, tuple2_v.SERVICE_ID, tuple2_v.PROFILE_ID, tuple2_v.MAIN_CLASS);
                select '1' into v from DICT_SERVICE_INS_trg(tuple2_v.GRAPH_ID, tuple2_v.SERVICE_ID, tuple2_v.PROFILE_ID, tuple2_v.MAIN_CLASS);
            end loop;

    end;
$$;
/
