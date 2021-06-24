package dev.itboot.mb.domains;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
public class Task {
	
	public Task() {

	}

	public Task(String title, Date lmt) {
		this.title = title;
		this.lmt = lmt;
	}

	public Task(int id) {
		this.id = id;
	}

	public Task(int id, Boolean status, String title, Date lmt) {
		this.id = 0;
		this.status = status;
		this.title = title;
		this.lmt = lmt;
	}

	private int id;
	private boolean status;
//  @NotBlank(message = "必須項目です")
	@NotBlank
	@Size(max = 60)
//  @Size(min = 3, max = 6, message = "3文字から6文字で入力して下さい")
	private String title;
//  @NotNull(message = "必須項目です")
	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	private Date lmt;
}
