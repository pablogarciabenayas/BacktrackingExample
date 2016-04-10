public class Nodo {
	final int N = 5;
	private int nivel;
	private int[] solucion = new int[N];
	// matriz => Disponible en entrada.
	private int cota; // Cota
	
	public Nodo nodoInicial(){
		Nodo nodo = new Nodo();
		for (int i = 0; i < solucion.length; i++) {
			nodo.solucion[i] = 0;
		}
		nodo.nivel = 0;
		/*
		 * nodo.matriz[1,1] = ...
		 */
		return nodo;
	}
	
}
