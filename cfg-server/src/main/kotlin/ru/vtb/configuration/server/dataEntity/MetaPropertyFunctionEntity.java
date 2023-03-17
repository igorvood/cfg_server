package ru.vtb.configuration.server.dataEntity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "meta_property_function", schema = "db_configuration_manager", catalog = "db_configuration_manager")
public class MetaPropertyFunctionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private String id;
    @Basic
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "metaPropertyFunctionByFunctionId")
    private Collection<DictFlinkPropValueEntity> dictFlinkPropValuesById;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

        MetaPropertyFunctionEntity that = (MetaPropertyFunctionEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public Collection<DictFlinkPropValueEntity> getDictFlinkPropValuesById() {
        return dictFlinkPropValuesById;
    }

    public void setDictFlinkPropValuesById(Collection<DictFlinkPropValueEntity> dictFlinkPropValuesById) {
        this.dictFlinkPropValuesById = dictFlinkPropValuesById;
    }
}
