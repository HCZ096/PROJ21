import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.*;

public class Aluguer implements Serializable {
    private LocalDateTime inicio,fim;
    private Utilizador utilizador;
    private VeiculoDeAluguer veiculo;

    public  Aluguer() {}

    public Aluguer(VeiculoDeAluguer veiculo,Utilizador utilizador,LocalDateTime inicio , LocalDateTime fim) {


        this.inicio = inicio;
        this.fim = fim;
        this.veiculo = veiculo;
        this.utilizador = utilizador;
    }
    public LocalDateTime getinicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public VeiculoDeAluguer getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(VeiculoDeAluguer veiculo) {
        this.veiculo = veiculo;
    }


    public double valorTotalAluguer(VeiculoDeAluguer v, Utilizador u) {


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

    public String toString() {
        return "Aluguer";
    }
}

