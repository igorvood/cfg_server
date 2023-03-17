package ru.vtb.configuration.server.dataEntity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "dict_kafka_prop_value", schema = "db_configuration_manager", catalog = "db_configuration_manager")
@IdClass(DictKafkaPropValueEntityPK.class)
public class DictKafkaPropValueEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "grp_id")
    private String grpId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "type_prop")
    private String typeProp;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "prop_id")
    private String propId;
    @Basic
    @Column(name = "prop_value")
    private String propValue;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "type_prop", referencedColumnName = "type_read", nullable = false), @JoinColumn(name = "grp_id", referencedColumnName = "id", nullable = false)})
    private DictKafkaPropertyGrpEntity dictKafkaPropertyGrp;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "type_prop", referencedColumnName = "type_prop", nullable = false), @JoinColumn(name = "prop_id", referencedColumnName = "prop_id", nullable = false)})
    private DictKafkaPropEntity dictKafkaProp;
    @OneToMany(mappedBy = "dictKafkaPropValue")
    private Collection<DictKafkaPropValueByStandEntity> dictKafkaPropValueByStands;

    public String getGrpId() {
        return grpId;
    }

    public void setGrpId(String grpId) {
        this.grpId = grpId;
    }

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

    public String getPropValue() {
        return propValue;
    }

    public void setPropValue(String propValue) {
        this.propValue = propValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictKafkaPropValueEntity that = (DictKafkaPropValueEntity) o;

        if (grpId != null ? !grpId.equals(that.grpId) : that.grpId != null) return false;
        if (typeProp != null ? !typeProp.equals(that.typeProp) : that.typeProp != null) return false;
        if (propId != null ? !propId.equals(that.propId) : that.propId != null) return false;
        if (propValue != null ? !propValue.equals(that.propValue) : that.propValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = grpId != null ? grpId.hashCode() : 0;
        result = 31 * result + (typeProp != null ? typeProp.hashCode() : 0);
        result = 31 * result + (propId != null ? propId.hashCode() : 0);
        result = 31 * result + (propValue != null ? propValue.hashCode() : 0);
        return result;
    }

    public DictKafkaPropertyGrpEntity getDictKafkaPropertyGrp() {
        return dictKafkaPropertyGrp;
    }

    public void setDictKafkaPropertyGrp(DictKafkaPropertyGrpEntity dictKafkaPropertyGrp) {
        this.dictKafkaPropertyGrp = dictKafkaPropertyGrp;
    }

    public DictKafkaPropEntity getDictKafkaProp() {
        return dictKafkaProp;
    }

    public void setDictKafkaProp(DictKafkaPropEntity dictKafkaProp) {
        this.dictKafkaProp = dictKafkaProp;
    }

    public Collection<DictKafkaPropValueByStandEntity> getDictKafkaPropValueByStands() {
        return dictKafkaPropValueByStands;
    }

    public void setDictKafkaPropValueByStands(Collection<DictKafkaPropValueByStandEntity> dictKafkaPropValueByStands) {
        this.dictKafkaPropValueByStands = dictKafkaPropValueByStands;
    }
}
