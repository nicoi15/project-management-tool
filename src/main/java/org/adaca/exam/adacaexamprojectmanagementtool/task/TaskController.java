package org.adaca.exam.adacaexamprojectmanagementtool.task;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/task")
@Slf4j
public class TaskController {

    private final TaskService taskService;
    private final TaskQueryService taskQueryService;

    @GetMapping
    public List<Task> getTasks(@Valid TaskCriteria criteria) {
        return taskQueryService.findTasksByCriteria(criteria);
    }

    @GetMapping("/paged")
    public Page<Task> getPagedTasks(@RequestParam(required = false, defaultValue = "0") Integer pageNumber,
                                    @RequestParam(required = false, defaultValue = "20") Integer pageSize,
                                    @Valid TaskCriteria criteria) {
        return taskQueryService.findPagedTasksByCriteria(pageNumber, pageSize, criteria);
    }

    @PostMapping
    public void create(@RequestBody @Valid TaskCreateRequest request) {
        taskService.create(request);
    }


    @PutMapping("{id}")
    public void update(@PathVariable long id, @RequestBody @Valid TaskUpdateRequest request) {
        taskService.update(id, request);
    }
}
