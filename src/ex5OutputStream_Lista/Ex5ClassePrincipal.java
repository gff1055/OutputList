/*Programa que escreve em um arquivo (arquivo.txt) e posteriormente extrai as linhas desse arquivo e
 * as envia para uma lista*/

//nome do pacote
package ex5OutputStream_Lista;

//imports
import java.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex5ClassePrincipal {
	public static void main(String[] args){
		//declaraçcao variaveis
		CarregaOutputStream varCarregaArquivo = new CarregaOutputStream();
		//variavel para receber entrada de itens da lista
		Scanner digitalizadorItensLista = new Scanner(System.in);
		//variaveis para receber entrada relacionada a continuacao ou não do programa
		Scanner scaInputData = new Scanner(System.in);
		String strInputData = "";
		//Variavel que contem itens da lista
		List<String> listaItens= new ArrayList();
		//Objeto do tipo FileToList
		FileToList file;
		String itensLista;
		//Executará no caso do arquivo existir
		try{
			//carrega arquivo
			BufferedWriter bufferPrincipal = varCarregaArquivo.CarregaArquivo("/home/guilherme/workspace/ex5OutputStream_Lista/src/ex5OutputStream_Lista/arquivo.txt");
			//Entrada de um item da lista dentro do arquivo
			System.out.println("Digte um item da lista:");
			itensLista = digitalizadorItensLista.next();	
			//Executará a entrada e gravacao no arquivo até o usuario digitar --sair
			while (!itensLista.equals("--sair")){
				//escrevendo no buffer do arquivo
				bufferPrincipal.write(itensLista);
				bufferPrincipal.newLine();
				//Reentrada de dados
				System.out.println("Digte um item da lista:");
				itensLista = digitalizadorItensLista.next();
			}
			
			//fechando o arquivo
			varCarregaArquivo.fechaArquivo();
			
			//Inicializando objeto que será usado no processo de conversao
			file = new FileToList("/home/guilherme/workspace/ex5OutputStream_Lista/src/ex5OutputStream_Lista/arquivo.txt");
			
			//a lista é carregada
			listaItens = file.toList();
			
			//mostrando mensagens
			System.out.println("DADOS SOBRE A LISTA");
			
			//mostrando quantidade de itens na lista
			System.out.println("QUANTIDADE DE ITENS NA LISTA: " + listaItens.size());
			
			//percorre a lista mostrando a posicao e o dado que esta nessa posicao
			System.out.println("DADOS QUE ESTAO NA LISTA: ");
			for(int i=0; i<listaItens.size(); i++){
				System.out.println("Posicao " +i+": " + listaItens.get(i));
			}
			
			//usuario digita a posicao que quer excluir
			System.out.println("DIGITE O NUMERO DO ITEM QUE DESEJA EXCLUIR");
			strInputData = scaInputData.next();
			
			//processo de exclusao de um item
			//o programa vai excluir até que o usuario digite a palavra "sair" ou a lista fique vazia
			while(!listaItens.isEmpty() && !strInputData.equals("sair")){
								
				//iniciando processo de exclusao
				System.out.println("EXCLUINDO ITEM "+ Integer.parseInt(strInputData));
				listaItens.remove(Integer.parseInt(strInputData));
				System.out.println("ITEM "+Integer.parseInt(strInputData)+" EXCLUIDO");
				
				//usuario digita a posicao que quer excluir
				System.out.println("DIGITE O NUMERO DO ITEM QUE DESEJA EXCLUIR");
				strInputData = scaInputData.next();
			}
			
			//se a lista estiver vazia, uma mensagem é exibida
			if(listaItens.isEmpty())System.out.println("A LISTA ESTA VAZIA");
			
			//Exibicao dos dados que ainda estao na lista
			System.out.println("DADOS QUE ESTAO NA LISTA: ");
			file.showItemsLista(listaItens);
			
			System.out.println("DADOS QUE ESTAO NA LISTA EM ORDEM ALFABETICA: ");
			//Ordenando em ordem alfabetica
			Collections.sort(listaItens);
			file.showItemsLista(listaItens);
			
			System.out.println("MAIOR ELEMENTO DA LISTA: "+ Collections.max(listaItens));
			
			System.out.println("MENOR ELEMENTO DA LISTA: "+ Collections.min(listaItens));
			
			System.out.println("DADOS QUE ESTAO NA LISTA EM ORDEM INVERSA: ");
			//Ordenando em ordem alfabetica
			Collections.reverse(listaItens);
			file.showItemsLista(listaItens);
			
			
			
			
		}catch(IOException e){
			System.out.println(e);
		}
	}
}
