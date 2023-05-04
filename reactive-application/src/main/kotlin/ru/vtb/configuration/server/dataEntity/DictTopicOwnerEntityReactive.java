package ru.vtb.configuration.server.dataEntity;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import ru.vtb.processor.annotation.GenerateReactiveJpa;

//import javax.persistence.*;


//@Entity
//@Table(name = "dict_topic_owner", schema = "db_configuration_manager", catalog = "db_configuration_manager")
@org.springframework.data.relational.core.mapping.Table("db_configuration_manager.dict_topic_owner")
@GenerateReactiveJpa(tableComment = "Владелец топика", genRest = true)
public class DictTopicOwnerEntityReactive {
    @Id
//    @Column(name = "id", nullable = false)
    @Column( "id")
    private String id;
//    @Basic
//    @Column(name = "is_our", nullable = false)
    @Column( "is_our")
    private Integer our;
//    @Basic
    @Column( "description_for_report")
//    @Column(name = "description_for_report")
    private String descriptionForReport;
//    @OneToMany(mappedBy = "dictTopicOwnerByTopicOwnerId")
//    private Collection<DictTopicNodeEntity> dictTopicNodesById;

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

        DictTopicOwnerEntityReactive that = (DictTopicOwnerEntityReactive) o;

        if (our != that.our) return false;
        if (!id.equals(that.id)) return false;
        return descriptionForReport.equals(that.descriptionForReport);
    }

    @Override
    public int hashCode() {
        return this.getClass().getName().hashCode();
    }

//    public Collection<DictTopicNodeEntity> getDictTopicNodesById() {
//        return dictTopicNodesById;
//    }

//    public void setDictTopicNodesById(Collection<DictTopicNodeEntity> dictTopicNodesById) {
//        this.dictTopicNodesById = dictTopicNodesById;
//    }
}
