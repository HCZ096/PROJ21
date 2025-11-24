import java.util.Scanner;

public class Funcionario extends Utilizador{
    protected int anoContrato;

    public Funcionario(){}
    public Funcionario(String nome, int id,int anoContrato) {
        super(id, nome);
        this.anoContrato = anoContrato ;
    }

    public int getAnoContrato() {
        return anoContrato;
    }
    public void setAnoContrato(int anoContrato) {
        this.anoContrato = anoContrato;
    }
    public double precoPorHora(Bicicleta b) {
        return b.getDuaspessoas() ? 3.00 : 2.00;
    }

    public double precoPorHora(VeiculoDeAluguer v) {
        return v.precoPara(this);}

    //public double precoPorHora(VeiculoDeAluguer veiculo){return this.precoporhora;}



    //public double precoPorHora(Ebike e) {
      //  return e.getBateriaRemovivel()? 3.0 : 2.75;
    //}

    //public double precoPorHora(Trotinete t) {
     //   return t.getComLcd() ? 2.60 : 2.50;
//    }

}

