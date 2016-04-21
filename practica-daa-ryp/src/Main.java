import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
//	static int filas;
//	static int columnas;
//	static int[][] matriz_beneficios;
//	static int[] pedido;
//	static int cota = 0;
//	static int[] solucion;	
//	 
//	
//	
//	public static void main(String[] args) throws IOException {
//		
//		// INICIALIZAR FILAS, COLUMNAS, MATRIZ Y PEDIDO CON EL FICHERO ENTRADA!		
//	 
//		// CALCULO LA COTA INICIAL Y LA ASIGNACION INICIAL DE PASTELEROS
//		int cota_superior = 0;
//		int [] asignacion_inicial = new int[pedido.length];
//		for(int i = 0; i<pedido.length;i++){
//			asignacion_inicial[i] = matriz_beneficios[i][pedido[i]];
//		}
//		for(int i = 0; i < asignacion_inicial.length;i++){ 
//			cota_superior += asignacion_inicial[i];
//		}
//		solucion = asignacion_inicial;
//		
//		// CREO LA LISTA DE NODOS VIVOS
//		ArrayList<Nodo> nodos_vivos = new ArrayList<Nodo>();		
//		
//		// METEMOS LOS DATOS EN UN NUEVO NODO
//		Nodo nuevo_nodo = new Nodo(filas,columnas,matriz_beneficios,pedido);
//		
//		// CALCULO COTA PARA ESE NODO
//		nuevo_nodo.setCota();
//		
//		// AÑADO EL NODO A LA LISTA DE NODOS VIVOS
//		nodos_vivos.add(nuevo_nodo);
//		
//		while (!nodos_vivos.isEmpty()){
//			
//			Nodo padre = nodos_vivos.remove(0);
//			
//			ArrayList<Nodo> complecciones = getComplecciones(padre,filas,columnas);
//			
//			
//		}
//		
//		
//		
////		if(args[0] == null){
////			throw new IOException("Es necesario un fichero de entrada!!!");
////		}
//		
//		try {
////			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
//			BufferedReader reader = new BufferedReader(new FileReader("/home/pablo/git/daa_pra_ryp/practica-daa-ryp/src/entrada"));
//			String[] firstParamLine = reader.readLine().split("\\s+");
//			int n = Integer.parseInt(firstParamLine[0]);
//			int m = Integer.parseInt(firstParamLine[1]);
//			int[][] matrixParams = new int[n][m];
//			for(int i=0; i<n; i++ ){
//				String[] splitValues = reader.readLine().split("\\s+");
//				System.out.print("[");
//				for(int j=0; j<m; j++ ){
//					matrixParams[i][j] = Integer.parseInt(splitValues[j]);
//					System.out.print(" "+matrixParams[i][j]+" ");
//				}
//				System.out.println("]");
//			}
//			String[] lastParamLine = reader.readLine().split("\\s+");
//			int[] vectorTask = new int[lastParamLine.length];
//			for(int i=0; i<lastParamLine.length; i++){
//				vectorTask[i] = Integer.parseInt(lastParamLine[i]);
//			}
//			reader.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}	
//	}
//	public static ArrayList<Nodo> getComplecciones (Nodo padre, int n, int m){
//		ArrayList<Nodo> hijos = new ArrayList<Nodo> ();
//		return hijos;
//		
//	}
}
