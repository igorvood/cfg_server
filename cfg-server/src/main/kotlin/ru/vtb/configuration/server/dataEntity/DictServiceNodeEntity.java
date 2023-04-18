package ru.vtb.configuration.server.dataEntity;

import ru.vtb.processor.annotation.GenerateJpa;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dict_service_node", schema = "db_configuration_manager", catalog = "db_configuration_manager")
@IdClass(DictServiceNodeEntityPK.class)
@GenerateJpa(tableComment = "Нода сервиса", genRest = true, readOnly = true)
public class DictServiceNodeEntity {
    @Id
    @Column(name = "service_id", nullable = false)
    private String serviceId;
    @Id
    @Column(name = "profile_id", nullable = false)
    private String profileId;
    @Basic
    @Column(name = "node_type", nullable = false, updatable = false)
    private String nodeType;
    @Basic
    @Column(name = "id", nullable = false, updatable = false)
    private String id;
    @Basic
    @Column(name = "report_description", nullable = false)
    private String reportDescription;

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
        return Objects.equals(serviceId, that.serviceId) && Objects.equals(profileId, that.profileId) && Objects.equals(nodeType, that.nodeType) && Objects.equals(id, that.id) && Objects.equals(reportDescription, that.reportDescription);
    }

    @Override
    public int hashCode() {
        return this.getClass().getName().hashCode();
    }
}
