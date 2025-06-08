package org.adaca.exam.adacaexamprojectmanagementtool.user;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final UserQueryService userQueryService;

    @GetMapping
    public List<User> getUsers() {
        return userQueryService.findAll();
    }

    @GetMapping("{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userQueryService.findByUserName(username);
    }
}
