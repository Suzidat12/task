package com.app.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PickupResponse {
   private String date;
   private String readable_date;
}
