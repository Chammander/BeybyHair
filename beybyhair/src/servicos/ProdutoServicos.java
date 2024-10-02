package servicos;

import java.util.ArrayList;

import dao.DAOFactory;
import dao.ProdutoDAO;
import model.Produto;

public class ProdutoServicos {
    ProdutoDAO pDAO = DAOFactory.getProdutoDAO();

    public void cadastrarProduto(Produto pVO) {
        pDAO.cadastrarProduto(pVO);
    }

    public ArrayList<Produto> listarProdutos() {
        return pDAO.listarProdutos();
    }

    public Produto buscarProdutoByCodigo(int codigo) {
        return pDAO.buscarProdutoByCodigo(codigo);
    }

    public void atualizarProduto(Produto pVO) {
        pDAO.atualizarProduto(pVO);
    }

    public boolean deletarProduto(int codigo) {
        return pDAO.deletarProduto(codigo);
    }
}
