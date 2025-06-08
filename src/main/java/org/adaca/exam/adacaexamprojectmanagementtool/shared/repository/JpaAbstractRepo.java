package org.adaca.exam.adacaexamprojectmanagementtool.shared.repository;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@AllArgsConstructor
public abstract class JpaAbstractRepo<T> {

    protected final EntityManager entityManager;

    @Transactional
    public void create(T object) {
        entityManager.persist(object);
    }

    @Transactional
    public void update(T object) {
        entityManager.unwrap(Session.class).merge(object);
    }

}
