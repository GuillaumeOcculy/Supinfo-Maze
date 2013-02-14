package com.supinfo.maze;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: occul_000
 * Date: 14/02/13
 * Time: 17:58
 * To change this template use File | Settings | File Templates.
 */
public class Maze {
    private int i,j,iStart,jStart,iEnd,jEnd, lower=1, higher=9;
    private char maze[][] = new char[10][10];
    private char start = 'S';
    private char end = 'G';

    Random random = new Random();

    public Maze(){
        //dessiner contour
        for (i=0; i<maze.length; i++){
            for (j=0;j<maze.length;j++){
                maze[i][j]='X';
            }
        }

        //dessine l'interieur
        for(i=1; i<maze.length-1; i++){
            for (j=1; j<maze.length-1; j++){
                maze[i][j]= '_';
            }
        }
    }

    void show(){

        start();
        end();
        for (i=0;i<maze.length;i++){
            for(j=0;j<maze.length;j++){
                System.out.print(maze[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

   private void start(){
        i = random.nextInt(8)+1;
        j = random.nextInt(8)+1;
        iStart = i;
        jStart = j;
        maze[i][j] = start;
    }

    private void end(){

        i = random.nextInt(8)+1;
        j = random.nextInt(8)+1;
        iEnd = i;
        jEnd = j;

        maze[i][j] = end;
    }



}
