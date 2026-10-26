package siga;

/**
 * Folha da estrutura curricular — hoje sem nenhuma interface em comum
 * com Modulo. É essa ausência que obriga o cliente a usar instanceof - corrigido.
 */
public class Disciplina implements ItemCurricular {

    private final String nome;
    private final int cargaHoraria;

    public Disciplina(String nome, int cargaHoraria) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void imprimir(int nivel) {  
        String recuo = "  ".repeat(nivel);
        System.out.println(recuo + nome + " (" + cargaHoraria + "h)");
    }
}
