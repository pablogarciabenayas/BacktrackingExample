package daa.ryp;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Inicio de programa...\n\n");
		FileUtils fileInput = null;
		if (args.length == 2) {
			File output = new File(args[1]);
			if (output.exists() && !output.isDirectory()) {
				throw new IOException(
						"El fichero de salida ya existe, introduce otro nombre para crear el fichero de salida");
			}
		}

		try {
			fileInput = new FileUtils(args[0]);
			System.out
					.println("El fichero de entrada contiente la siguiente matriz: ");
			System.out.println(fileInput.printParams());
			System.out.println("y el siguiente vector de pedido:");
			System.out.println("\t" + fileInput.printOrder());
			System.out
					.println("---------------------------------------------------------");

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Es necesario un fichero de entrada valido!");
			e.printStackTrace();
		}

		int[] order = fileInput.getOrder();
		int[][] params = fileInput.getMatrixParams();
		int rows = fileInput.getRows();
		int columns = fileInput.getColumns();

		long startTime = System.nanoTime();

		BakeryTaskProcessor processor = new BakeryTaskProcessor(order, params,
				rows, columns);
		processor.process();
		long executionTime = System.nanoTime() - startTime;

		System.out.println("Tiempo de ejecución: "
				+ TimeUnit.MILLISECONDS.convert(executionTime,
						TimeUnit.NANOSECONDS) + " milisegundos");
		System.out
				.println("---------------------------------------------------------");

		try {
			PrintWriter writer = new PrintWriter(args[1], "UTF-8");
			writer.println(processor.getFinalResult());
			writer.println(processor.getFinalProfit());
			writer.close();
			
			System.out.println("Los resultados se han almacenado en un fichero con el siguiente nombre:" );
			System.out.println(args[1]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out
					.println("\n\nNo ha introducido ningun nombre para el fichero de salida, se imprimira el resultado por pantalla.\n");
			System.out.println(processor.getFinalResult());
			System.out.println(processor.getFinalProfit());
		}

	}
}
