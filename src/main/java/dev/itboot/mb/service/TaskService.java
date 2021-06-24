package dev.itboot.mb.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.itboot.mb.domains.Task;
import dev.itboot.mb.mappers.TaskMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class TaskService {

	private final TaskMapper mapper;

	public List<Task> selectAll() {
		return mapper.all();
	}

	public void add(Task task) {
		mapper.add(task);

	}

	public void complete(Task task) {
		mapper.complete(task);

	}

}
