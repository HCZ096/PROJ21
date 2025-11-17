
public class Utilizador {

    private String nome;
    private int id;
    public Utilizador() {}

    public Utilizador(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

        public String getNome(String nome) {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getId(int id) {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    public String metodopagamento(){
        return "0";
    }
    public String toString(){
        return "Nome :" + nome + " " + "ID : " + id;
    }

}




