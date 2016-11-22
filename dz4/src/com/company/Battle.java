package com.company;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by lushi on 21.11.2016.
 */
public class Battle {
    public void namesWar(Squad s){
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.println("1-Дать имена воинам самостоятельно, 2-Автоматически");
        int key = sc.nextInt();
        if(key == 1){
            for(int i =0;i < s.n; i++) {
                System.out.println("Дайте имя воину: ");
                s.warrior[i].setName(sc.next());
            }
        }
        else{
            for(int i =0;i < s.n; i++) {
                s.warrior[i].setName("Warrior_" + r.nextInt(100));
            }
        }
    }
    public void initSquad(Squad s){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название отряда: ");
        s.name = sc.nextLine();
        System.out.println("Число воинов в отряде: ");
        s.n = sc.nextInt();
        Random r = new Random();
        s.warrior = new Warrior[s.n];
        for(int i =0;i < s.n; i++){
            switch (r.nextInt(4)){
                case 0:
                    s.warrior[i] = new Archer();
                    break;
                case 1:
                    s.warrior[i] = new Berserk();
                    break;
                case 2:
                    s.warrior[i] = new Defender();
                    break;
                case 3:
                    s.warrior[i] = new Viking();
                    break;
            }
            s.warrior[i].setSquadName(s.name);
        }
        namesWar(s);
    }
    public void outWarrior(Squad s){
        for(int i =0;i < s.n; i++){
            System.out.println(" " + s.warrior[i].toString()+ " " + s.warrior[i].getInfo());
        }
        System.out.println();
    }
    public Battle() {
        DateHelper d = new DateHelper();
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        Squad squad1 = new Squad();
        Squad squad2 = new Squad();

        initSquad(squad1);


        System.out.println("1-Клонировать отряд, 2-Создать отличный отряд");
        int key = sc.nextInt();
        if(key == 1) {
            squad2 = squad1.clone();
            System.out.println("Введите название отряда: ");
            squad2.name = sc.next();
            for(int i =0;i < squad2.n; i++)
                squad2.warrior[i].setSquadName(squad2.name);
        }
        else {
            initSquad(squad2);
        }

        System.out.println("Обе командыготовы к бою!");
        System.out.println("Имя_воина Класс Команда Здоровье Атака");
        outWarrior(squad1);
        System.out.println();
        outWarrior(squad2);


        Warrior w1,w2;
        System.out.println("Дата начала битвы "+d.getFormattedStartDate()+"\n");
        while (squad1.hasAliveWarriors() && squad2.hasAliveWarriors()){
            w2 = squad2.getRandomWarrior();
            w1 = squad1.getRandomWarrior();

            System.out.println(w1.toString() +" атакует " + w2.toString());
            w2.takeDamage(w1.attack());
            System.out.println();
            d.skipTime();
            if(!squad2.hasAliveWarriors()){
                System.out.println("Первая команда победила!");
                break;
            }
            w1 = squad1.getRandomWarrior();
            w2 = squad2.getRandomWarrior();

            System.out.println(w2.toString() +" атакует " + w1.toString());
            w1.takeDamage(w2.attack());
            System.out.println();
            d.skipTime();
            if(!squad1.hasAliveWarriors()){
                System.out.println("Вторая команда победила!");
                break;
            }
        }
        System.out.println("\nДлительность битвы: " + d.getFormattedDiff());
    }
}
