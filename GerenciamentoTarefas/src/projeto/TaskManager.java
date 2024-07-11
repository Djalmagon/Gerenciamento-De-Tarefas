package projeto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {

	private List<Task> tasks;

	public TaskManager() {
		tasks = new ArrayList<>();
	}

	public void addTask(String title, String description, LocalDate dueDate) {
		tasks.add(new Task(title, description, dueDate));
	}

	public void editTask(int index, String newTitle, String newDescription, LocalDate newDueDate) {
		if (index >= 0 && index < tasks.size()) {
			Task task = tasks.get(index);
			task.setTitle(newTitle);
			task.setDescription(newDescription);
			task.setDueDate(newDueDate);
		}
	}

	public void removeTask(int index) {
		if (index >= 0 && index < tasks.size()) {
			tasks.remove(index);
		}
	}

	public void markTaskAsCompleted(int index) {
		if (index >= 0 && index < tasks.size()) {
			Task task = tasks.get(index);
			task.setCompleted(true);
		}
	}

	public void listTasks() {
		for (int i = 0; i < tasks.size(); i++) {
			Task task = tasks.get(i);
			System.out.println(i + ": " + task);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		TaskManager taskManager = new TaskManager();
		while (true) {
			System.out.println("1. Adicionar Tarefa");
			System.out.println("2. Editar Tarefa");
			System.out.println("3. Remover Tarefa");
			System.out.println("4. Marcar Tarefa como Concluída");
			System.out.println("5. Listar Tarefas");
			System.out.println("6. Sair");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.println("Digite o título: ");
				String title = scanner.nextLine();
				System.out.println("Digite a descrição: ");
				String description = scanner.nextLine();
				System.out.print("Digite a data de vencimento (AAAA-MM-DD): ");
				String dueDateStr = scanner.nextLine();
				LocalDate dueDate = LocalDate.parse(dueDateStr);
				taskManager.addTask(title, description, dueDate);
				break;
			case 2:
				System.out.print("Digite o índice da tarefa para editar: ");
				int editIndex = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Digite o novo título: ");
				String newTitle = scanner.nextLine();
				System.out.print("Digite a nova descrição: ");
				String newDescription = scanner.nextLine();
				System.out.print("Digite a nova data de vencimento (AAAA-MM-DD): ");
				String newDueDateStr = scanner.nextLine();
				LocalDate newDueDate = LocalDate.parse(newDueDateStr);
				taskManager.editTask(editIndex, newTitle, newDescription, newDueDate);
				break;
			case 3:
				System.out.print("Digite o índice da tarefa para remover: ");
				int removeIndex = scanner.nextInt();
				taskManager.removeTask(removeIndex);
				break;
			case 4:
				System.out.print("Digite o índice da tarefa para marcar como concluída: ");
				int completeIndex = scanner.nextInt();
				taskManager.markTaskAsCompleted(completeIndex);
				break;
			case 5:
				taskManager.listTasks();
				break;
			case 6:
				System.out.println("Saindo...");
				scanner.close();
				return;
			default:
				System.out.println("Escolha inválida, tente novamente.");
			}
		}
	}
}
