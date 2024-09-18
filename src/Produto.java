public class Produto {
    private int id;
    private String nome;
    private double preco;
    private String categoria;
    private double avaliacao;

    public Produto(int id, String nome, double preco, String categoria, double avaliacao) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.avaliacao = avaliacao;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public String getCategoria() { return categoria; }
    public double getAvaliacao() { return avaliacao; }

    @Override
    public String toString() {
        return String.format("%d. %s - R$%.2f (Avaliação: %.1f)", id, nome, preco, avaliacao);
    }
}
