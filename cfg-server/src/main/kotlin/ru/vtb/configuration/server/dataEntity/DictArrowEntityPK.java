package ru.vtb.configuration.server.dataEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class DictArrowEntityPK implements Serializable {
    @Column(name = "graph_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String graphId;
    @Column(name = "beg_node_type")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String begNodeType;
    @Column(name = "beg_node_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String begNodeId;
    @Column(name = "end_node_type")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String endNodeType;
    @Column(name = "end_node_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String endNodeId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictArrowEntityPK that = (DictArrowEntityPK) o;
        return Objects.equals(graphId, that.graphId) && Objects.equals(begNodeType, that.begNodeType) && Objects.equals(begNodeId, that.begNodeId) && Objects.equals(endNodeType, that.endNodeType) && Objects.equals(endNodeId, that.endNodeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(graphId, begNodeType, begNodeId, endNodeType, endNodeId);
    }
}
