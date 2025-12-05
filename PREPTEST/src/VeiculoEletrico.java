public abstract class VeiculoEletrico extends VeiculoDeAluguer
 {
    private int nivelbateria;
    public VeiculoEletrico(){}


    public VeiculoEletrico(int identificador, String localizador,int nivelbateria){
        super(identificador,localizador);
        this.nivelbateria = nivelbateria;
    }

    public int getNivelbateria() {
        return nivelbateria;
    }

    public void setNivelbateria(int nivelbateria) {
        this.nivelbateria = nivelbateria;
    }
}
