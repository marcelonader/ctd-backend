public class Main {
    public static void main(String[] args) {
        /*Mofidicar o main para testar a lógica com o template method */
        Funcionario func1 = new Funcionario("Pedro",2); func1.vender(2);
        Funcionario func2 = new Funcionario("Maria",1); func2.vender(1);

        Vendedor afi1 = new Afiliado("Ramon"); afi1.vender(4);
        Vendedor afi2 = new Afiliado("Paulo"); afi2.vender(1);
        Vendedor afi3 = new Afiliado("José");

        Vendedor estag1 = new Estagiario("Rogério"); estag1.vender(3);
        Vendedor estag2 = new Estagiario("Cibele"); estag2.vender(6);
        Vendedor estag3 = new Estagiario("Patrícia"); estag3.vender(4);

        func1.addAfiliado(afi1);

        System.out.println(func1.mostrarCategoria()+"\n\n");
        System.out.println(func2.mostrarCategoria()+"\n\n");
        System.out.println(afi1.mostrarCategoria()+"\n\n");

        System.out.println(estag1.mostrarCategoria()+"\n\n");
        System.out.println(estag3.mostrarCategoria()+"\n\n");

    }
}
