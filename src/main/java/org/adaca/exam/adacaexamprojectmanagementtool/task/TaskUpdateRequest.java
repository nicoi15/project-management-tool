package org.adaca.exam.adacaexamprojectmanagementtool.task;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class TaskUpdateRequest {

    private String name;
    private Status status;
    private LocalDate dueDate;
    private Long userId;
}
