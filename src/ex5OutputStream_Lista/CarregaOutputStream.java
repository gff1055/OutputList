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
	
	public BufferedWriter CarregaArquivo (String stringArquivo) throws IOException{
		varOutputStream = new FileOutputStream(stringArquivo);
		
		varBuffer = new BufferedWriter(
									new OutputStreamWriter(
											new FileOutputStream(stringArquivo)
									)
								);
		
		return varBuffer;
		
		
//		String itensLista = digitalizadorItensLista.next();
	//	varBuffer.write(itensLista);
		//varBuffer.newLine();
		
		//if (itensLista.equals("--sair")){
			//System.out.println("VOCE ESTA SAINDO... :)");
	//	}
		
//		itensLista = digitalizadorItensLista.next();
	//	varBuffer.write(itensLista);
		//varBuffer.newLine();
		
		
	}
	public void fechaArquivo() throws IOException{
		varBuffer.close();
	}
	
}
