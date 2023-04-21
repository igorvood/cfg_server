package ru.vtb.configuration.server.dataEntity;

import ru.vtb.processor.annotation.GenerateJpa;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dict_service_group", schema = "db_configuration_manager", catalog = "db_configuration_manager")
@IdClass(DictServiceGroupEntityPK.class)
@GenerateJpa(tableComment = "Cвязь группы и сервиса.", genRest = true, readOnly = true)
public class DictServiceGroupEntity {
    @Id
    @Column(name = "group_id")
    private String groupId;
    @Id
    @Column(name = "service_id")
    private String serviceId;
    @Id
    @Column(name = "profile_id")
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
        DictServiceGroupEntity that = (DictServiceGroupEntity) o;
        return Objects.equals(groupId, that.groupId) && Objects.equals(serviceId, that.serviceId) && Objects.equals(profileId, that.profileId);
    }

    @Override
    public int hashCode() {
        return this.getClass().getName().hashCode();
    }
}
