package caso2;

import java.util.ArrayList;


@SuppressWarnings("rawtypes")
public class MemoriaReal {

	private ArrayList[] ram;
	private int numMarcos;
	private boolean completa = false;
	
	
	public MemoriaReal(int numMarcos) {
		
		this.ram = new ArrayList[numMarcos];
		this.numMarcos = numMarcos;
	}
	
	public ArrayList[] getRam() {
		return this.ram;
	}
	
	public synchronized void llenarRam(MemoriaVirtual memoriaVirtual) {
		
		for(int i=0; i<numMarcos; i++) {
			
			ArrayList pagina = memoriaVirtual.getMemoria()[i];
			ram[i] = pagina;
			memoriaVirtual.getTablaPagina().darTablaPagina()[i] = i;
			memoriaVirtual.eliminarPagina(i);
		}
		this.completa = true;
	}
	
	public synchronized void actualizarPaginaRam(int indiceAgregar, int indiceQuitar, MemoriaVirtual memoriaVirtual) {
		
		int indiceRam = memoriaVirtual.getTablaPagina().darIndicePagina(indiceQuitar);
		
		if(indiceRam != -1) {
			eliminarPaginaRam(indiceRam, indiceQuitar, memoriaVirtual);
			agregarPaginaRam(indiceRam, indiceAgregar, memoriaVirtual);
		}
	}
	
	private synchronized void eliminarPaginaRam(int indiceRam, int indice, MemoriaVirtual memoriaVirtual) {
		
		ArrayList pagina = ram[indiceRam];
		memoriaVirtual.agregarPagina(indice, pagina);
		memoriaVirtual.getTablaPagina().actualizarTabla(indice, -1);
		ram[indiceRam] = null;
	}
	
	private synchronized void agregarPaginaRam(int indiceRam, int indice, MemoriaVirtual memoriaVirtual) {
		
		ArrayList pagina = memoriaVirtual.getMemoria()[indice];
		ram[indiceRam] = pagina;
		memoriaVirtual.getTablaPagina().actualizarTabla(indice, indiceRam);
	}
	
	
	public boolean completa() {
		return this.completa;
	}
	
}
