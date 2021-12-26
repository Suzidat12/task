/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.task.dto;

import lombok.Data;

/**
 *
 * @author HP
 */
@Data
public class PickupRequest {
   private  String pickup_day;
   private int recurrence;
}
