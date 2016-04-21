package daa.ryp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Inicio de programa...\n\n");
		try{
//			FileUtils fileInput = new FileUtils("/home/pablo/git/daa_pra_ryp/practica-daa-ryp/src/entrada");
			FileUtils fileInput = new FileUtils(args[0]);
			System.out.println(fileInput.toString());
		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Es necesario un fichero de entrada!!!");
			e.printStackTrace();
		}
		//Chicha del programa, llamar a BakeryTaskProcessor
		long startTime = System.nanoTime();
		
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		long executionTime = System.nanoTime() - startTime;
		System.out.println("Tiempo de ejecución: "+TimeUnit.SECONDS.convert(executionTime, TimeUnit.NANOSECONDS) + "segundos");
		//Simulacion
		
		
		//Generar fichero de salida, si el usuario no introduce ningún nombre para el fichero de salida se imprimira por pantalla.
		try{
			BufferedReader reader = new BufferedReader(new FileReader(args[1]));
		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println("\n\nNo ha introducido ningun nombre para el fichero de salida, se imprimira el resultado por pantalla.\n");
			System.out.println("RESULTADOOOOOO!");
		}
		
		
	}

}
