/*Programa que escreve em um arquivo (arquivo.txt) e posteriormente extrai as linhas desse arquivo e
 * as envia para uma lista*/

//nome do pacote
package ex5OutputStream_Lista;

//imports
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
		Scanner scaInputData = new Scanner(System.in);
		String strInputData = "";
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
			
			while(!listaItens.isEmpty() && !strInputData.equals("sair")){
				System.out.println("DIGITE O NUMERO DO ITEM QUE DESEJA EXCLUIR");
				strInputData = scaInputData.next();
				System.out.println("EXCLUINDO ITEM "+ Integer.parseInt(strInputData));
				listaItens.remove(Integer.parseInt(strInputData));
				System.out.println("ITEM "+Integer.parseInt(strInputData)+" EXCLUIDO");
				System.out.println("DESEJA CONTINUAR (para finalizar digite 'sair') ");
				strInputData = scaInputData.next();
			}
			
			System.out.println("DADOS QUE ESTAO NA LISTA: ");
			for(int i=0; i<listaItens.size(); i++){
				System.out.println("Posicao " +i+": " + listaItens.get(i));
			}
			
			if(listaItens.isEmpty())System.out.println("A LISTA ESTA VAZIA");
			
			
			
			
			
			
		}catch(IOException e){
			System.out.println(e);
		}
	}
}
