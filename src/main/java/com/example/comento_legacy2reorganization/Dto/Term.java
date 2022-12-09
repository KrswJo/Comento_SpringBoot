package com.example.comento_legacy2reorganization.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Builder
@Getter
public class Term {
    private String startTime;
    private String endTime;
}
