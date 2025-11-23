import java.io.Serializable;
import java.time.Duration;
import java.time.LocalTime;
public class Aluguer implements Serializable {
    private LocalTime horainicio, horafim, datainicio, datafim, tempoTotalAluguer, diaria;
    private Utilizador utilizador;
    VeiculoDeAluguer veiculo;
    //boolean capacete;
    //boolean luz;
    private String servicosExtra; //Fazer condicao se verdade vai me retornar se foi capacete ou luz.

    public Aluguer() {}

    public Aluguer(LocalTime horafim, LocalTime horainicio, LocalTime datainicio, LocalTime datafim, LocalTime tempoTotalAluguer,
                   LocalTime diaria, boolean capacete, boolean luz, String servicosExtra) {
        this.horainicio = horainicio;
        this.horafim = horafim;
        this.datainicio = datainicio;
        this.datafim = datafim;
        this.tempoTotalAluguer = tempoTotalAluguer;
        //this.capacete = capacete;
        //this.luz = luz;
        this.diaria = diaria;
        this.servicosExtra = servicosExtra;
       // this.veiculo = new VeiculoDeAluguer();
    }
    public LocalTime getTempoTotalAluguer(){
        return tempoTotalAluguer;
    }
    public void setTempoTotalAluguer(LocalTime tempoTotalAluguer){
        this.tempoTotalAluguer = tempoTotalAluguer;
    }

    public LocalTime getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(LocalTime horainicio) {
        this.horainicio = horainicio;
    }

    public LocalTime getHorafim() {
        return horafim;
    }

    public void setHorafim(LocalTime horafim) {
        this.horafim = horafim;
    }

    public LocalTime getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(LocalTime datainicio) {
        this.datainicio = datainicio;
    }

    public LocalTime getDatafim() {
        return datafim;
    }

    public void setDatafim(LocalTime datafim) {
        this.datafim = datafim;
    }

    public LocalTime getDiaria() {
        return diaria;
    }

    public void setDiaria(LocalTime diaria) {
        this.diaria = diaria;
    }

    public double precoServicoExtra() {
        if (servicosExtra.equalsIgnoreCase("capacete")) {
            return 5.0;
        } else if (servicosExtra.equalsIgnoreCase("luz")) {
            return 2.5;
        }
        return 0;
    }

    public double valorTotalAluguer(Utilizador utilizador,VeiculoDeAluguer veiculo) {
        Duration tempoTotalAluguer = Duration.between(horainicio, horafim);
        double custoviagem;

        if(tempoTotalAluguer.toHours() > 24) {
            tempoTotalAluguer = Duration.ofHours(8);
            custoviagem = tempoTotalAluguer.toHours() * utilizador.precoPorHora(veiculo);
        }else {
            custoviagem = utilizador.precoPorHora(veiculo) + precoServicoExtra();
        }
        return custoviagem;
    }


    public String toString(){
        return "Data inicio: " + getDatainicio() + "Data fim" + getDatafim() + "Hora inicio: " + getHorainicio() + "Hora fim: " + getHorafim()
                + "Servico extra?: " + servicosExtra;
    }
}
