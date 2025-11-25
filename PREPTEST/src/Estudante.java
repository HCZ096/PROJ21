public class Estudante extends Utilizador{

    private String poloMfrequentado;
    private String cursoMatriculado;

    public Estudante(){}

    public Estudante(String nome, int id,String cursoMatriculado, String poloMfrequentado) {
        super(id, nome);
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

    public double precoPorHora(Bicicleta b) {
        return b.isUmaPessoa() ? 2.00 : 1;
    }

    public double precoPorHora(Trotinete t) {
        return t.isComLcd() ? 1.10 : 1.0;
    }

    public double precoPorHora(Ebike e) {
        return e.isBateriaRemovivel()? 1.50 : 1.25;
    }

    @Override
    public String toString () {
        return "Estudante" + getNome() + "ID: " + getId() + "Curso: " + getCursoMatriculado() + "Polo: " + getPoloMfrequentado() ;
        }
}

