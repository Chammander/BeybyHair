package dao;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import conexao.Conexao;
import model.Cliente;

public class ClienteDAO {

    public void cadastrarCliente(Cliente cVO) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "insert into cliente values " + "(null, ?, ?, ?, ?, ?)";
            // id cpf nome telefone endereco historico_de_compras
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, cVO.getCpf());
            pst.setString(2, cVO.getNome());
            pst.setInt(3, cVO.getTelefone());
            pst.setString(4, cVO.getEndereco());
            pst.setString(5, cVO.getHistorico());
            pst.execute();
            System.out.println("Cliente cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar cliente.\n" + e.getMessage());
        }
    }

    public ArrayList<Cliente> listarClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from cliente ";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setCpf(rs.getInt("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getInt("telefone"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setHistorico(rs.getString("historico_de_compras"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar cliente.\n" + e.getMessage());
        }
        return clientes;
    }

    public Cliente buscarClienteById (int id){
        Cliente c = new Cliente();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from cliente where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                // lado da aplicação | (lado do banco)
                c.setId(rs.getInt("id"));
                c.setCpf(rs.getInt("cpf"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getInt("telefone"));
                c.setEndereco(rs.getString("endereco"));
                c.setHistorico(rs.getString("historico_de_compras"));
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao buscar Cliente.\n"+ e.getMessage());
        }
        return c;
    }

    public void atualizarCliente (Cliente cVO){
        try {
            Connection con = Conexao.getConexao();
            String sql = "update cliente set nome = ?, telefone = ?, endereco = ?, historico_de_compras = ? where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cVO.getNome());
            pst.setInt(2, cVO.getTelefone());
            pst.setString(3, cVO.getEndereco());
            pst.setString(4, cVO.getHistorico());
            pst.setInt(5, cVO.getId());
            pst.executeUpdate();
        } catch (SQLException e ){
            System.out.println("Erro ao atualizar Cliente.\n"+e.getMessage());
        }
    }

    public boolean deletarCliente(int cpf){
        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from cliente where cpf = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, cpf);
            return pst.executeUpdate() != 0;
        } catch (Exception e) {
            System.out.println("Erro ao deletar Cliente.\n"+e.getMessage());
        }
        return true;
    }

}//fim cliente dao
