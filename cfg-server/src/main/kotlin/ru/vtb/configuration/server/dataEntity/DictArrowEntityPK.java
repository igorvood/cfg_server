package ru.vtb.configuration.server.dataEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

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

        if (graphId != null ? !graphId.equals(that.graphId) : that.graphId != null) return false;
        if (begNodeType != null ? !begNodeType.equals(that.begNodeType) : that.begNodeType != null) return false;
        if (begNodeId != null ? !begNodeId.equals(that.begNodeId) : that.begNodeId != null) return false;
        if (endNodeType != null ? !endNodeType.equals(that.endNodeType) : that.endNodeType != null) return false;
        if (endNodeId != null ? !endNodeId.equals(that.endNodeId) : that.endNodeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = graphId != null ? graphId.hashCode() : 0;
        result = 31 * result + (begNodeType != null ? begNodeType.hashCode() : 0);
        result = 31 * result + (begNodeId != null ? begNodeId.hashCode() : 0);
        result = 31 * result + (endNodeType != null ? endNodeType.hashCode() : 0);
        result = 31 * result + (endNodeId != null ? endNodeId.hashCode() : 0);
        return result;
    }
}
