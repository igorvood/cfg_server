package ru.vtb.configuration.server.dataEntity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "dict_topic_params_by_stand", schema = "db_configuration_manager", catalog = "db_configuration_manager")
@IdClass(DictTopicParamsByStandEntityPK.class)
public class DictTopicParamsByStandEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "node_id")
    private String nodeId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "stand_id")
    private String standId;
    @Basic
    @Column(name = "cnt_partition")
    private BigInteger cntPartition;
    @Basic
    @Column(name = "topic_name")
    private String topicName;
    @ManyToOne
    @JoinColumn(name = "node_id", referencedColumnName = "id", nullable = false)
    private DictTopicNodeEntity dictTopicNodeByNodeId;
    @ManyToOne
    @JoinColumn(name = "node_id", referencedColumnName = "id", nullable = false)
    private DictTopicNodeEntity dictTopicNodeByNodeId_0;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getStandId() {
        return standId;
    }

    public void setStandId(String standId) {
        this.standId = standId;
    }

    public BigInteger getCntPartition() {
        return cntPartition;
    }

    public void setCntPartition(BigInteger cntPartition) {
        this.cntPartition = cntPartition;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictTopicParamsByStandEntity that = (DictTopicParamsByStandEntity) o;

        if (nodeId != null ? !nodeId.equals(that.nodeId) : that.nodeId != null) return false;
        if (standId != null ? !standId.equals(that.standId) : that.standId != null) return false;
        if (cntPartition != null ? !cntPartition.equals(that.cntPartition) : that.cntPartition != null) return false;
        if (topicName != null ? !topicName.equals(that.topicName) : that.topicName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nodeId != null ? nodeId.hashCode() : 0;
        result = 31 * result + (standId != null ? standId.hashCode() : 0);
        result = 31 * result + (cntPartition != null ? cntPartition.hashCode() : 0);
        result = 31 * result + (topicName != null ? topicName.hashCode() : 0);
        return result;
    }

    public DictTopicNodeEntity getDictTopicNodeByNodeId() {
        return dictTopicNodeByNodeId;
    }

    public void setDictTopicNodeByNodeId(DictTopicNodeEntity dictTopicNodeByNodeId) {
        this.dictTopicNodeByNodeId = dictTopicNodeByNodeId;
    }

    public DictTopicNodeEntity getDictTopicNodeByNodeId_0() {
        return dictTopicNodeByNodeId_0;
    }

    public void setDictTopicNodeByNodeId_0(DictTopicNodeEntity dictTopicNodeByNodeId_0) {
        this.dictTopicNodeByNodeId_0 = dictTopicNodeByNodeId_0;
    }
}
