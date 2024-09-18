# Viena Store

Este é um aplicativo de loja virtual básico em Java, onde os usuários podem visualizar produtos, adicionar itens ao carrinho, fazer login, e finalizar a compra. O aplicativo foi desenvolvido utilizando conceitos de **orientação a objetos**, como encapsulamento, modularidade e reutilização de código.

## Funcionalidades

- Listagem de produtos com nome, preço e avaliação.
- Adicionar produtos ao carrinho com controle de quantidade.
- Visualização do carrinho e cálculo do total.
- Login e logout do usuário.
- Finalização de compras.

## Estrutura do Projeto

O projeto é dividido em várias classes que representam as principais entidades do sistema:

- **`Produto`**: Representa um produto da loja com ID, nome, preço, categoria e avaliação.
- **`ItemCarrinho`**: Representa um item no carrinho, que inclui o produto e a quantidade.
- **`Usuario`**: Representa o usuário que realiza compras na loja.
- **`Vienastore`**: Classe principal que gerencia o fluxo do programa (exibição de menu, interação com o usuário, etc.).

## Tecnologias Usadas

- **Java**: Linguagem principal.
- **Java Util**: Usado para listas dinâmicas (`ArrayList`), mapas (`HashMap`), e leitura de dados do console (`Scanner`).

## Como Executar

1. **Pré-requisitos**: Certifique-se de ter o Java Development Kit (JDK) instalado. Você pode baixar o JDK no site oficial da [Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

2. **Compilar o projeto**: Em um terminal, navegue até o diretório do projeto e execute o seguinte comando:
   ```bash
   javac vienastore.java


## Executar o projeto:

bash 'java Vienastore'

## Executar o projeto:
=== Viena Store ===
1. Listar Produtos
2. Adicionar ao Carrinho
3. Ver Carrinho
4. Finalizar Compra
5. Fazer Login
0. Sair
Escolha uma opção: 

**Listar Produtos:** Mostra todos os produtos disponíveis para compra.
**Adicionar ao Carrinho:** Permite ao usuário adicionar um produto com a quantidade desejada.
**Ver Carrinho:** Mostra todos os itens no carrinho com o total acumulado.
**Finalizar Compra:** Finaliza a compra se o carrinho contiver itens e o usuário estiver logado.
**Fazer Login:** Solicita o nome e o email do usuário para realizar a compra.
**Sair:** Encerra o programa.

## Melhorias Futuras
Implementar persistência de dados (salvar produtos e compras em arquivos ou banco de dados).
Interface gráfica (GUI) utilizando bibliotecas como JavaFX ou Swing.
Integração com um sistema de pagamento.

## Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.

