package documin.elementos;

import java.util.HashMap;

/**
 * Classe abstrata que representa um elemento genérico em um documento.
 */
public abstract class Elemento {

    protected String valor;
    protected int prioridade;

    /**
     * Construtor da classe Elemento.
     *
     * @param valor     O valor do elemento.
     * @param prioridade A prioridade do elemento.
     */
    public Elemento(String valor, int prioridade) {
        this.valor = valor;
        this.prioridade = prioridade;
    }

    /**
     * Construtor da classe Elemento.
     *
     * @param valor O valor do elemento.
     */
    public Elemento(String valor) {
        this.valor = valor;
    }

    /**
     * Método abstrato para gerar a representação completa do elemento.
     *
     * @return A representação completa do elemento.
     */
    public abstract String gerarRepresentacaoCompleta();

    /**
     * Método abstrato para gerar a representação resumida do elemento.
     *
     * @return A representação resumida do elemento.
     */
    public abstract String gerarRepresentacaoResumida();

    /**
     * Obtém a prioridade do elemento.
     *
     * @return A prioridade do elemento.
     */
    public int getPrioridade() {
        return prioridade;
    }

    /**
     * Obtém o valor do elemento.
     *
     * @return O valor do elemento.
     */
    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Elemento{" +
                "valor='" + valor + '\'' +
                ", prioridade=" + prioridade +
                '}';
    }


}
