package ru.vtb.configuration.server.dataEntity;



import ru.vtb.processor.annotation.GenerateJpa;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collection;

@Entity
@Table(name = "dict_topic_node", schema = "db_configuration_manager", catalog = "db_configuration_manager")
@GenerateJpa(tableComment = "Топик", genRest = true, readOnly = false)
public class DictTopicNodeEntity {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Basic
    @Column(name = "node_type", updatable = false)
    private String nodeType;
    @Basic
    @Column(name = "topic_owner_id", nullable = false)
    private String topicOwnerId;
    @Basic
    @Column(name = "cleanup_policy", nullable = false)
    private String cleanupPolicy;
    @Basic
    @Column(name = "retention")
    private BigInteger retention;
    @ManyToOne
    @JoinColumn(name = "topic_owner_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private DictTopicOwnerEntity dictTopicOwnerByTopicOwnerId;
    @OneToMany(mappedBy = "dictTopicNodeByNodeId", fetch = FetchType.EAGER)
    private Collection<DictTopicParamsByStandEntity> dictTopicParamsByStandsById;
//    @OneToMany(mappedBy = "dictTopicNodeByNodeId_0")
//    private Collection<DictTopicParamsByStandEntity> dictTopicParamsByStandsById_0;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getTopicOwnerId() {
        return topicOwnerId;
    }

    public void setTopicOwnerId(String topicOwnerId) {
        this.topicOwnerId = topicOwnerId;
    }

    public String getCleanupPolicy() {
        return cleanupPolicy;
    }

    public void setCleanupPolicy(String cleanupPolicy) {
        this.cleanupPolicy = cleanupPolicy;
    }

    public BigInteger getRetention() {
        return retention;
    }

    public void setRetention(BigInteger retention) {
        this.retention = retention;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictTopicNodeEntity that = (DictTopicNodeEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nodeType != null ? !nodeType.equals(that.nodeType) : that.nodeType != null) return false;
        if (topicOwnerId != null ? !topicOwnerId.equals(that.topicOwnerId) : that.topicOwnerId != null) return false;
        if (cleanupPolicy != null ? !cleanupPolicy.equals(that.cleanupPolicy) : that.cleanupPolicy != null)
            return false;
        if (retention != null ? !retention.equals(that.retention) : that.retention != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return this.getClass().getName().hashCode();
    }

    public DictTopicOwnerEntity getDictTopicOwnerByTopicOwnerId() {
        return dictTopicOwnerByTopicOwnerId;
    }

    public void setDictTopicOwnerByTopicOwnerId(DictTopicOwnerEntity dictTopicOwnerByTopicOwnerId) {
        this.dictTopicOwnerByTopicOwnerId = dictTopicOwnerByTopicOwnerId;
    }

    public Collection<DictTopicParamsByStandEntity> getDictTopicParamsByStandsById() {
        return dictTopicParamsByStandsById;
    }

    public void setDictTopicParamsByStandsById(Collection<DictTopicParamsByStandEntity> dictTopicParamsByStandsById) {
        this.dictTopicParamsByStandsById = dictTopicParamsByStandsById;
    }

//    public Collection<DictTopicParamsByStandEntity> getDictTopicParamsByStandsById_0() {
//        return dictTopicParamsByStandsById_0;
//    }
//
//    public void setDictTopicParamsByStandsById_0(Collection<DictTopicParamsByStandEntity> dictTopicParamsByStandsById_0) {
//        this.dictTopicParamsByStandsById_0 = dictTopicParamsByStandsById_0;
//    }
}
