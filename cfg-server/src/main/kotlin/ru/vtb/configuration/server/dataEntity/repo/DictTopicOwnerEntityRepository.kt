package ru.vtb.configuration.server.dataEntity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.vtb.configuration.server.dataEntity.DictTopicOwnerEntity;

@Repository
public interface DictTopicOwnerEntityRepository extends JpaRepository<DictTopicOwnerEntity, String> {

    @Modifying(flushAutomatically = true)
    @Query("update DictTopicOwnerEntity u set u.id = :newId where u.id = :id")
    @Transactional(propagation = Propagation.MANDATORY)
    void update(@Param("id") String id,
                @Param("newId") String newId
//                @Param("newVals") DictTopicOwnerEntity dictTopicOwnerEntity
    );

}