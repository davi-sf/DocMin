package documin;

/**
 * Classe Facade que fornece uma interface simplificada para interagir com a funcionalidade da classe DocumentoController.
 */
public class Facade {
    private documin.DocumentoController documentoController;

    /**
     * Cria um novo documento com o título especificado.
     *
     * @param titulo O título do documento.
     * @return true se o documento foi criado com sucesso, caso contrário, false.
     */
    public boolean criarDocumento(String titulo) {
        return this.documentoController.criarDocumento(titulo);
    }

    /**
     * Cria um novo documento com o título e tamanho máximo especificados.
     *
     * @param titulo O título do documento.
     * @param tamanhoMaximo O tamanho máximo do documento.
     */
    public boolean criarDocumento(String titulo, int tamanhoMaximo) throws IllegalArgumentException {
        return this.documentoController.criarDocumento(titulo, tamanhoMaximo);
    }

    /**
     * Remove um documento com o título especificado.
     *
     * @param titulo O título do documento a ser removido.
     */
    void removerDocumento(String titulo) {
        this.documentoController.removerDocumento(titulo);
    }

    /**
     * Conta o número de elementos em um documento com o título especificado.
     *
     * @param titulo O título do documento.
     * @return O número de elementos no documento.
     */
    int contarElementos(String titulo) {
        return this.documentoController.contarElementos(titulo);
    }

    /**
     * Exibe o conteúdo de um documento com o título especificado.
     *
     * @param titulo O título do documento.
     * @return Um array de strings representando o conteúdo do documento.
     */
    String[] exibirDocumento(String titulo) {
        return this.documentoController.exibirDocumento(titulo);
    }

    /**
     * Cria um novo texto em um documento existente com o título especificado.
     *
     * @param tituloDoc O título do documento.
     * @param valor O valor do texto a ser criado.
     * @param prioridade A prioridade do texto.
     * @return O índice do texto criado no documento.
     */
    int criarTexto(String tituloDoc, String valor, int prioridade) {
        return this.documentoController.criarTexto(tituloDoc, valor, prioridade);
    }

    /**
     * Cria um novo título em um documento existente com o título especificado.
     *
     * @param tituloDoc O título do documento.
     * @param valor O valor do título a ser criado.
     * @param prioridade A prioridade do título.
     * @param nivel O nível do título.
     * @param linkavel Indica se o título é linkável.
     * @return O índice do título criado no documento.
     */
    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
        return this.documentoController.criarTitulo(tituloDoc, valor, prioridade, nivel, linkavel);
    }

    /**
     * Cria uma nova lista em um documento existente com o título especificado.
     *
     * @param tituloDoc O título do documento.
     * @param valorLista O valor da lista a ser criada.
     * @param prioridade A prioridade da lista.
     * @param separador O separador da lista.
     * @param charLista O caractere da lista.
     * @return O índice da lista criada no documento.
     */
    int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
        return this.documentoController.criarLista(tituloDoc, valorLista, prioridade, separador, charLista);
    }

    /**
     * Cria um novo termo em um documento existente com o título especificado.
     *
     * @param tituloDoc O título do documento.
     * @param valorTermos O valor dos termos a serem criados.
     * @param prioridade A prioridade dos termos.
     * @param separador O separador dos termos.
     * @param ordem A ordem dos termos.
     * @return O índice dos termos criados no documento.
     */
    int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
        return this.documentoController.criarTermos(tituloDoc, valorTermos, prioridade, separador, ordem);
    }

    /**
     * Obtém a representação completa de um elemento em um documento com o título especificado.
     *
     * @param tituloDoc O título do documento.
     * @param elementoPosicao A posição do elemento no documento.
     * @return A representação completa do elemento.
     */
    String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
        return this.documentoController.geraRepresentaoCompleta(tituloDoc, elementoPosicao);
    }

    /**
     * Obtém a representação resumida de um elemento em um documento com o título especificado.
     *
     * @param tituloDoc O título do documento.
     * @param elementoPosicao A posição do elemento no documento.
     * @return A representação resumida do elemento.
     */
    String pegarrepresentacaoResumida(String tituloDoc, int elementoPosicao) {
        return this.documentoController.geraRepresentacaoResumida(tituloDoc, elementoPosicao);
    }

    /**
     * Apaga um elemento em um documento com o título especificado.
     *
     * @param tituloDoc O título do documento.
     * @param elementoPosicao A posição do elemento no documento.
     * @return true se o elemento foi apagado com sucesso, caso contrário, false.
     */
    boolean apagarElemento(String tituloDoc, int elementoPosicao) {
        return this.documentoController.apagarElementos(tituloDoc, elementoPosicao);
    }

    /**
     * Move um elemento para cima em um documento com o título especificado.
     *
     * @param tituloDoc O título do documento.
     * @param elementoPosicao A posição do elemento no documento.
     */
    void moverParaCima(String tituloDoc, int elementoPosicao) {
        this.documentoController.moverParaCima(tituloDoc, elementoPosicao);
    }

    /**
     * Move um elemento para baixo em um documento com o título especificado.
     *
     * @param tituloDoc O título do documento.
     * @param elementoPosicao A posição do elemento no documento.
     */
    void moverParaBaixo(String tituloDoc, int elementoPosicao) {
        this.documentoController.moverParaBaixo(tituloDoc, elementoPosicao);
    }

    /**
     * Cria um novo atalho para um documento com o título especificado.
     *
     * @param tituloDoc O título do documento que terá o atalho.
     * @param tituloDocReferenciado O título do documento a ser referenciado pelo atalho.
     * @return O índice do atalho criado no documento.
     */
    int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
        return this.documentoController.criarAtalho(tituloDoc, tituloDocReferenciado);
    }

    /**
     * Cria uma visão completa de um documento com o título especificado.
     *
     * @param tituloDoc O título do documento.
     * @return O identificador da visão completa criada.
     */
    int criarVisaoCompleta(String tituloDoc) {
        return this.documentoController.criarVisaoCompleta(tituloDoc);
    }

    /**
     * Cria uma visão resumida de um documento com o título especificado.
     *
     * @param tituloDoc O título do documento.
     * @return O identificador da visão resumida criada.
     */
    int criarVisaoResumida(String tituloDoc) {
        return this.documentoController.criarVisaoResumida(tituloDoc);
    }

    /**
     * Cria uma visão prioritária de um documento com o título especificado.
     *
     * @param tituloDoc O título do documento.
     * @param prioridade A prioridade da visão prioritária.
     * @return O identificador da visão prioritária criada.
     */
    int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
        return this.documentoController.criarVisaoPrioritaria(tituloDoc, prioridade);
    }

    /**
     * Cria uma visão de títulos de um documento com o título especificado.
     *
     * @param tituloDoc O título do documento.
     * @return O identificador da visão de títulos criada.
     */
    int criarVisaoTitulo(String tituloDoc) {
        return this.documentoController.criarVisaoTitulo(tituloDoc);
    }

    /**
     * Exibe o conteúdo de uma visão com o identificador especificado.
     *
     * @param visaoId O identificador da visão.
     * @return Um array de strings representando o conteúdo da visão.
     */
    String[] exibirVisao(int visaoId) {
        return this.documentoController.exibirVisao(visaoId);
    }
}
