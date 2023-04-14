package caso2;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class App {
	
	//Función para leer una opción desde la consola
    public static int leerEnteroDesdeConsola() {
        int entero = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String entrada = br.readLine();
                entero = Integer.parseInt(entrada);
                entradaValida = true;
            } catch (IOException | NumberFormatException e) {
                System.out.print("Entrada inválida. Por favor ingresa un entero: ");
            }
        }

        return entero;
    }
    
    
    public static void main(String[] args) {
        String rutaArchivo = "src/caso2/archivo.txt";// Ruta del archivo 
        //Inicializa las variables
        int nf = 0;
        int nc = 0;
        int te = 0;
        int tp = 0;
        int mp = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en nombre de atributo y valor, asumiendo que están separados por "="
                String[] partes = linea.split("=");
                String atributo = partes[0];
                int valor = Integer.parseInt(partes[1]);
                
                //Leyendo los atributos
                switch (atributo) {
                    case "NF":
                        nf = valor;
                        break;
                    case "NC":
                        nc = valor;
                        break;
                    case "TE":
                        te = valor;
                        break;
                    case "TP":
                        tp = valor;
                        break;
                    case "MP":
                        mp = valor;
                        break;
                    
                    default:
                        
                        break;
                }
            }
       //Inicializa un proceso
       Proceso proceso = new Proceso(nf,nc,te,tp,mp);
       
       int opcion;
       do {
           System.out.println("===== MENU =====");
           System.out.println("SELECCIONA UN MODO PARA EL PROGRAMA");
           System.out.println("1. Modo 1 - Comportamiento del proceso");
           System.out.println("2. Modo 2 - Comportamiento del sistema de paginación");
           System.out.println("3. Salir");
           System.out.print("Ingresa tu opción: ");
           opcion = leerEnteroDesdeConsola();
           
           
           switch (opcion) {
           case 1:
           //Invoca el proceso de imprimirReferencias() y lo imprime en un archivo aparte
               try {
                   PrintStream consoleOut = System.out; 
                   FileOutputStream fileOut = new FileOutputStream("src/caso2/referencias.txt"); 
                   PrintStream fileStream = new PrintStream(fileOut);
                   System.setOut(fileStream); 

                   GeneradorReferencias generadorReferencias = new GeneradorReferencias(proceso);
                   generadorReferencias.imprimirReferencias();

                   System.setOut(consoleOut); 
                   fileStream.close();
                   fileOut.close();
                   System.out.println("Imprimiendo referencias...");
               } catch (IOException e) {
                   e.printStackTrace();
                   
               }
               break;
               case 2:
                   System.out.println("======== INICIO MODO 2 ========");
                   
                   MemoriaVirtual memVirtual = new MemoriaVirtual();
                   

                   MemoriaReal memReal = new MemoriaReal(mp, memVirtual.getTablaPagina(), memVirtual);
                   Falla falla = new Falla(memReal);
                   Actualizador actualizador = new Actualizador(memReal, memVirtual.getTablaPagina(), falla, memVirtual);
        
                   Matriz matriz = new Matriz(memReal, actualizador, falla);
                   
                   
                   falla.start();
                   actualizador.start();
                   matriz.iniciar();

                   PrintStream consoleOut = System.out; 
                   FileOutputStream fileOut = new FileOutputStream("src/caso2/salida2.txt"); 
                   PrintStream fileStream = new PrintStream(fileOut);
                   System.setOut(fileStream); 

                   System.out.println("Fallas: " + falla.getFallas());

                   System.setOut(consoleOut); 
                   fileStream.close();
                   fileOut.close();
                   System.out.println("Imprimiendo fallas...");
                   break;
                   
               case 3:
                   System.out.println("Saliendo...");
                   System.exit(0);
                   break;
               default:
                   System.out.println("Opción inválida. Por favor ingresa una opción válida.");
                   break;
           }
       } while (opcion != 3);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir un valor a entero: " + e.getMessage());
        }
    }
}
