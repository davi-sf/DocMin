package documin.elementos;

/**
 * Classe que representa um elemento de título em um documento.
 */
public class Titulo extends Elemento {

    private int nivel;
    private boolean linkavel;

    /**
     * Construtor da classe Titulo.
     *
     * @param valor     O valor do título.
     * @param prioridade A prioridade do título.
     * @param nivel     O nível do título.
     * @param linkavel  Indica se o título é linkável.
     */
    public Titulo(String valor, int prioridade, int nivel, boolean linkavel) {
        super(valor, prioridade);
        this.nivel = nivel;
        this.linkavel = linkavel;
    }

    /**
     * Verifica se o título é linkável.
     *
     * @return `true` se o título for linkável, caso contrário, `false`.
     */
    public boolean isLinkavel() {
        return linkavel;
    }

    /**
     * Gera a representação completa do título.
     *
     * @return A representação completa do título.
     */
    @Override
    public String gerarRepresentacaoCompleta() {
        String rp = "";
        if (isLinkavel()) {
            rp = nivel + ". " + getValor() + " -- " + getValor().toUpperCase().replaceAll(" ", "");
        } else {
            rp = nivel + ". " + getValor();
        }
        return rp;
    }

    /**
     * Gera a representação resumida do título.
     *
     * @return A representação resumida do título.
     */
    @Override
    public String gerarRepresentacaoResumida() {
        String rp = "";
        if (isLinkavel()) {
            rp = nivel + ". " + getValor();
        } else {
            rp = nivel + ". " + getValor();
        }
        return rp;
    }

    // testes para o elemento titulo



}
