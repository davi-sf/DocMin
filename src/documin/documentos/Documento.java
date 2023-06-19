package documin;

import documin.elementos.Elemento;

import java.util.ArrayList;

/**
 * A classe Documento representa um documento contendo elementos.
 * @author Davi Soares Ferreira
 */
public class Documento {

    private String titulo; // O título do documento
    private int tamanhoMaximo; // O tamanho máximo do documento
    private ArrayList<Elemento> elementosNoDocumento = new ArrayList<>(); // A lista de elementos do documento

    /**
     * Constrói um objeto Documento com um título e tamanho máximo especificados.
     * @param titulo o título do documento
     * @param tamanhoMaximo o tamanho máximo do documento
     */
    public Documento(String titulo, int tamanhoMaximo) {
        this.titulo = titulo;
        this.tamanhoMaximo = tamanhoMaximo;
    }

    /**
     * Constrói um objeto Documento com um título e tamanho máximo padrão.
     * O tamanho máximo é definido como Integer.MAX_VALUE.
     * @param titulo o título do documento
     */
    public Documento(String titulo) {
        this.tamanhoMaximo = Integer.MAX_VALUE;
        this.titulo = titulo;
    }

    /**
     * Obtém o título do documento.
     * @return o título do documento
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtém o tamanho máximo do documento.
     * @return o tamanho máximo do documento
     */
    public int getTamanhoMaximo() {

        return tamanhoMaximo;
    }

    /**
     * Obtém a lista de elementos do documento.
     * @return a lista de elementos do documento
     */
    public ArrayList<Elemento> getElementosNoDocumento() {
        return elementosNoDocumento;
    }

    /**
     * Conta o número de elementos no documento.
     * @return o número de elementos no documento
     */
    public int contaElementos() {
        return elementosNoDocumento.size();
    }

    /**
     * Adiciona um elemento ao documento e diminui a capacidade do documento
     * a cada elemento adicionado, em caso do documento tiver capacidade limitada
     * @param elemento o elemento a ser adicionado
     */
    public void adicionaElemento(Elemento elemento) {
        tamanhoMaximo -- ; // diminui o tamanho maximo em 1;
        this.elementosNoDocumento.add(elemento);
    }

    /**
     * Calcula a média das prioridades dos elementos no documento.
     * @return a média das prioridades dos elementos
     */
    public int media() {
        int soma = 0;
        for (Elemento elemento : elementosNoDocumento) {
            soma += elemento.getPrioridade();
        }
        return soma / elementosNoDocumento.size();
    }

    @Override
    public String toString() {
        return "Documento{" +
                "titulo='" + titulo + '\'' +
                ", tamanhoMaximo=" + tamanhoMaximo +
                ", elementosNoDocumento=" + elementosNoDocumento +
                '}';
    }
}
