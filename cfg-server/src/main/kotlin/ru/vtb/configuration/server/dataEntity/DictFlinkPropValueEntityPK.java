package ru.vtb.configuration.server.dataEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class DictFlinkPropValueEntityPK implements Serializable {
    @Column(name = "service_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String serviceId;
    @Column(name = "profile_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String profileId;
    @Column(name = "prop_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String propId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictFlinkPropValueEntityPK that = (DictFlinkPropValueEntityPK) o;

        if (serviceId != null ? !serviceId.equals(that.serviceId) : that.serviceId != null) return false;
        if (profileId != null ? !profileId.equals(that.profileId) : that.profileId != null) return false;
        if (propId != null ? !propId.equals(that.propId) : that.propId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = serviceId != null ? serviceId.hashCode() : 0;
        result = 31 * result + (profileId != null ? profileId.hashCode() : 0);
        result = 31 * result + (propId != null ? propId.hashCode() : 0);
        return result;
    }
}
