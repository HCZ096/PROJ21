import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
public class Aluguer implements Serializable {
    private LocalDateTime horainicio, horafim;
    private Utilizador utilizador;
    private VeiculoDeAluguer veiculo;
    private Estudante estudante;
    private Funcionario funcionario;
    private Bicicleta bicicleta;

   // private String servicosExtra; //Fazer condicao se verdade vai me retornar se foi capacete ou luz.

    public  Aluguer() {}

    public Aluguer(VeiculoDeAluguer veiculo,Utilizador utilizador,LocalDateTime horafim, LocalDateTime horainicio
            ) {


        this.horainicio = horainicio;
        this.horafim = horafim;
        //this.datainicio = datainicio;
        //this.datafim = datafim;
        //this.tempoTotalAluguer = tempoTotalAluguer;
        //this.capacete = capacete;
        //this.luz = luz;
        //this.diaria = diaria;
        //  this.servicosExtra = servicosExtra;
        this.veiculo = veiculo;
        this.utilizador = utilizador;
        //this.identificador = identificador;
        // this.localizador = localizador;
    }
//    public LocalTime getTempoTotalAluguer(){
//        return tempoTotalAluguer;
//    }
//    public void setTempoTotalAluguer(LocalTime tempoTotalAluguer){
//        this.tempoTotalAluguer = tempoTotalAluguer;
//    }

    public LocalDateTime getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(LocalDateTime horainicio) {
        this.horainicio = horainicio;
    }

    public LocalDateTime getHorafim() {
        return horafim;
    }

    public void setHorafim(LocalDateTime horafim) {
        this.horafim = horafim;
    }

//    public LocalTime getDatainicio() {
//        return datainicio;
//    }

//    public void setDatainicio(LocalTime datainicio) {
//        this.datainicio = datainicio;
//    }

//    public LocalTime getDatafim() {
//        return datafim;
//    }
//
//    public void setDatafim(LocalTime datafim) {
//        this.datafim = datafim;
//    }
//
//    public LocalTime getDiaria() {
//        return diaria;
//    }
//
//    public void setDiaria(LocalTime diaria) {
//        this.diaria = diaria;
//    }
//
//         if (servicosExtra.equalsIgnoreCase("capacete")) {
//            return 5.0;
//        } else if (servicosExtra.equalsIgnoreCase("luz")) {
//            return 2.5;
//        }
//        return 0;
//    }

    public double valorTotalAluguer(VeiculoDeAluguer v, Utilizador u) {
        if (this.horafim.isBefore(this.horainicio)) {
            throw new IllegalArgumentException("Hora de fim não pode ser antes da hora de início");
        }


            Duration tempoTotalAluguer = Duration.between(this.horainicio, this.horafim);


        long horas = tempoTotalAluguer.toHours();
        double precoHora = u.precoPorHora(v);//no metodo principal ao passar e utilizador (estudante)veiculo(bicicleta) como parametro,era suposto ir
        double custo ;
        if (horas > 24) {
            custo = precoHora * 8;
        }else{
            System.out.println("Preco por hora :  " + precoHora);
            System.out.println("horas : " + horas);

            custo = precoHora * horas;
        }
        return custo;
    }

    public String toString(){
        return "Data inicio: "  + "Data fim" +"Hora inicio: " + getHorainicio() + "Hora fim: " + getHorafim()
                + "Servico extra?: ";
    }
}
