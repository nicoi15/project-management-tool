package org.adaca.exam.adacaexamprojectmanagementtool.task;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PageTaskRepository extends PagingAndSortingRepository<Task, Long>, JpaSpecificationExecutor<Task> {
}
