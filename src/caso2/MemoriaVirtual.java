package caso2;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("rawtypes")
public class MemoriaVirtual {

	private ArrayList[] memoria;
	private TablaPagina tablaPagina;
	
	@SuppressWarnings("unchecked")
	public MemoriaVirtual() {
		
		try {
			InputStream ins = new FileInputStream("src/caso2/referencias.txt");
			Scanner sc = new Scanner(ins);
			
			//int tp = Integer.parseInt(sc.nextLine().substring(3));
			sc.nextLine();
			int nf = Integer.parseInt(sc.nextLine().substring(3));
			int nc = Integer.parseInt(sc.nextLine().substring(3));
			int nr = Integer.parseInt(sc.nextLine().substring(3));
			
			int cantPaginas = nr/(nf*nc);
			
			this.memoria = new ArrayList[cantPaginas];
			this.tablaPagina = new TablaPagina(cantPaginas);
			
			for(int i=0; i<cantPaginas; i++) {
				ArrayList<String> pagina = new ArrayList<String>();
				memoria[i] = pagina;
			}
			
			while(sc.hasNextLine()) {
				
				String linea = sc.nextLine();
				String[] lista = linea.split(",");
				
				int pagina = Integer.parseInt(lista[1]);
				
				memoria[pagina].add(lista[0]);
			}
			
			sc.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public ArrayList[] getMemoria() {
		return this.memoria;
	}
	
	
	public TablaPagina getTablaPagina() {
		return this.tablaPagina;
	}
	
	
	public void eliminarPagina(int indice) {
		this.memoria[indice] = null;
	}

	public void agregarPagina(int indice, ArrayList pagina) {
		this.memoria[indice] = pagina;
	}
	
	
	public static void main(String[] args) {
		
		//MemoriaVirtual mem = new MemoriaVirtual();
	}
}
