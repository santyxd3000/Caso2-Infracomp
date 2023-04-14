package caso2;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

@SuppressWarnings("rawtypes")
public class MemoriaVirtual {

	private HashMap<Integer, ArrayList<String>> memoria = new HashMap<Integer, ArrayList<String>>();
	private TablaPagina tablaPagina;
	
	
	public MemoriaVirtual() {
		
		try {
			InputStream ins = new FileInputStream("src/caso2/referencias.txt");
			Scanner sc = new Scanner(ins);
			
			sc.nextLine();
			int nf = Integer.parseInt(sc.nextLine().substring(3));
			int nc = Integer.parseInt(sc.nextLine().substring(3));
			int nr = Integer.parseInt(sc.nextLine().substring(3));
			
			int cantPaginas = nr/(nf*nc);
			
			//this.memoria = new ArrayList<>();
			this.tablaPagina = new TablaPagina(cantPaginas);
			
			for(int i=0; i<cantPaginas; i++) {
				ArrayList<String> pagina = new ArrayList<String>();
				memoria.put(i,pagina);
			}
			
			while(sc.hasNextLine()) {
				
				String linea = sc.nextLine();
				String[] lista = linea.split(",");
				int pagina = Integer.parseInt(lista[1]);
				ArrayList<String> pag = (ArrayList<String>) memoria.get(pagina);
				pag.add(lista[0]);
				
			}
			
			sc.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public HashMap getMemoria() {
		return this.memoria;
	}

	public ArrayList<String> getPagina (int pagina) {
		return memoria.get(pagina);
	}
	
	
	public TablaPagina getTablaPagina() {
		return this.tablaPagina;
	}

}
