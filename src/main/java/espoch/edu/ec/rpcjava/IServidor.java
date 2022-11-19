package espoch.edu.ec.rpcjava;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IServidor extends Remote {
    public void agregarCancion(String nombre, String artista, String genero) throws RemoteException;
    public void eliminarCancion(int indice) throws RemoteException;
    public void modificarCancion(int indice, String nombre, String artista, String genero) throws RemoteException;
    public String buscarCancion(int indice) throws RemoteException;
    public ArrayList<String> obtenerPlaylist() throws RemoteException;
}
