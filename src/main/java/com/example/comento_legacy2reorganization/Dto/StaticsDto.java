package com.example.comento_legacy2reorganization.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class StaticsDto {
    private boolean isSuccesses;
    private String requestType;
    private String message;
    private Long resultCount;
    private Number result;
}
