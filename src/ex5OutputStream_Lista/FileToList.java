/*Classe responsavel por transformar as linhas do arquivo em indices de uma lista*/

package ex5OutputStream_Lista;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileToList {
	

	public BufferedReader bufferExit;

//	Contsrutor que carrega o arquivo 
	public FileToList(String stringArquivo) throws IOException{
		bufferExit = new BufferedReader(
							new InputStreamReader(
								new FileInputStream(stringArquivo)));
	}
	
	//Metodo que converte o texto em uma lista	
	public List toList() throws IOException{
		String stringReader = bufferExit.readLine();
		List<String> listFromFile = new ArrayList();
		while(stringReader != null){
			listFromFile.add(stringReader);
			stringReader = bufferExit.readLine();
		}
		return listFromFile;
		
	}
	
}
