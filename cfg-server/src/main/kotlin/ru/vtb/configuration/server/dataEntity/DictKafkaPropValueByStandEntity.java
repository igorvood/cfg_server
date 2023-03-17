package ru.vtb.configuration.server.dataEntity;

import javax.persistence.*;

@Entity
@Table(name = "dict_kafka_prop_value_by_stand", schema = "db_configuration_manager", catalog = "db_configuration_manager")
@IdClass(DictKafkaPropValueByStandEntityPK.class)
public class DictKafkaPropValueByStandEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "grp_id")
    private String grpId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "type_prop", insertable = false, updatable = false)
    private String typeProp;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "prop_id")
    private String propId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "stand_id")
    private String standId;
    @Basic
    @Column(name = "prop_value")
    private String propValue;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "type_prop", referencedColumnName = "type_prop", nullable = false), @JoinColumn(name = "grp_id", referencedColumnName = "grp_id", nullable = false), @JoinColumn(name = "prop_id", referencedColumnName = "prop_id", nullable = false)})
    private DictKafkaPropValueEntity dictKafkaPropValue;
    @ManyToOne
    @JoinColumn(name = "stand_id", referencedColumnName = "id", nullable = false)
    private MetaStandEntity metaStandByStandId;

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

    public String getStandId() {
        return standId;
    }

    public void setStandId(String standId) {
        this.standId = standId;
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

        DictKafkaPropValueByStandEntity that = (DictKafkaPropValueByStandEntity) o;

        if (grpId != null ? !grpId.equals(that.grpId) : that.grpId != null) return false;
        if (typeProp != null ? !typeProp.equals(that.typeProp) : that.typeProp != null) return false;
        if (propId != null ? !propId.equals(that.propId) : that.propId != null) return false;
        if (standId != null ? !standId.equals(that.standId) : that.standId != null) return false;
        if (propValue != null ? !propValue.equals(that.propValue) : that.propValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = grpId != null ? grpId.hashCode() : 0;
        result = 31 * result + (typeProp != null ? typeProp.hashCode() : 0);
        result = 31 * result + (propId != null ? propId.hashCode() : 0);
        result = 31 * result + (standId != null ? standId.hashCode() : 0);
        result = 31 * result + (propValue != null ? propValue.hashCode() : 0);
        return result;
    }

    public DictKafkaPropValueEntity getDictKafkaPropValue() {
        return dictKafkaPropValue;
    }

    public void setDictKafkaPropValue(DictKafkaPropValueEntity dictKafkaPropValue) {
        this.dictKafkaPropValue = dictKafkaPropValue;
    }

    public MetaStandEntity getMetaStandByStandId() {
        return metaStandByStandId;
    }

    public void setMetaStandByStandId(MetaStandEntity metaStandByStandId) {
        this.metaStandByStandId = metaStandByStandId;
    }
}
