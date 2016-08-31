package ex5OutputStream_Lista;

import java.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex5ClassePrincipal {
	public static void main(String[] args){
		CarregaOutputStream varCarregaArquivo = new CarregaOutputStream();
		Scanner digitalizadorItensLista = new Scanner(System.in);
		List<String> listaItens= new ArrayList();
		FileToList file;
		String itensLista;
		try{
			//carrega arquivo
			BufferedWriter bufferPrincipal = varCarregaArquivo.CarregaArquivo("/home/guilherme/workspace/ex5OutputStream_Lista/src/ex5OutputStream_Lista/arquivo.txt");
			System.out.println("Digte um item da lista:");
			itensLista = digitalizadorItensLista.next();			
			while (!itensLista.equals("--sair")){
				bufferPrincipal.write(itensLista);
				bufferPrincipal.newLine();
				System.out.println("Digte um item da lista:");
				itensLista = digitalizadorItensLista.next();
			}
			
			
			varCarregaArquivo.fechaArquivo();
			
			file = new FileToList("/home/guilherme/workspace/ex5OutputStream_Lista/src/ex5OutputStream_Lista/arquivo.txt");
			
			listaItens = file.toList();
			
			System.out.println("DADOS SOBRE A LISTA");
			System.out.println("QUANTIDADE DE ITENS NA LISTA: " + listaItens.size());
			System.out.println("DADOS QUE ESTAO NA LISTA: ");
			for(int i=0; i<listaItens.size(); i++){
				System.out.println("Posicao " +i+": " + listaItens.get(i));
			}
			
			
			System.out.println("EXCLUINDO ITEM 1");
			listaItens.remove(1);
			
			if(!listaItens.contains(1)) System.out.println("ITEM 1 EXCLUIDO");
			else System.out.println("ERRO!!!");
			
			System.out.println("DADOS QUE ESTAO NA LISTA: ");
			for(int i=0; i<listaItens.size(); i++){
				System.out.println("Posicao " +i+": " + listaItens.get(i));
			}
			
			
			
			
			
			
		}catch(IOException e){
			System.out.println(e);
		}
	}
}
