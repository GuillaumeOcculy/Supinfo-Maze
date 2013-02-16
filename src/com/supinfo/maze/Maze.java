package com.supinfo.maze;

import java.io.Serializable;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: occul_000
 * Date: 14/02/13
 * Time: 17:58
 * To change this template use File | Settings | File Templates.
 */
public class Maze implements Serializable {
    private int rows;
    private int columns;
    private int i,j,iStart,jStart,iEnd,jEnd;
    private Cell maze[][];

    Random random = new Random();

    //constructeur
    public Maze(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        maze= new Cell[rows][columns];
    }

    public void initMaze(){

        //dessiner contour
        for (i=0; i<rows; i++){
            for (j=0;j<columns;j++){
                maze[i][j]= new Cell("X");
            }
        }

        //dessine l'interieur
        for(i=1; i<rows-1; i++){
            for (j=1; j<columns-1; j++){
                maze[i][j].setValue("_");
            }
        }
    }

    void show(){

        initMaze();
        wall();
        start();
        end();


        for (i=0;i<rows;i++){
            for(j=0;j<columns;j++){
                System.out.print(maze[i][j].getValue() + " ");
            }
            System.out.println(" ");
        }
    }

   private void start(){
        iStart = random.nextInt(rows-2)+1;
        jStart = random.nextInt(columns-2)+1;

       maze[iStart][jStart].setValue("S");
    }

    private void end(){

        iEnd = random.nextInt(rows-2)+1;
        jEnd = random.nextInt(columns-2)+1;

        maze[iEnd][jEnd].setValue("G");
    }


    //mettre les murs autours
    private void wall(){

        for (int i=1; i <rows - 1; i++){
            for (int j=1; j < columns - 1; j++){
                maze[i][j].setValue("_");
                // Wall
                i = random.nextInt(rows-2)+1;
                j = random.nextInt(columns-2)+1;
                maze[i][j].setValue("X");
    }

}
    }

}
