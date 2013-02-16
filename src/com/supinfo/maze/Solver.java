package com.supinfo.maze;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created with IntelliJ IDEA.
 * User: occul_000
 * Date: 16/02/13
 * Time: 20:02
 * To change this template use File | Settings | File Templates.
 */
public class Solver {

    private String file;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Solver(String file) {

        this.file = file;
    }

    public void solve(){
        Maze maze = null;
        if(!(file.contains(".zip"))){
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            try {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                 maze = (Maze) ois.readObject();

            } catch (IOException e) {
                e.printStackTrace();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } finally { /* Close the stream */ }

        }else{

            FileInputStream fis = null;
            ZipInputStream zis = null;
            ZipEntry ze = null; FileOutputStream fos = null;
            try {
                fis = new FileInputStream(file);
                zis = new ZipInputStream(fis);
                while ((ze = zis.getNextEntry()) != null) {
                    int b;
                    fos = new FileOutputStream("./" +ze.getName());
                    while ((b = zis.read()) != -1) {
                        fos.write(b);
                    }
                    fos.close();
                }
            } catch (Exception e) { /* ... */ }
            finally { /* ... */ }



        }

        maze.show();


    }
//    FileInputStream fis = null;
//    ZipInputStream zis = null;
//    ZipEntry ze = null; FileOutputStream fos = null;
//
//    try {
//        fis = new FileInputStream("C:/archive.zip");
//        zis = new ZipInputStream(fis);
//        while ((ze = zis.getNextEntry()) != null) {
//            int b;
//            fos = new FileOutputStream("./" + 			ze.getName());
//            while ((b = zis.read()) != -1) {
//                fos.write(b);
//            }
//            fos.close();
//        }
//    } catch (Exception e) { /* ... */ }
//    finally { /* ... */ }

}
