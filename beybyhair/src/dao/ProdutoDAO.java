package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Conexao;
import model.Produto;

public class ProdutoDAO {
    public void cadastrarProduto(Produto pVO) {
        try {
            Connection con = Conexao.getConexao();
            // codigo marca finalidade tipo quantidade preco
            String sql = "insert into produto values "
                    + "(?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, pVO.getCodigo());
            pst.setString(2, pVO.getMarca());
            pst.setString(3, pVO.getFinalidade());
            pst.setString(4, pVO.getTipo());
            pst.setInt(5, pVO.getQuantidade());
            pst.setFloat(6, pVO.getPreco());
            pst.execute();
            System.out.println("Produto cadastrado com sucesso!!!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar produto.\n" + e.getMessage());
        }
    }

    public ArrayList<Produto> listarProdutos() {
        ArrayList<Produto> produtos = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from produto";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setCodigo(rs.getInt("codigo"));
                produto.setMarca(rs.getString("marca"));
                produto.setFinalidade(rs.getString("finalidade"));
                produto.setTipo(rs.getString("tipo"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setPreco(rs.getFloat("preco"));
                produtos.add(produto);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar produto.\n"
                    + e.getMessage());
        }
        return produtos;
    }

    public Produto buscarProdutoByCodigo(int codigo) {
        Produto p = new Produto();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from produto where codigo = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, codigo);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                p.setCodigo(rs.getInt("codigo"));
                p.setMarca(rs.getString("marca"));
                p.setFinalidade(rs.getString("finalidade"));
                p.setTipo(rs.getString("tipo"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setPreco(rs.getFloat("preco"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar produto.\n" + e.getMessage());
        }
        return p;
    }

    public void atualizarProduto(Produto pVO) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "update produto set marca = ?, finalidade = ?, tipo = ?, quantidade = ?, preco = ? where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, pVO.getMarca());
            pst.setString(2, pVO.getFinalidade());
            pst.setString(3, pVO.getTipo());
            pst.setInt(4, pVO.getQuantidade());
            pst.setFloat(5, pVO.getPreco());
            pst.setInt(6, pVO.getCodigo());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar produto.\n" + e.getMessage());
        }
    }

    public boolean deletarProduto(int codigo) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from produto where codigo = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, codigo);
            return pst.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar produto.\n" + e.getMessage());
        }
        return true;
    }
}
