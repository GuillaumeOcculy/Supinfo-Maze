package com.supinfo.maze;

/**
 * Created with IntelliJ IDEA.
 * User: occul_000
 * Date: 14/02/13
 * Time: 17:55
 * To change this template use File | Settings | File Templates.
 */
public class Game {

    public void start(){
        System.out.println("LABYRINTHE");
        System.out.println("================");
        System.out.println("");

        Maze maze = new Maze();
        maze.show();
    }

}
