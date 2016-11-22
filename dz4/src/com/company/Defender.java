package com.company;

/**
 * Created by lushi on 21.11.2016.
 */
public class Defender implements Warrior {
    String name, squad;
    int health = 200;
    int damage = 50;
    @Override
    public int attack() {
        System.out.println("Получил урон " + damage);
        return damage;
    }

    @Override
    public void takeDamage(int damage) {
        System.out.println("Осталось здоровья: " + (health-damage));
        health -=damage;
    }

    @Override
    public boolean isAlive() {
        if(health > 0)
            return true;
        else
            return false;
    }

    @Override
    public void setSquadName(String n) {
        squad = n;
    }
    @Override
    public String toString(){
        return name+" " + this.getClass().getSimpleName().toString()+" " + squad;
    }
    @Override
    public Defender clone() {
        Defender w = new Defender();
        w.name = this.name;
        return w;
    }
    @Override
    public void setName(String n){
        name = n;
    }
    @Override
    public String getInfo(){
        return health+ " " + damage;
    }
}
