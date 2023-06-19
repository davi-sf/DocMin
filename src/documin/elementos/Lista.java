package documin.elementos;

/**
 * Classe que representa um elemento de lista em um documento.
 */
public class Lista extends Elemento {

    private String separador;
    private String charLista;

    /**
     * Construtor da classe Lista.
     *
     * @param valorLista O valor da lista.
     * @param prioridade A prioridade da lista.
     * @param separador  O separador utilizado para separar os itens da lista.
     * @param charLista  O caractere utilizado para representar cada item da lista.
     */
    public Lista(String valorLista, int prioridade, String separador, String charLista) {
        super(valorLista, prioridade);
        this.separador = separador;
        this.charLista = charLista;
    }

    /**
     * Gera a representação completa da lista.
     *
     * @return A representação completa da lista.
     */
    @Override
    public String gerarRepresentacaoCompleta() {
        StringBuilder respostaFormatada = new StringBuilder();
        String[] respostaSeparada = getValor().split(separador);
        for (int i = 0; i < respostaSeparada.length; i++) {
            respostaFormatada.append(charLista);
            respostaFormatada.append(respostaSeparada[i].trim());
            if (i < respostaSeparada.length - 1) {
                respostaFormatada.append("\n");
            }
        }
        return respostaFormatada.toString();
    }

    /**
     * Gera a representação resumida da lista.
     *
     * @return A representação resumida da lista.
     */
    @Override
    public String gerarRepresentacaoResumida() {
        return getValor();
    }
}
