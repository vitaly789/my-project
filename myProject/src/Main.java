import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            System.out.println("Выберите действие: ");
            System.out.println("1. Добавить задачу");
            System.out.println("2. Просмотреть задачи (по дедлайну или статусу)");
            System.out.println("3. Изменить статус задачи");
            System.out.println("4. Удалить задачу");
            System.out.println("5. Поиск задачи");
            System.out.println("6. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Чистим буфер

            switch (choice) {
                case 1:
                    System.out.println("Введите описание задачи: ");
                    String description = scanner.nextLine();
                    System.out.println("Введите дедлайн задачи (гггг-мм-ддTчч:мм:сс): "); // дата пишем по образцу
                    String deadlineInput = scanner.nextLine();
                    LocalDateTime deadline = LocalDateTime.parse(deadlineInput);
                    taskManager.addTask(description, deadline);
                    break;

                case 2:
                    System.out.println("Сортировать по (deadline/status): ");
                    String sortBy = scanner.nextLine();
                    taskManager.listTasks(sortBy);
                    break;

                case 3:
                    System.out.println("Введите ID задачи для изменения статуса: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Чистим буфер
                    System.out.println("Введите новый статус: ");
                    String newStatus = scanner.nextLine();
                    taskManager.changeTaskStatus(id, newStatus);
                    break;

                case 4:
                    System.out.println("Введите ID задачи для удаления: ");
                    int deleteId = scanner.nextInt();
                    taskManager.deleteTask(deleteId);
                    break;

                case 5:
                    System.out.println("Введите ключевое слово для поиска: ");
                    String keyword = scanner.nextLine();
                    taskManager.searchTasks(keyword);
                    break;

                case 6:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }
}