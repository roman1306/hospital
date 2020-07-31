package com.github.roman1306.registry.presentation;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class DoctorView {

    private UUID id;

    private String name;

    private String description;

    private String photo;

    private List<String> specialities;

}
