package servicos;

import dao.ClienteDAO;
import dao.DAOFactory;
import model.Cliente;

public class ClienteServicos {
    ClienteDAO cDAO = DAOFactory.getClienteDAO();

    public void cadastrarCliente (Cliente cVO){
        cDAO.cadastrarCliente(cVO);
    }

    public ArrayList<Cliente> listarClientes (){
        return cDAO.listarClientes();
    }

    public Cliente buscarClienteById(int id){
        return cDAO.buscarClienteById(id);
    }

    public void atualizarCliente (Cliente cVO){
        cDAO.atualizarCliente(cVO);
    }

    public boolean deletarCliente(int cpf){
        return cDAO.deletarCliente(cpf);
    }
}
