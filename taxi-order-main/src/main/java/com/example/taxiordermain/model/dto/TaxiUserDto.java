package com.example.taxiordermain.model.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaxiUserDto {
    @NotNull
    private String name;
    @NotNull
    private String email;
    private boolean approved = false;
}
