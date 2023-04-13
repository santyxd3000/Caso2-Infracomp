package caso2;

public class Actualizador extends Thread{

	private MemoriaVirtual memVirtual;
	private MemoriaReal memReal;
	
	public Actualizador(int mp) {
		
		this.memVirtual = new MemoriaVirtual();
		this.memReal = new MemoriaReal(mp);
	}
	
	
	public void run() {
		
		memReal.llenarRam(memVirtual);
	}
	
	
	public MemoriaReal getMemoriaReal() {
		return this.memReal;
	}
}
