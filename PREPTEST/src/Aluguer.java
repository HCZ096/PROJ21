import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

public class Aluguer implements Serializable {
    private LocalDateTime inicio,fim;
    private Utilizador utilizador;
    private VeiculoDeAluguer veiculo;
    private boolean capacete;
    private boolean luz;

    public  Aluguer() {}

    public Aluguer(VeiculoDeAluguer veiculo,Utilizador utilizador,LocalDateTime inicio , LocalDateTime fim) {


        this.inicio = inicio;
        this.fim = fim;
        this.veiculo = veiculo;
        this.utilizador = utilizador;
    }

    public Aluguer(Utilizador utilizador, VeiculoDeAluguer veiculo, LocalDateTime inicio, LocalDateTime fim, boolean capacete, boolean luz) {
        this.utilizador = utilizador;
        this.veiculo = veiculo;
        this.inicio = inicio;
        this.fim = fim;
        this.capacete = capacete;
        this.luz = luz;
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

    public long getHoras() {
        Duration duracao = Duration.between(inicio, fim);
        return duracao.toHours();
    }

    private double custoExtras(){
        double total = 0.0;
        if(capacete){
            total += 5.0;
        }
        if(luz){
            total += 2.0;
        }
        return total;
    }

    public double valorTotalAluguer() {
        return calcularCusto();
    }

    public double calcularCusto() {


        Duration duracao = Duration.between(inicio, fim);


        long totalHoras = duracao.toHours();   // total de horas do aluguer
        long dias = totalHoras / 24;           // nº de dias completos
        long horasRestantes = totalHoras % 24; // horas que sobram após contar os dias

        double precoHora = utilizador.precoPorHora(veiculo);
        double custo = 0.0;

        // Cada dia conta como 8 horas pagas
        if (dias > 0) {
            custo += dias * 8 * precoHora;
        }

        // As horas restantes são cobradas normalmente
        custo += horasRestantes * precoHora;
        custo += custoExtras();

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
