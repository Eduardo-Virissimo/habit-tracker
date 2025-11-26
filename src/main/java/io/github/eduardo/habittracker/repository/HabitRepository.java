package io.github.eduardo.habittracker.repository;

import io.github.eduardo.habittracker.entity.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitRepository extends JpaRepository<Habit, Long> {
}
