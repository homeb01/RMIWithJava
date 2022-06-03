package espoch.edu.ec.rpcjava;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class rmi extends UnicastRemoteObject implements IServidor{
    
    ArrayList<String> playlist;
    
    public rmi() throws RemoteException {
        playlist = new ArrayList<>();
    }
    
    @Override
    public void agregarCancion(String nombre, String artista, String genero) throws RemoteException {
        playlist.add((playlist.size()+1) + ". " + nombre + " - " + artista + " - " + genero);
    }
    
    @Override
    public void eliminarCancion(int indice) throws RemoteException {
        playlist.remove(indice-1);
    }
    
    @Override
    public ArrayList<String> obtenerPlaylist() throws RemoteException {
        return playlist;
    }
}
