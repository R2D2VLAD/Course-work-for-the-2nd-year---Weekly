package Еженедельник;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DallyTask extends Task implements Repeatable {
    public DallyTask(int id, String title, String description, boolean isWork, LocalDateTime dateTime) {
        super(id, title, description, isWork, dateTime);
    }

    @Override
    public boolean checkIfSuitable(LocalDate date) {
        return true;
    }
}
