package Еженедельник;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task implements Repeatable {
    public MonthlyTask(int id, String title, String description, boolean isWork, LocalDateTime dateTime) {
        super(id, title, description, isWork, dateTime);
    }

    @Override
    public boolean checkIfSuitable(LocalDate date) {
        return date.getDayOfMonth() == dateTime.getDayOfMonth();
    }
}
