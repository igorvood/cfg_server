package ru.vtb.configuration.server.dataEntity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "dict_service_node", schema = "db_configuration_manager", catalog = "db_configuration_manager")
@IdClass(DictServiceNodeEntityPK.class)
public class DictServiceNodeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "service_id")
    private String serviceId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "profile_id")
    private String profileId;
    @Basic
    @Column(name = "node_type")
    private String nodeType;
    @Basic
    @Column(name = "id")
    private String id;
    @Basic
    @Column(name = "report_description")
    private String reportDescription;
    @OneToMany(mappedBy = "dictServiceNode")
    private Collection<DictFlinkPropValueEntity> dictFlinkPropValues;
    @OneToMany(mappedBy = "dictServiceNode")
    private Collection<DictPlaceHolderByServiceEntity> dictPlaceHolderByServices;
    @OneToMany(mappedBy = "dictServiceNode")
    private Collection<DictServiceGroupEntity> dictServiceGroups;
    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id", nullable = false)
    private DictServiceEntity dictServiceByServiceId;

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

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReportDescription() {
        return reportDescription;
    }

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictServiceNodeEntity that = (DictServiceNodeEntity) o;

        if (serviceId != null ? !serviceId.equals(that.serviceId) : that.serviceId != null) return false;
        if (profileId != null ? !profileId.equals(that.profileId) : that.profileId != null) return false;
        if (nodeType != null ? !nodeType.equals(that.nodeType) : that.nodeType != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (reportDescription != null ? !reportDescription.equals(that.reportDescription) : that.reportDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = serviceId != null ? serviceId.hashCode() : 0;
        result = 31 * result + (profileId != null ? profileId.hashCode() : 0);
        result = 31 * result + (nodeType != null ? nodeType.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (reportDescription != null ? reportDescription.hashCode() : 0);
        return result;
    }

    public Collection<DictFlinkPropValueEntity> getDictFlinkPropValues() {
        return dictFlinkPropValues;
    }

    public void setDictFlinkPropValues(Collection<DictFlinkPropValueEntity> dictFlinkPropValues) {
        this.dictFlinkPropValues = dictFlinkPropValues;
    }

    public Collection<DictPlaceHolderByServiceEntity> getDictPlaceHolderByServices() {
        return dictPlaceHolderByServices;
    }

    public void setDictPlaceHolderByServices(Collection<DictPlaceHolderByServiceEntity> dictPlaceHolderByServices) {
        this.dictPlaceHolderByServices = dictPlaceHolderByServices;
    }

    public Collection<DictServiceGroupEntity> getDictServiceGroups() {
        return dictServiceGroups;
    }

    public void setDictServiceGroups(Collection<DictServiceGroupEntity> dictServiceGroups) {
        this.dictServiceGroups = dictServiceGroups;
    }

    public DictServiceEntity getDictServiceByServiceId() {
        return dictServiceByServiceId;
    }

    public void setDictServiceByServiceId(DictServiceEntity dictServiceByServiceId) {
        this.dictServiceByServiceId = dictServiceByServiceId;
    }
}
