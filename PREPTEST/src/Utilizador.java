import java.io.Serializable;
import java.util.Scanner;

public abstract class Utilizador implements Serializable {
    private int id;
    private String nome;
    protected String metodopagamento;


    public Utilizador() {}

    public Utilizador(int id,String nome,String metodopagamento) {
        this.id = id;
        this.nome = nome;
        this.metodopagamento = metodopagamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
            return id;
    }

    public void setId(int id) {
            this.id = id;
        }

    public String getMetodopagamento() {
        return metodopagamento;
    }

    public void setMetodopagamento(String metodopagamento) {
        this.metodopagamento = metodopagamento;
    }
    public double descontoUtilizador(double preco) {
       return preco ; }

    public abstract double precoPorHora(VeiculoDeAluguer v);

    public String toString(){
        return "Pessoa " + nome +"com id" + id ;
    }


}




