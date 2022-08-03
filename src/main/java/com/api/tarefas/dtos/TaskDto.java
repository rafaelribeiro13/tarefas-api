package com.api.tarefas.dtos;

import javax.validation.constraints.NotBlank;

public class TaskDto {

	@NotBlank
	private String title;
	private boolean status;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
