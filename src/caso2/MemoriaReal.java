package caso2;

import java.util.ArrayList;
import java.util.HashMap;


@SuppressWarnings("rawtypes")
public class MemoriaReal {

	private HashMap<Integer, Integer> ram;
	private TablaPagina tablaPag;
	private MemoriaVirtual memVirtual;
	private int numMarcos;
	private HashMap <Integer, Long> bytesAsociados;
	
	
	public MemoriaReal(int numMarcos, TablaPagina tablaPag, MemoriaVirtual memVirtual) {
		
		this.ram = new HashMap<Integer, Integer>();
		for (int i = 0; i < numMarcos; i++) {
			ram.put(i,-1);
		}
		this.tablaPag = tablaPag;
		this.memVirtual = memVirtual;
		this.numMarcos = numMarcos;
		this.bytesAsociados = new HashMap<Integer, Long>();
		for (int i = 0; i < numMarcos; i++) {
			bytesAsociados.put(i, (long)0);
		}

		
	}
	
	
	public HashMap<Integer, Integer> getRam() {
		return this.ram;
	}
	
	// public synchronized void actualizarPaginaRam(int paginaAgregar, int paginaQuitar) {
		
	// 	int indiceRam = tablaPag.darIndicePagina(paginaQuitar);
		
	// 	if(indiceRam != -1) {
	// 		eliminarPaginaRam(paginaQuitar);
	// 		agregarPaginaRam(paginaAgregar);
	// 	}
	// }
	
	// public synchronized void eliminarPaginaRam(int paginaQuitar) {
		
	// 	int indiceRam = tablaPag.darIndicePagina(paginaQuitar);
	// 	tablaPag.actualizarTabla(paginaQuitar, -1);
	// 	ram[indiceRam] = null;
	// }
	
	// public synchronized void agregarPaginaRam(int paginaAgregar) {
		
	// 	int indiceRam = tablaPag.darIndicePagina(paginaAgregar);
	// 	ArrayList pagina = memVirtual.getMemoria()[paginaAgregar];
	// 	ram[indiceRam] = pagina;
	// 	tablaPag.actualizarTabla(paginaAgregar, indiceRam);

	public synchronized HashMap<Integer, Long> getBytesAsociados() {
		return bytesAsociados;
	}

	public synchronized void setBytesAsociados(HashMap<Integer, Long> bytesAsociados) {
		this.bytesAsociados = bytesAsociados;
	}
		
	// }
	
}
