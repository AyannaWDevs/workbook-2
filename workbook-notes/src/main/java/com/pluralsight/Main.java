package com.pluralsight;

public class Main {
    public static void main(String[]args){
        Vampire vampire = new Vampire();
        Werewolf werewolf = new Werewolf();
        vampire.Talk();
        werewolf.Talk();
        Enemy enemy = vampire;
        enemy.Talk();
    }
}
