package ru.vtb.configuration.server.dataEntity;

import javax.persistence.*;
import java.util.Collection;

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
    @OneToMany(mappedBy = "dictAbstractGraphNodeByDictArrowBegFk")
    private Collection<DictArrowEntity> dictArrows;
    @OneToMany(mappedBy = "dictAbstractGraphNodeByDictArrowEndFk")
    private Collection<DictArrowEntity> dictArrows_0;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "node_type", referencedColumnName = "node_type", nullable = false), @JoinColumn(name = "node_id", referencedColumnName = "id", nullable = false)})
    private DictServiceNodeEntity dictServiceNode;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "node_type", referencedColumnName = "node_type", nullable = false), @JoinColumn(name = "node_id", referencedColumnName = "id", nullable = false)})
    private DictTopicNodeEntity dictTopicNode;

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

        DictAbstractGraphNodeEntity that = (DictAbstractGraphNodeEntity) o;

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

    public Collection<DictArrowEntity> getDictArrows() {
        return dictArrows;
    }

    public void setDictArrows(Collection<DictArrowEntity> dictArrows) {
        this.dictArrows = dictArrows;
    }

    public Collection<DictArrowEntity> getDictArrows_0() {
        return dictArrows_0;
    }

    public void setDictArrows_0(Collection<DictArrowEntity> dictArrows_0) {
        this.dictArrows_0 = dictArrows_0;
    }

    public DictServiceNodeEntity getDictServiceNode() {
        return dictServiceNode;
    }

    public void setDictServiceNode(DictServiceNodeEntity dictServiceNode) {
        this.dictServiceNode = dictServiceNode;
    }

    public DictTopicNodeEntity getDictTopicNode() {
        return dictTopicNode;
    }

    public void setDictTopicNode(DictTopicNodeEntity dictTopicNode) {
        this.dictTopicNode = dictTopicNode;
    }
}
