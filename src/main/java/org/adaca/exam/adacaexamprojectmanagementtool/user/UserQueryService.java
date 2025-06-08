package org.adaca.exam.adacaexamprojectmanagementtool.user;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class UserQueryService {

    private final JpaUserRepository userRepository;

    public User findByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(long userId) {
        return userRepository.findById(userId)
                .orElse(null);
    }
}
