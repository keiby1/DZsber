package com.company;

/**
 * Created by lushi on 21.11.2016.
 */
public interface Warrior {
    int attack();
    void takeDamage(int damage);
    boolean isAlive();
    void setSquadName(String name);
    void setName(String name);
    String getInfo();
    String toString();
    Warrior clone();
}
