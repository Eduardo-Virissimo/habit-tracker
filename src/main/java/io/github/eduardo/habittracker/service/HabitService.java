package io.github.eduardo.habittracker.service;

import io.github.eduardo.habittracker.dto.HabitCreateDTO;
import io.github.eduardo.habittracker.entity.Habit;
import io.github.eduardo.habittracker.entity.HabitRecord;
import io.github.eduardo.habittracker.exception.HabitNotFoundException;
import io.github.eduardo.habittracker.repository.HabitRecordRepository;
import io.github.eduardo.habittracker.repository.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HabitService {

    @Autowired
    HabitRepository habitRepository;

    @Autowired
    HabitRecordRepository habitRecordRepository;

    public Habit createHabit(HabitCreateDTO dto) {
        Habit habit = new Habit();
        habit.setName(dto.getName());
        habit.setDescription(dto.getDescription());
        return habitRepository.save(habit);
    }

    public List<Habit> listAll(){
        return habitRepository.findAll();
    }

    public Habit getById(Long id){
        return habitRepository.findById(id).orElseThrow(() -> new HabitNotFoundException("Habit not found"));
    }

    public HabitRecord recordHabit(Long habitId){
        Habit habit = getById(habitId);

        HabitRecord record = new HabitRecord();
        record.setData(LocalDate.now());
        record.setHabit(habit);

        return habitRecordRepository.save(record);
    }
}
