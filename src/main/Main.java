package main;

import entities.Entity;
import navigation.GameMapRenderer;
import settings.Intializer;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Intializer init = new Intializer();
        GameMapRenderer map = new GameMapRenderer();
        ArrayList<Entity> entities = new ArrayList<>();
        entities.add(init.rabbit(5,10));
        entities.add(init.rabbit(7,29));

        map.addEntites(entities);

        map.displayMap();
    }
}