# SIGA — Atividade de padrões estruturais II: Decorator e Composite (código final)

**Técnicas de Programação II (TP2) · Aula 11** — CST em Desenvolvimento de Software Multiplataforma · Fatec de Porto Ferreira

Este é o **código final** da atividade prática da Aula 11. 

## Estrutura do projeto

```
siga-estruturais-ii/
└── src/
    └── siga/
        ├── Relatorio.java                 (interface da Aula 10)
        ├── RelatorioDeAlunos.java         (relatório sem opcionais)
        ├── DecoradorRelatorio.java        (decorador abstrato: implementa e contém um Relatorio)
        ├── ComCabecalho.java              (decorador: acrescenta o cabeçalho)
        ├── ComNumeracao.java              (decorador: numera as linhas)
        ├── ComMarcaDagua.java             (decorador: acrescenta a marca d'água)
        ├── ItemCurricular.java            (interface comum do Composite)
        ├── Disciplina.java                (folha: implementa ItemCurricular)
        ├── Modulo.java                    (composto: contém uma lista de ItemCurricular)
        └── Main.java                      (monta as pilhas de decoradores e a grade curricular)
```

## Como compilar e executar

Pré-requisito: JDK 17 ou superior (`java -version` para verificar).

```bash
# 1. Compilar (a saída vai para a pasta "bin")
javac -encoding UTF-8 -d bin src/siga/*.java

# 2. Executar
java -cp bin siga.Main
```

## Os três deslizes propositais resolvidos

| # | Deslize | Onde estava | Como foi resolvido |
|---|---|---|---|
| 1 | **Explosão combinatória de subclasses** | As quatro classes `RelatorioCom...` | três decoradores no lugar de uma classe por combinação. |
| 2 | **Duplicação do comportamento** | `RelatorioComCabecalho`, `...ENumeracao`, `...EMarcaDagua` | o cabeçalho e a numeração ficam cada um em uma classe só. |
| 3 | **Travessia com `instanceof`** | `Modulo` e `GradeCurricular` | a interface `ItemCurricular` e o Composite, sem `instanceof`. |

## Tarefas Realizadas

1. **Fazer a conta.** Registrado no README (Ver seção Etapa 1) quantas subclasses de relatório existiam no código inicial e quantas seriam necessárias se a secretaria pedisse uma quarta característica (um rodapé com a data de emissão). 
2. **Criar os decoradores.** Escrita a classe abstrata `DecoradorRelatorio`, que implementa `Relatorio` e contém um `Relatorio`, e as três subclasses `ComCabecalho`, `ComNumeracao` e `ComMarcaDagua`. Cada uma contém o seu comportamento **uma vez só**. 
3. **Empilhar.** No `Main`, montadas **duas pilhas diferentes** de decoradores sobre o mesmo `RelatorioDeAlunos` e impressas duas saídas. Ao inverter a ordem de `ComCabecalho` e `ComNumeracao`, deixando a numeração por fora, o cabeçalho também passa a ser numerado.
4. **Criar o Composite.** Criada a interface `ItemCurricular` com `getNome()`, `getCargaHoraria()` e `imprimir(int nivel)`. `Disciplina` e `Modulo` passaram a implementá-la, com a coleção de `Modulo` passando a ser de `ItemCurricular`. A classe `GradeCurricular` deixou de existir: as operações passaram a ser dos próprios itens.
5. **Provar que funciona.** Foi acrescentado um submódulo de **terceiro nível** (uma trilha de especialização dentro de um semestre) e verificado que nada no cliente precisou mudar.

## Etapa 1 

No código inicial, o relatório tinha 4 subclasses, mas poderia chegar até 8, porque são dois estados por característica (presente e ausente), por isso 2³ = 8 combinações. Caso fosse 4 características, esse número multiplicaria para o dobro, 2⁴ = 16 combinações possíveis. 

## Padrão de entrega

Conforme a ficha de atividade prática: identificadores em português, um arquivo `.java` por classe pública, código formatado, entrega no repositório Git com README e commits descritivos. O uso de IA para gerar o código é proibido nesta atividade (ver seção 5.3 da ficha).


