package org.adaca.exam.adacaexamprojectmanagementtool.task;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.adaca.exam.adacaexamprojectmanagementtool.email.EmailService;
import org.adaca.exam.adacaexamprojectmanagementtool.project.Project;
import org.adaca.exam.adacaexamprojectmanagementtool.project.ProjectQueryService;
import org.adaca.exam.adacaexamprojectmanagementtool.user.User;
import org.adaca.exam.adacaexamprojectmanagementtool.user.UserQueryService;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDateTime;

@AllArgsConstructor
@Service
@Slf4j
public class TaskService {


    private final JpaTaskRepository jpaTaskRepository;
    private final ProjectQueryService projectQueryService;
    private final UserQueryService userQueryService;
    private final EmailService emailService;

    public void create(@Valid TaskCreateRequest request) {
        log.info("Task create request received: {}", request);

        Project project = projectQueryService.findById(request.getProjectId());
        Task.TaskBuilder builder = Task.builder()
                .createdDate(LocalDateTime.now())
                .status(request.getStatus())
                .name(request.getName())
                .priority(request.getPriority())
                .project(project);

        if (request.getUserId() != null) {
            User user = userQueryService.findById(request.getUserId());
            builder.user(user);
        }

        jpaTaskRepository.create(builder.build());
    }

    public void update(long id, @Valid TaskUpdateRequest request) {
        log.info("Task update request received: {}", request);
        Task task = jpaTaskRepository.findById(id);

        if (request.getStatus() != null) {
            task.setStatus(request.getStatus());
        }

        if (request.getName() != null) {
            task.setName(request.getName());
        }

        if (request.getDueDate() != null) {
            request.setDueDate(request.getDueDate());
        }

        if (request.getUserId() != null) {
            User user = userQueryService.findById(request.getUserId());
            task.setUser(user);
            emailService.send(user.getEmail(),
                    "A task has been assigned",
                    String.format("Task: %s Due date: %s", task.getName(), task.getDueDate().toString()));
        }

        jpaTaskRepository.update(task);
    }
}
