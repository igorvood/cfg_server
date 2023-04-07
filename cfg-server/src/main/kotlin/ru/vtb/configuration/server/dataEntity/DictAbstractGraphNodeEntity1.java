package ru.vtb.configuration.server.dataEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dict_abstract_graph_node", schema = "db_configuration_manager", catalog = "db_configuration_manager")
//@IdClass(DictAbstractGraphNodeEntityPK.class)
//@GenerateJpa(tableComment = "Нода графа", genRest = true)
public class DictAbstractGraphNodeEntity1 {
    @Id
    @Column(name = "graph_id", nullable = false)
    private String graphId;
    @Id
    @Column(name = "node_type", nullable = false, updatable = false)
    private String nodeType;
    @Id
    @Column(name = "node_id", nullable = false)
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
        DictAbstractGraphNodeEntity1 that = (DictAbstractGraphNodeEntity1) o;
        return Objects.equals(graphId, that.graphId) && Objects.equals(nodeType, that.nodeType) && Objects.equals(nodeId, that.nodeId);
    }

    @Override
    public int hashCode() {
        return this.getClass().getName().hashCode();
    }
}
