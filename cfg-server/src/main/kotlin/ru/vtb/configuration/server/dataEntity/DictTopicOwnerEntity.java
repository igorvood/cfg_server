package ru.vtb.configuration.server.dataEntity;


import ru.vtb.processor.annotation.GenerateJpa;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "dict_topic_owner", schema = "db_configuration_manager", catalog = "db_configuration_manager")
@GenerateJpa(tableComment = "Владелец топика", genRest = true, readOnly = false)
public class DictTopicOwnerEntity {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Basic
    @Column(name = "is_our", nullable = false)
    private Integer our;
    @Basic
    @Column(name = "description_for_report")
    private String descriptionForReport;
    @OneToMany(mappedBy = "dictTopicOwnerByTopicOwnerId")
    private Collection<DictTopicNodeEntity> dictTopicNodesById;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getOur() {
        return our;
    }

    public void setOur(Integer isOur) {
        this.our = isOur;
    }

    public String getDescriptionForReport() {
        return descriptionForReport;
    }

    public void setDescriptionForReport(String descriptionForReport) {
        this.descriptionForReport = descriptionForReport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictTopicOwnerEntity that = (DictTopicOwnerEntity) o;

        if (our != that.our) return false;
        if (!id.equals(that.id)) return false;
        return descriptionForReport.equals(that.descriptionForReport);
    }

    @Override
    public int hashCode() {
        return this.getClass().getName().hashCode();
    }

    public Collection<DictTopicNodeEntity> getDictTopicNodesById() {
        return dictTopicNodesById;
    }

    public void setDictTopicNodesById(Collection<DictTopicNodeEntity> dictTopicNodesById) {
        this.dictTopicNodesById = dictTopicNodesById;
    }
}
