package ru.vtb.configuration.server.dataEntity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "dict_flink_prop_value", schema = "db_configuration_manager", catalog = "db_configuration_manager")
@IdClass(DictFlinkPropValueEntityPK.class)
public class DictFlinkPropValueEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "service_id")
    private String serviceId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "profile_id")
    private String profileId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "prop_id")
    private String propId;
    @Basic
    @Column(name = "prop_value")
    private String propValue;
    @Basic
    @Column(name = "is_function")
    private BigInteger isFunction;
    @Basic
    @Column(name = "function_id")
    private String functionId;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "service_id", referencedColumnName = "service_id", nullable = false), @JoinColumn(name = "profile_id", referencedColumnName = "profile_id", nullable = false)})
    private DictServiceNodeEntity dictServiceNode;
    @ManyToOne
    @JoinColumn(name = "function_id", referencedColumnName = "id")
    private MetaPropertyFunctionEntity metaPropertyFunctionByFunctionId;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
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

    public BigInteger getIsFunction() {
        return isFunction;
    }

    public void setIsFunction(BigInteger isFunction) {
        this.isFunction = isFunction;
    }

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictFlinkPropValueEntity that = (DictFlinkPropValueEntity) o;

        if (serviceId != null ? !serviceId.equals(that.serviceId) : that.serviceId != null) return false;
        if (profileId != null ? !profileId.equals(that.profileId) : that.profileId != null) return false;
        if (propId != null ? !propId.equals(that.propId) : that.propId != null) return false;
        if (propValue != null ? !propValue.equals(that.propValue) : that.propValue != null) return false;
        if (isFunction != null ? !isFunction.equals(that.isFunction) : that.isFunction != null) return false;
        if (functionId != null ? !functionId.equals(that.functionId) : that.functionId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = serviceId != null ? serviceId.hashCode() : 0;
        result = 31 * result + (profileId != null ? profileId.hashCode() : 0);
        result = 31 * result + (propId != null ? propId.hashCode() : 0);
        result = 31 * result + (propValue != null ? propValue.hashCode() : 0);
        result = 31 * result + (isFunction != null ? isFunction.hashCode() : 0);
        result = 31 * result + (functionId != null ? functionId.hashCode() : 0);
        return result;
    }

    public DictServiceNodeEntity getDictServiceNode() {
        return dictServiceNode;
    }

    public void setDictServiceNode(DictServiceNodeEntity dictServiceNode) {
        this.dictServiceNode = dictServiceNode;
    }

    public MetaPropertyFunctionEntity getMetaPropertyFunctionByFunctionId() {
        return metaPropertyFunctionByFunctionId;
    }

    public void setMetaPropertyFunctionByFunctionId(MetaPropertyFunctionEntity metaPropertyFunctionByFunctionId) {
        this.metaPropertyFunctionByFunctionId = metaPropertyFunctionByFunctionId;
    }
}
