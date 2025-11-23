public class Ndocente  extends Funcionario{
    double p_phora ;
    private String servico;
    public Ndocente(String nome,int id,int anoContrato,String servico){
        super(nome,id,anoContrato);
        this.servico = servico;

    }

    public String getServico() {
        return servico;
    }
    public void setServico(String servico) {}

    public double descontoUtilizador(double preco) {
        preco *= (50.0 / 100.0);
            return  preco;

}

    public double calcularprecobicicleta(Bicicleta b) {
        double preco;
        if (b.getLugar().equals("1 Lugares")) {
            preco = 2.0;
            return descontoUtilizador(preco);

        } else if (b.getLugar().equals("2 lugares")) {
            preco = 3.0;
            return descontoUtilizador(preco);
        } else {
            return 0.0;
        }
    }
    public double calcularprecotrotinete(Trotinete t){
        double precobase ;
        if(t.getComLcd() == true){
            precobase = 2.60;
            return descontoUtilizador(precobase);}
        else{
            precobase = 2.50;
            return descontoUtilizador(precobase);
        }

    }
    public double calcularprecoEbike(Ebike e){
        double precobike;
        if(e.getBateriaRemovivel() == true){
            precobike = 3.0;
            return descontoUtilizador(precobike);
        }else{
            precobike = 2.75;
            return descontoUtilizador(precobike);
        }
    }

     */


