package ex5OutputStream_Lista;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileToList {
	
	public BufferedReader bufferExit;
	
	public FileToList(String stringArquivo) throws IOException{
		bufferExit = new BufferedReader(
							new InputStreamReader(
								new FileInputStream(stringArquivo)));
	}
	
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
