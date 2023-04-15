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
	

	public synchronized HashMap<Integer, Long> getBytesAsociados() {
		return bytesAsociados;
	}

	public  void setBytesAsociados(HashMap<Integer, Long> bytesAsociados) {
		this.bytesAsociados = bytesAsociados;
	}
		
	
	
}
