package ru.vtb.configuration.server.dataEntity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collection;

@Entity
@Table(name = "meta_stand", schema = "db_configuration_manager", catalog = "db_configuration_manager")
public class MetaStandEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private String id;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "is_local")
    private BigInteger isLocal;
    @Basic
    @Column(name = "is_prod")
    private BigInteger isProd;
    @Basic
    @Column(name = "replacment_for_topic_name")
    private String replacmentForTopicName;
    @Basic
    @Column(name = "cnt_partition")
    private BigInteger cntPartition;
    @OneToMany(mappedBy = "metaStandByStandId")
    private Collection<DictKafkaPropValueByStandEntity> dictKafkaPropValueByStandsById;
    @OneToMany(mappedBy = "metaStandByStandId")
    private Collection<DictPlaceHolderByServiceEntity> dictPlaceHolderByServicesById;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getIsLocal() {
        return isLocal;
    }

    public void setIsLocal(BigInteger isLocal) {
        this.isLocal = isLocal;
    }

    public BigInteger getIsProd() {
        return isProd;
    }

    public void setIsProd(BigInteger isProd) {
        this.isProd = isProd;
    }

    public String getReplacmentForTopicName() {
        return replacmentForTopicName;
    }

    public void setReplacmentForTopicName(String replacmentForTopicName) {
        this.replacmentForTopicName = replacmentForTopicName;
    }

    public BigInteger getCntPartition() {
        return cntPartition;
    }

    public void setCntPartition(BigInteger cntPartition) {
        this.cntPartition = cntPartition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaStandEntity that = (MetaStandEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (isLocal != null ? !isLocal.equals(that.isLocal) : that.isLocal != null) return false;
        if (isProd != null ? !isProd.equals(that.isProd) : that.isProd != null) return false;
        if (replacmentForTopicName != null ? !replacmentForTopicName.equals(that.replacmentForTopicName) : that.replacmentForTopicName != null)
            return false;
        if (cntPartition != null ? !cntPartition.equals(that.cntPartition) : that.cntPartition != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (isLocal != null ? isLocal.hashCode() : 0);
        result = 31 * result + (isProd != null ? isProd.hashCode() : 0);
        result = 31 * result + (replacmentForTopicName != null ? replacmentForTopicName.hashCode() : 0);
        result = 31 * result + (cntPartition != null ? cntPartition.hashCode() : 0);
        return result;
    }

    public Collection<DictKafkaPropValueByStandEntity> getDictKafkaPropValueByStandsById() {
        return dictKafkaPropValueByStandsById;
    }

    public void setDictKafkaPropValueByStandsById(Collection<DictKafkaPropValueByStandEntity> dictKafkaPropValueByStandsById) {
        this.dictKafkaPropValueByStandsById = dictKafkaPropValueByStandsById;
    }

    public Collection<DictPlaceHolderByServiceEntity> getDictPlaceHolderByServicesById() {
        return dictPlaceHolderByServicesById;
    }

    public void setDictPlaceHolderByServicesById(Collection<DictPlaceHolderByServiceEntity> dictPlaceHolderByServicesById) {
        this.dictPlaceHolderByServicesById = dictPlaceHolderByServicesById;
    }
}
