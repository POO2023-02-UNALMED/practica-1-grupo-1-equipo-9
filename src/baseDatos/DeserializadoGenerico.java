package baseDatos;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DeserializadoGenerico {

    public static <T> ArrayList<T> deserializarObjetos(String filePath) {
        ArrayList<T> objetos = null;

        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Object obj = objectInputStream.readObject();
            if (obj instanceof ArrayList) {
                objetos = (ArrayList<T>) obj;
            } else {
                System.out.println("Error en la deserialización");
            }

            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return objetos;
    }
}
