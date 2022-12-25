package Еженедельник;

import Еженедельник.Calendar;
import Еженедельник.DallyTask;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    private static Calendar calendar;
    public static void main(String[] args) {
        calendar = new Calendar();
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            deleteATask(scanner);
                            break;
                        case 3:
                            getTasksForDay(scanner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Введите название задачи: ");
        String title = scanner.nextLine();
        System.out.println("Введите описание задачи: ");
        String description = scanner.nextLine();

        boolean isWork;
        System.out.println("Эта задача рабочая?");
        switch (scanner.nextLine()) {
            case "1":
            case "да":
            case "yes":
                isWork = true;
                break;
            default:
                isWork = false;
        }
        LocalDateTime date = null;
        System.out.println("Введите дату и время задачи (00.00.0000 00:00:00):");
        boolean shouldEnterAgain = true;
        while (shouldEnterAgain) {
            try {
                date = LocalDateTime.parse(scanner.nextLine(), Task.DATE_TIME_FORMATTER);
                shouldEnterAgain = false;
            } catch (DateTimeParseException e) {
                System.out.println("Неправильный формат введите еще раз!");
            }
        }

        Task task;
        System.out.println("Повторяемость задания:");
        System.out.println("\n 1) 0 - не повторяется");
        System.out.println("\n 2) 1 - ежедневно");
        System.out.println("\n 3) 2 - еженедельно");
        System.out.println("\n 4) 3 - ежемесячно");
        System.out.println("\n 5) 4 - ежегодно");
        switch (scanner.next()) {
            case "1":
                task = new DallyTask(Task.getCounter(), title, description, isWork, date);
                break;
            case "2":
                task = new WeeklyTask(Task.getCounter(), title, description, isWork, date);
                break;
            case "3":
                task = new MonthlyTask(Task.getCounter(), title, description, isWork, date);
                break;
            case "4":
                task = new YearlyTask(Task.getCounter(), title, description, isWork, date);
                break;
            default:
                task = new OneTimeTask(Task.getCounter(), title, description, isWork, date);
        }
        System.out.println("Задача успешно добавлена!");
        System.out.println("----------------------------------------------------------------------------------");
        calendar.addTask(task);
    }

    public static void getTasksForDay(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Введите дату (00.00.0000) :");
        LocalDate date = null;
        boolean shouldEnterAgain = true;
        while (shouldEnterAgain) {
            try {
                date = LocalDate.parse(scanner.nextLine(), Task.DATE_FORMATTER);
                shouldEnterAgain = false;
            } catch (DateTimeParseException e) {
                System.out.println("Неправильный формат введите еще раз!");
            }
        }
        System.out.println(calendar.getTasksForOneDay(date));
    }

    public static void deleteATask(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Введите id задачи, которую хотите удалить:");
        int id = scanner.nextInt();
        System.out.println("Ваша задача успешно удалена!");
        calendar.deleteTask(id);
        System.out.println("------------------------------------------------------");
    }
    private static void printMenu() {
        System.out.println(
                        "1. Добавить задачу\n" +
                        "2. Удалить задачу\n" +
                        "3. Получить задачу на указанный день\n" +
                        "0. Выход");
    }
}