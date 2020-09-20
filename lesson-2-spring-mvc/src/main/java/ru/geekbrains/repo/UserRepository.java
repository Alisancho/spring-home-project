package ru.geekbrains.repo;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.persist.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByLogin(String login);

    List<User> findByLoginLike(String loginPattern);

    Object findAll(Specification<User> spec, PageRequest pageRequest);
}
