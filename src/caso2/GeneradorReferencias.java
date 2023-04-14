package caso2;


public class GeneradorReferencias {
	private Proceso proceso; //pide un proceso de la clase Proceso
	private int nr;

	public int getNr() {
		return nr;
	}
	
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
		
		//Obtiene todos los valores del proceso que fueron creados
		int nf = proceso.getNf();
		int nc = proceso.getNc();
		int te = proceso.getTe();
		int tp = proceso.getTp();
		
		
		//Inicializa una matriz tridimensional
		int[][][] matriz = new int[nf][nc][2];
		
		
		//Caso en el cual el desplazamiento recibido como entrada es 0
		   if (desplazamiento == 0) {
			   pagina++;
		   }
		
		
		for (int i = 0; i<nf; i++) {
			for (int j = 0; j < nc; j++) {
				
				//Caso para reiniciar el desplazamiento y añadir una página
				if (desplazamiento >= tp) {
					pagina++; //Añadir una página
					desplazamiento = 0; //Reiniciar el desplazamiento
				}
				matriz[i][j][0] = pagina; //Almacenar página en la matriz
				matriz[i][j][1] = desplazamiento; //Almacenar desplazamiento en la matriz
				
				desplazamiento += te;
			}
		}
		
		return matriz;
		
	}
	

	
	
	public void imprimirReferencias() {
		
		//Obtener los valores necesarios de la clase proceso
		int nf = proceso.getNf();
		int nc = proceso.getNc();
		int te = proceso.getTe();
		int tp = proceso.getTp();
		
		
		//La página 1 se inicializa en -1 tomando en cuenta el caso en el que el desplazamiento recibido es 0, siempre se añade una página 
		int paginaA = -1;
		int desplazamientoA = 0; //Inicio de las páginas
		int elementosMatrizA = nf*nc-1; //Todos los elementos de la matriz (contando el 0)
		int paginaB = elementosMatrizA / (tp/te); //Determina cuántas páginas son necesarias para añadir toda la matriz
		int desplazamientoB = ((elementosMatrizA % (tp / te)) * te + te) % tp; //Determina el último desplazamiento de A, y añade tp para determinar el primer desplazamiento de B
		int elementosMatrizB = elementosMatrizA; //Mismas filas, mismas columnas
		int paginaC = (elementosMatrizA + elementosMatrizB) / (tp/te); //Determina cuántas páginas son necesarias para añadir las dos matrices
		int desplazamientoC = ((elementosMatrizB % (tp / te)) * te + desplazamientoB + te) % tp; //Determina cuántas páginas son necesarias para añadir las dos matrices
		int elementosMatrizC = elementosMatrizB; //Mismas filas, mismas columnas
		
		int[][][] matrizA = calcularReferencias(paginaA, desplazamientoA);
		int[][][] matrizB = calcularReferencias(paginaB, desplazamientoB);
		int[][][] matrizC = calcularReferencias(paginaC, desplazamientoC);
		
		int nr = elementosMatrizA + elementosMatrizB + elementosMatrizC + 3; //Todos los elementos de las 3 matrices
		
		
		System.out.println("TP="+tp);
		System.out.println("NF="+nf);
		System.out.println("NC="+nc);
		System.out.println("NR="+nr);
		
		
		//Imprime cada coordenada intercalada entre matrices
		for (int i = 0; i<nf;i++) {
			for (int j = 0; j <nc;j++) {
				System.out.println("[A-" + i + "-" + j + "]," + matrizA[i][j][0] + "," + matrizA[i][j][1]);
				System.out.println("[B-" + i + "-" + j + "]," + matrizB[i][j][0] + "," + matrizB[i][j][1]);
				System.out.println("[C-" + i + "-" + j + "]," + matrizC[i][j][0] + "," + matrizC[i][j][1]);
			}
		}
	}



	}


