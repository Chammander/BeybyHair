package servicos;

import java.util.ArrayList;

import dao.DAOFactory;
import dao.FuncionarioDAO;
import model.Funcionario;

public class FuncionarioServicos {
    FuncionarioDAO fDAO = DAOFactory.getFuncionarioDAO();

    public void cadastrarFuncionario (Funcionario fVO){
        fDAO.cadastrarFuncionario(fVO);
    }

    public ArrayList<Funcionario> listarFuncionarios (){
        return fDAO.listarFuncionarios();
    }

    public Funcionario buscarFuncionarioByMatricula(int matricula){
        return fDAO.buscarFuncionarioByMatricula(matricula);
    }

    public void atualizarFuncionario (Funcionario fVO){
        fDAO.atualizarFuncionario(fVO);
    }

    public boolean deletarFuncionario(int matricula){
        return fDAO.deletarFuncionario(matricula);
    }

}
