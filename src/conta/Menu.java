package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
	
		ContaController contas = new ContaController();
		Scanner sc = new Scanner(System.in);
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;
		
		System.out.println("\nCriar Contas\n");
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);
		
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Mateus Ferreira", 2000f, 100.0f);
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
		contas.cadastrar(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Juliano Ramos", 8000f, 15);
		contas.cadastrar(cp2);
		
		contas.listarTodas();
		
		while (true) {
			System.out.println(Cores.TEXT_YELLOW_BOLD + Cores.ANSI_BLACK_BACKGROUND
					+ "\n*******************************************************");
			System.out.println("*                                                     *");
			System.out.println("*                BANCO DO BRAZIL COM Z                *");
			System.out.println("*                                                     *");
			System.out.println("*******************************************************");
			System.out.println("*                                                     *");
			System.out.println("*             1 - Criar cconta                        *");
			System.out.println("*             2 - Listar todas as contas              *");
			System.out.println("*             3 - Buscar conta por número             *");
			System.out.println("*             4 - Atualizar dados da conta            *");
			System.out.println("*             5 - Apagar conta                        *");
			System.out.println("*             6 - Sacar                               *");
			System.out.println("*             7 - Depositar                           *");
			System.out.println("*             8 - Transferir valores entre contas     *");
			System.out.println("*             9 - Sair                                *");
			System.out.println("*                                                     *");
			System.out.println("*******************************************************");
			System.out.println("            Entre com a opção desejada:                ");
			System.out.println("                                                       " + Cores.TEXT_RESET);

			try {
				opcao = sc.nextInt();
			}catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				sc.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println(Cores.TEXT_YELLOW_BOLD + Cores.ANSI_BLACK_BACKGROUND + "\nBanco do Brasil com Z - O seu futuro começa aqui!" + Cores.TEXT_RESET);
				sc.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Criar conta \n\n");
				System.out.print("Digite o Numero da Agência: ");
				agencia = sc.nextInt();
				System.out.print("Digite o Nome do Titular: ");
				sc.skip("\\R?");
				titular = sc.nextLine();
				
				do {
					System.out.print("Digite o tipo da conta (1-CC ou 2-CP): ");
					tipo = sc.nextInt();
				}while(tipo < 1 && tipo > 2);
				
				System.out.print("Digite o saldo da conta: R$ ");
				saldo = sc.nextFloat();
				switch(tipo) {
					case 1 -> {
						System.out.print("Digite o limite de crédito: R$ ");
						limite = sc.nextFloat();
						contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.print("Digite o aniversário da conta: ");
						aniversario = sc.nextInt();
						contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
				}
				
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as contas \n\n");
				
				contas.listarTodas();
				
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da conta - por número \n\n");
				System.out.print("Digite o número da conta: ");
				numero = sc.nextInt();
				
				contas.procurarPorNumero(numero);
				
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da conta \n\n");
				System.out.print("Digite o número da conta: ");
				numero = sc.nextInt();
				
				if(contas.buscarNaCollection(numero) != null) {
					System.out.print("Número da agência: ");
					agencia = sc.nextInt();
					System.out.print("Digite o nome do titular: ");
					sc.skip("\\R?");
					titular = sc.nextLine();
					
					System.out.print("Digite o saldo da conta: R$ ");
					saldo = sc.nextFloat();
					
					tipo = contas.retornaTipo(numero);
					switch(tipo) {
						case 1 -> {
							System.out.print("Digite o limite de crédito: R$ ");
							limite = sc.nextFloat();
							contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
						}
						case 2 -> {
							System.out.print("Digite o aniversário da conta: ");
							aniversario = sc.nextInt();
							contas.atualizar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
						}
						default -> {
							System.out.println("Tipo de conta inválido!");
						}
					}
				} else {
					System.out.println("\nConta não encontrada!");
				}
			
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar conta \n\n");
				
				System.out.print("Digite o número da conta: ");
				numero = sc.nextInt();
				
				contas.deletar(numero);
				
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Saque \n\n");
				
				System.out.print("Digite o número da conta: ");
				numero = sc.nextInt();
				
				do {
					System.out.print("Digite o valor do saque: R$ ");
					valor = sc.nextFloat();
				} while(valor <= 0);
				
				contas.sacar(numero, valor);
				
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito \n\n");
				
				System.out.print("Digite o número da conta: ");
				numero = sc.nextInt();
				
				do {
					System.out.print("Digite o valor do depósito: R$ ");
					valor = sc.nextFloat();
				}while(valor <= 0);
				
				contas.depositar(numero, valor);
				
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre contas \n\n");
				
				System.out.print("Digite o número da conta de origem: ");
				numero = sc.nextInt();
				System.out.print("Digite o número da conta de destino: ");
				numeroDestino = sc.nextInt();
				
				do {
					System.out.print("Digite o valor da Transferência: R$");
					valor = sc.nextFloat();
				} while(valor <= 0);
				
				contas.transferir(numero, numeroDestino, valor);
				
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "Opção inválida \n\n");
				
				keyPress();
				break;
			}
		}
	}
	
	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione enter para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}

}
