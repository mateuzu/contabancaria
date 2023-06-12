package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;
import conta.util.Cores;

public class ContaController implements ContaRepository {
	
	private ArrayList<Conta> listaContas = new ArrayList<>();
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			conta.visualizar();
		} else {
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\nA conta número: " + numero + " não foi encontrada!" + Cores.TEXT_RESET);
		}
	}

	@Override
	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "\nA Conta número: " + conta.getNumero() + " foi criada com sucesso!" + Cores.TEXT_RESET);
	}

	@Override
	public void atualizar(Conta conta) {
		var buscarConta = buscarNaCollection(conta.getNumero());
		
		if(buscarConta != null) {
			listaContas.set(listaContas.indexOf(buscarConta), conta);
			System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "\nA conta número: " + conta.getNumero() + " foi atualizada com sucesso!" + Cores.TEXT_RESET);
		} else {
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\nA conta número: " + conta.getNumero() + " não foi encontrada!" + Cores.TEXT_RESET);
		}
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			if (listaContas.remove(conta) == true) {
				System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "\nA conta número: " + numero + " foi deletada com sucesso!" + Cores.TEXT_RESET);
			} 
		} else 
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\nA conta número: " + numero + " não foi encontrada!" + Cores.TEXT_RESET);
	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if(conta.sacar(valor) == true)
				System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "\nO saque na Conta número: " + numero + " foi efetuado com sucesso!" + Cores.TEXT_RESET);
		} else {
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\nA Conta número: " + numero + " não foi encontrada!" + Cores.TEXT_RESET);
		}
	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			conta.depositar(valor);
			System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "\nO depósito na Conta número: " + numero + " foi efetuado com sucesso!" + Cores.TEXT_RESET);
		} else {
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\nA Conta número: " + numero + " não foi encontrada ou a Conta destino não é uma Conta Corrente!" + Cores.TEXT_RESET);
		}
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);
		
		if (contaOrigem != null && contaDestino != null) {
			if (contaOrigem.sacar(valor) == true) {
				contaDestino.depositar(valor);
				System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "\nA transferênca foi efetuada com sucesso!" + Cores.TEXT_RESET);
			}
		} else 
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\nA Conta de origem e/ou Destino não foram encontradas!" + Cores.TEXT_RESET);
	}

	public int gerarNumero() {
		return ++ numero;
	}
	
	public Conta buscarNaCollection(int numero) {
		for(var conta : listaContas) {
			if(conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}
	
	
	public int retornaTipo(int numero) {
		for(var conta : listaContas) {
			if(conta.getNumero() == numero) {
				return conta.getTipo();
			}
		}
		return 0;
	}
	
}
