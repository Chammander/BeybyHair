package model;

public class Produto {

    private int codigo;
    private String marca;
    private String finalidade;
    private String tipo;
    private int quantidade;
    private float preco;

    public Produto(){
    }

    public Produto(int codigo, String marca, String finalidade, String tipo, int quantidade, float preco) {
        this.codigo = codigo;
        this.marca = marca;
        this.finalidade = finalidade;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto [codigo=" + codigo + ", marca=" + marca + ", finalidade=" + finalidade + ", tipo=" + tipo
                + ", quantidade=" + quantidade + ", preco=" + preco + "]";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    


}
