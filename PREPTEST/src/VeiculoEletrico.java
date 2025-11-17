 abstract public class VeiculoEletrico extends VeiculoAluguer  {


    public VeiculoEletrico(){}
    public VeiculoEletrico(int identificador, String localizador){
        super.setIdentificador(identificador);
        super.setLocalizador(localizador);
    }
    public int niveldaBateria(){
        return 0 ;
    }






}
