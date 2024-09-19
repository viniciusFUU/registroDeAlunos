public class ProvaController {
    public double calcularMediaPonderada(Prova[] provas){
        double somaProvas = 0;
        double pesoProva = 1;

        for (Prova prova : provas){
            somaProvas += prova.getNota() * pesoProva;
            pesoProva +=0.1;
        }

        return somaProvas / provas.length;
    }
}
