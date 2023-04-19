package ru.vtb.configuration.server.dataEntity;

import ru.vtb.processor.annotation.GenerateJpa;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dict_arrow", schema = "db_configuration_manager", catalog = "db_configuration_manager")
@IdClass(DictArrowEntityPK.class)
@GenerateJpa(tableComment = "Связь нод графа", genRest = true, readOnly = true)
public class DictArrowEntity {
    @Id
    @Column(name = "graph_id", nullable = false)
    private String graphId;

    @Id
    @Column(name = "beg_node_type", nullable = false)
    private String begNodeType;

    @Id
    @Column(name = "beg_node_id", nullable = false)
    private String begNodeId;

    @Id
    @Column(name = "end_node_type", nullable = false)
    private String endNodeType;

    @Id
    @Column(name = "end_node_id", nullable = false)
    private String endNodeId;
    @Basic
    @Column(name = "property_key", nullable = false)
    private String propertyKey;
    @Basic
    @Column(name = "flink_srv", nullable = false, updatable = false)
    private String flinkSrv;
    @Basic
    @Column(name = "common_name", nullable = false)
    private String commonName;
    @Basic
    @Column(name = "kafka_direction", nullable = false, updatable = false)
    private String kafkaDirection;
    @Basic
    @Column(name = "kafka_grp_prop", nullable = false)
    private String kafkaGrpProp;

    public String getGraphId() {
        return graphId;
    }

    public void setGraphId(String graphId) {
        this.graphId = graphId;
    }

    public String getBegNodeType() {
        return begNodeType;
    }

    public void setBegNodeType(String begNodeType) {
        this.begNodeType = begNodeType;
    }

    public String getBegNodeId() {
        return begNodeId;
    }

    public void setBegNodeId(String begNodeId) {
        this.begNodeId = begNodeId;
    }

    public String getEndNodeType() {
        return endNodeType;
    }

    public void setEndNodeType(String endNodeType) {
        this.endNodeType = endNodeType;
    }

    public String getEndNodeId() {
        return endNodeId;
    }

    public void setEndNodeId(String endNodeId) {
        this.endNodeId = endNodeId;
    }

    public String getPropertyKey() {
        return propertyKey;
    }

    public void setPropertyKey(String propertyKey) {
        this.propertyKey = propertyKey;
    }

    public String getFlinkSrv() {
        return flinkSrv;
    }

    public void setFlinkSrv(String flinkSrv) {
        this.flinkSrv = flinkSrv;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getKafkaDirection() {
        return kafkaDirection;
    }

    public void setKafkaDirection(String kafkaDirection) {
        this.kafkaDirection = kafkaDirection;
    }

    public String getKafkaGrpProp() {
        return kafkaGrpProp;
    }

    public void setKafkaGrpProp(String kafkaGrpProp) {
        this.kafkaGrpProp = kafkaGrpProp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictArrowEntity that = (DictArrowEntity) o;
        return Objects.equals(graphId, that.graphId) && Objects.equals(begNodeType, that.begNodeType) && Objects.equals(begNodeId, that.begNodeId) && Objects.equals(endNodeType, that.endNodeType) && Objects.equals(endNodeId, that.endNodeId) && Objects.equals(propertyKey, that.propertyKey) && Objects.equals(flinkSrv, that.flinkSrv) && Objects.equals(commonName, that.commonName) && Objects.equals(kafkaDirection, that.kafkaDirection) && Objects.equals(kafkaGrpProp, that.kafkaGrpProp);
    }

    @Override
    public int hashCode() {
        return this.getClass().getName().hashCode();
    }

}
