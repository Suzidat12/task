package com.app.task;

import com.app.task.dto.ApiResponse;
import com.app.task.dto.PickupRequest;
import com.app.task.service.AppService;
import com.app.task.utils.TaskUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskApplicationTests {
@Autowired
AppService service;

	@Test
	void contextLoads() {
	}

	@Test
	void testTask1(){
		PickupRequest test = new PickupRequest();
		test.setPickup_day("Monday");
		test.setRecurrence(4);
		ResponseEntity<ApiResponse> result = service.bookService(test);
		assertEquals(result.getBody().getPickup_dates().size(), 4);

	}

	@Test
	void testTask2(){
		String testData="acbbac";
		assertEquals(TaskUtils.getTask2(testData),"b");
		testData="abcdef";
		assertNull(TaskUtils.getTask2(testData));

	}

	@Test
	void testTask3(){
		int[] testData={3, 4, 9, 6, 1};
		int [] expected ={1,1,2,1,0};
		assertTrue(Arrays.equals(TaskUtils.getTask3(testData), expected));

	}
	@Test
	void testTask4(){
		int expected[]={0, 4, 4, 9, 81};
		int testData[]={-9, -2, 0, 2, 3};
		assertTrue(Arrays.equals(TaskUtils.getTask4(testData), expected));


	}

}
