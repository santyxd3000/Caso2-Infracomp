package caso2;

import java.util.HashMap;

public class TablaPagina {

	private HashMap<Integer, Integer> tablaPag;
	
	
	public TablaPagina(int numMarcos) {
		this.tablaPag = new HashMap<Integer, Integer>();
		for (int i = 0; i < numMarcos; i++) {
			tablaPag.put(i, null);
		}
	}
	
	
	public HashMap<Integer,Integer> darTablaPagina() {
		return this.tablaPag;
	}
	
	
	public int darPareja(int indice) {
		return tablaPag.get(indice);
	}
	
	
	public synchronized void actualizarTabla(int indice, Integer pagina) {
		
		tablaPag.put(indice, pagina);
	}
}
