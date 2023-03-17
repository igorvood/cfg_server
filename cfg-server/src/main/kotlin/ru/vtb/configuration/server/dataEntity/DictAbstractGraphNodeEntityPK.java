package ru.vtb.configuration.server.dataEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class DictAbstractGraphNodeEntityPK implements Serializable {
    @Column(name = "graph_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String graphId;
    @Column(name = "node_type")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nodeType;
    @Column(name = "node_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nodeId;

    public String getGraphId() {
        return graphId;
    }

    public void setGraphId(String graphId) {
        this.graphId = graphId;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictAbstractGraphNodeEntityPK that = (DictAbstractGraphNodeEntityPK) o;

        if (graphId != null ? !graphId.equals(that.graphId) : that.graphId != null) return false;
        if (nodeType != null ? !nodeType.equals(that.nodeType) : that.nodeType != null) return false;
        if (nodeId != null ? !nodeId.equals(that.nodeId) : that.nodeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = graphId != null ? graphId.hashCode() : 0;
        result = 31 * result + (nodeType != null ? nodeType.hashCode() : 0);
        result = 31 * result + (nodeId != null ? nodeId.hashCode() : 0);
        return result;
    }
}
