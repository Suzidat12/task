package com.app.task.dto;

import lombok.Data;

import java.util.List;

@Data
public class ApiResponse {
    private List<PickupResponse> pickup_dates;
}
