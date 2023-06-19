package documin.elementos;

/**
 * Classe que representa um elemento de texto em um documento.
 */
public class Texto extends Elemento {

    /**
     * Construtor da classe Texto.
     *
     * @param valor     O valor do texto.
     * @param prioridade A prioridade do texto.
     */
    public Texto(String valor, int prioridade) {
        super(valor, prioridade);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String gerarRepresentacaoCompleta() {
        return getValor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String gerarRepresentacaoResumida() {
        return getValor();
    }
}
