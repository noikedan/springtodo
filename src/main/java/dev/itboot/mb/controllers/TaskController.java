package dev.itboot.mb.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import dev.itboot.mb.domains.Task;
import dev.itboot.mb.mappers.TaskMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TaskController {

	private final TaskMapper taskMapper;

	@Autowired
	public TaskController(TaskMapper taskMapper) {
		this.taskMapper = taskMapper;
	}

	@GetMapping("/")
	public String index(Model model) {
		List<Task> tasks = taskMapper.all();
		model.addAttribute("tasks", tasks);
		log.info("一覧画面表示処理");
		return "index";

	}

	@GetMapping("/add")
	public String showAddForm(Task task, Model model) {
		log.info("登録画面遷移処理");
		return "add";
	}

	@PostMapping("/add")
	public String create(@Validated Task task, BindingResult bindingResult, Model model) throws Exception {

		if (bindingResult.hasErrors()) {
			return "add";
		} else {
			String title = task.getTitle();
			int id = 0;
			Task t = new Task(id, false, title, task.getLmt());
			taskMapper.add(t);
			log.info("登録遷移処理");
			return "redirect:/";
		}
	}

	@PostMapping("/complete")
	public String create(Task task, Model mode) {
		Task t = new Task(task.getId());
		taskMapper.complete(t);
		return "redirect:/";
	}
}