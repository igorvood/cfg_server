package ru.vtb.configuration.server.dataEntity;


import ru.vtb.processor.annotation.GenerateJpa;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collection;

@Entity
@Table(name = "dict_topic_owner", schema = "db_configuration_manager", catalog = "db_configuration_manager")
@GenerateJpa
public class DictTopicOwnerEntity {
    @Id
    @Column(name = "id")
    private String id;
    @Basic
    @Column(name = "is_our")
    private BigInteger isOur;
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

    public BigInteger getIsOur() {
        return isOur;
    }

    public void setIsOur(BigInteger isOur) {
        this.isOur = isOur;
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

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (isOur != null ? !isOur.equals(that.isOur) : that.isOur != null) return false;
        if (descriptionForReport != null ? !descriptionForReport.equals(that.descriptionForReport) : that.descriptionForReport != null)
            return false;

        return true;
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
