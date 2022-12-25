package Еженедельник;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static int counter;

    private int id;
    private String title;
    private String description;
    private boolean isWork;
    protected LocalDateTime dateTime;

    public Task(int id, String title, String description, boolean isWork, LocalDateTime dateTime) {
        this.id = counter++;
        this.title = title;
        this.description = description;
        this.isWork = isWork;
        this.dateTime = dateTime;
    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isWork() {
        return isWork;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Задача : " +
                ", title='" + title +
                ", description='" + description;
    }
}
