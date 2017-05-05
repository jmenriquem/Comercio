/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

class AperturaFicheroExcepcion extends Exception {

    public AperturaFicheroExcepcion(String msg) {
        super(msg);
    }
}

class CierreFicheroExcepcion extends Exception {

    public CierreFicheroExcepcion(String msg) {
        super(msg);
    }
}

class MiObjectOutputStream extends ObjectOutputStream {

    public MiObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    protected MiObjectOutputStream() throws IOException, SecurityException {
        super();
    }

    /**
     * Redefinición del método de escribir la cabecera para que no haga nada.
     */
    @Override
    protected void writeStreamHeader() throws IOException {
    }

}

/**
 * Clase para trabajar con ficheros binarios
 *
 * @author Juanma
 */
public class Archive {

    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private MiObjectOutputStream moos;
    private File f;
    private int fileAccessMode = 0;
    private boolean fileExists = false;

    /**
     * Constructor de la clase Fichero
     *
     * @param fileName - El nombre del fichero a abrir
     * @param accessMode - El modo de apertura wb: Escritura binario rb: Lectura
     * binario ab: Adición binario
     * @throws colegio.AperturaFicheroExcepcion
     *
     */
    public Archive(String fileName, String accessMode)
            throws AperturaFicheroExcepcion {
        f = new File(fileName);
        switch (accessMode) {
            case "wb": //Modo 1
                fileAccessMode = 1;
                System.err.println("Escribiendo");
                try {
                    oos = new ObjectOutputStream(new FileOutputStream(f));
                } catch (IOException ex) {
                    throw new AperturaFicheroExcepcion(
                            "Error al abrir el fichero");
                }
                break;
            case "rb": //Modo 2
                fileAccessMode = 2;
                System.err.println("Leyendo");
                try {
                    ois = new ObjectInputStream(new FileInputStream(f));
                } catch (IOException ex) {
                    throw new AperturaFicheroExcepcion(
                            "Error al abrir el fichero");
                }
                break;
            case "ab": //Modo 3
                fileAccessMode = 3;
                System.err.println("Añadiendo");
                if (f.isFile()) { //Compruebo si es fichero
                    this.fileExists = true;
                    try {
                        moos = new MiObjectOutputStream(new FileOutputStream(f, true));
                    } catch (IOException ex) {
                        throw new AperturaFicheroExcepcion(
                                "Error al abrir el fichero");
                    }
                } else {
                    try {
                        oos = new ObjectOutputStream(new FileOutputStream(f, true));
                    } catch (IOException ex) {
                        throw new AperturaFicheroExcepcion(
                                "Error al abrir el fichero");
                    }
                }
                break;
            default:
                throw new AperturaFicheroExcepcion(
                        "modo de apertura incorrecto");
        }
    }

    /**
     * Escribe un obj en el fichero abierto
     *
     * @param obj
     */
    public void writeObject(Object obj) {
        try {
            if (fileExists) {
                System.err.println("Existia");
                moos.writeObject(obj);
            } else {
                System.err.println("No existia");
                oos.writeObject(obj);
            }
        } catch (IOException io) {
            System.err.println("Error al escribir" + io.getMessage());
        }
    }

    /**
     * Lee un obj en el fichero abierto
     *
     * @return Object - El obj leido.
     */
    public Object readObject() {
        Object obj = null;
        try {
            obj = ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
        }
        return obj;
    }

    public void close() throws CierreFicheroExcepcion {
        try {
            switch (fileAccessMode) {
                case 1:
                    oos.close();
                    break;
                case 2:
                    ois.close();
                    break;
                case 3:
                    if (fileExists) {
                        moos.close();
                    } else {
                        oos.close();
                    }
                    break;
            }
        } catch (IOException io) {
            throw new CierreFicheroExcepcion("Error al cerrar el fichero");
        }
    }
}
