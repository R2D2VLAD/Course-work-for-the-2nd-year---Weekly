package Еженедельник;

import java.time.LocalDateTime;

public class OneTimeTask extends Task {
    public OneTimeTask(int id, String title, String description, boolean isWork, LocalDateTime dateTime) {
        super(id, title, description, isWork, dateTime);
    }
}
