package controlador;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProgramaLlamar {

	public static void main(String[] args) {

		try {

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String textoRecibido = reader.readLine();

			System.out.println("introduce una cadena..." + "\nCadena escrita: " + textoRecibido + "\n"); 

		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
