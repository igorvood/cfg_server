package ru.vtb.configuration.server.dataEntity;

import ru.vtb.processor.annotation.GenerateJpa;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dict_service", schema = "db_configuration_manager", catalog = "db_configuration_manager")
@GenerateJpa(tableComment = "Данные по сервису", genRest = true, readOnly = true)
public class DictServiceEntity {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Basic
    @Column(name = "main_class", nullable = false)
    private String mainClass;

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
        return Objects.equals(id, that.id) && Objects.equals(mainClass, that.mainClass);
    }

    @Override
    public int hashCode() {
        return this.getClass().getName().hashCode();
    }
}
