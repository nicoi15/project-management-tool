package org.adaca.exam.adacaexamprojectmanagementtool.task;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class TaskCriteria {

    private List<Integer> priorities;
    private List<Long> projectIds;
    private List<Long> userIds;
    private LocalDate dueDateFrom;
    private LocalDate dueDateTo;
    private List<String> sortBy;
    private Sort.Direction sortDirection;
}
