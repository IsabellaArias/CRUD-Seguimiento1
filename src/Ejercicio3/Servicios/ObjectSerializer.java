package Ejercicio3.Servicios;

import java.io.*;

public class ObjectSerializer {
    //guarda objetos en archivos, lo que permite persistir datos de manera que puedan ser recuperados en el futuro.
    public static void writeObjectToFile(Object obj, String fileName) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(fileName);
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        objOut.writeObject(obj);
        objOut.close();
        fileOut.close();
    }
    //permite recuperar datos que fueron previamente guardados en ese archivo.
    public static Object readObjectFromFile(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(fileName);
        ObjectInputStream objIn = new ObjectInputStream(fileIn);
        Object obj = objIn.readObject();
        objIn.close();
        fileIn.close();
        return obj;
    }
}