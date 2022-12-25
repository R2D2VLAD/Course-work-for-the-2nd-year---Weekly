package Еженедельник;

import Еженедельник.Repeatable;
import Еженедельник.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task implements Repeatable {

    public WeeklyTask(int id, String title, String description, boolean isWork, LocalDateTime dateTime) {
        super(id, title, description, isWork, dateTime);
    }

    public boolean checkIfSuitable(LocalDate date) {
        return date.getDayOfWeek() == dateTime.getDayOfWeek();
    }
}
