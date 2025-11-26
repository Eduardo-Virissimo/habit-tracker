package io.github.eduardo.habittracker.dto;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class HabitCreateDTO {
    @NotBlank
    private String name;

    private String description;

}
