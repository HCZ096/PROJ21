public class Trotinete extends VeiculoEletrico {
    private boolean comLcd;

//public Trotinete(){}

    public Trotinete(int id, String localizador, int nivelDeBateria, boolean comLcd) {
        super(id, localizador, nivelDeBateria);
        this.comLcd = comLcd;
    }

    public boolean isComLcd() {
        return comLcd;
    }

    public void setComLcd(boolean comLcd) {
        this.comLcd = comLcd;
    }

    @Override
    public double precoPorHoraPara(Utilizador u) {
        return u.precoPorHora(this);
    }

    public String toString() {
        return "Trotinete -- ID: " + getId() + ", Localizador" +  getLocalizador() + ", Bateria: " + getNivelDeBateria() + "%" + (comLcd ? " com LCD" : "Sem LCD");
    }
}



