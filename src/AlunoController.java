import java.util.ArrayList;

public class AlunoController {
    private ArrayList<Aluno> listaDeAlunos = new ArrayList<>();
    int posicaoInserir = 0;
    
    public void addAluno(String nome, int matricula, String curso, Prova[] provas){
        Aluno aluno = new Aluno(nome, matricula, curso, provas);        
        if (existMatricula(matricula) == false){
            listaDeAlunos.add(aluno);
            System.out.println("ALuno adicionado");
        } else {
            System.out.println("Aluno já existe");
        }
    }
    
    public String removeAlunoByName(String nome){        
        String alunoExcluido = "";
        int posicaoExcluida = 0;
        
        for (int i = 0; i < listaDeAlunos.size()-1; i++){
            if (listaDeAlunos.get(i).getNome().equals(nome)){
                posicaoExcluida = i;
                alunoExcluido = listaDeAlunos.get(i).getNome();
                listaDeAlunos.set(i, null);
                posicaoInserir--;
                break;
            }
        }

        return "Aluno removido: " + alunoExcluido;
    }

    public boolean existMatricula(int matricula){
        if (listaDeAlunos.size() != 0){
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

    public void updateAluno(String nome, int matricula){
        for(Aluno aluno : listaDeAlunos){
            if (aluno.getMatricula() == matricula){
                aluno.setNome(nome);
            }
        }
    }

    public void showAlunos(){
        for (Aluno aluno : listaDeAlunos){
            if(aluno != null){
                System.out.println(aluno.getNome());
            }
        }
    }
}
