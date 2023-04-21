package ru.vtb.configuration.server.dataEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class DictServiceGroupEntityPK implements Serializable {
    @Column(name = "group_id")
    @Id
    private String groupId;
    @Column(name = "service_id")
    @Id
    private String serviceId;
    @Column(name = "profile_id")
    @Id
    private String profileId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictServiceGroupEntityPK that = (DictServiceGroupEntityPK) o;
        return Objects.equals(groupId, that.groupId) && Objects.equals(serviceId, that.serviceId) && Objects.equals(profileId, that.profileId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, serviceId, profileId);
    }
}
