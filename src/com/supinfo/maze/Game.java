package com.supinfo.maze;

import java.io.*;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: occul_000
 * Date: 14/02/13
 * Time: 17:55
 * To change this template use File | Settings | File Templates.
 */
public class Game implements Serializable {

    public void start(){
        System.out.println("LABYRINTHE");
        System.out.println("================");
        System.out.println("1/ Générer Labyrinthe Simple");
        System.out.println("2/ Générer Labyrinthes Multiples");
        System.out.println("3/ Solutions");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();



        System.out.println("la valeur de i est :" +choice);

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        ZipOutputStream zipos = null;
        FileInputStream fis = null;
        ZipEntry ze = null;



        switch (choice){



            case 1:
                System.out.println("Combien voulez vous de lignes ?");
                int row = scanner.nextInt();

                System.out.println("Combien voulez vous de colonnes");
                int column = scanner.nextInt();

                try {
                    Maze maze = new Maze(row, column);
                    maze.show();

                    fos = new FileOutputStream("maze.txt");
                    oos = new ObjectOutputStream(fos);

                    oos.writeObject(maze); 	// Serialization
                } catch (IOException e) {

                } finally {
                    // Close the streams
                }
                break;

            case 2:
                System.out.println("Combien voulez vous de lignes ?");
                 row = scanner.nextInt();

                System.out.println("Combien voulez vous de colonnes");
                 column = scanner.nextInt();

                System.out.println("Combien voulez vous de labyrinthes ?");
                int choiceMultiple = scanner.nextInt();
                for (int i=0; i<choiceMultiple;i++){
                    Maze maze = new Maze(row, column);
                    maze.show();


                    try {



                        fos = new FileOutputStream("mazeMultiple"+i+".txt");
                        oos = new ObjectOutputStream(fos);

                        oos.writeObject(maze); 	// Serialization
                    } catch (IOException e) {

                    } finally {
                        // Close the streams
                    }


                }

                //archiver fichiers crée dans .zip

                try {
                    fos = new FileOutputStream("archive.zip");
                    zipos = new ZipOutputStream(fos);
                    byte[] data = new byte[2048];
                    for(int i=0; i<choiceMultiple;i++){


                        fis = new FileInputStream("mazeMultiple"+i+".txt");
                        ze = new ZipEntry("mazeMultiple"+i+".txt");
                        zipos.putNextEntry(ze);
                        while (fis.read(data) != -1) {
                            zipos.write(data);
                        }
                        zipos.flush();
                    }
                    zipos.closeEntry();
                    zipos.close();

                } catch (Exception e) {
                    System.out.println("blabla"); }
                finally  { /* Close all the streams */ }
                break;


            case 3:

                System.out.println("Veuillez mettre le nom du fichier/archive que vous voulez résoudre");
                String file = scanner.next();
                Solver solver = new Solver(file);
                solver.solve();


                break;




            default:
                System.out.println("Veuillez entrer un chiffre entre 1 et 3");
                break;


        }



    }

}
