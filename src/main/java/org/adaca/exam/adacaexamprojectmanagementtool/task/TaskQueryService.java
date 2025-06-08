package org.adaca.exam.adacaexamprojectmanagementtool.task;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class TaskQueryService {

    private final JpaTaskRepository jpaTaskRepository;

    public List<Task> findTasksByCriteria(TaskCriteria taskCriteria) {
        return jpaTaskRepository.findByCriteria(taskCriteria);
    }

    public Page<Task> findPagedTasksByCriteria(int page, int size, TaskCriteria taskCriteria) {
        return jpaTaskRepository.findByCriteriaPage(page, size, taskCriteria);
    }
}
