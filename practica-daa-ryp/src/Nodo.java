import java.util.ArrayList;
import java.util.Arrays;

public class Nodo {
	final int N = 5;
	private int nivel;
	private int[] solucion = new int[N];
	int [][] matriz = new int[4][4];
	private int cota; // Cota
	
	public Nodo nodoInicial(){
		Nodo nodo = new Nodo();
		for (int i = 0; i < solucion.length; i++) {
			nodo.solucion[i] = 0;
		}
		nodo.nivel = 0;
		/*
		 * Extracción de los datos de la matriz de entrada
		 * que se incluiran en la varible matriz de nodo.
		 * nodo.matriz[1,1] = ...
		 */
		nodo.matriz[1][1]=94;	nodo.matriz[1][2]=1;	nodo.matriz[1][3]=54;	nodo.matriz[1][4]=68;
		nodo.matriz[2][1]=74;	nodo.matriz[2][2]=10;	nodo.matriz[2][3]=88;	nodo.matriz[2][4]=82;
		nodo.matriz[3][1]=62;	nodo.matriz[3][2]=88;	nodo.matriz[3][3]=8;	nodo.matriz[3][4]=76;
		nodo.matriz[4][1]=11;	nodo.matriz[4][2]=74;	nodo.matriz[4][4]=81;	nodo.matriz[4][4]=21;
		return nodo;
	}
	
	public int expandir(Nodo n, ArrayList<Nodo> hijos){
		int nHijos = 0;
		int nk = n.nivel+1;
		int i = n.solucion[nk-1];
		
		if (nk > N) {
			return nHijos;
		}
		for (int j = 0; j < solucion.length; j++) {
			if (noEsta(n.solucion,nk-1,j)){
				nHijos += 1;
//				Nodo nuevo = n.clone();
				Nodo nuevo = new Nodo();
//				Arrays.copyOf(n, nuevo);
				nuevo.solucion[nk] = j;
				quitar(nuevo.matriz, nk ,j);
				nuevo.nivel += 1;
				hijos.add(nHijos-1, nuevo);
			}
		}	
		return nHijos;
	}

	
	public boolean noEsta (int [] s, int k, int j){
		for (int i = 1; i < k; i++){
			if (s[i] == j) {
				return false;
			}
		}
		return true;
	}
	
	public void quitar(int [][] m, int i, int j){
		int k;
		int temp;
		temp = m[i][j];
		for (k = 1; k <= N; j++){
			m[i][k] = Integer.MAX_VALUE;
			m[k][j] = Integer.MAX_VALUE;		
		}
		m[i][j] = temp;
	}
	
	public int beneficioColumna(int [][] m, int j){ //Calcula el elmento maximo de una colummna dada
		int i;
		int b;
		b = m[1][j];
		for (i=2; i<=N; i++){
			if (m[i][j]>b){
				b = m[i][j];
			}
		}
		return b;
	}
	
	public int beneficio(int [][] m){ //Calcula la suma de los maximos de las columnas
		int j;
		int beneficio = 0;
		for (j=1; j<=N; j++){
			beneficio += beneficioColumna(m,j);
		}
		return beneficio;
	}
	
	public int ub(Nodo n){
		return beneficio(n.matriz);
	}
	
	public boolean esFactible(Nodo n){
		return valor(n) >= cota;
	}
	
	public int valor(Nodo n){
		return ub(n);
	}
	
	public boolean esSolucion(Nodo n){
		return n.nivel == N;
	}
	
	public void eliminar(Nodo n){
	}
}
