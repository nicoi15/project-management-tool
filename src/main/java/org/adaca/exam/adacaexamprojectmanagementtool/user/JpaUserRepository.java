package org.adaca.exam.adacaexamprojectmanagementtool.user;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.adaca.exam.adacaexamprojectmanagementtool.shared.repository.JpaAbstractRepo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@Transactional
public class JpaUserRepository extends JpaAbstractRepo<User> {

    private final UserRepository userRepository;

    public JpaUserRepository(EntityManager entityManager, UserRepository userRepository) {
        super(entityManager);
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        return userRepository
                .findByUsername(username)
                .orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(long userId) {
        return userRepository.findById(userId);
    }
}
