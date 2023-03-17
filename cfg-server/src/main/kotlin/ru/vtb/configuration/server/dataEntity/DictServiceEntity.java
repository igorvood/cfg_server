package ru.vtb.configuration.server.dataEntity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "dict_service", schema = "db_configuration_manager", catalog = "db_configuration_manager")
public class DictServiceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private String id;
    @Basic
    @Column(name = "main_class")
    private String mainClass;
    @OneToMany(mappedBy = "dictServiceByServiceId")
    private Collection<DictServiceNodeEntity> dictServiceNodesById;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMainClass() {
        return mainClass;
    }

    public void setMainClass(String mainClass) {
        this.mainClass = mainClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictServiceEntity that = (DictServiceEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (mainClass != null ? !mainClass.equals(that.mainClass) : that.mainClass != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (mainClass != null ? mainClass.hashCode() : 0);
        return result;
    }

    public Collection<DictServiceNodeEntity> getDictServiceNodesById() {
        return dictServiceNodesById;
    }

    public void setDictServiceNodesById(Collection<DictServiceNodeEntity> dictServiceNodesById) {
        this.dictServiceNodesById = dictServiceNodesById;
    }
}
