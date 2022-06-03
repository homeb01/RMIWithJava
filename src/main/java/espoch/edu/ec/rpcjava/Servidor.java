package espoch.edu.ec.rpcjava;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

public class Servidor {

    public static void main(String[] args) {
        try {
            Registry registro = LocateRegistry.createRegistry(1099);
            registro.rebind("IServidor", new rmi());
            JOptionPane.showMessageDialog(null, "Servidor conectado...");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha podido establecer la conexion: " + e);
        }
    }
    
}
