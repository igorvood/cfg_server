package ru.vtb.configuration.server.dataEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dict_abstract_graph_node", schema = "db_configuration_manager", catalog = "db_configuration_manager")
@IdClass(DictAbstractGraphNodeEntityPK.class)
public class DictAbstractGraphNodeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "graph_id")
    private String graphId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "node_type")
    private String nodeType;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "node_id")
    private String nodeId;
    @Basic
    @Column(name = "new_column")
    private Integer newColumn;

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

    public Integer getNewColumn() {
        return newColumn;
    }

    public void setNewColumn(Integer newColumn) {
        this.newColumn = newColumn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictAbstractGraphNodeEntity that = (DictAbstractGraphNodeEntity) o;
        return Objects.equals(graphId, that.graphId) && Objects.equals(nodeType, that.nodeType) && Objects.equals(nodeId, that.nodeId) && Objects.equals(newColumn, that.newColumn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(graphId, nodeType, nodeId, newColumn);
    }
}
