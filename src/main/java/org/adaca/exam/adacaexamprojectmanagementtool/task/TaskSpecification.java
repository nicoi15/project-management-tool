package org.adaca.exam.adacaexamprojectmanagementtool.task;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.adaca.exam.adacaexamprojectmanagementtool.project.Project;
import org.adaca.exam.adacaexamprojectmanagementtool.user.User;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TaskSpecification {

    public static Specification<Task> prioritySpecification(List<Integer> priorities) {
        return (root, query, builder) -> {
            if (priorities == null || priorities.isEmpty()) {
                return builder.conjunction();
            }
            List<Predicate> predicates = new ArrayList<>();
            for (Integer priority: priorities) {
                predicates.add(builder.equal(root.get("priority"), priority));
            }

            return builder.or(predicates.toArray(new Predicate[0]));
        };
    }

    public static Specification<Task> projectSpecification(List<Long> projectIds) {
        return (root, query, builder) -> {
            if (projectIds == null || projectIds.isEmpty()) {
                return builder.conjunction();
            }

            Join<Project, Task> projectJoin = root.join("project");
            List<Predicate> predicates = new ArrayList<>();
            for (Long projectId : projectIds) {
                predicates.add(builder.equal(projectJoin.get("id"), projectId));
            }
            return builder.or(predicates.toArray(new Predicate[0]));
        };
    }

    public static Specification<Task> userSpecification(List<Long> userIds) {
        return (root, query, builder) -> {
            if (userIds == null || userIds.isEmpty()) {
                return builder.conjunction();
            }

            Join<User, Task> userJoin = root.join("user");
            List<Predicate> predicates = new ArrayList<>();
            for (Long userId : userIds) {
                predicates.add(builder.equal(userJoin.get("id"), userId));
            }
            return builder.or(predicates.toArray(new Predicate[0]));
        };
    }

    public static Specification<Task> dueDateRangeSpecification(LocalDate fromDate, LocalDate toDate) {
        return (root, query, criteriaBuilder) -> {
            if (fromDate == null && toDate == null) {
                return criteriaBuilder.conjunction();
            }

            if (fromDate == null) {
                return criteriaBuilder.lessThanOrEqualTo(root.get("dueDate"), toDate);
            }

            if (toDate == null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("dueDate"), fromDate);
            }

            return criteriaBuilder.between(root.get("dueDate"), fromDate, toDate);
        };
    }
}
