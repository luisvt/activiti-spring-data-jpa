package org.activiti.springdatajpa.repositories;

import org.activiti.springdatajpa.models.ProcessDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProcessDefinitionRepository extends JpaRepository<ProcessDefinition, String> {

    @Query("SELECT pd FROM ProcessDefinition pd WHERE pd.deploymentId = ?1 AND pd.key = ?2 AND (pd.tenantId = '' OR pd.tenantId IS NULL)")
    ProcessDefinition findOneByDeploymentIdAndKey(String deploymentId, String key);

    ProcessDefinition findOneByDeploymentIdAndKeyAndTenantId(String deploymentId, String key, String tenantId);

    @Query("SELECT pd FROM ProcessDefinition pd" +
            " WHERE pd.key = ?1" +
            " AND pd.tenantId = '' OR pd.tenantId IS NULL" +
            " AND pd.version = (" +
            "   SELECT MAX(pd1.version) FROM ProcessDefinition pd1" +
            "   WHERE pd1.key = pd1.key " +
            "   AND (pd1.tenantId = '' OR pd1.tenantId IS NULL))")
    ProcessDefinition findLatestByKey(String key);

    @Query("SELECT pd FROM ProcessDefinition pd" +
            " WHERE pd.key = ?1" +
            " AND pd.tenantId = '' OR pd.tenantId IS NULL" +
            " AND pd.version = (" +
            "   SELECT MAX(pd1.version) FROM ProcessDefinition pd1" +
            "   WHERE pd1.key = pd1.key " +
            "   AND pd1.tenantId = ?2)")
    ProcessDefinition findLatestByKeyAndTenantId(String key, String tenantId);

}

