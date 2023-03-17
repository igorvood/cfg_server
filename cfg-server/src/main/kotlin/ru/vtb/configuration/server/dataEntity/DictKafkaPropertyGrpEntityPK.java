package ru.vtb.configuration.server.dataEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class DictKafkaPropertyGrpEntityPK implements Serializable {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "type_read")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String typeRead;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictKafkaPropertyGrpEntityPK that = (DictKafkaPropertyGrpEntityPK) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (typeRead != null ? !typeRead.equals(that.typeRead) : that.typeRead != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (typeRead != null ? typeRead.hashCode() : 0);
        return result;
    }
}
