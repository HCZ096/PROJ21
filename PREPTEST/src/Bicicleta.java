import java.util.Scanner;

public class Bicicleta extends VeiculoAluguer{
    private String lugar;

    public Bicicleta(){}

    public Bicicleta(String lugar){
        this.lugar = lugar;

    }
    public String getLugar(){return lugar;}

    public String sLugar(String lugar){
        return lugar == "1" ? "1 Lugar" : "2 Lugares";}

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public  String toString(){
        return"Bicicleta";
    }

        }






