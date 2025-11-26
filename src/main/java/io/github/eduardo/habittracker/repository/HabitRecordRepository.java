package io.github.eduardo.habittracker.repository;

import io.github.eduardo.habittracker.entity.HabitRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitRecordRepository extends JpaRepository<HabitRecord, Long> {
}
