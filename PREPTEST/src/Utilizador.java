import java.io.Serializable;

public abstract class Utilizador {
    private int id;


    public Utilizador() {}

    public Utilizador(int id,String nome) {
        this.id = id;
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
    public String toString(){
        return "Pessoa " + nome +"com id" + id ;
    }

}




