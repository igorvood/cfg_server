package ru.vtb.configuration.server.dataEntity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "dict_place_holder", schema = "db_configuration_manager", catalog = "db_configuration_manager")
public class DictPlaceHolderEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private String id;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "default_value")
    private String defaultValue;
    @OneToMany(mappedBy = "dictPlaceHolderByPlaceHolderId")
    private Collection<DictPlaceHolderByServiceEntity> dictPlaceHolderByServicesById;

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

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictPlaceHolderEntity that = (DictPlaceHolderEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (defaultValue != null ? !defaultValue.equals(that.defaultValue) : that.defaultValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (defaultValue != null ? defaultValue.hashCode() : 0);
        return result;
    }

    public Collection<DictPlaceHolderByServiceEntity> getDictPlaceHolderByServicesById() {
        return dictPlaceHolderByServicesById;
    }

    public void setDictPlaceHolderByServicesById(Collection<DictPlaceHolderByServiceEntity> dictPlaceHolderByServicesById) {
        this.dictPlaceHolderByServicesById = dictPlaceHolderByServicesById;
    }
}
