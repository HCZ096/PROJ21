public abstract class VeiculoEletrico extends VeiculoDeAluguer
 {
    private String nivelbateria;
    public VeiculoEletrico(){}


    public VeiculoEletrico(int identificador, String localizador,String nivelbateria){
        super(identificador,localizador);
        this.nivelbateria = nivelbateria;
    }







}
