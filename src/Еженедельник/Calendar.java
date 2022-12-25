package Еженедельник;

import java.time.LocalDate;
import java.util.*;

public class Calendar {
    private Map<Integer, Task> mapOfTask;

    public Calendar() {
        mapOfTask = new HashMap<>();
    }

    public void addTask(Task task) {
        mapOfTask.put(task.getId(), task);
    }

    public void deleteTask(int id) {
        mapOfTask.remove(id);
    }

    public List<Task> getTasksForOneDay(LocalDate date) {
        List<Task> result = new ArrayList<>();
        for (Map.Entry<Integer, Task> entry : mapOfTask.entrySet()) {
            if (entry.getValue() instanceof Repeatable
                    && ((Repeatable) entry.getValue()).checkIfSuitable(date)
                    || !(entry.getValue() instanceof Repeatable)
                    && entry.getValue().getDateTime().toLocalDate().equals(date)) {
                result.add(entry.getValue());
            }
            }
        result.sort(Comparator.comparing(Task::getDateTime));
        return result;
    }
}
