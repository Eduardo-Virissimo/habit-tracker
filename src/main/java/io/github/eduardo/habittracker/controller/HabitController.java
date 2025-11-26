package io.github.eduardo.habittracker.controller;


import io.github.eduardo.habittracker.dto.HabitCreateDTO;
import io.github.eduardo.habittracker.dto.HabitResponseDTO;
import io.github.eduardo.habittracker.entity.Habit;
import io.github.eduardo.habittracker.service.HabitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habits")
public class HabitController {

    @Autowired
    private HabitService service;

    @PostMapping
    public HabitResponseDTO createHabit(@Valid @RequestBody HabitCreateDTO dto) {
        Habit h = service.createHabit(dto);
        return new HabitResponseDTO(h.getId(), h.getName(), h.getDescription());
    }

    @GetMapping
    public List<Habit> list() {
        return service.listAll();
    }

    @PostMapping("/{id}/record")
    public String record(@PathVariable Long id) {
        service.recordHabit(id);
        return "Habit recorded";
    }
}
