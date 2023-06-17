package com.example.team.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Position {

    MENTEE("ROLE_MENTEE"),
    MENTOR("ROLE_MENTOR");

    private final String value;
}
