public class Trotinete extends VeiculoEletrico{
private boolean comLcd;

public Trotinete(){}
public Trotinete(boolean comLcd, int identificador, String localizador){
    super(identificador, localizador);
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

    public double precoPara(Estudante e) {
        return this.getComLcd() ? 1.10 : 1.0;
    }
    public double precoPara(Funcionario f) {
        return this.getComLcd() ? 2.60 : 2.50;
    }


    //   public boolean comLcd(){
   //     return comLcd;
   // }

    //public double precoPorHora(Trotinete t){
       // return t.precoPorHoraPara(this);
    //}
}



