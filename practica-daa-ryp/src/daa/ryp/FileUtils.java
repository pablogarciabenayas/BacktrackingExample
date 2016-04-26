package daa.ryp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class FileUtils {

	private int[][] matrixParams;
	private int[] order;
	private int rows;
	private int columns;

	public FileUtils(String fileName) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String[] firstParamLine = reader.readLine().split("\\s+");
			rows = Integer.parseInt(firstParamLine[0]);
			columns = Integer.parseInt(firstParamLine[1]);
			matrixParams = new int[rows + 1][columns + 1];
			for (int i = 1; i < rows + 1; i++) {
				String[] splitValues = reader.readLine().split("\\s+");
				for (int j = 1; j < columns + 1; j++) {
					matrixParams[i][j] = Integer.parseInt(splitValues[j - 1]);
				}
			}
			String[] lastParamLine = reader.readLine().split("\\s+");
			order = new int[lastParamLine.length + 1];
			for (int i = 1; i < lastParamLine.length + 1; i++) {
				order[i] = Integer.parseInt(lastParamLine[i - 1]);
			}
		} catch (Exception e) {
			System.out.println("El fichero de entrada no es valido!!");
			e.printStackTrace();
		} finally {
			reader.close();
		}

	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public int[][] getMatrixParams() {
		return matrixParams;
	}

	public int[] getOrder() {
		return order;
	}
	
	public String printOrder(){
		String string = "[";
		for (int i = 1; i < order.length; i++) {
			string = string + " " + order[i] + " ";
			if(i<order.length-1){
				string = string + ",";
			}
		}
		string = string + "]";
		return string;
	}
	
	public String printParams(){
		String string = "";
		for (int i = 1; i < rows+1; i++){
			for (int j = 1; j < columns+1 ; j++){
				string = string +"\t"+ " " + matrixParams[i][j] + " ";
			}
			string = string + '\n';
		}
		
		return string;
	}



}
