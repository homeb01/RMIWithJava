package espoch.edu.ec.rpcjava;

import static espoch.edu.ec.rpcjava.ClienteB.pausar;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ClienteA {

    public static void main(String[] args) {
        try {
            Registry miRegistro = LocateRegistry.getRegistry("localhost", 1099);
            IServidor servidor;
            servidor = (IServidor) Naming.lookup("//127.0.0.1/IServidor");

            boolean activo = true;
            int opc;
            Scanner in = new Scanner(System.in);

            do {
                System.out.println("-------------- PLAYLIST APP --------------");
                System.out.println("# 1. Agregar cancion                     #");
                System.out.println("# 2. Eliminar cancion                    #");
                System.out.println("# 3. Mostrar playlist                    #");
                System.out.println("# 4. Salir                               #");
                System.out.println("------------------------------------------");
                System.out.print("Ingrese una opcion: ");
                opc = Integer.parseInt(in.nextLine());

                switch (opc) {
                    case 1: {
                        System.out.print("Nombre: ");
                        String nombre = in.nextLine();
                        System.out.print("Artista: ");
                        String artista = in.nextLine();
                        System.out.print("Genero: ");
                        String genero = in.nextLine();
                        servidor.agregarCancion(nombre, artista, genero);
                        System.out.println("Cancion agregada correctamente!");
                        pausar(2);
                        break;
                    }
                    case 2: {
                        System.out.print("Ingrese el indice de la cancion a eliminar: ");
                        int indice = Integer.parseInt(in.nextLine());
                        if (indice > 0 && indice <= servidor.obtenerPlaylist().size()) {
                            servidor.eliminarCancion(indice);
                            System.out.println("Cancion eliminada!");
                        } else {
                            System.out.println("No se ha encontrado una cancion con ese indice!");
                        }
                        pausar(2);
                        break;
                    }
                    case 3: {
                        for (int i = 0; i < servidor.obtenerPlaylist().size(); i++) {
                            System.out.println(servidor.obtenerPlaylist().get(i));
                        }
                        pausar(5);
                        break;
                    }
                    case 4:
                        activo = false;
                }
            } while (activo);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Servidor no encontrado: " + e);
        }
    }
}
