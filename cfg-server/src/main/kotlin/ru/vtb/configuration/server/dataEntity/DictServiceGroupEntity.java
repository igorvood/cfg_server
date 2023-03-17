package ru.vtb.configuration.server.dataEntity;

import javax.persistence.*;

@Entity
@Table(name = "dict_service_group", schema = "db_configuration_manager", catalog = "db_configuration_manager")
@IdClass(DictServiceGroupEntityPK.class)
public class DictServiceGroupEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "group_id")
    private String groupId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "service_id")
    private String serviceId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "profile_id")
    private String profileId;
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false)
    private DictGroupEntity dictGroupByGroupId;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "service_id", referencedColumnName = "service_id", nullable = false), @JoinColumn(name = "profile_id", referencedColumnName = "profile_id", nullable = false)})
    private DictServiceNodeEntity dictServiceNode;

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

        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (serviceId != null ? !serviceId.equals(that.serviceId) : that.serviceId != null) return false;
        if (profileId != null ? !profileId.equals(that.profileId) : that.profileId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupId != null ? groupId.hashCode() : 0;
        result = 31 * result + (serviceId != null ? serviceId.hashCode() : 0);
        result = 31 * result + (profileId != null ? profileId.hashCode() : 0);
        return result;
    }

    public DictGroupEntity getDictGroupByGroupId() {
        return dictGroupByGroupId;
    }

    public void setDictGroupByGroupId(DictGroupEntity dictGroupByGroupId) {
        this.dictGroupByGroupId = dictGroupByGroupId;
    }

    public DictServiceNodeEntity getDictServiceNode() {
        return dictServiceNode;
    }

    public void setDictServiceNode(DictServiceNodeEntity dictServiceNode) {
        this.dictServiceNode = dictServiceNode;
    }
}
