package siga;

import java.util.ArrayList;
import java.util.List;

/**
 * Composto da estrutura curricular — hoje sem interface em comum com Disciplina.
 *
 * DESLIZE 3 (parte A) — a coleção é de Object, porque não existe um tipo que
 * abranja tanto Disciplina quanto Modulo. O compilador deixa de ajudar, e a
 * responsabilidade de descobrir o tipo recai sobre quem percorre a estrutura - corrigido com composite.
 */
public class Modulo implements ItemCurricular {

    private final String nome;
    private final List<ItemCurricular> filhos = new ArrayList<>();

    public Modulo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void adicionar(ItemCurricular filho) {
        filhos.add(filho);
    }

    public List<ItemCurricular> getFilhos() {
        return filhos;
    }

    public int getCargaHoraria() {
        int total = 0;
        for (ItemCurricular filho : filhos) {
            total += filho.getCargaHoraria();
        }
        return total;
    }

    public void imprimir(int nivel) {  
        String recuo = "  ".repeat(nivel);
        System.out.println(recuo + "[" + nome + "]");
        for (ItemCurricular filho : filhos) {
            filho.imprimir(nivel + 1);
        }
    }
}
