package model;

public class Funcionario extends Pessoa {
    private int matricula;
    private String cargo;

    public Funcionario() {
    }

    public Funcionario(int cpf, String nome, String endereco, int telefone, int matricula, String cargo) {
        super(cpf, nome, endereco, telefone);
        this.matricula = matricula;
        this.cargo = cargo;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Funcionario [matricula=" + matricula + ", cargo=" + cargo + ", getCpf()=" + getCpf() + ", getNome()="
                + getNome() + ", getEndereco()=" + getEndereco() + ", getTelefone()=" + getTelefone() + "]";
    }

}
