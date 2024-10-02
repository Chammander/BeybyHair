package dao;

public class DAOFactory {
    private static ClienteDAO cDAO = new ClienteDAO();

    public static ClienteDAO getClienteDAO(){
        return cDAO;
    }//cliente

    private static FuncionarioDAO fDAO = new FuncionarioDAO();

    public static FuncionarioDAO getFuncionarioDAO(){
        return fDAO;
    }//funcionario

    private static ProdutoDAO pDAO = new ProdutoDAO();

    public static ProdutoDAO getProdutoDAO(){
        return fDAO;
    }//produto
}
