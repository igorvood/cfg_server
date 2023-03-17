package ru.vtb.configuration.server.dataEntity;

import javax.persistence.*;

@Entity
@Table(name = "dict_place_holder_by_service", schema = "db_configuration_manager", catalog = "db_configuration_manager")
@IdClass(DictPlaceHolderByServiceEntityPK.class)
public class DictPlaceHolderByServiceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "service_id")
    private String serviceId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "profile_id")
    private String profileId;
    @Basic
    @Column(name = "stand_id")
    private String standId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "place_holder_id")
    private String placeHolderId;
    @Basic
    @Column(name = "value")
    private String value;
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "service_id", referencedColumnName = "service_id", nullable = false), @JoinColumn(name = "profile_id", referencedColumnName = "profile_id", nullable = false)})
    private DictServiceNodeEntity dictServiceNode;
    @ManyToOne
    @JoinColumn(name = "stand_id", referencedColumnName = "id", nullable = false)
    private MetaStandEntity metaStandByStandId;
    @ManyToOne
    @JoinColumn(name = "place_holder_id", referencedColumnName = "id", nullable = false)
    private DictPlaceHolderEntity dictPlaceHolderByPlaceHolderId;

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

    public String getStandId() {
        return standId;
    }

    public void setStandId(String standId) {
        this.standId = standId;
    }

    public String getPlaceHolderId() {
        return placeHolderId;
    }

    public void setPlaceHolderId(String placeHolderId) {
        this.placeHolderId = placeHolderId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictPlaceHolderByServiceEntity that = (DictPlaceHolderByServiceEntity) o;

        if (serviceId != null ? !serviceId.equals(that.serviceId) : that.serviceId != null) return false;
        if (profileId != null ? !profileId.equals(that.profileId) : that.profileId != null) return false;
        if (standId != null ? !standId.equals(that.standId) : that.standId != null) return false;
        if (placeHolderId != null ? !placeHolderId.equals(that.placeHolderId) : that.placeHolderId != null)
            return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = serviceId != null ? serviceId.hashCode() : 0;
        result = 31 * result + (profileId != null ? profileId.hashCode() : 0);
        result = 31 * result + (standId != null ? standId.hashCode() : 0);
        result = 31 * result + (placeHolderId != null ? placeHolderId.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    public DictServiceNodeEntity getDictServiceNode() {
        return dictServiceNode;
    }

    public void setDictServiceNode(DictServiceNodeEntity dictServiceNode) {
        this.dictServiceNode = dictServiceNode;
    }

    public MetaStandEntity getMetaStandByStandId() {
        return metaStandByStandId;
    }

    public void setMetaStandByStandId(MetaStandEntity metaStandByStandId) {
        this.metaStandByStandId = metaStandByStandId;
    }

    public DictPlaceHolderEntity getDictPlaceHolderByPlaceHolderId() {
        return dictPlaceHolderByPlaceHolderId;
    }

    public void setDictPlaceHolderByPlaceHolderId(DictPlaceHolderEntity dictPlaceHolderByPlaceHolderId) {
        this.dictPlaceHolderByPlaceHolderId = dictPlaceHolderByPlaceHolderId;
    }
}
