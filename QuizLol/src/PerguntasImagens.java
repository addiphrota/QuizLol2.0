public class PerguntasImagens extends Perguntas{

    private String urlImagem;

    public PerguntasImagens(String pergunta, String[] opções, int repostaCorreta, String urlImagem){
        super(pergunta, opções, repostaCorreta);
        this.urlImagem = urlImagem;
    }

    public String getUrlImagem() {
        return urlImagem;
    }
}
