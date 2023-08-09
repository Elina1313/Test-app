package ru.test.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.test.test.model.Count;

@Repository
public interface CountRepository extends JpaRepository<Count, Integer> {
    boolean existsByCounterId(String counterId);

    Count findAllByCounterId(String counterId);
}
