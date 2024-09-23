package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import vista.Ventana;

public class Metodos {
	
	
	//metodo para ejecutar el programa
	public void ejecutarPrograma(String programa) {
		//iniciamos la calculadora
		String[] infoProceso = {programa};

		try {
			//ejecutamos el proceso nuevo
			Process proceso = Runtime.getRuntime().exec(infoProceso);

			long pid1 = proceso.pid();
			
			ProcessHandle currentProcess = ProcessHandle.current();
			long pid1padre = currentProcess.pid();

			Ventana.appendTextPID1(String.valueOf(pid1));
			Ventana.appendTextPIDPadre1(String.valueOf(pid1padre));

		}catch(IOException e) {
			e.printStackTrace();
		}
	}


	//metodo para ejecutar un comando en el cmd
	public String ejecutarComando(String comando) {
		//El comando que queramos ejecutar, en una cadena de texto.
		String[] infoProceso = {"cmd.exe","/C",comando};
		String resultado = null;

		

		try {
			//ejecutamos el proceso nuevo
			Process proceso = Runtime.getRuntime().exec(infoProceso);

			long pid2 = proceso.pid();
			
			ProcessHandle currentProcess = ProcessHandle.current();
			long pid2padre = currentProcess.pid();
			
			Ventana.appendTextPID2(String.valueOf(pid2));
			Ventana.appendTextPIDPadre2(String.valueOf(pid2padre));

			InputStream is = proceso.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			String line = null;

			while((line = br.readLine()) != null) {
				resultado += line + "\n";
			}

			is.close();
			br.close();

		}catch(IOException e) {
			e.printStackTrace();
		}
		return resultado;
	}


	public String llamarPrograma(String dato) {
		ProcessBuilder builder;
		String respuesta = "";
		String pid3Total="";
		long pid3;
		long pid3padre = 0;

		for(int i=0; i<5; i++) {
			try {
				builder = new ProcessBuilder("java", "controlador.ProgramaLlamar");
				builder.directory(new File("bin"));
				builder.start();
				Process proceso = builder.start();
				
				pid3 = proceso.pid();
				
				pid3Total+= String.valueOf(pid3) + " ";
				
				ProcessHandle currentProcess = ProcessHandle.current();
				pid3padre = currentProcess.pid();
				
				//enviar el texto al proceso ProgramaLlamar
				PrintWriter writer = new PrintWriter(new OutputStreamWriter(proceso.getOutputStream()));
				writer.println(dato);
				writer.flush();
				writer.close();

				//leer la salida del proceso ProgramaLlamar
				BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

				String linea;

				while ((linea = reader.readLine()) != null) {
					respuesta+=linea + "\n";

				}
				reader.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Ventana.appendTextPID3(String.valueOf(pid3Total));
		Ventana.appendTextPIDPadre3(String.valueOf(pid3padre));
		return respuesta;
		

	}

}
