package com.app.task.service;

import com.app.task.dto.ApiResponse;
import com.app.task.dto.PickupRequest;
import com.app.task.dto.PickupResponse;
import com.app.task.utils.AppUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Component
@ApplicationScope
@Slf4j
public class AppService {
    private List<Integer> stores;
    private List<String> days;

    @PostConstruct
    public void init() {
        stores = new ArrayList<>();
        days = new ArrayList<>();
        stores.add(4);
        stores.add(1);
        stores.add(2);
        days.add("MONDAY");
        days.add("TUESDAY");
        days.add("WEDNESDAY");
        days.add("THURSDAY");
        days.add("FRIDAY");
        days.add("SATURDAY");

    }

    public boolean isDayValid(String day) {
        log.info("You receive {}", day);
        return days.contains(day);
    }

    public ResponseEntity bookService(@RequestBody PickupRequest load) {
        if (!isDayValid(load.getPickup_day().toUpperCase())) {
            log.warn("Invalid give day {}",load.getPickup_day().toUpperCase());
            return new ResponseEntity("Invalid pickup day", HttpStatus.BAD_REQUEST);
        }
        if (load.getRecurrence() > 4 || load.getRecurrence()<=0) {
            log.warn("Recurrence period within a month should be between 1 and 4");
            return new ResponseEntity("Invalid pickup reoccurence", HttpStatus.BAD_REQUEST);
        }
        ApiResponse response = new ApiResponse();
        List<PickupResponse> datalist = new ArrayList<>();
        Calendar cl = Calendar.getInstance();
        for (int i = 1; i <= load.getRecurrence(); i++) {
            if (i == 1) {
                int result =makeFirstChanges(cl, load.getPickup_day());
                if (result == 0) {
                    cl.add(Calendar.DAY_OF_MONTH, 7);
                    datalist.add(
                            new PickupResponse(
                                    AppUtil.getRawFormat(cl.getTime()),
                                    AppUtil.getReadableFormat(cl.getTime())));
                } else {
                    datalist.add(
                            new PickupResponse(
                                    AppUtil.getRawFormat(cl.getTime()),
                                    AppUtil.getReadableFormat(cl.getTime())));
                }
            } else {
                cl.add(Calendar.DAY_OF_MONTH, 7);
                datalist.add(
                        new PickupResponse(
                                AppUtil.getRawFormat(cl.getTime()),
                                AppUtil.getReadableFormat(cl.getTime())));
            }

        }
        response.setPickup_dates(datalist);
        return ResponseEntity.ok(response);
    }
/*
check if the given day is equal to current calendar day, then add 7 days interval otherwise find the next given day then generate it further
 */
    public int makeFirstChanges(Calendar cl, String day) {
        Calendar c = Calendar.getInstance();
        Integer weekday = c.get(Calendar.DAY_OF_WEEK);
        Integer dayNo = getDayOfWeek(day.toUpperCase());
        if (weekday == dayNo) {
            return 0;
        } else {

            if (dayNo > weekday) {
                cl.add(Calendar.DAY_OF_MONTH, dayNo - weekday);
            } else {

                int counter = 0;
                for (int i = 1; i < 7; i++) {
                    c.add(Calendar.DAY_OF_MONTH, i);

                    if (c.get(Calendar.DAY_OF_WEEK) == dayNo) {
                        counter = i;
                        break;

                    }
                }
                cl.add(Calendar.DAY_OF_MONTH, counter);
            }
            return 1;
        }

    }

    private int getDayOfWeek(String dayname) {
        int day = 0;
        switch (dayname) {
            case "SUNDAY":
                day = 1;
                break;
            case "MONDAY":
                day = 2;
                break;
            case "TUESDAY":
                day = 3;
                break;
            case "WEDNESDAY":
                day = 4;
                break;
            case "THURSDAY":
                day = 5;
                break;
            case "FRIDAY":
                day = 6;
                break;
            case "SATURDAY":
                day = 7;
                break;
        }
        return day;
    }
}
