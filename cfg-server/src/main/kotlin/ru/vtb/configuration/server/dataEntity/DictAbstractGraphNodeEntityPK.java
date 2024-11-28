package ru.vtb.configuration.server.dataEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

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
        return Objects.equals(graphId, that.graphId) && Objects.equals(nodeType, that.nodeType) && Objects.equals(nodeId, that.nodeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(graphId, nodeType, nodeId);
    }
}
