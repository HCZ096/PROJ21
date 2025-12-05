
public class Ebike extends VeiculoEletrico{
    private boolean BateriaRemovivel ;

    public Ebike(int identificador, String localizador,int nivelbateria,boolean BateriaRemovivel){
        super(identificador,localizador,nivelbateria);
        this.BateriaRemovivel = BateriaRemovivel;
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
        return "Ebike";
    }
}


