import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

public class Aluguer implements Serializable {
    private LocalDateTime inicio;
    private LocalDateTime fim;

    private Utilizador utilizador;
    private VeiculoDeAluguer veiculo;

    private boolean capacete;
    private boolean luz;

    private String metodoDePagamento;

    //public Aluguer() {}
    public Aluguer(Utilizador utilizador, VeiculoDeAluguer veiculo, LocalDateTime inicio, LocalDateTime fim, boolean capacete, boolean luz, String metodoDePagamento) {
        this.utilizador = utilizador;
        this.veiculo = veiculo;
        this.inicio = inicio;
        this.fim = fim;
        this.capacete = capacete;
        this.luz = luz;
        this.metodoDePagamento = metodoDePagamento;
    }

    public double getPrecoServicoExtraHora() {
        double total = 0;

        if (capacete) {
            total += 5.0;
        }
        if (luz) {
            total += 2.5;
        }
        return total;
    }

    public double getPrecoServicoExtraDia(long horas) {
        double total = 0;

        //Servicos cobrados diariamente
        if(capacete) {
            total += 5.0;
        }
        if(luz) {
            total += 2.5;
        }

        //E se for apenas por horas (<24 horas), cobramos de forma justa
        return total * (horas / 24.0);
    }

    public double valorTotalAluguer(Utilizador u, VeiculoDeAluguer veiculo) {
        long horas = Duration.between(inicio, fim).toHours();
        if (horas == 0) {
            horas = 1;  //Isso apenas para ter no minimo uma hora, pois a contagem é por hora
        }

        double precoBaseHora = veiculo.precoPorHoraPara(utilizador);
        double total;

        if (horas > 24) {
            long dias = (horas + 23) / 24;  //Isto arredonda os valores para frente
            total = dias * (8 * precoBaseHora);
            total += dias * getPrecoServicoExtraDia(horas);
        } else {
            total = precoBaseHora * horas;
            total += getPrecoServicoExtraDia(horas) * (horas / 24.0);
        }

        //Desconto para nao docentes
        if (utilizador.temDesconto50()) {
            total *= 0.5;
        }
        return total;
    }


    public String toString() {
            return "Aluguer: " + utilizador.getNome() + "Utiliador: " + "Veiculo: " + veiculo + "Inicio: " +  inicio + "Fim: " + fim +
                    "Capacete: " + capacete + "Luz: " + luz + "Metodo Pagamento: " + "Total: " + valorTotalAluguer() + "%";
    }
}
