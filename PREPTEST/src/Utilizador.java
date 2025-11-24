import java.io.Serializable;
import java.util.Scanner;

public abstract class Utilizador {
    private int id;
    private String nome;
    private double precoporhora;

    public Utilizador() {}

    public Utilizador(int id,String nome) {
        this.id = id;
        this.nome = nome;
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

    public String metodopagamento(){
        return "0";
    }

    public void preencherDadosEspecificos(Scanner sc) {

    }

    public abstract double precoPorHora(VeiculoDeAluguer v);

    public String toString(){
        return "Pessoa " + nome +"com id" + id ;
    }


}




