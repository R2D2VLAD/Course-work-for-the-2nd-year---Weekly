package Еженедельник;

import Еженедельник.Repeatable;
import Еженедельник.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task implements Repeatable {
    public YearlyTask(int id, String title, String description, boolean isWork, LocalDateTime dateTime) {
        super(id, title, description, isWork, dateTime);
    }

    @Override
    public boolean checkIfSuitable(LocalDate date) {
        return date.getDayOfMonth() == dateTime.getDayOfMonth() && date.getMonth() == dateTime.getMonth();
    }
}
