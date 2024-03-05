public class Perguntas {
    private String pergunta;
    private String[] opções;
    private int repostaCorreta;


    public Perguntas(String pergunta, String[] opções, int repostaCorreta){
        this.pergunta = pergunta;
        this.opções = opções;
        this.repostaCorreta = repostaCorreta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public String[] getOpções() {
        return opções;
    }

    public int getRepostaCorreta() {
        return repostaCorreta;
    }
}
