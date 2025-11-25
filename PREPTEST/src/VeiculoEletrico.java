public abstract class VeiculoEletrico extends VeiculoDeAluguer  {
    private int nivelDeBateria;

    //public VeiculoEletrico(){}

    public VeiculoEletrico(int id, String localizador,  int nivelDeBateria) {
        super(id, localizador);
        this.nivelDeBateria = nivelDeBateria;
    }
    public int getNivelDeBateria(){
        return nivelDeBateria ;
    }
    public void setNivelDeBateria(int nivelDeBateria){
        this.nivelDeBateria = nivelDeBateria;
    }

    public String toString() {
        return "Id: " + getId() + ", Localizador: " + getLocalizador() + ", NivelDeBateria: " + getNivelDeBateria() + "%";
    }
}
