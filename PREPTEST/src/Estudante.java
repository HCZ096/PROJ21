public class Estudante extends Utilizador{
    protected String cursoMatriculado;
    protected String poloMfrequentado;


    public Estudante(String nome,int id,String cursoMatriculado, String poloMfrequentado){

       super(nome,id);
        this.cursoMatriculado = cursoMatriculado;
        this.poloMfrequentado = poloMfrequentado;
    }

    public String metodopagamento(String op) {
        return op == "1" ? "Cartao" :"Referencia Multibanco";
    }



    }

