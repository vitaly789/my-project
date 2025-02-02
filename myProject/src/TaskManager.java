import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String description, LocalDateTime deadline) {
        Task task = new Task(description, deadline);
        tasks.add(task);
        System.out.println("Задача добавлена: " + task);
    }

    public void listTasks(String sortBy) {
        Comparator<Task> comparator;

        if ("deadline".equalsIgnoreCase(sortBy)) {
            comparator = Comparator.comparing(Task::getDeadline);
        } else {
            comparator = Comparator.comparing(Task::getStatus);
        }

        tasks.stream().sorted(comparator).forEach(System.out::println);
    }

    public void changeTaskStatus(int id, String newStatus) {
        Optional<Task> taskOpt = tasks.stream().filter(t -> t.getId() == id).findFirst();

        if (taskOpt.isPresent()) {
            Task task = taskOpt.get();
            task.setStatus(newStatus);
            System.out.println("Статус задачи изменен: " + task);
        } else {
            System.out.println("Задача с ID " + id + " не найдена.");
        }
    }

    public void deleteTask(int id) {
        tasks.removeIf(t -> t.getId() == id);
        System.out.println("Задача с ID " + id + " удалена.");
    }

    public void searchTasks(String keyword) {
        tasks.stream()
                .filter(t -> t.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .forEach(System.out::println);
    }
}