package siga;

public abstract class DecoradorRelatorio implements Relatorio {
    private Relatorio relatorio;

    public DecoradorRelatorio (Relatorio relatorio) {
        this.relatorio = relatorio;
    }

    public String gerar() {
        return relatorio.gerar();
    }
}
