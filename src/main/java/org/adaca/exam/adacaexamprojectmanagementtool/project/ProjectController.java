package org.adaca.exam.adacaexamprojectmanagementtool.project;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/project")
@Slf4j
public class ProjectController {

    private final ProjectQueryService projectQueryService;

    @GetMapping
    public List<Project> getAllProjects() {
        return projectQueryService.getAllProjects();
    }
}
