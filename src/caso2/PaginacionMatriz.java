package caso2;


public class PaginacionMatriz {
	private int nf;
	private int nc;
	private int te;
	private int tp;
	private int mp;
	
	public PaginacionMatriz(int nf, int nc, int te, int tp, int mp) {
		this.nf = nf;
		this.nc = nc;
		this.te = te;
		this.tp = tp;
		this.mp = mp;
	}
	

	
	public int[][][] calcularReferenciasA() {
		int[][][] matriz = new int[nf][nc][2];
		int pagina = 0;
		int desplazamiento = 0;
		for (int i = 0; i < nf; i++) {
	        for (int j = 0; j < nc; j++) {
	            // Verificar si la página está llena para matriz A
	            if (desplazamiento >= tp) {
	                pagina++;
	                desplazamiento = 0;
	            }

	           matriz[i][j][0] = pagina;
	           matriz[i][j][1] = desplazamiento;
	           
	           desplazamiento += te;
	           
	          
	        }
	    }
		
		return matriz;
	}
	
	public int[][][] calcularReferenciasB() {
		int elementosMatrizA = nf*nc-1;
		int pagina = elementosMatrizA / (tp/te);
		int desplazamiento = ((elementosMatrizA % (tp / te)) * te + te) % tp;
		
		int[][][] matriz = new int[nf][nc][2];
		
		   if (desplazamiento == 0) {
			   pagina++;
		   }
	    // offset de página para matriz B

	    for (int i = 0; i < nf; i++) {
	        for (int j = 0; j < nc; j++) {
	        	
	            if (desplazamiento >= tp) {
	                pagina++;
	                desplazamiento = 0;
	            }
	            // Insertar elemento en la matriz B
	            
	            matriz[i][j][0] = pagina;
	            matriz[i][j][1] = desplazamiento;
	            
	            desplazamiento += te;
	        	
	        	
	        }
	    }
		
		
		return matriz;
	}
	


	public int[][][] calcularReferenciasC() {
		int elementosMatrizA = nf*nc-1;
		int elementosMatrizB = elementosMatrizA;
		int desplazamientoB = ((elementosMatrizA % (tp / te)) * te + te) % tp;
		int pagina = (elementosMatrizA + elementosMatrizB)/ (tp/te);
		int desplazamiento = ((elementosMatrizB % (tp / te)) * te + desplazamientoB + te) % tp;
		
		int[][][] matriz = new int[nf][nc][2];
		
		   if (desplazamiento == 0) {
			   pagina++;
		   }
	    // offset de página para matriz B

	    for (int i = 0; i < nf; i++) {
	        for (int j = 0; j < nc; j++) {
	        	
	            if (desplazamiento >= tp) {
	                pagina++;
	                desplazamiento = 0;
	            }
	            // Insertar elemento en la matriz B
	            
	            matriz[i][j][0] = pagina;
	            matriz[i][j][1] = desplazamiento;
	            
	            desplazamiento += te;
	        	
	        	
	        }
	    }
	    return matriz;
		
	}
	
	
	public void imprimirReferencias() {
		int[][][] matrizA = calcularReferenciasA();
		int[][][] matrizB = calcularReferenciasB();
		int[][][] matrizC = calcularReferenciasC();
		
		for (int i = 0; i<nf;i++) {
			for (int j = 0; j <nc;j++) {
				System.out.println("[A-" + i + "-" + j + "]," + matrizA[i][j][0] + "," + matrizA[i][j][1]);
				System.out.println("[B-" + i + "-" + j + "]," + matrizB[i][j][0] + "," + matrizB[i][j][1]);
				System.out.println("[C-" + i + "-" + j + "]," + matrizC[i][j][0] + "," + matrizC[i][j][1]);
			}
		}
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

	public static void main(String[] args) {
		
		
		
		int numRows = 4;
		int numCols = 3;
		int pageSize = 16;
		int intSize = 4;
		PaginacionMatriz paginacion = new PaginacionMatriz(numRows,numCols,intSize,pageSize,5);
		
		paginacion.imprimirReferencias();
		
	}
	}


