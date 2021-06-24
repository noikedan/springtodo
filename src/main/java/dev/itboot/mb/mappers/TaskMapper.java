package dev.itboot.mb.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dev.itboot.mb.domains.Task;

@Mapper
public interface TaskMapper {

	List<Task> all();

	void add(Task task);

	void complete(Task task);

}
