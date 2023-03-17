package ru.vtb.configuration.server.dataEntity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "dict_kafka_property_grp", schema = "db_configuration_manager", catalog = "db_configuration_manager")
@IdClass(DictKafkaPropertyGrpEntityPK.class)
public class DictKafkaPropertyGrpEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private String id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "type_read")
    private String typeRead;
    @Basic
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "dictKafkaPropertyGrp")
    private Collection<DictArrowEntity> dictArrows;
    @OneToMany(mappedBy = "dictKafkaPropertyGrp")
    private Collection<DictKafkaPropValueEntity> dictKafkaPropValues;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeRead() {
        return typeRead;
    }

    public void setTypeRead(String typeRead) {
        this.typeRead = typeRead;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictKafkaPropertyGrpEntity that = (DictKafkaPropertyGrpEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (typeRead != null ? !typeRead.equals(that.typeRead) : that.typeRead != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (typeRead != null ? typeRead.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public Collection<DictArrowEntity> getDictArrows() {
        return dictArrows;
    }

    public void setDictArrows(Collection<DictArrowEntity> dictArrows) {
        this.dictArrows = dictArrows;
    }

    public Collection<DictKafkaPropValueEntity> getDictKafkaPropValues() {
        return dictKafkaPropValues;
    }

    public void setDictKafkaPropValues(Collection<DictKafkaPropValueEntity> dictKafkaPropValues) {
        this.dictKafkaPropValues = dictKafkaPropValues;
    }
}
