package org.adaca.exam.adacaexamprojectmanagementtool.project;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.adaca.exam.adacaexamprojectmanagementtool.shared.repository.JpaAbstractRepo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@Transactional
public class JpaProjectRepository extends JpaAbstractRepo<Project> {

    private final ProjectRepository projectRepository;

    public JpaProjectRepository(EntityManager entityManager, ProjectRepository projectRepository) {
        super(entityManager);
        this.projectRepository = projectRepository;
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Optional<Project> findById(long projectId) {
        return projectRepository.findById(projectId);
    }
}
