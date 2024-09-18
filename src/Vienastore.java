import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Vienastore {
    private static List<Produto> produtos = new ArrayList<>();
    private static Map<Integer, ItemCarrinho> carrinho = new HashMap<>();
    private static Usuario usuarioAtual = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarProdutos();

        while (true) {
            exibirMenuPrincipal();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    listarProdutos();
                    break;
                case 2:
                    adicionarAoCarrinho();
                    break;
                case 3:
                    verCarrinho();
                    break;
                case 4:
                    finalizarCompra();
                    break;
                case 5:
                    if (usuarioAtual == null) {
                        fazerLogin();
                    } else {
                        fazerLogout();
                    }
                    break;
                case 0:
                    System.out.println("Obrigado por visitar a Loja Camila & Viena. Até logo!");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
    }

    private static void inicializarProdutos() {
        produtos.add(new Produto(1, "Fones de Ouvido Sem Fio", 399.99, "Eletrônicos", 4.5));
        produtos.add(new Produto(2, "Relógio Inteligente", 999.99, "Eletrônicos", 4.2));
        produtos.add(new Produto(3, "Caixa de Som Bluetooth", 299.99, "Eletrônicos", 4.0));
        produtos.add(new Produto(4, "Mochila para Notebook", 249.99, "Acessórios", 4.7));
        produtos.add(new Produto(5, "Monitor de Atividades", 449.99, "Eletrônicos", 4.3));
        produtos.add(new Produto(6, "Carregador Portátil", 149.99, "Eletrônicos", 4.6));
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n=== Viena Store ===");
        System.out.println("1. Listar Produtos");
        System.out.println("2. Adicionar ao Carrinho");
        System.out.println("3. Ver Carrinho");
        System.out.println("4. Finalizar Compra");
        System.out.println("5. " + (usuarioAtual == null ? "Fazer Login" : "Fazer Logout"));
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void listarProdutos() {
        System.out.println("\n=== Produtos Disponíveis ===");
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    private static void adicionarAoCarrinho() {
        listarProdutos();
        System.out.print("Digite o ID do produto que deseja adicionar ao carrinho: ");
        int id = scanner.nextInt();
        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();

        Produto produtoSelecionado = produtos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        if (produtoSelecionado != null) {
            ItemCarrinho item = carrinho.get(id);
            if (item == null) {
                carrinho.put(id, new ItemCarrinho(produtoSelecionado, quantidade));
            } else {
                item.setQuantidade(item.getQuantidade() + quantidade);
            }
            System.out.println("Produto adicionado ao carrinho com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void verCarrinho() {
        if (carrinho.isEmpty()) {
            System.out.println("Seu carrinho está vazio.");
            return;
        }

        System.out.println("\n=== Seu Carrinho ===");
        double total = 0;
        for (ItemCarrinho item : carrinho.values()) {
            System.out.println(item);
            total += item.getTotal();
        }
        System.out.printf("Total do Carrinho: R$%.2f\n", total);
    }

    private static void finalizarCompra() {
        if (carrinho.isEmpty()) {
            System.out.println("Seu carrinho está vazio. Adicione produtos antes de finalizar a compra.");
            return;
        }

        if (usuarioAtual == null) {
            System.out.println("Por favor, faça login antes de finalizar a compra.");
            fazerLogin();
            if (usuarioAtual == null) {
                return;
            }
        }

        verCarrinho();
        System.out.print("Confirmar compra? (S/N): ");
        String confirmacao = scanner.nextLine();

        if (confirmacao.equalsIgnoreCase("S")) {
            System.out.println("Compra finalizada com sucesso! Obrigado por comprar na Loja Camila & Viena.");
            carrinho.clear();
        } else {
            System.out.println("Compra cancelada.");
        }
    }

    private static void fazerLogin() {
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();

        usuarioAtual = new Usuario(nome, email);
        System.out.println("Login realizado com sucesso. Bem-vindo, " + nome + "!");
    }

    private static void fazerLogout() {
        usuarioAtual = null;
        System.out.println("Logout realizado com sucesso.");
    }
}
