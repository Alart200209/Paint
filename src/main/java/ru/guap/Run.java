package ru.guap;

import javax.swing.*;

import ru.guap.client.*;
import ru.guap.server.*;


public class Run {
    public static void main(String[] args) {
        // первый аргумент при вызове определяет, вызываем мы сервер или клиент
        if (args.length != 0) {
            if (args[0].toUpperCase().equals("-S")) {
                System.out.println("SERVER");
                Server server = new Server();
            } else if (args[0].toUpperCase().equals("-C") && args.length == 3) {
                // 2-ой и 3-й - адрес и порт сервера, к которому будет подключаться клиент
                System.out.println("CLIENT");
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        Client client = new Client(args[1], Integer.parseInt(args[2]));
                    }
                });
            } else {
                System.out.println("Ошибка не правильно введен адрес или порт сервера");
            }
        } else {
            System.out.println("Ошибка аргумент не вызывает не сервер, не клиент");
        }
    }
}