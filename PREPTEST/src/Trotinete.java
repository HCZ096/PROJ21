public class Trotinete extends VeiculoEletrico{
private boolean comLcd;

public Trotinete(){}
public Trotinete(boolean comLcd, int identificador, String localizador){
    super();
    this.comLcd = comLcd;

    }
    public boolean getComLcd() {
        return comLcd;
    }

    public void setComLcd(boolean comLcd) {
        this.comLcd = comLcd;
    }

    public int niveldaBateria(){
        return 0;
    }

 //   public boolean comLcd(){
   //     return comLcd;
   // }

    //public double precoPorHora(Trotinete t){
       // return t.precoPorHoraPara(this);
    //}
}



