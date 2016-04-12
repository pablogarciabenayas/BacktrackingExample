import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//	ArrayList<Nodo> nodos = new ArrayList();
	public static void main(String[] args) throws IOException {
//		if(args[0] == null){
//			throw new IOException("Es necesario un fichero de entrada!!!");
//		}
		
		try {
//			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			BufferedReader reader = new BufferedReader(new FileReader("/home/pablo/git/daa_pra_ryp/practica-daa-ryp/src/entrada"));
			String[] firstParamLine = reader.readLine().split("\\s+");
			int n = Integer.parseInt(firstParamLine[0]);
			int m = Integer.parseInt(firstParamLine[1]);
			int[][] matrixParams = new int[n][m];
			for(int i=0; i<n; i++ ){
				String[] splitValues = reader.readLine().split("\\s+");
				System.out.print("[");
				for(int j=0; j<m; j++ ){
					matrixParams[i][j] = Integer.parseInt(splitValues[j]);
					System.out.print(" "+matrixParams[i][j]+" ");
				}
				System.out.println("]");
			}
			String[] lastParamLine = reader.readLine().split("\\s+");
			int[] vectorTask = new int[lastParamLine.length];
			for(int i=0; i<lastParamLine.length; i++){
				vectorTask[i] = Integer.parseInt(lastParamLine[i]);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}