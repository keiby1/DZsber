package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SomeTerminal terminal = new SomeTerminal();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("1-Есть Клиент/Карта");
            System.out.println("2-Нет Клиента/Карты");
            System.out.print("3-Выход из приложения\n>>");

            int key = sc.nextInt();
            switch (key) {
                case 1:
                    terminal.Welcome();
                    break;
                case 2:
                    terminal.CreatingClientOrCard();
                    break;
                case 3:
                    return;
            }
        }
    }
}
