public class Estudante extends Utilizador{
    private String cursoMatriculado;
    private String poloMfrequentado;


    public Estudante(String nome,int id,String cursoMatriculado, String poloMfrequentado){

       super(nome,id);
        this.cursoMatriculado = cursoMatriculado;
        this.poloMfrequentado = poloMfrequentado;
    }

    public String getCursoMatriculado() {
        return cursoMatriculado;
    }

    public void setCursoMatriculado(String cursoMatriculado) {
        this.cursoMatriculado = cursoMatriculado;
    }

    public String getPoloMfrequentado() {
        return poloMfrequentado;
    }

    public void setPoloMfrequentado(String poloMfrequentado) {
        this.poloMfrequentado = poloMfrequentado;
    }

    public String metodopagamento(String op) {
        return op == "1" ? "Cartao" :"Referencia Multibanco";
    }



    }

