package org.adaca.exam.adacaexamprojectmanagementtool.task;

import lombok.Builder;
import lombok.Data;
import org.adaca.exam.adacaexamprojectmanagementtool.tools.JsonDateFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
public class TaskCreateRequest {

    @NotEmpty
    @NotNull
    private String name;
    private Integer priority;
    private Status status;
    @NotEmpty
    @NotNull
    private Long projectId;
    private Long userId;
    @JsonDateFormat
    private LocalDate dueDate;
}
