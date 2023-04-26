package ru.vtb.configuration.server.dataEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class DictTopicParamsByStandEntityPK implements Serializable {
    @Column(name = "node_id")
    @Id
    private String nodeId;
    @Column(name = "stand_id")
    @Id
    private String standId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictTopicParamsByStandEntityPK that = (DictTopicParamsByStandEntityPK) o;

        if (nodeId != null ? !nodeId.equals(that.nodeId) : that.nodeId != null) return false;
        if (standId != null ? !standId.equals(that.standId) : that.standId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return this.getClass().getName().hashCode();
    }
}
