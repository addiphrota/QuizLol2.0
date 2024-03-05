public class PerguntasObjetivas extends Perguntas {

    public PerguntasObjetivas(String pergunta,String[] opções, int repostaCorreta){
        super(pergunta, opções, repostaCorreta);

    }

    public boolean verificarReposta(int respostaUsuario){
        return respostaUsuario == getRepostaCorreta();
    }
}
