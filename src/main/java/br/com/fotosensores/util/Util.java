package br.com.fotosensores.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Util {

	public static BufferedReader executeCommand(String[] cmdarray) throws IOException {
		Process p = Runtime.getRuntime().exec(cmdarray);

		InputStream inputStream = p.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		return bufferedReader;
	}

}
