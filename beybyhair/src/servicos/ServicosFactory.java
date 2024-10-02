package servicos;

public class ServicosFactory {
    private static ClienteServicos clienteS = new ClienteServicos();

    public static ClienteServicos getClienteServicos() {
        return clienteS;
    }// vitimas

    private static FuncionarioServicos funcionarioS = new FuncionarioServicos();

    public static FuncionarioServicos getFuncionarioServicos() {
        return funcionarioS;
    }

    private static ProdutoServicos produtoS = new ProdutoServicos();

    public static ProdutoServicos getProdutoServicos() {
        return produtoS;
    }
}
