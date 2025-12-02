import java.util.Scanner;

public class Ebike extends VeiculoEletrico{
    private boolean BateriaRemovivel ;
    private int nivelDeBateria;

    public Ebike(){}

    public Ebike( int nivelDeBateria, boolean BateriaRemovivel, int identificador, String localizador){
        super(identificador, localizador);
        this.BateriaRemovivel = BateriaRemovivel;
        this.nivelDeBateria = nivelDeBateria;
    }

    public boolean getBateriaRemovivel() {
        return BateriaRemovivel;
    }

    public void setBateriaRemovivel(boolean bateriaRemovivel) {
        BateriaRemovivel = bateriaRemovivel;
    }
    public double precoPara(Estudante e) {
        return this.getBateriaRemovivel()? 1.50 : 1.25;
    }
    public double precoPara(Funcionario f) {
        return this.getBateriaRemovivel()? 3.0 : 2.75;
    }

    public String toString(){
        return "Tpo de Veiculo : Ebike;" + "\n" +"Bateria Removivel : " + getBateriaRemovivel() +"\n "+ "Nivel de bateria : " ;
    }
}


