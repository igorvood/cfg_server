package ru.vtb.configuration.server.dataEntity;


import ru.vood.processor.annotation.GenerateJpa;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "dict_currency", schema = "db_configuration_manager", catalog = "db_configuration_manager")
@GenerateJpa(tableComment = "Справочник валют", genRest = true, readOnly = false)
public class DictCurrencyEntity {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Basic
    @Column(name = "iso", updatable = true, nullable = false)
    private String iso;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictCurrencyEntity that = (DictCurrencyEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (iso != null ? !iso.equals(that.iso) : that.iso != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return this.getClass().getName().hashCode();
    }
}
