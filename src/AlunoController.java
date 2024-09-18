

public class AlunoController {
    private Aluno[] listaDeAlunos;
    int posicaoInserir = 0;

    public AlunoController(int quantidade){
        listaDeAlunos = new Aluno[quantidade];
    }
    
    public void addAluno(String nome, int matricula){
        aumentarCapacidadeLista();
        Aluno aluno = new Aluno(nome, matricula);
        
        if (existMatricula(matricula) == false){
            if(listaDeAlunos[posicaoInserir] == null){
                listaDeAlunos[posicaoInserir] = aluno;
                posicaoInserir++;
            }
        }
    }
    
    public String removeAlunoByName(String nome){        
        String alunoExcluido = "";
        int posicaoExcluida = 0;
        
        for (int i = 0; i < listaDeAlunos.length-1; i++){
            if (listaDeAlunos[i].getNome() == nome && listaDeAlunos[i] != null){
                posicaoExcluida = i;
                alunoExcluido = listaDeAlunos[i].getNome();
                listaDeAlunos[i] = null;
                posicaoInserir--;
                break;
            }
        }

        if (listaDeAlunos[posicaoExcluida] == null){
            System.out.println(posicaoInserir);
            for (int j = posicaoExcluida; j <= posicaoInserir; j++){
                if (listaDeAlunos[j+1] == null){
                    listaDeAlunos[j] = null;
                } else if (listaDeAlunos[j+1] != null){
                    listaDeAlunos[j] = listaDeAlunos[j+1];
                }
            }
        }
        
        return alunoExcluido;
    }

    public void aumentarCapacidadeLista(){
        if (listaDeAlunos.length == posicaoInserir+1){
            Aluno[] novaListAlunos = new Aluno[listaDeAlunos.length * 2];

            for (int i = 0; i < this.listaDeAlunos.length; i++){
                novaListAlunos[i] = this.listaDeAlunos[i];
            }
            this.listaDeAlunos = novaListAlunos;
        }
    }

    public boolean existMatricula(int matricula){
        if (listaDeAlunos[0] != null){
            for (Aluno aluno : listaDeAlunos){
                if (aluno != null && aluno.getMatricula() == matricula){
                    System.out.println("Aluno ja existe!");
                    return true;
                }
                continue;
            }
        }

        return false;
    }

    public void showAlunos(){
        Aluno[] listaParaPercorrer = listaDeAlunos;

        for (Aluno aluno : listaParaPercorrer){
            if(aluno != null){
                System.out.println(aluno.getNome());
            }
        }
    }

    public static void main(String[] args) {
        AlunoController aluno = new AlunoController(2);
        aluno.addAluno("Vinicius", 1);
        aluno.showAlunos();
        aluno.addAluno("Bianca", 1);
        aluno.addAluno("Bianca", 2);
        aluno.showAlunos();
    }
}
