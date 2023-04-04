package org.caucotafederico.Clase11Tema10;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
    	String opcion = "";
    	String rutaArchivo = "src\\org\\caucotafederico\\resources\\Chat.txt"; 
        Scanner scn = new Scanner(System.in);
        System.out.println("Bienvenido al programa de char por consola");
        System.out.println("Por favor ingrese su nombre");
        String nombre = scn.nextLine();
        System.out.println("Hola " + nombre );
        while (opcion != "0") {
            System.out.println("Por favor indique una de las siguientes opciones posibles:"  );
            System.out.println("(*)Presione la tecla 1, para Escribir un mensaje"  );
            System.out.println("(*)Presione la tecla 2, para Leer todos los mensajes del chat"  );
            System.out.println("(*)Presione la tecla 0, para salir del programa"  );
            opcion = scn.nextLine();
            if (opcion.equals("1")) {
            	System.out.println("Perfecto!!! Escribe tu mensaje:");
            	opcion = scn.nextLine();
            	try {
            		opcion = "\n ("+ LocalDateTime.now().toString() + ") ==>  " + nombre + ": " + opcion;
            		Files.writeString(Paths.get(rutaArchivo), opcion, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
	            	System.out.println("Mensaje guardado en el chat");
	            	opcion = "";
				} catch (Exception e) {
					//e.printStackTrace();
					opcion = e.getMessage();
					if (opcion == null)
						opcion = "";
					opcion = opcion + " . Fin del programa.";
					System.out.println("Error al escribir en el Archivo del chat " + opcion);
					opcion = "0";
				}
            }else if (opcion.equals("2")) {
            	System.out.println("Perfecto!!! Has seleccionado Leer todos los mensajes del chat");
            	try {
					List<String> lineasArchivo = Files.readAllLines(Paths.get(rutaArchivo));
					System.out.println("Mensajes:");
					for(String lineaLeida: lineasArchivo) {
						System.out.println(lineaLeida);
					}
					System.out.println("Fin de los mensajes");
	            	opcion = "";
				} catch (Exception e) {
					opcion = e.getMessage();
					if (opcion == null)
						opcion = "";
					opcion = opcion + " . Fin del programa.";
					System.out.println("Error al leer el Archivo del chat " + opcion);
					opcion = "0";
				}
            	
            } else if(opcion.equals("0")) {
            	System.out.println("Gracias, te esperamos pronto. Fin del programa.");
            	break;
    		}else {
            	System.out.println("La opción seleccionada no es correcta para este programa.");
    		}
        }
        scn.close();
    }
}
