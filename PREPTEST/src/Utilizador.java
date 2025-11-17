public class Utilizador {

    private String nome;
    private int id;
    public Utilizador() {}

    public Utilizador(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public String informacao() {return "0";}// funcao responsavel por setar o nome e numero de estudante ou funcionario

    public double descontoUtilizador(){
        return 0;
    }
    public String metodopagamento(){
        return "0";
    }

}
