package caso2;

public class TablaPagina {

	private int[] tablaPag;
	
	
	public TablaPagina(int numMarcos) {
		this.tablaPag = new int[numMarcos];
	}
	
	
	public int[] darTablaPagina() {
		return this.tablaPag;
	}
	
	
	public int darIndicePagina(int indice) {
		return this.tablaPag[indice];
	}
	
	
	public synchronized void actualizarTabla(int indice, int pagina) {
		
		tablaPag[indice] = pagina;
	}
}
