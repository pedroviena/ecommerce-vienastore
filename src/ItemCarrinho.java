public class ItemCarrinho {
    private Produto produto;
    private int quantidade;

    public ItemCarrinho(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public double getTotal() {
        return produto.getPreco() * quantidade;
    }

    @Override
    public String toString() {
        return String.format("%s - Quantidade: %d - Total: R$%.2f", produto.getNome(), quantidade, getTotal());
    }
}
