# Simulação de Conta Bancária em Java 💰

Este repositório contém uma simulação simples de uma conta bancária em Java, com as seguintes funcionalidades:

<br><br>

## Funcionalidades 🔧

1. **Criar Conta:**
    - Crie uma nova conta bancária fornecendo os dados do titular.
2. **Listar Todas as Contas:**
    - Exiba uma lista de todas as contas bancárias cadastradas.
3. **Buscar Conta por Número:**
    - Busque uma conta específica fornecendo o número da conta.
4. **Atualizar Dados da Conta:**
    - Atualize as informações de uma conta existente.
5. **Apagar Conta:**
    - Remova uma conta do sistema.
6. **Realizar Saque:**
    - Efetue saques da conta especificada.
7. **Realizar Depósito:**
    - Faça depósitos em uma conta específica.
8. **Transferir Valores entre Contas:**
    - Transfira dinheiro de uma conta para outra.

<br><br>

## Instruções de Uso 📋

Siga esse passo a passo para compilar e executar o programa baixado em seu computador:

1. **Navegue até o diretório:
	- Acesse a pasta onde foi realizado o download do repositório:
```bash
  cd caminho/para/contabancaria-main
```
	
2. **Compilação:**
    - Compile os arquivos Java utilizando o seguinte comando:
```bash
javac -cp src src/conta/Menu.java
```

3. **Execução:**    
    - Execute o programa usando o comando:
```bash
java -cp src conta.Menu
```
	        
4. **Interaja com o Menu:**
    - Siga as opções do menu para utilizar as funcionalidades do banco.

<br><br>

## Exemplo de Uso ✅

```java

*******************************************************
*                                                     *
*                BANCO DO BRAZIL COM Z                *
*                                                     *
*******************************************************
*                                                     *
*             1 - Criar cconta                        *
*             2 - Listar todas as contas              *
*             3 - Buscar conta por número             *
*             4 - Atualizar dados da conta            *
*             5 - Apagar conta                        *
*             6 - Sacar                               *
*             7 - Depositar                           *
*             8 - Transferir valores entre contas     *
*             9 - Sair                                *
*                                                     *
*******************************************************
            Entre com a opção desejada:

1
Criar conta


Digite o Numero da Agência: 1
Digite o Nome do Titular: Teste
Digite o tipo da conta (1-CC ou 2-CP): 2
Digite o saldo da conta: R$ 5000
Digite o aniversário da conta: 10

A Conta número: 5 foi criada com sucesso!


Pressione enter para continuar...

```

Este é um projeto simples que pode ser usado como ponto de partida para sistemas mais complexos de gestão bancária em Java. Sinta-se à vontade para explorar e expandir conforme necessário.
