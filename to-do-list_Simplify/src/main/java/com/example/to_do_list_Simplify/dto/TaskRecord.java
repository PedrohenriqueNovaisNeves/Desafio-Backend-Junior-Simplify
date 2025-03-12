package com.example.to_do_list_Simplify.dto;

import jakarta.validation.constraints.NotBlank;

public record TaskRecord(@NotBlank String name, @NotBlank String description, boolean carriedOut, @NotBlank String priority){

}
