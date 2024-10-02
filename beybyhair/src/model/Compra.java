package model;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

public class Compra {
	
    private int nota_fiscal;
    private int funcionario_matricula;
    private int cliente_id;
    private int produto_codigo;
    private LocalDateTime data_hora;
    private String produtos;
    private float valor;

    public Compra(){}

    public Compra(int nota_fiscal, int funcionario_matricula, int cliente_id, int produto_codigo, LocalDateTime data_hora, String produtos, float valor){
        this.nota_fiscal = nota_fiscal;
        this.funcionario_matricula = funcionario_matricula;
        this.cliente_id = cliente_id;
        this.produto_codigo = produto_codigo;
        this.data_hora = data_hora;
        this.produtos = produtos;
        this.valor = valor;
    }

    public int getNota_fiscal() {
        return nota_fiscal;
    }

    public void setNota_fiscal(int nota_fiscal) {
        this.nota_fiscal = nota_fiscal;
    }

    public int getFuncionario_matricula() {
        return funcionario_matricula;
    }

    public void setFuncionario_matricula(int funcionario_matricula) {
        this.funcionario_matricula = funcionario_matricula;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getProduto_codigo() {
        return produto_codigo;
    }

    public void setProduto_codigo(int produto_codigo) {
        this.produto_codigo = produto_codigo;
    }

    public LocalDateTime getData_hora() {
        return data_hora;
    }

    public void setData_hora(LocalDateTime data_hora) {
        this.data_hora = data_hora;
    }

    public String getProdutos() {
        return produtos;
    }

    public void setProdutos(String produtos) {
        this.produtos = produtos;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

}
