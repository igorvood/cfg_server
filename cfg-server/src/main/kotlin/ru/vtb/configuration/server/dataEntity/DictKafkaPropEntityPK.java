package ru.vtb.configuration.server.dataEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class DictKafkaPropEntityPK implements Serializable {
    @Column(name = "type_prop")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String typeProp;
    @Column(name = "prop_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String propId;

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

        DictKafkaPropEntityPK that = (DictKafkaPropEntityPK) o;

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
}
