package model;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

public class Cliente extends Pessoa {

    private int id;
    private String historico;

    public Cliente() {
    }

    public Cliente(int id, int cpf, String nome, String endereco, int telefone, String historico) {
        super(cpf, nome, endereco, telefone);
        this.id = id;
        this.historico = historico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", historico=" + historico + ", getCpf()=" + getCpf() + ", getNome()="
                + getNome() + ", getEndereco()=" + getEndereco() + ", getTelefone()=" + getTelefone() + "]";
    }
}
