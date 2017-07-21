package com.phonesaragao.classes;

import java.util.List;
import java.util.Scanner;

import com.phonesaragao.dao.CelularDAO;

public class Principal {

	public static void main(String[] args) {

		int opcao = 1;
		Scanner input = new Scanner(System.in);

		do {
			System.out.println("0 - Sair do programa" + "\n1 - Cadastrar novo celular" + "\n2 - Remover celular"
					+ "\n3 - Atualizar celular" + "\n4 - Listar celulares");
			System.out.print("\nInforme a opção desejada: ");
			opcao = input.nextInt();
			input.nextLine();

			if (opcao == 0) {
				System.out.println("\nFinalizando o programa...");
			} else if (opcao == 1) {
				Celular celular = new Celular();

				System.out.print("\nInforme a marca do celular: ");
				celular.setMarca(input.nextLine());

				System.out.print("Informe o modelo do celular: ");
				celular.setModelo(input.nextLine());

				System.out.print("Informe a RAM do celular: ");
				celular.setRam(input.nextDouble());
				input.nextLine();

				System.out.print("Informe o processador do celular: ");
				celular.setProcessador(input.nextLine());

				System.out.print("Informe a velocidade do processador do celular: ");
				celular.setVelocidade_processador(input.nextDouble());

				System.out.print("Informe o preço do celular: R$");
				celular.setPreco(input.nextDouble());

				System.out.print("Informe o tamanho da tela do celular: ");
				celular.setTela(input.nextDouble());

				System.out.print("Informe o tamanho da memória de armazenamento do celular: ");
				celular.setArmazenamento(input.nextInt());
				input.nextLine();

				System.out.print("Informe a qualidade da câmera frontal: ");
				celular.setCamera_frontal(input.nextDouble());

				System.out.print("Informe a qualidade da câmera traseira: ");
				celular.setCamera_traseira(input.nextDouble());

				CelularDAO cel_dao = new CelularDAO();

				if (cel_dao.cadastrarCelular(celular)) {
					System.out.println("\nCelular cadastrado com sucesso!\n");
				} else {
					System.out.println("\nNão foi possível cadastrar o celular!\n");
				}

				cel_dao.close();

			} else if (opcao == 2) {
				Celular celular = new Celular();

				System.out.print("\nInforme a marca do celular: ");
				celular.setMarca(input.nextLine());

				System.out.print("Informe o modelo do celular: ");
				celular.setModelo(input.nextLine());

				CelularDAO cel_dao = new CelularDAO();

				if (cel_dao.removerCelular(celular)) {
					System.out.println("\nCelular removido com sucesso!\n");
				} else {
					System.out.println("\nNão foi possível remover celular!\n");
				}

				cel_dao.close();

			} else if (opcao == 3) {

				Celular celular = new Celular();

				System.out.print("\nInforme a marca do celular: ");
				celular.setMarca(input.nextLine());

				System.out.print("Informe o modelo do celular: ");
				celular.setModelo(input.nextLine());

				System.out.print("Informe o novo preço: R$");
				double novoPreco = input.nextDouble();

				CelularDAO cel_dao = new CelularDAO();

				if (cel_dao.atualizarCelular(celular, novoPreco)) {
					System.out.println("\nPreço atualizado com sucesso!\n");
				} else {
					System.out.println("\nNão foi possível atualizar o preço do celular!\n");
				}
				
				cel_dao.close();

			} else if (opcao == 4) {

				CelularDAO cel_dao = new CelularDAO();
				List<Celular> celulares = cel_dao.listarCelulares();
				cel_dao.close();

				if (celulares.isEmpty()) {
					System.out.println("\nNenhum celular foi encontrado!");
				} else {
					int num = 0;
					for (Celular celular : celulares) {
						num += 1;
						System.out.println("\nCelular " + num + ":");
						System.out.println(celular);
					}
				}
				System.out.println(
						"\n-------------------------------------------------------------\n");
			}

		} while (opcao != 0);

		input.close();
		
	}

}
