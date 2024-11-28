package ru.vtb.configuration.server.dataEntity;

import ru.vtb.processor.annotation.GenerateJpa;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dict_group", schema = "db_configuration_manager", catalog = "db_configuration_manager")
@GenerateJpa(tableComment = "Группа сервисов.", genRest = true, readOnly = true)
public class DictGroupEntity {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Basic
    @Column(name = "description", nullable = false)
    private String description;

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
        DictGroupEntity that = (DictGroupEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return this.getClass().getName().hashCode();
    }
}
