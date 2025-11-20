public class Trotinete extends VeiculoEletrico{
private boolean comLcd;

public Trotinete(){}
public Trotinete(boolean comLcd){
    this.comLcd = comLcd;
}


    public boolean getComLcd() {
        return comLcd;
    }

    public void setComLcd(boolean comLcd) {
        this.comLcd = comLcd;
    }

    public int niveldaBateria(){
        return 0 ;
    }

    }



