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
	
	
	public void calcularMatriz(int fila, int columna, String nombreMatriz, int pagina, int desplazamiento) {
		if (desplazamiento >= tp) {
			pagina++;
			desplazamiento = 0;
		}
		
		System.out.println("[" + nombreMatriz + "-" + fila + "-" + columna + "]," + pagina + "," + desplazamiento);
		desplazamiento += te;
	}
	
	

	
	public static void calcularMatrizA1(int numRows, int numCols, int pageSize, int intSize) {
	    int pageIndexA = 0; // índice de página para matriz A
	    int pageOffsetA = 0; // offset de página para matriz A

	    for (int i = 0; i < numRows; i++) {
	        for (int j = 0; j < numCols; j++) {
	            // Verificar si la página está llena para matriz A
	            if (pageOffsetA >= pageSize) {
	                pageIndexA++;
	                pageOffsetA = 0;
	            }

	            // Insertar elemento en la matriz 
	            System.out.println("[A-" + i + "-" + j + "]," + pageIndexA + "," + pageOffsetA);
	            pageOffsetA += intSize;
	        }
	    }
	}
	
	
	public static void calcularMatrizB(int numRowsA, int numColsA, int pageSize, int intSize) {
		int lastIndexA = numRowsA * numColsA - 1; // último índice de la matriz A
	    int pageIndexB = lastIndexA / (pageSize / intSize); // último índice de la matriz B
	    int pageOffsetB = ((lastIndexA % (pageSize / intSize)) * intSize + intSize) % pageSize; // offset de página para matriz B

	    
	    
	   //Existe un caso que ocurre cuando se cambia de página justo al añadir una nueva matriz
		   if (pageOffsetB == 0) {
			   pageIndexB++;
		   }
	    // offset de página para matriz B

	    for (int i = 0; i < numRowsA; i++) {
	        for (int j = 0; j < numColsA; j++) {
	            // Insertar elemento en la matriz B
	            
	            System.out.println("[B-" + i + "-" + j + "]," + pageIndexB + "," + pageOffsetB);

	            pageOffsetB += intSize;
	            if (pageOffsetB >= pageSize) {
	                pageIndexB++;
	                pageOffsetB = 0;
	            }
	        }
	    }
	}

	
	public static void calcularMatrizC(int numRowsA, int numColsA, int pageSize, int intSize) {
		int lastIndexA = numRowsA * numColsA - 1;
		int lastIndexB = numRowsA * numColsA - 1;
		int pageOffsetB = ((lastIndexA % (pageSize / intSize)) * intSize + intSize) % pageSize;// último índice de la matriz A
	    int pageIndexC = (lastIndexA + lastIndexB) / (pageSize / intSize); // último índice de la matriz B
	    int pageOffsetC = ((lastIndexB % (pageSize / intSize)) * intSize + pageOffsetB + intSize) % pageSize; // offset de página para matriz B

	    
	    
	   //Existe un caso que ocurre cuando se cambia de página justo al añadir una nueva matriz
		   if (pageOffsetC == 0) {
			   pageIndexC++;
		   }
	    // offset de página para matriz B

	    for (int i = 0; i < numRowsA; i++) {
	        for (int j = 0; j < numColsA; j++) {
	            // Insertar elemento en la matriz B
	            
	            System.out.println("[C-" + i + "-" + j + "]," + pageIndexC + "," + pageOffsetC);

	            pageOffsetC += intSize;
	            if (pageOffsetC >= pageSize) {
	                pageIndexC++;
	                pageOffsetC = 0;
	            }
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
		
		
		
		int numRows = 10;
		int numCols = 10;
		int pageSize = 256;
		int intSize = 4;
		PaginacionMatriz paginacion = new PaginacionMatriz(numRows,numCols,pageSize,intSize,5);
		
		paginacion.calcularMatrizA1(numRows,numCols,pageSize,intSize);
		paginacion.calcularMatrizB(numRows, numCols, pageSize, intSize);
		paginacion.calcularMatrizC(numRows, numCols, pageSize, intSize);
		
		
		
		
		
	}
	}


