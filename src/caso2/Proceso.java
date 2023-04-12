package caso2;

public class Proceso{
	private int nf;
	private int nc;
	private int te;
	private int tp;
	private int mp;
	
	public Proceso(int nf, int nc, int te, int tp, int mp) {
		this.nf = nf;
		this.nc = nc;
		this.te = te;
		this.tp = tp;
		this.mp = mp;
		
	}

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
