package daa.ryp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileUtils {

	private int[][] matrixParams;
	private int[] taskVector;

	public FileUtils(String fileName) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String[] firstParamLine = reader.readLine().split("\\s+");
			int n = Integer.parseInt(firstParamLine[0]);
			int m = Integer.parseInt(firstParamLine[1]);
			matrixParams = new int[n][m];
			for (int i = 0; i < n; i++) {
				String[] splitValues = reader.readLine().split("\\s+");
				for (int j = 0; j < m; j++) {
					matrixParams[i][j] = Integer.parseInt(splitValues[j]);
				}
			}
			String[] lastParamLine = reader.readLine().split("\\s+");
			taskVector = new int[lastParamLine.length];
			for (int i = 0; i < lastParamLine.length; i++) {
				taskVector[i] = Integer.parseInt(lastParamLine[i]);
			}
		} catch (Exception e) {
			System.out.println("El fichero de entrada no es valido!!");
			e.printStackTrace();
		} finally{
			reader.close();
		}
		
	}

	public int[][] getMatrixParams() {
		return matrixParams;
	}

	public int[] getTaskVector() {
		return taskVector;
	}

	@Override
	public String toString() {
		return "El fichero de entrada contiente la siguiente matriz: "
				+ Arrays.deepToString(matrixParams) + "\n"
				+ ", y el siguiente vector de pedido: "
				+ Arrays.toString(taskVector);
	}

}
