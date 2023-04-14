package caso2;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class Matriz {

	private MemoriaReal memReal;
	private HashMap <Integer, Integer> ram;
	private int nr;
	boolean contiene;
	private int necesita;
	private Actualizador actualizador;
	private Falla falla;
	
	
	public Matriz (MemoriaReal memReal, Actualizador actualizador, Falla falla) {
		
		this.memReal = memReal;
		this.actualizador = actualizador;
		this.falla = falla;
	}
	
	public void iniciar() {
		
		try {
			InputStream ins = new FileInputStream("src/caso2/referencias.txt");
			Scanner sc = new Scanner(ins);
			
			sc.nextLine();
			sc.nextLine();
			sc.nextLine();
			String linea = sc.nextLine();

			String[] partes = linea.split("=");
            nr = Integer.parseInt(partes[1]);

			ram = memReal.getRam();
			int i = 0;
			while (i < nr) {
				
				
				
				String lineaMatrizA = sc.nextLine(); //lee la linea
				String[] listaMatrizA = lineaMatrizA.split(","); //separa la linea en una lista
				int paginaA = Integer.parseInt(listaMatrizA[1]);  //toma el numero de pagina

				Collection<Integer> valores = ram.values();//se obtienen los valores de la ram
	
				contiene = cont(valores, paginaA);//se verifica si la pagina esta en la ram
				
				
				while (!contiene) { //no esta en la ram
					
					actualizador.setPoner(paginaA); //se pone lo que se necesita
					contiene = cont(valores, paginaA);//se verifica si la pagina esta en la ram

					//llamar a falla a hacer algo
				}


				i++;
				

				
			}
			
			
			sc.close();

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
	}

	public boolean cont(Collection<Integer> valores, int pag){
		if (valores.contains(pag)) {
			return true;
		}
		return false;
	}


}
