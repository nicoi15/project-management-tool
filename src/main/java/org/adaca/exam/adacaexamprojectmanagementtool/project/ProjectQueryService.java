package org.adaca.exam.adacaexamprojectmanagementtool.project;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class ProjectQueryService {

    private final JpaProjectRepository jpaProjectRepository;

    public List<Project> getAllProjects() {
        return jpaProjectRepository.findAll();
    }

    public Project findById(long projectId) {
        return jpaProjectRepository.findById(projectId)
                .orElse(null);
    }
}
