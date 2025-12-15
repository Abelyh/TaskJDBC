package jm.task.core.jdbc;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();

        User[] users = {new User("Ivan", "Ivanov", (byte) 20)
                , new User("Sergei", "Petrov", (byte) 25)
                , new User("Vladimir", "Sidorov", (byte) 30)
                , new User("Victor", "Smirnov", (byte) 35)};

        for (User u : users) {
            userService.saveUser(u.getName(), u.getLastName(), u.getAge());
            System.out.printf("User с именем — %s добавлен в базу данных %n", u.getName());
        }


        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
