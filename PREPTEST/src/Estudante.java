import java.util.Scanner;
public class Estudante extends Utilizador{

    private String poloMfrequentado;
    private String cursoMatriculado;


    public Estudante(){}

    public Estudante(String nome, int id,String metodopagamento,String cursoMatriculado, String poloMfrequentado) {

        super(id, nome,metodopagamento);
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
    @Override
    public double descontoUtilizador(double preco) {
        return preco;
    }


    @Override
    public double precoPorHora(VeiculoDeAluguer v) {
        return v.precoPara(this);
   }


    @Override
    public String toString () {
        return "Curso Frequentado :" + " " + getCursoMatriculado() + "\n" +
                "Polo mais Frequentado :" + " " + getPoloMfrequentado() + "\n";
        }
}

