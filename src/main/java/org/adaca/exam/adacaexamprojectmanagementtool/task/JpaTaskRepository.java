package org.adaca.exam.adacaexamprojectmanagementtool.task;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.adaca.exam.adacaexamprojectmanagementtool.shared.repository.JpaAbstractRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Slf4j
@Repository
@Transactional
public class JpaTaskRepository extends JpaAbstractRepo<Task> {

    private static final Set<String> ALLOWED_SORT_PROPERTIES = Set.of("name", "priority", "status", "dueDate", "createdDate");

    private final TaskRepository taskRepository;

    public JpaTaskRepository(EntityManager entityManager, TaskRepository taskRepository) {
        super(entityManager);
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(long id) {
        return taskRepository.findById(id)
                .orElse(null);
    }

    public List<Task> findByCriteria(TaskCriteria criteria) {
        Sort.Direction sortDirection = Sort.Direction.ASC;
        String[] sortProperties = new String[]{"name"};

        if (criteria.getSortDirection() != null) {
            sortDirection = criteria.getSortDirection();
        }

        if ((criteria.getSortBy() != null && !criteria.getSortBy().isEmpty()) && ALLOWED_SORT_PROPERTIES.containsAll(criteria.getSortBy())) {
            sortProperties = criteria.getSortBy().toArray(sortProperties);
        }

        return taskRepository.findAll(
                TaskSpecification.projectSpecification(criteria.getProjectIds())
                    .and(TaskSpecification.userSpecification(criteria.getUserIds())
                    .and(TaskSpecification.prioritySpecification(criteria.getPriorities())
                    .and(TaskSpecification.dueDateRangeSpecification(criteria.getDueDateFrom(), criteria.getDueDateTo())))),
                Sort.by(sortDirection, sortProperties));
    }

    public Page<Task> findByCriteriaPage(int page, int size, TaskCriteria criteria) {
        Sort.Direction sortDirection = Sort.Direction.ASC;
        String[] sortProperties = new String[]{"name"};

        if (criteria.getSortDirection() != null) {
            sortDirection = criteria.getSortDirection();
        }

        if ((criteria.getSortBy() != null && !criteria.getSortBy().isEmpty()) && ALLOWED_SORT_PROPERTIES.containsAll(criteria.getSortBy())) {
            sortProperties = criteria.getSortBy().toArray(sortProperties);
        }
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sortDirection, sortProperties));

        return taskRepository.findAll(
                TaskSpecification.projectSpecification(criteria.getProjectIds())
                        .and(TaskSpecification.userSpecification(criteria.getUserIds())
                                .and(TaskSpecification.prioritySpecification(criteria.getPriorities())
                                        .and(TaskSpecification.dueDateRangeSpecification(criteria.getDueDateFrom(), criteria.getDueDateTo())))),
                pageRequest);
    }
}
