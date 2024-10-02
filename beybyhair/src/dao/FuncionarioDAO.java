package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Conexao;
import model.Funcionario;



public class FuncionarioDAO {

    public void cadastrarFuncionario(Funcionario fVO) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "insert into funcionario values " + "(?, ?, ?, ?, ?, ?)";
            // cpf nome telefone endereco historico_de_compras
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, fVO.getMatricula());
            pst.setInt(2, fVO.getCpf());
            pst.setString(3, fVO.getNome());
            pst.setInt(4, fVO.getTelefone());
            pst.setString(5, fVO.getEndereco());
            pst.setString(6, fVO.getCargo());
            pst.execute();
            System.out.println("Cliente cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar funcionário.\n" + e.getMessage());
        }
    }

    public ArrayList<Funcionario> listarFuncionarios() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from funcionario ";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                
                // lado da aplicação | (lado do banco)
                funcionario.setMatricula(rs.getInt("matricula"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getInt("cpf"));
                funcionario.setTelefone(rs.getInt("telefone"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar Funcionário.\n"
                    + e.getMessage());
        }
        return funcionarios;
    }//daqui pra cima inserir a vitima no banco de dados

    public Funcionario buscarFuncionarioByMatricula(int matricula) {
        Funcionario f = new Funcionario();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from funcionario where nome like ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, matricula);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                // lado da aplicação | (lado do banco)
                f.setMatricula(rs.getInt("matricula"));
                f.setNome(rs.getString("nome"));
                f.setCpf(rs.getInt("cpf"));
                f.setTelefone(rs.getInt("telefone"));
                f.setCargo(rs.getString("cargo"));
                f.setEndereco(rs.getString("endereco"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Funcionário.\n" + e.getMessage());
        }
        return f;
    }//daqui pra cima pesquisa por nome no banco de dados

    public void atualizarFuncionario(Funcionario fVO) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "update funcionario set nome = ?, endereco = ?, telefone = ?, cargo= ? where matricula = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, fVO.getNome());
            pst.setString(2, fVO.getEndereco());
            pst.setInt(3, fVO.getTelefone());
            pst.setString(4, fVO.getCargo());
            pst.setInt(5, fVO.getMatricula());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Funcionário.\n" + e.getMessage());
        }
    }//atualizar vitima no banco de dados

    public boolean deletarFuncionario(int matricula) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from funcionario where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, matricula);
            return pst.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar funcionário.\n" + e.getMessage());
        }
        return true;
    }

}
