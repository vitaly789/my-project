import java.time.LocalDateTime;

public class Task {
    private static int idCounter = 1;
    private int id;
    private String description;
    private LocalDateTime deadline;
    private String status;

    public Task(String description, LocalDateTime deadline) {
        this.id = idCounter++;
        this.description = description;
        this.deadline = deadline;
        this.status = "Открыта"; // Статус по умолчанию
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Описание: '" + description + "', Дедлайн: " + deadline + ", Статус: " + status;
    }
}