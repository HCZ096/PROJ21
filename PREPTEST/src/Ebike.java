public class Ebike extends VeiculoEletrico{
    private boolean bateriaRemovivel ;

    public Ebike(int id, String localizador, int nivelDeBateria, boolean bateriaRemovivel) {
        super(id, localizador, nivelDeBateria);
        this.bateriaRemovivel = bateriaRemovivel;
    }

    public boolean isBateriaRemovivel() {
        return bateriaRemovivel;
    }

    public void setBateriaRemovivel(boolean bateriaRemovivel) {
        this.bateriaRemovivel = bateriaRemovivel;
    }

    public double precoHoraPara(Utilizador u){
        return u.precoPorHora(this);
    }

    @Override
    public double precoPorHoraPara(Utilizador u) {
        return 0;
    }

    public String toString(){
        return "ID: " + getId() + ", Localizador: " + getLocalizador() + "Nivel de Bateria: " + getNivelDeBateria() + (bateriaRemovivel ? "Bateria removivel" : "Bateria fixa") +"\n";
    }

}


