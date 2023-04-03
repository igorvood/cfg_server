package ru.vtb.configuration.server.dataEntity;


import ru.vtb.processor.annotation.GenerateJpa;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "dict_topic_params_by_stand", schema = "db_configuration_manager", catalog = "db_configuration_manager")
@IdClass(DictTopicParamsByStandEntityPK.class)
@GenerateJpa
public class DictTopicParamsByStandEntity  {
    @Id
    @Column(name = "node_id")
    private String nodeId;
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
    @JoinColumn(name = "node_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private DictTopicNodeEntity dictTopicNodeByNodeId;

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
        return this.getClass().getName().hashCode();
    }

    public DictTopicNodeEntity getDictTopicNodeByNodeId() {
        return dictTopicNodeByNodeId;
    }

    public void setDictTopicNodeByNodeId(DictTopicNodeEntity dictTopicNodeByNodeId) {
        this.dictTopicNodeByNodeId = dictTopicNodeByNodeId;
    }

}
