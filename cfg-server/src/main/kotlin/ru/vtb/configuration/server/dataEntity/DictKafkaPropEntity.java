package ru.vtb.configuration.server.dataEntity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "dict_kafka_prop", schema = "db_configuration_manager", catalog = "db_configuration_manager")
@IdClass(DictKafkaPropEntityPK.class)
public class DictKafkaPropEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "type_prop")
    private String typeProp;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "prop_id")
    private String propId;
    @OneToMany(mappedBy = "dictKafkaProp")
    private Collection<DictKafkaPropValueEntity> dictKafkaPropValues;

    public String getTypeProp() {
        return typeProp;
    }

    public void setTypeProp(String typeProp) {
        this.typeProp = typeProp;
    }

    public String getPropId() {
        return propId;
    }

    public void setPropId(String propId) {
        this.propId = propId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictKafkaPropEntity that = (DictKafkaPropEntity) o;

        if (typeProp != null ? !typeProp.equals(that.typeProp) : that.typeProp != null) return false;
        if (propId != null ? !propId.equals(that.propId) : that.propId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = typeProp != null ? typeProp.hashCode() : 0;
        result = 31 * result + (propId != null ? propId.hashCode() : 0);
        return result;
    }

    public Collection<DictKafkaPropValueEntity> getDictKafkaPropValues() {
        return dictKafkaPropValues;
    }

    public void setDictKafkaPropValues(Collection<DictKafkaPropValueEntity> dictKafkaPropValues) {
        this.dictKafkaPropValues = dictKafkaPropValues;
    }
}
