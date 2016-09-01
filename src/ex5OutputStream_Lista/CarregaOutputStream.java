/*Classe responsavel por carregar, editar e fechar o arquivo*/
package ex5OutputStream_Lista;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.*;

public class CarregaOutputStream {

	
	OutputStream varOutputStream;
	BufferedWriter varBuffer;
	Scanner digitalizadorItensLista;
	
	//metodo para carregar o arquivo
	public BufferedWriter CarregaArquivo (String stringArquivo) throws IOException{
		varOutputStream = new FileOutputStream(stringArquivo);
		
		varBuffer = new BufferedWriter(
									new OutputStreamWriter(
											new FileOutputStream(stringArquivo)
									)
								);
		
		return varBuffer;	
		
	}
	
	//metodo responsavel por fechar o arquivo
	public void fechaArquivo() throws IOException{
		varBuffer.close();
	}
	
}
