package com.app.task.task1;

import com.app.task.dto.PickupRequest;
import com.app.task.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("/laundry")
public class LaundryRoute {
@Autowired
private AppService service;
@PostMapping("book")
    public ResponseEntity bookService(@RequestBody PickupRequest load){
return service.bookService(load);
    }

}