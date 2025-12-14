package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Ivan", "Ivanov", (byte) 20);
        System.out.println("User с именем — Ivan добавлен в базу данных");

        userService.saveUser("Sergei", "Petrov", (byte) 25);
        System.out.println("User с именем — Sergei добавлен в базу данных");

        userService.saveUser("Vladimir", "Sidorov", (byte) 30);
        System.out.println("User с именем — Vladimir добавлен в базу данных");

        userService.saveUser("Victor", "Smirnov", (byte) 35);
        System.out.println("User с именем — Victor добавлен в базу данных");

        System.out.println(userService.getAllUsers());

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
