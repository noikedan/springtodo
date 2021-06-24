package dev.itboot.mb.service;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import dev.itboot.mb.domains.Task;
@Transactional
@SpringBootTest
class TaskServiceTest {
	@Autowired TaskService service;

	@Test
	void testSelectAll() {
		assertEquals("シュート練習", service.selectAll().get(0).getTitle());
		assertEquals("ドリブル練習", service.selectAll().get(1).getTitle());
	}
	
	

	@Test
	void testAdd() throws ParseException {
		Task task = new Task();
		String lmt = "2011-01-01";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		task.setTitle("ジョギング練習");
		task.setLmt(dateFormat.parse(lmt));
		service.add(task);
		assertEquals("ジョギング練習", service.selectAll().get(2).getTitle());
	}

	@Test
	void testComplete() {
		Task task = new Task();
		task.setId(1);
		service.complete(task);
		assertTrue(service.selectAll().get(0).isStatus());
	
	}

}
