package org.example;


public class Session {
    int time = 1;
    Thread timer = new Thread(() -> {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(time++);
        }
    });

    Thread checker = new Thread(() -> {
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("Прошло 5 секунд, поточное время с начала роботы: ");
        }
    });

}
