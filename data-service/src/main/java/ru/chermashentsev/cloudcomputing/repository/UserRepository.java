package ru.voroncov.cloudcomputing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.voroncov.cloudcomputing.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
