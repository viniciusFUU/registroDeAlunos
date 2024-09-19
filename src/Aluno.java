public class Aluno {
    private String nome;
    private int matricula;
    private String curso;
    private Prova[] prova;

    public Aluno(String nome, int matricula, String curso, Prova[] prova){
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.prova = prova;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Prova[] getProva() {
        return prova;
    }

    public void setProva(Prova[] prova) {
        this.prova = prova;
    }
}
