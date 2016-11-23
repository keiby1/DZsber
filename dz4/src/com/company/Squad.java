package com.company;

import java.util.Random;

/**
 * Created by lushi on 21.11.2016.
 */
public class Squad {
    String name;
    Warrior []warrior;
    int n;
    public Warrior getRandomWarrior(){
        Random r = new Random();
        int ind;
        if(hasAliveWarriors() == true)
            while (true){
                ind = r.nextInt(n);
                if(warrior[ind].isAlive()){
                    return warrior[ind];
                }
            }
        else
            return null;
    }
    public boolean hasAliveWarriors(){
        for(int i =0;i < n; i++){
            if(warrior[i].isAlive()/* ==  true* излишне*/){
                return true;
            }
        }
        return false;
    }//нужны аннотации, пустые строки
    public String toString(){
        return name;
    }
    public Squad clone(){
        Squad sq = new Squad();
        sq.n = this.n;
        sq.warrior = new Warrior[sq.n];
        for(int i =0;i < sq.n;i++){
            sq.warrior[i] = this.warrior[i].clone();
        }
            return sq;
    }
}
