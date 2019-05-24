package psp06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duche
 */
public class PSP06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner tec = new Scanner(System.in);
        String usuario = null, nombreFichero = null;
        File fichero = null;
        do{
            if (usuario != null){
                System.out.println("Nombre de usuario incorrecto!!");
            }
            
            System.out.print("Introduzca el nombre de usuario (8 letras minúsculas): ");
        }while (!(usuario = tec.nextLine()).matches("^[a-z]{8}$"));
        System.out.println("Bienvendio " + usuario);
        do {
            if (fichero != null){
                System.out.println("El fichero " + fichero.getAbsolutePath() + " no existe...");
                nombreFichero = null;
                fichero = null;
            }
            do {
                if (nombreFichero != null)
                    System.out.println("Nombre de fichero incrrecto!!");
                System.out.print("Introduzca el nombre del fichero: ");
            }while (!(nombreFichero = tec.nextLine()).matches("^\\w{1,8}\\.\\w{3}$"));
            fichero = new File("c:/datos/" + nombreFichero);
        }while (!fichero.exists());
        try{
            FileReader reader = new FileReader(fichero);
            BufferedReader bf = new BufferedReader(reader);
            String linea;
            while ((linea = bf.readLine()) != null){
                System.out.println(linea);
            }
        }catch (IOException ex){
            
        }
        
    }
    
}
