public class Estagiario extends Vendedor{
    public Estagiario(String nome){
        super.nome = nome;
        super.PONTOS_POR_VENDA = 5;
    }
    @Override
    public int calcularPontos() {
        return 0;
    }

    @Override
    protected String recategorizar(int pontos) {
        return pontos<50 ? "estagiário novato" : "estagiário experiente";
    }

    @Override
    public String mostrarCategoria() {
       int pontos = calcularPontos();
        return    "========Vendedor========\n"
                + this.nome +
                "\n=====Total de pontos====\n"
                + pontos +
                "\n========Categoria=======\n"
                + recategorizar(pontos);
    }
}
