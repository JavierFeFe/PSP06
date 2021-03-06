# PSP06  
Detalles de la tarea de esta unidad.  
Enunciado.  
La tarea de la unidad esta dividida en dos actividades.  

Actividad 6.1. Crea una aplicación que realice los siguientes pasos:  

Solicita el nombre del usuario que va a utilizar la aplicación. El login tiene una longitud de 8 caracteres y está compuesto únicamente por letras minúsculas.  
Solicita al usuario el nombre de un fichero que quiere mostrar. El nombre del fichero es como máximo de 8 caracteres y tiene una extensión de 3 caracteres.  
Visualiza en pantalla el contenido del fichero.
Es importante tener en cuenta que se tiene que realizar una validación de los datos de entrada y llevar un registro de la actividad del programa.  
```Java
package psp06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author duche
 */
public class PSP06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("MyLog"); //Creo un logger
        try{
            // TODO code application logic here
            Scanner tec = new Scanner(System.in); //Creo un Scanner para capturar entrada de teclado
            String usuario = null, nombreFichero = null;
            File fichero = null;
            
            FileHandler fh;
            fh = new FileHandler("c:/datos/MyLog.log", true); //Creo el archivo de log
            logger.addHandler(fh); //Le asigno el fichero
            logger.setLevel(Level.ALL); //Le asigno un nivel de logueo (en este caso todo)
            fh.setFormatter(new SimpleFormatter()); //Le asigno un formatter

            
            do{ //Bucle q fuerza la introducción de un usuario válido
                if (usuario != null){ //Esta condición no se cumple en la primera iteración.
                    logger.log(Level.WARNING,"Usuario introducido no válido"); //Almaceno el fallo en el log
                }
                
                System.out.print("Introduzca el nombre de usuario (8 letras minúsculas): ");
            }while (!(usuario = tec.nextLine()).matches("^[a-z]{8}$")); //Este regex comprueba si se introduce una cadena de texto de 8 caracteres minúscula
            logger.log(Level.INFO,"Login de usuario correcto: " + usuario); //Almaceno el login correcto en el log
            //System.out.println("Bienvendio " + usuario);
            do { //Bucle q fuerza la introducción de un fichero existente
                if (fichero != null){ //Esta condición nunca se cumple en la primera iteración
                    //System.out.println("El fichero " + fichero.getAbsolutePath() + " no existe...");
                    logger.log(Level.WARNING,"Fichero " + fichero.getAbsolutePath() + " inexistente!!!"); //Almaceno el fallo en el log
                    nombreFichero = null; //Quito el valor a la variable para q entre en el otro bucle como si fuera la primera vez
                    fichero = null;
                }
                do {
                    if (nombreFichero != null) //Esta condición nunca se cumple en la rimera iteración
                        //System.out.println("Nombre de fichero incrrecto!!");
                        logger.log(Level.WARNING,"Nombre de fichero Incorrecto!!!"); //Almaceno el fallo en el log
                    System.out.print("Introduzca el nombre del fichero: ");
                }while (!(nombreFichero = tec.nextLine()).matches("^\\w{1,8}\\.\\w{3}$")); //Regex que detecta un numbre de fichero entre 1 y 8 caracteres alfanuméricos con una extensión de 3 caracteres alfanuméricos
                fichero = new File("c:/datos/" + nombreFichero);
            }while (!fichero.exists()); //Compruebo la existencia del fichero
            logger.log(Level.INFO,"Fichero correcto: " + fichero.getAbsolutePath()); //Almaceno el fichero correcto en el log
            FileReader reader = new FileReader(fichero);
            BufferedReader bf = new BufferedReader(reader);
            String linea;
            while ((linea = bf.readLine()) != null){ //Leo el fichero
                System.out.println(linea);
            }
        }catch (IOException | SecurityException ex){ //Almaceno en el log todos los posibles fallos
            logger.log(Level.WARNING,ex.getMessage());
        }finally {
            logger.log(Level.INFO,"Fin de ejecución"); //Almaceno en el log el fin de ejecución
        }
        
    }
    
}
```

Actividad 6.2. Utilizando la aplicación desarrollada en la actividad anterior, configura las políticas de acceso para:  

Firmar digitalmente la aplicación.  
Que sólo pueda leer los datos del directorio c:/datos.  
![image](https://user-images.githubusercontent.com/44543081/58342627-2df51d00-7e51-11e9-8b28-91f9b647346c.png)  
![image](https://user-images.githubusercontent.com/44543081/58342715-6eed3180-7e51-11e9-96ef-399096f9cbf4.png)  
![image](https://user-images.githubusercontent.com/44543081/58342777-9f34d000-7e51-11e9-8b24-fddd05274d66.png)  
![image](https://user-images.githubusercontent.com/44543081/58342835-cc817e00-7e51-11e9-92cb-1c49145a765a.png)  
![image](https://user-images.githubusercontent.com/44543081/58342873-ede26a00-7e51-11e9-8503-8c778b4bc8c9.png)  
![image](https://user-images.githubusercontent.com/44543081/58342945-26824380-7e52-11e9-87dc-b8d60667a687.png)  
