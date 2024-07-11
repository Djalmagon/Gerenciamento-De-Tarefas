package projeto;

import java.time.LocalDate;

public class Task {

	private String title;
	private String description;
	private LocalDate dueDate;
	private boolean isCompleted;

	public Task(String title, String description, LocalDate dueDate) {
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.isCompleted = false;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	@Override
	public String toString() {
		return "Tarefa{" +
				"título='" + title + '\'' +
				", descrição='" + description + '\'' +
				", data de vencimento=" + dueDate +
				", está concluída=" + isCompleted +
				'}';
	}
}	
