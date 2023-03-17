package ru.vtb.configuration.server.dataEntity;

import javax.persistence.*;

@Entity
@Table(name = "dict_arrow", schema = "db_configuration_manager", catalog = "db_configuration_manager")
@IdClass(DictArrowEntityPK.class)
public class DictArrowEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "graph_id")
    private String graphId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "beg_node_type")
    private String begNodeType;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "beg_node_id")
    private String begNodeId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "end_node_type")
    private String endNodeType;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "end_node_id")
    private String endNodeId;
    @Basic
    @Column(name = "property_key")
    private String propertyKey;
    @Basic
    @Column(name = "flink_srv")
    private String flinkSrv;
    @Basic
    @Column(name = "common_name")
    private String commonName;
    @Basic
    @Column(name = "kafka_direction")
    private String kafkaDirection;
    @Basic
    @Column(name = "kafka_grp_prop")
    private String kafkaGrpProp;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "graph_id", referencedColumnName = "graph_id", nullable = false), @JoinColumn(name = "beg_node_type", referencedColumnName = "node_type", nullable = false), @JoinColumn(name = "beg_node_id", referencedColumnName = "node_id", nullable = false)})
    private DictAbstractGraphNodeEntity dictAbstractGraphNodeByDictArrowBegFk;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "graph_id", referencedColumnName = "graph_id", nullable = false), @JoinColumn(name = "beg_node_type", referencedColumnName = "node_type", nullable = false), @JoinColumn(name = "beg_node_id", referencedColumnName = "node_id", nullable = false)})
    private DictAbstractGraphNodeEntity dictAbstractGraphNodeByDictArrowEndFk;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "kafka_grp_prop", referencedColumnName = "id", nullable = false), @JoinColumn(name = "kafka_direction", referencedColumnName = "type_read", nullable = false)})
    private DictKafkaPropertyGrpEntity dictKafkaPropertyGrp;

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

        if (graphId != null ? !graphId.equals(that.graphId) : that.graphId != null) return false;
        if (begNodeType != null ? !begNodeType.equals(that.begNodeType) : that.begNodeType != null) return false;
        if (begNodeId != null ? !begNodeId.equals(that.begNodeId) : that.begNodeId != null) return false;
        if (endNodeType != null ? !endNodeType.equals(that.endNodeType) : that.endNodeType != null) return false;
        if (endNodeId != null ? !endNodeId.equals(that.endNodeId) : that.endNodeId != null) return false;
        if (propertyKey != null ? !propertyKey.equals(that.propertyKey) : that.propertyKey != null) return false;
        if (flinkSrv != null ? !flinkSrv.equals(that.flinkSrv) : that.flinkSrv != null) return false;
        if (commonName != null ? !commonName.equals(that.commonName) : that.commonName != null) return false;
        if (kafkaDirection != null ? !kafkaDirection.equals(that.kafkaDirection) : that.kafkaDirection != null)
            return false;
        if (kafkaGrpProp != null ? !kafkaGrpProp.equals(that.kafkaGrpProp) : that.kafkaGrpProp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = graphId != null ? graphId.hashCode() : 0;
        result = 31 * result + (begNodeType != null ? begNodeType.hashCode() : 0);
        result = 31 * result + (begNodeId != null ? begNodeId.hashCode() : 0);
        result = 31 * result + (endNodeType != null ? endNodeType.hashCode() : 0);
        result = 31 * result + (endNodeId != null ? endNodeId.hashCode() : 0);
        result = 31 * result + (propertyKey != null ? propertyKey.hashCode() : 0);
        result = 31 * result + (flinkSrv != null ? flinkSrv.hashCode() : 0);
        result = 31 * result + (commonName != null ? commonName.hashCode() : 0);
        result = 31 * result + (kafkaDirection != null ? kafkaDirection.hashCode() : 0);
        result = 31 * result + (kafkaGrpProp != null ? kafkaGrpProp.hashCode() : 0);
        return result;
    }

    public DictAbstractGraphNodeEntity getDictAbstractGraphNodeByDictArrowBegFk() {
        return dictAbstractGraphNodeByDictArrowBegFk;
    }

    public void setDictAbstractGraphNodeByDictArrowBegFk(DictAbstractGraphNodeEntity dictAbstractGraphNodeByDictArrowBegFk) {
        this.dictAbstractGraphNodeByDictArrowBegFk = dictAbstractGraphNodeByDictArrowBegFk;
    }

    public DictAbstractGraphNodeEntity getDictAbstractGraphNodeByDictArrowEndFk() {
        return dictAbstractGraphNodeByDictArrowEndFk;
    }

    public void setDictAbstractGraphNodeByDictArrowEndFk(DictAbstractGraphNodeEntity dictAbstractGraphNodeByDictArrowEndFk) {
        this.dictAbstractGraphNodeByDictArrowEndFk = dictAbstractGraphNodeByDictArrowEndFk;
    }

    public DictKafkaPropertyGrpEntity getDictKafkaPropertyGrp() {
        return dictKafkaPropertyGrp;
    }

    public void setDictKafkaPropertyGrp(DictKafkaPropertyGrpEntity dictKafkaPropertyGrp) {
        this.dictKafkaPropertyGrp = dictKafkaPropertyGrp;
    }
}
