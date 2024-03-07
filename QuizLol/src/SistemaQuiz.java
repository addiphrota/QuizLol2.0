import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaQuiz {
    private List<Perguntas> listaPerguntas;
    private int pontuacao;

    public SistemaQuiz(){
        this.listaPerguntas = new ArrayList<>();
        this.pontuacao =0;
    }

    public void adicionarPergunta(Perguntas pergunta){
        listaPerguntas.add(pergunta);
    }

    public void realizarQuiz(){
        Scanner scanner = new Scanner(System.in);

        for(Perguntas pergunta : listaPerguntas) {
            System.out.println(pergunta.getPergunta());

            if (pergunta instanceof PerguntasObjetivas){
                PerguntasObjetivas perguntasObjetivas = (PerguntasObjetivas) pergunta;

                for(int i = 0; i< perguntasObjetivas.getOpções().length;i++){
                    System.out.println((i+1)+"."+ perguntasObjetivas.getOpções()[i]);
                }
                System.out.print("Escolha a opção correta(1-" + perguntasObjetivas.getOpções().length + "):");
                int respostaUsuario = scanner.nextInt();

                if (perguntasObjetivas.verificarReposta(respostaUsuario)){
                    System.out.println("Resposta correta!!");
                    pontuacao++;
                }else{
                    System.out.println("Reposta incorreta, A resposta correta era."+ perguntasObjetivas.getRepostaCorreta());

                }
            } else if (pergunta instanceof PerguntasImagens) {
                PerguntasImagens perguntasImagens = (PerguntasImagens) pergunta;

                System.out.println("Imagem:"+
                        perguntasImagens.getUrlImagem());
                System.out.print("Digite a resposta:");
                String respostaUsuario = scanner.next();

                if(respostaUsuario.equalsIgnoreCase(Integer.toString(perguntasImagens.getRepostaCorreta()))){
                    System.out.println("Resposta correta!!");
                    pontuacao++;
                }else {
                    System.out.println("Resposta incorreta. A reposta correta era:" + perguntasImagens.getRepostaCorreta());

                }

            }
            System.out.println();
        }

        System.out.println("Quiz concluido!! Pontuação final:" + pontuacao +"/" + listaPerguntas.size());

    }

    private void println(String pergunta) {

    }

    public static void main(String[] args){
        SistemaQuiz sistemaQuiz = new SistemaQuiz();

        //Adicione perguntas ao sistema
        PerguntasObjetivas perguntasObjetivas = new PerguntasObjetivas("Qual é o campeão mais populas em League of legends?", new String[]{"Aatrox","Lee Sin", "Yasuo", "Jinx"},3);
        sistemaQuiz.adicionarPergunta(perguntasObjetivas);

        PerguntasImagens perguntasImagens = new PerguntasImagens("Quem é esse campeão ?",new String[]{"Darius","Garen","Jarvan IV","Renekton"},2,"https://example.com/garen.jpg");
        sistemaQuiz.adicionarPergunta(perguntasImagens);

        // Realize o quiz
        sistemaQuiz.realizarQuiz();
    }
}
