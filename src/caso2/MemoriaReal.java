package caso2;

import java.util.ArrayList;


@SuppressWarnings("rawtypes")
public class MemoriaReal {

	private ArrayList[] ram;
	private TablaPagina tablaPag;
	private MemoriaVirtual memVirtual;
	
	
	public MemoriaReal(int numMarcos, TablaPagina tablaPag, MemoriaVirtual memVirtual) {
		
		this.ram = new ArrayList[numMarcos];
		this.tablaPag = tablaPag;
		this.memVirtual = memVirtual;
	}
	
	
	public ArrayList[] getRam() {
		return this.ram;
	}
	
	public synchronized void actualizarPaginaRam(int paginaAgregar, int paginaQuitar) {
		
		int indiceRam = tablaPag.darIndicePagina(paginaQuitar);
		
		if(indiceRam != -1) {
			eliminarPaginaRam(paginaQuitar);
			agregarPaginaRam(paginaAgregar);
		}
	}
	
	public synchronized void eliminarPaginaRam(int paginaQuitar) {
		
		int indiceRam = tablaPag.darIndicePagina(paginaQuitar);
		tablaPag.actualizarTabla(paginaQuitar, -1);
		ram[indiceRam] = null;
	}
	
	public synchronized void agregarPaginaRam(int paginaAgregar) {
		
		int indiceRam = tablaPag.darIndicePagina(paginaAgregar);
		ArrayList pagina = memVirtual.getMemoria()[paginaAgregar];
		ram[indiceRam] = pagina;
		tablaPag.actualizarTabla(paginaAgregar, indiceRam);
	}
	
}
