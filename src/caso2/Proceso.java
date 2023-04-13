package caso2;

public class Proceso{
	private int nf; // Número de filas
	private int nc; // Número de columnas
	private int te; // Tamaño del entero
	private int tp; // Tamaño de página
	private int mp; // Número de marcos de página
	
	public Proceso(int nf, int nc, int te, int tp, int mp) {
		this.nf = nf;
		this.nc = nc;
		this.te = te;
		this.tp = tp;
		this.mp = mp;
		
	}
	
	//Todos los métodos getter y setter para cada atributo

	public int getNf() {
		return nf;
	}
	
	
	
	public void setNf(int nf) {
		this.nf = nf;
	}



	public int getNc() {
		return nc;
	}



	public void setNc(int nc) {
		this.nc = nc;
	}



	public int getTe() {
		return te;
	}



	public void setTe(int te) {
		this.te = te;
	}



	public int getTp() {
		return tp;
	}



	public void setTp(int tp) {
		this.tp = tp;
	}



	public int getMp() {
		return mp;
	}



	public void setMp(int mp) {
		this.mp = mp;
	}

}
