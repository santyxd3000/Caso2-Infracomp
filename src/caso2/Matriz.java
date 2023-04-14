package caso2;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Matriz extends Thread {

	private MemoriaReal memReal;
	
	
	public Matriz (MemoriaReal memReal) {
		
		this.memReal = memReal;
	}
	
	public void run() {
		
		try {
			InputStream ins = new FileInputStream("src/caso2/referencias.txt");
			Scanner sc = new Scanner(ins);
			
			sc.nextLine();
			sc.nextLine();
			sc.nextLine();
			sc.nextLine();
			
			while(sc.hasNextLine()) {
				
				sleep(2);
				
				String lineaMatrizA = sc.nextLine();
				String[] listaMatrizA = lineaMatrizA.split(",");
				
				String lineaMatrizB = sc.nextLine();
				String[] listaMatrizB = lineaMatrizB.split(",");
				
				String lineaMatrizC = sc.nextLine();
				String[] listaMatrizC = lineaMatrizC.split(",");
				
				int paginaA = Integer.parseInt(listaMatrizA[1]);
				int paginaB = Integer.parseInt(listaMatrizB[1]);
				int paginaC = Integer.parseInt(listaMatrizC[1]);
				
				if(memReal.getRam()[paginaA] == null || !memReal.getRam()[paginaA].contains(listaMatrizA[0])) {
					//FALLO
				} 
				
				if(memReal.getRam()[paginaB] == null || !memReal.getRam()[paginaB].contains(listaMatrizB[0])) {
					//FALLO
				} 
				
				if(memReal.getRam()[paginaC] == null || !memReal.getRam()[paginaC].contains(listaMatrizC[0])) {
					//FALLO
				} 
			}
			
			sc.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
