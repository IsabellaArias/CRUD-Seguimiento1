package Ejercicio1.service;

import Ejercicio1.dto.CuentasDto;

import java.io.*;
import java.util.List;

public abstract class ObjectSerializer {
    public static void writeObjectToFile(Object obj, String fileName) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(fileName);
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        objOut.writeObject(obj);
        objOut.close();
        fileOut.close();
    }

    public static Object readObjectFromFile(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(fileName);
        ObjectInputStream objIn = new ObjectInputStream(fileIn);
        Object obj = objIn.readObject();
        objIn.close();
        fileIn.close();
        return obj;
    }


}
