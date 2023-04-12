package caso2;


public class GeneradorReferencias {
	private Proceso proceso;
	
	public GeneradorReferencias(Proceso proceso) {
		this.proceso = proceso;
	}
	
	
	public Proceso getProceso() {
		return proceso;
	}


	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}
	
	public int[][][] calcularReferencias(int pagina, int desplazamiento) {
		
		int nf = proceso.getNf();
		int nc = proceso.getNc();
		int te = proceso.getTe();
		int tp = proceso.getTp();
		
		int[][][] matriz = new int[nf][nc][2];
		
		
		   if (desplazamiento == 0) {
			   pagina++;
		   }
		
		
		for (int i = 0; i<nf; i++) {
			for (int j = 0; j < nc; j++) {
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
	

	
	
	public void imprimirReferencias() {
		
		int nf = proceso.getNf();
		int nc = proceso.getNc();
		int te = proceso.getTe();
		int tp = proceso.getTp();
		
		
		int paginaA = -1;
		int desplazamientoA = 0;
		int elementosMatrizA = nf*nc-1;
		int paginaB = elementosMatrizA / (tp/te);
		int desplazamientoB = ((elementosMatrizA % (tp / te)) * te + te) % tp;
		int elementosMatrizB = elementosMatrizA;
		int paginaC = (elementosMatrizA + elementosMatrizB) / (tp/te);
		int desplazamientoC = ((elementosMatrizB % (tp / te)) * te + desplazamientoB + te) % tp;
		
		int[][][] matrizA = calcularReferencias(paginaA, desplazamientoA);
		int[][][] matrizB = calcularReferencias(paginaB, desplazamientoB);
		int[][][] matrizC = calcularReferencias(paginaC, desplazamientoC);
		
		for (int i = 0; i<nf;i++) {
			for (int j = 0; j <nc;j++) {
				System.out.println("[A-" + i + "-" + j + "]," + matrizA[i][j][0] + "," + matrizA[i][j][1]);
				System.out.println("[B-" + i + "-" + j + "]," + matrizB[i][j][0] + "," + matrizB[i][j][1]);
				System.out.println("[C-" + i + "-" + j + "]," + matrizC[i][j][0] + "," + matrizC[i][j][1]);
			}
		}
	}



	}


