package io.github.eduardo.habittracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HabitResponseDTO {
    private Long id;
    private String name;
    private String description;
}
