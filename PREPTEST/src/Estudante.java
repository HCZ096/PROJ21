import java.util.Scanner;
public class Estudante extends Utilizador{

    private String poloMfrequentado;
    private String cursoMatriculado;
    private double precoporhora;

    public Estudante(){}

    public Estudante(String nome, int id,String cursoMatriculado, String poloMfrequentado) {

        super(id, nome);
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
    public void preencherDadosEspecificos(Scanner sc){//Teste
        System.out.println("Diga o seu Curso Frequentado : \n");
        this.cursoMatriculado = sc.nextLine();

        System.out.println("Diga o seu Polo Frequentado : \n");
         this.poloMfrequentado = sc.nextLine();
    }


    @Override
    public double precoPorHora(VeiculoDeAluguer v) {
        return v.precoPara(this);

//    public double precoPorHora(Bicicleta b) {
//        return b.getDuaspessoas() ? 2.00 : 1;
//    }

//    public double precoPorHora(Trotinete t) {
//        return t.getComLcd() ? 1.10 : 1.0;
//    }
//
//    public double precoPorHora(Ebike e) {
//        return e.getBateriaRemovivel()? 1.50 : 1.25;
   }


    @Override
    public String toString () {
        return "Estudante";
        }
}

