package com.github.roman1306.registry.presentation;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
public class DoctorView {

    private UUID id;

    private String name;

    private String description;

    private String photo;
}
