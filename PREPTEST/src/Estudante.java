public class Estudante extends Utilizador{
    private String cursoMatriculado;
    private String poloMfrequentado;


    public Estudante(String nome,int id,String cursoMatriculado, String poloMfrequentado){

       super(nome,id);
        this.cursoMatriculado = cursoMatriculado;
        this.poloMfrequentado = poloMfrequentado;
    }

    public String getCursoMatriculado() {
        return cursoMatriculado;
    }

    public void setCursoMatriculado(String cursoMatriculado) {
        this.cursoMatriculado = cursoMatriculado;
    }

    public String getPoloMfrequentado() {
        return poloMfrequentado;
    }

    public void setPoloMfrequentado(String poloMfrequentado) {
        this.poloMfrequentado = poloMfrequentado;
    }

    public String metodopagamento(String op) {
        return op == "1" ? "Cartao" :"Referencia Multibanco";
    }

    @Override
    public String toString(){
        return "Estudante";
    }


    public double calcularprecobicicleta(Bicicleta b) {
        double preco;
        if (b.getLugar().equals("1 Lugares")) {
            preco = 1.0;
            return preco;

        } else if (b.getLugar().equals("2 lugares")) {
            preco = 2.0;
            return preco;
        } else {
            return 0.0;


        }
    }
    public double calcularprecotrotinete(Trotinete t){
        double precobase ;
        if(t.getComLcd() == true){
            precobase = 1.10;
            return precobase;}
            else{
                precobase = 1.0;
                return precobase;
            }

    }

    public double calcularprecoEbike(Ebike e){
        double precobike;
        if(e.getBateriaRemovivel() == true){
                precobike = 1.50;
            }else{
             precobike = 1.25;
        }
        return 0.0;
    }


}

