package controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Metodos {

	//metodo para ejecutar el programa
	public void ejecutarPrograma(String programa) {
		//iniciamos la calculadora
		String[] infoProceso = {programa};

		try {
			//ejecutamos el proceso nuevo
			Runtime.getRuntime().exec(infoProceso);

		}catch(IOException e) {
			e.printStackTrace();
		}
	}


	//metodo para ejecutar un comando en el cmd
	public void ejecutarComando(String comando) {
		//El comando que queramos ejecutar, en una cadena de texto.
		String[] infoProceso = {"cmd.exe","/C",comando};

		try {
			//ejecutamos el proceso nuevo
			Process proceso = Runtime.getRuntime().exec(infoProceso);

			InputStream is = proceso.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}

			is.close();
			br.close();

		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
