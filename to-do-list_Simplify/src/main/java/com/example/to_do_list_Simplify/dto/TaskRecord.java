package com.example.to_do_list_Simplify.dto;

import com.example.to_do_list_Simplify.models.Priority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskRecord(@NotBlank String name, @NotBlank String description, boolean carriedOut, @NotNull Priority priority){

}
