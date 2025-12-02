import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.*;

public class Aluguer implements Serializable {
    private LocalDateTime Ano,mes,dia,hora,minuto;//private LocalDate datafim,datainicio;
    private LocalDateTime Ano_fim,mes_fim,dia_fim,hora_fim,minuto_fim;//private LocalDate datafim,datainicio;
    private Utilizador utilizador;
    private VeiculoDeAluguer veiculo;
    private Estudante estudante;
    private Funcionario funcionario;
    private Bicicleta bicicleta;

    public Aluguer(VeiculoDeAluguer veiculo, Utilizador utilizador,
                   LocalTime horafim, LocalTime horainicio,
                   LocalDate  datafim, LocalDate  datainicio) {


     /*   this.horainicio = horainicio;
        this.horafim = horafim;
        this.datainicio = datainicio;
        this.datafim = datafim;*/
        //  this.servicosExtra = servicosExtra;
        this.veiculo = veiculo;
        this.utilizador = utilizador;
        this.hora = hora;
        this.hora = hora;
        this.hora_fim = hora_fim;
        this.minuto_fim = minuto_fim;
        this.minuto = minuto;
        this.dia_fim = dia_fim;
        this.dia = dia;
        this.Ano = Ano;
        this.Ano_fim = Ano_fim;

    }
   // private String servicosExtra; //Fazer condicao se verdade vai me retornar se foi capacete ou luz.

    public  Aluguer() {}

    public LocalDateTime getAno() {
        return Ano;
    }

    public void setAno(LocalDateTime ano) {
        Ano = ano;
    }

    public LocalDateTime getMes() {
        return mes;
    }

    public void setMes(LocalDateTime mes) {
        this.mes = mes;
    }

    public LocalDateTime getDia() {
        return dia;
    }

    public void setDia(LocalDateTime dia) {
        this.dia = dia;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public LocalDateTime getMinuto() {
        return minuto;
    }

    public void setMinuto(LocalDateTime minuto) {
        this.minuto = minuto;
    }

    public LocalDateTime getAno_fim() {
        return Ano_fim;
    }

    public void setAno_fim(LocalDateTime ano_fim) {
        Ano_fim = ano_fim;
    }

    public LocalDateTime getMes_fim() {
        return mes_fim;
    }

    public void setMes_fim(LocalDateTime mes_fim) {
        this.mes_fim = mes_fim;
    }

    public LocalDateTime getDia_fim() {
        return dia_fim;
    }

    public void setDia_fim(LocalDateTime dia_fim) {
        this.dia_fim = dia_fim;
    }

    public LocalDateTime getHora_fim() {
        return hora_fim;
    }

    public void setHora_fim(LocalDateTime hora_fim) {
        this.hora_fim = hora_fim;
    }

    public LocalDateTime getMinuto_fim() {
        return minuto_fim;
    }

    public void setMinuto_fim(LocalDateTime minuto_fim) {
        this.minuto_fim = minuto_fim;
    }


     /*public LocalTime getHorainicio() {
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

    public LocalDate getDatainicio() {
      return datainicio;
    }

    public void setDatainicio(LocalDate datainicio) {
      this.datainicio = datainicio;
    }

    public LocalDate getDatafim() {
        return datafim;
   }


    public void setDatafim(LocalDate datafim) {
        this.datafim = datafim;
    }*/




    public double valorTotalAluguer(VeiculoDeAluguer v, Utilizador u) {
        // Junta data e hora num LocalDateTime
        LocalDateTime inicio = LocalDateTime.of(Ano,mes,dia,hora,minuto);
        LocalDateTime fim    = LocalDateTime.of(Ano_fim,mes_fim,dia_fim,hora_fim,minuto_fim);

        if (fim.isBefore(inicio)) {
            throw new IllegalArgumentException("Hora de fim não pode ser antes da hora de início");
        }


        Duration duracao = Duration.between(inicio, fim);
        long totalHoras = duracao.toHours();   // total de horas do aluguer
        long dias = totalHoras / 24;           // nº de dias completos
        long horasRestantes = totalHoras % 24; // horas que sobram após contar os dias

        double precoHora = u.precoPorHora(v);
        double custo = 0.0;

        // Cada dia conta como 8 horas pagas
        if (dias > 0) {
            custo += dias * 8 * precoHora;
        }

        // As horas restantes são cobradas normalmente
        custo += horasRestantes * precoHora;

        System.out.println("Preço por hora: " + precoHora);
        System.out.println("Total horas: " + totalHoras);
        System.out.println("Dias completos: " + dias);
        System.out.println("Horas restantes: " + horasRestantes);

        return custo;
    }


    public String toString(){
       return "Aluguer";
        //return "Data inicio: " + " " + this.datainicio + "\n" + "Data fim" +" "+ this.datafim + "\n" + "Hora inicio: " + this.horainicio + "Hora fim: " + this.horafim
         //       + "Servico extra?: ";
    }
}
