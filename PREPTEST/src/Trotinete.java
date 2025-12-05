public class Trotinete extends VeiculoEletrico{
private boolean comLcd;

public Trotinete(int identificador, String localizador,int nivelBateria, boolean comLcd){
    super(identificador, localizador,nivelBateria);
    this.comLcd = comLcd;

    }
    public boolean getComLcd() {
        return comLcd;
    }

    public void setComLcd(boolean comLcd) {
        this.comLcd = comLcd;
    }

    public double precoPara(Estudante e) {
        return this.getComLcd() ? 1.10 : 1.0;
    }
    public double precoPara(Funcionario f) {
        return this.getComLcd() ? 2.60 : 2.50;
    }

   public String toString(){
    return "Trotinete";
    }
}



