package dao;


import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import conexao.Conexao;
import model.Pessoa;

public class CompraDAO {
public void cadastrarCompra(Pessoa vVO) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "insert into compra values "
                    + "(null, ?, ?, ?, ?, ?, null, null, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, vVO.getNome());
            pst.setString(2, vVO.getOlho());
            pst.setString(3, vVO.getCabelo());
            pst.setString(4, vVO.getPele());
            pst.setBoolean(5, vVO.isSexo());
            // pst.setString(6, pVO.getArmamento());
            pst.setInt(6, vVO.getPontoDeVida());
            // pst.setInt(6, pVO.getPontoDeVida()); ADICIONAR NA TABELA MSQL
            pst.execute();
            System.out.println("Compra cadastrada com sucesso!!!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar compra.\n" + e.getMessage());
        }
    }

    public ArrayList<Pessoa> getCompras() {
        ArrayList<Pessoa> compras = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from compra ";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Pessoa compra = new Pessoa();
                
                // lado da aplicação | (lado do banco)
                compra.setId(rs.getInt("id"));
                compra.setNome(rs.getString("nome"));
                compra.setCabelo(rs.getString("cabelo"));
                compra.setOlho(rs.getString("olho"));
                compra.setPele(rs.getString("pele"));
                compra.setSexo(rs.getBoolean("sexo"));
                compra.setPontoDeVida(rs.getInt("pontosDeVida"));
                compras.add(Compra);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar Vítima.\n"
                    + e.getMessage());
        }
        return Compras;
    }//daqui pra cima inserir a Compra no banco de dados

    public Pessoa getCompraByNome(String nome) {
        Pessoa v = new Pessoa();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa where nome like ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                // lado da aplicação | (lado do banco)
                v.setId(rs.getInt("id"));
                v.setNome(rs.getString("nome"));
                v.setCabelo(rs.getString("cabelo"));
                v.setOlho(rs.getString("olho"));
                v.setPele(rs.getString("pele"));
                v.setSexo(rs.getBoolean("sexo"));
                v.setPontoDeVida(rs.getInt("pontosDeVida"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Vítima.\n" + e.getMessage());
        }
        return v;
    }//daqui pra cima pesquisa por nome no banco de dados
    
    public Pessoa getCompraById(int id) {
        Pessoa v = new Pessoa();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                // lado da aplicação | (lado do banco)
                v.setId(rs.getInt("id"));
                v.setNome(rs.getString("nome"));
                v.setCabelo(rs.getString("cabelo"));
                v.setOlho(rs.getString("olho"));
                v.setPele(rs.getString("pele"));
                v.setSexo(rs.getBoolean("sexo"));
                v.setPontoDeVida(rs.getInt("pontosDeVida"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Vítima.\n" + e.getMessage());
        }
        return v;
    }

    public void atualizarCompra(Pessoa vVO) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "update pessoa set nome = ?, cabelo = ?, olho = ?, pele = ? where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, vVO.getNome());
            pst.setString(2, vVO.getCabelo());
            pst.setString(3, vVO.getOlho());
            pst.setString(4, vVO.getPele());
            pst.setInt(5, vVO.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Vítima.\n" + e.getMessage());
        }
    }//atualizar Compra no banco de dados

    public boolean deletarCompra(int id) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from pessoa where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            return pst.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar vítima.\n" + e.getMessage());
        }
        return true;
    }

}
