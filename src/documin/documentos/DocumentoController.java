package documin;

import documin.elementos.*;

import java.util.*;

public class DocumentoController {

    private HashMap<String, documin.Documento> documentos = new HashMap<>();
    private HashMap<Integer, String> rep = new HashMap<>();

    private Titulo titRef;

    /**
     * Verifica se um documento existe com base no título.
     *
     * @param titulo o título do documento a ser verificado
     * @return true se o documento existe, false caso contrário
     */
    boolean verificaDocumentoPeloNome(String titulo) {

        return documentos.containsKey(titulo);
    }

    /**
     * Verifica se o título está vazio ou contém apenas espaços em branco.
     * Se o título estiver vazio, lança uma exceção IllegalArgumentException.
     *
     * @param titulo o título a ser verificado
     */
    public void verificaTituloVaziaEspaco(String titulo) {
        if (titulo.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Cria um novo documento com um título e um tamanho máximo específico.
     * Se o título estiver vazio ou se o tamanho máximo for menor ou igual a zero,
     * lança uma exceção IllegalArgumentException.
     *
     * @param titulo        o título do documento a ser criado
     * @param tamanhoMaximo o tamanho máximo do documento
     * @return true se o documento foi criado com sucesso, false se um documento com o mesmo título já existe
     * @return false se o documento foi criado com sucesso, false se um documento com o mesmo título já existe
     */
    public boolean criarDocumento(String titulo, int tamanhoMaximo) {
        verificaTituloVaziaEspaco(titulo); // verifica se o título do documento está vazio ou contém apenas espaços em branco
        if (tamanhoMaximo <= 0) {
            throw new IllegalArgumentException();
        }
        if (!verificaDocumentoPeloNome(titulo)) {
            documin.Documento novoDocumento = new documin.Documento(titulo, tamanhoMaximo);
            documentos.put(titulo, novoDocumento);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Cria um novo documento com um título e tamanho máximo padrão.
     * Se o título estiver vazio, lança uma exceção IllegalArgumentException.
     * Se um documento com o mesmo título já existe, lança uma exceção NoSuchElementException.
     *
     * @param titulo o título do documento a ser criado
     * @return true se o documento foi criado com sucesso
     * @return false se um documento com o mesmo título já existe
     */
    public boolean criarDocumento(String titulo) {
        verificaTituloVaziaEspaco(titulo); // verifica se o título do documento está vazio ou contém apenas espaços em branco
        if (!verificaDocumentoPeloNome(titulo)) {
            documin.Documento novoDocumento = new documin.Documento(titulo);
            documentos.put(titulo, novoDocumento);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Remove um documento com base no título.
     * Se o título estiver vazio, lança uma exceção IllegalArgumentException.
     * Se o documento não existir, lança uma exceção NoSuchElementException.
     *
     * @param titulo o título do documento a ser removido
     * @return true se o documento foi removido com sucesso
     * @throws NoSuchElementException se o documento não existir
     */
    public boolean removerDocumento(String titulo) {
        verificaTituloVaziaEspaco(titulo); // verifica se o título do documento está vazio ou contém apenas espaços em branco
        if (verificaDocumentoPeloNome(titulo)) {
            documentos.remove(titulo);
            return true;
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Retorna os elementos de um documento como um array de strings.
     * Se o título estiver vazio, lança uma exceção IllegalArgumentException.
     * @throws NoSuchElementException se o documento não existir
     * @param titulo o título do documento a ser exibido
     * @return um array de strings com os elementos do documento
     */
    public String[] exibirDocumento(String titulo) {
        verificaTituloVaziaEspaco(titulo); // verifica se o título do documento está vazio ou contém apenas espaços em branco
        if(verificaDocumentoPeloNome(titulo)){
            int tamanhoArray = documentos.get(titulo).getElementosNoDocumento().size();
            String[] arrayElementos = new String[tamanhoArray];
            for (int i = 0; i < tamanhoArray; i++) {
                arrayElementos[i] = documentos.get(titulo).getElementosNoDocumento().get(i).toString();
            }
            return arrayElementos;
        } else {
            throw new NoSuchElementException();
        }
    }


    public boolean verificaCapacidadeDoc(String tituloDoc){
        if(documentos.get(tituloDoc).getTamanhoMaximo() > 0){
            return true;
        }
        return false;
    }


    /**
     * Cria um novo texto e o adiciona a um documento existente.
     * Se o título do documento estiver vazio ou so conter espaços ou se o tamanho máximo for menor ou igual a zero,
     * lança uma exceção IllegalArgumentException.
     * @param tituloDoc O título do documento ao qual o texto será adicionado.
     * @param valor O valor do texto a ser criado.
     * @param prioridade A prioridade do texto a ser criado.
     * @return O índice do novo elemento adicionado no documento.
     * @throws NoSuchElementException Se o documento com o título especificado não existe.
     * @throws IllegalArgumentException Se a capacidade do documento for insuficiente para adicionar o novo texto.
     */
    public int criarTexto(String tituloDoc, String valor, int prioridade) {
        verificaTituloVaziaEspaco(tituloDoc); // verifica se o título do documento está vazio ou contém apenas espaços em branco
        if(verificaCapacidadeDoc(tituloDoc)){
            if (verificaDocumentoPeloNome(tituloDoc)) {
                Elemento novoElemento = new Texto(valor, prioridade);
                documentos.get(tituloDoc).adicionaElemento(novoElemento);
                return documentos.get(tituloDoc).getElementosNoDocumento().size() - 1;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            throw new IllegalArgumentException();
        }

    }


    /**
     * Cria um novo título no documento.
     * Se o título do documento estiver vazio ou so conter espaços ou se o tamanho máximo for menor ou igual a zero,
     * lança uma exceção IllegalArgumentException.
     *
     * @param tituloDoc  o título do documento em que o título será criado
     * @param valor      o valor do título
     * @param prioridade a prioridade do título
     * @param nivel      o nível do título
     * @param linkavel   indica se o título é linkável ou não
     * @return a posição do título no documento
     * @throws NoSuchElementException se o documento não existir
     * @throws IllegalArgumentException Se a capacidade do documento for insuficiente para adicionar o novo titulo.
     */
    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
        verificaTituloVaziaEspaco(tituloDoc); // verifica se o título do documento está vazio ou contém apenas espaços em branco
        if(verificaCapacidadeDoc(tituloDoc)){
            if (verificaDocumentoPeloNome(tituloDoc)) {
                Titulo novoTitulo = new Titulo(valor, prioridade, nivel, linkavel);
                documentos.get(tituloDoc).adicionaElemento(novoTitulo);
                return documentos.get(tituloDoc).getElementosNoDocumento().size() - 1;
            } else {
                throw new NoSuchElementException();
            }
        } else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * Cria uma nova lista no documento.
     * Se o título do documento estiver vazio ou so conter espaços ou se o tamanho máximo for menor ou igual a zero,
     * lança uma exceção IllegalArgumentException.
     *
     * @param tituloDoc  o título do documento em que a lista será criada
     * @param valorLista o valor da lista
     * @param prioridade a prioridade da lista
     * @param separador  o separador da lista
     * @param charLista  o caractere utilizado para representar cada elemento da lista
     * @return a posição da lista no documento
     * @throws NoSuchElementException se o documento não existir
     * @throws IllegalArgumentException Se a capacidade do documento for insuficiente para adicionar a nova lista.
     */
    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
        verificaTituloVaziaEspaco(tituloDoc); // verifica se o título do documento está vazio ou contém apenas espaços em branco
        if(verificaCapacidadeDoc(tituloDoc)){
            if (verificaDocumentoPeloNome(tituloDoc)) {
                Lista novaLista = new Lista(valorLista, prioridade, separador, charLista);
                documentos.get(tituloDoc).adicionaElemento(novaLista);
                return documentos.get(tituloDoc).getElementosNoDocumento().size() - 1;
            } else {
                throw new NoSuchElementException();
            }
        } else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * Cria uma nova lista de termos no documento.
     * Se o título do documento estiver vazio ou so conter espaços ou se o tamanho máximo for menor ou igual a zero,
     * lança uma exceção IllegalArgumentException.
     *
     * @param tituloDoc   o título do documento em que a lista de termos será criada
     * @param valorTermos o valor da lista de termos
     * @param prioridade  a prioridade da lista de termos
     * @param separador   o separador da lista de termos
     * @param ordem       a ordem da lista de termos
     * @return a posição da lista de termos no documento
     * @throws NoSuchElementException se o documento não existir
     * @throws IllegalArgumentException Se a capacidade do documento for insuficiente para adicionar o elemento termos.
     */
    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
        verificaTituloVaziaEspaco(tituloDoc); // verifica se o título do documento está vazio ou contém apenas espaços em branco
        if(verificaCapacidadeDoc(tituloDoc)){
            if (verificaDocumentoPeloNome(tituloDoc)) {
                Termos novoTermo = new Termos(valorTermos, prioridade, separador, ordem);
                documentos.get(tituloDoc).adicionaElemento(novoTermo);
                return documentos.get(tituloDoc).getElementosNoDocumento().size() - 1;
            } else {
                throw new NoSuchElementException();
            }
        } else{
            throw new IllegalArgumentException();
        }
    }


    /**
     * Cria um novo atalho no documento.
     * Se o título do documento estiver vazio ou so conter espaços ou se o tamanho máximo for menor ou igual a zero,
     * lança uma exceção IllegalArgumentException.
     *
     * @param tituloDoc             o título do documento em que o atalho será criado
     * @param tituloDocReferenciado o título do documento a ser referenciado pelo atalho
     * @return a posição do atalho no documento
     * @throws NoSuchElementException se o documento não existir
     */
    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
        verificaTituloVaziaEspaco(tituloDoc); // verifica se o título do documento está vazio ou contém apenas espaços em branco
        verificaTituloVaziaEspaco(tituloDocReferenciado);
        String valor = documentos.get(tituloDocReferenciado).getTitulo();
        int prioridade = documentos.get(tituloDocReferenciado).media();
        if (verificaDocumentoPeloNome(tituloDoc) || verificaDocumentoPeloNome(tituloDocReferenciado)) {
            Atalho novoAtalho = new Atalho(valor, prioridade);
            novoAtalho.addDoc(this.documentos.get(tituloDocReferenciado));
            documentos.get(tituloDoc).adicionaElemento(novoAtalho);
            return documentos.get(tituloDoc).getElementosNoDocumento().size() - 1;
        } else {
            throw new NoSuchElementException();
        }
    }


    /**
     * Gera a representação completa de um elemento específico em um documento.
     * Se o título do documento estiver vazio ou so conter espaços lança uma exceção IllegalArgumentException.
     *
     * @param tituloDoc o título do documento
     * @param elemento  a posição do elemento no documento
     * @return a representação completa do elemento
     * @throws NoSuchElementException se o elemento não for encontrado no documento
     */
    public String geraRepresentaoCompleta(String tituloDoc, int elemento) {
        verificaTituloVaziaEspaco(tituloDoc);
        String rp = "";
        List<Elemento> elementos = documentos.get(tituloDoc).getElementosNoDocumento();
        if (elemento >= 0 && elemento < elementos.size()) {
            Elemento elementoSelecionado = elementos.get(elemento);
            String representacao = elementoSelecionado.gerarRepresentacaoCompleta() + "\n";
            if (representacao != null) {
                rp += representacao;
            }
        } else {
            throw new NoSuchElementException("Elemento não encontrado no documento");
        }
        return rp;
    }

    /**
     * Gera a representação resumida de um elemento específico em um documento.
     * Se o título do documento estiver vazio ou so conter espaços lança uma exceção IllegalArgumentException.
     *
     * @param tituloDoc o título do documento
     * @param elemento  a posição do elemento no documento
     * @return a representação resumida do elemento
     * @throws NoSuchElementException se o elemento não for encontrado no documento
     */
    public String geraRepresentacaoResumida(String tituloDoc, int elemento) {
        verificaTituloVaziaEspaco(tituloDoc);
        String rp = "";
        List<Elemento> elementos = documentos.get(tituloDoc).getElementosNoDocumento();
        if (elemento >= 0 && elemento < elementos.size()) {
            Elemento elementoSelecionado = elementos.get(elemento);
            String representacao = elementoSelecionado.gerarRepresentacaoResumida() + "\n";
            if (representacao != null) {
                rp += representacao;
            }
        } else {
            throw new NoSuchElementException("Elemento não encontrado no documento");
        }
        return rp;
    }

    /**
     * Move um elemento para cima em um documento.
     * Se o título do documento estiver vazio ou so conter espaços lança uma exceção IllegalArgumentException.
     *
     * @param tituloDoc       o título do documento
     * @param elementoPosicao a posição do elemento no documento
     * @return a nova posição do elemento após a movimentação
     */
    public int moverParaCima(String tituloDoc, int elementoPosicao) {
        verificaTituloVaziaEspaco(tituloDoc); // verifica se o título do documento está vazio ou contém apenas espaços em branco
        if (elementoPosicao >= 0 && elementoPosicao < documentos.get(tituloDoc).getElementosNoDocumento().size() - 1) {
            Collections.swap(documentos.get(tituloDoc).getElementosNoDocumento(), elementoPosicao, elementoPosicao + 1);
            return elementoPosicao + 1;
        }
        return elementoPosicao;
    }

    /**
     * Move um elemento para baixo em um documento.
     * Se o título do documento estiver vazio ou so conter espaços lança uma exceção IllegalArgumentException.
     *
     * @param tituloDoc       o título do documento
     * @param elementoPosicao a posição do elemento no documento
     * @return a nova posição do elemento após a movimentação
     */
    public int moverParaBaixo(String tituloDoc, int elementoPosicao) {
        verificaTituloVaziaEspaco(tituloDoc);
        if (elementoPosicao > 0 && elementoPosicao <= documentos.get(tituloDoc).getElementosNoDocumento().size()) {
            Collections.swap(documentos.get(tituloDoc).getElementosNoDocumento(), elementoPosicao, elementoPosicao - 1);
            return elementoPosicao - 1;
        }
        return elementoPosicao;
    }


    /**
     * Gera a representação completa de todos os elementos em um documento.
     *
     *
     * @param tituloDoc o título do documento
     * @return a representação completa de todos os elementos
     */
    public String representacaoCompleta(String tituloDoc) {
        String rp = "";
        for (int i = 0; i < documentos.get(tituloDoc).getElementosNoDocumento().size(); i++) {
            String representacao = documentos.get(tituloDoc).getElementosNoDocumento().get(i).gerarRepresentacaoCompleta() + "\n";
            if (representacao != null) {
                rp += representacao;
            }
        }
        return rp;
    }

    /**
     * Gera a representação resumida de todos os elementos em um documento.
     *
     * @param tituloDoc o título do documento
     * @return a representação resumida de todos os elementos
     */
    public String representacaoResumida(String tituloDoc) {
        String rp = "";
        for (int i = 0; i < documentos.get(tituloDoc).getElementosNoDocumento().size(); i++) {
            String representacao = documentos.get(tituloDoc).getElementosNoDocumento().get(i).gerarRepresentacaoResumida() + "\n";
            if (representacao != null) {
                rp += representacao;
            }
        }
        return rp;
    }

    /**
     * Cria uma visão completa do documento e a armazena.
     * Se o título do documento estiver vazio ou so conter espaços lança uma exceção IllegalArgumentException.
     *
     * @param tituloDoc o título do documento
     * @return o ID da visão criada
     * @throws NoSuchElementException se o documento não for encontrado
     * @throws IllegalArgumentException se o título for vazio ou conter apenas espaços em branco
     */
    public int criarVisaoCompleta(String tituloDoc) {
        // Verifica se o título é vazio ou contém apenas espaços em branco
        verificaTituloVaziaEspaco(tituloDoc);

        if (verificaDocumentoPeloNome(tituloDoc)) {
            // Cria uma representação completa do documento e a armazena no mapa "rep" com ID 0
            String representacaoResumida = representacaoCompleta(tituloDoc);
            rep.put(0, representacaoResumida);
            return 0;
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Cria uma visão resumida do documento e a armazena.
     * Se o título do documento estiver vazio ou so conter espaços lança uma exceção IllegalArgumentException.
     *
     * @param tituloDoc o título do documento
     * @return o ID da visão criada
     * @throws NoSuchElementException se o documento não for encontrado
     * @throws IllegalArgumentException se o título for vazio ou conter apenas espaços em branco
     */
    public int criarVisaoResumida(String tituloDoc) {
        // Verifica se o título é vazio ou contém apenas espaços em branco
        verificaTituloVaziaEspaco(tituloDoc);

        if (verificaDocumentoPeloNome(tituloDoc)) {
            // Cria uma representação resumida do documento e a armazena no mapa "rep" com ID 1
            String representacaoResumida = representacaoResumida(tituloDoc);
            rep.put(1, representacaoResumida);
            return 1;
        } else {
            throw new NoSuchElementException();
        }
    }


    /**
     * Cria uma visão prioritária do documento com base na prioridade fornecida e a armazena.
     * Se o título do documento estiver vazio ou so conter espaços lança uma exceção IllegalArgumentException.
     *
     * @param tituloDoc o título do documento
     * @param prioridade a prioridade mínima dos elementos a serem incluídos na visão
     * @return o ID da visão criada
     * @throws NoSuchElementException se o documento não for encontrado
     * @throws NoSuchElementException se nenhum elemento com a prioridade mínima for encontrado no documento
     * @throws IllegalArgumentException se o título for vazio ou conter apenas espaços em branco
     */
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
        String representacao = "";
        // Verifica se o título é vazio ou contém apenas espaços em branco
        verificaTituloVaziaEspaco(tituloDoc);

        if (verificaDocumentoPeloNome(tituloDoc)) {
            for (int i = 0; i < documentos.get(tituloDoc).getElementosNoDocumento().size(); i++) {
                if (documentos.get(tituloDoc).getElementosNoDocumento().get(i).getPrioridade() >= prioridade) {
                    representacao += documentos.get(tituloDoc).getElementosNoDocumento().get(i).gerarRepresentacaoCompleta();
                } else {
                    throw new NoSuchElementException();
                }
            }
            // Armazena a representação prioritária no mapa "rep" com ID 2
            rep.put(2, representacao);
            return 2;
        }
        throw new NoSuchElementException();
    }



    /**
     * Cria uma visão apenas com os títulos do documento e a armazena.
     * Se o título do documento estiver vazio ou so conter espaços lança uma exceção IllegalArgumentException.
     *
     * @param tituloDoc o título do documento
     * @return o ID da visão criada
     * @throws NoSuchElementException se o documento não for encontrado
     * @throws NoSuchElementException se algum elemento no documento não for do tipo "Titulo"
     * @throws IllegalArgumentException se o título for vazio ou conter apenas espaços em branco
     */
    public int criarVisaoTitulo(String tituloDoc) {
        verificaTituloVaziaEspaco(tituloDoc);

        if (verificaDocumentoPeloNome(tituloDoc)) {
            String representacao = "";
            for (int i = 0; i < documentos.get(tituloDoc).getElementosNoDocumento().size(); i++) {
                Elemento elemento = documentos.get(tituloDoc).getElementosNoDocumento().get(i);
                if (elemento instanceof Titulo) {
                    representacao += elemento.gerarRepresentacaoCompleta();
                } else {
                    throw new NoSuchElementException("O elemento encontrado não é do tipo 'Titulo'.");
                }
            }
            // Armazena a representação dos títulos no mapa "rep" com ID 3
            rep.put(3, representacao);
            return 3;
        } else {
            throw new NoSuchElementException("Documento não encontrado.");
        }
    }



    /**
     * Exibe a visão solicitada.
     *
     * @param visaoId o ID da visão a ser exibida
     * @return um array de strings contendo a representação da visão
     * @throws NoSuchElementException se a visão não for encontrada
     */
    public String[] exibirVisao(int visaoId) {
        if (rep.containsKey(visaoId)) {
            String representacao = rep.get(visaoId);
            String[] repArray = representacao.split("\n");
            return repArray;
        } else {
            throw new NoSuchElementException();
        }
    }


    /**
     * Conta o número de elementos em um documento.
     * Se o título do documento estiver vazio ou so conter espaços lança uma exceção IllegalArgumentException.
     *
     * @param titulo o título do documento
     * @return o número de elementos no documento
     * @throws NoSuchElementException se o documento não for encontrado
     */
    public int contarElementos(String titulo) {
        verificaTituloVaziaEspaco(titulo);
        if (verificaDocumentoPeloNome(titulo)) {
            return documentos.get(titulo).contaElementos();
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Apaga um elemento em uma determinada posição de um documento.
     * Se o título do documento estiver vazio ou so conter espaços lança uma exceção IllegalArgumentException.
     *
     * @param tituloDoc       o título do documento
     * @param elementoPosicao a posição do elemento a ser apagado
     * @return true se o elemento foi apagado com sucesso, false caso contrário
     * @throws NoSuchElementException se o documento não for encontrado
     * @throws NullPointerException   se a posição do elemento for inválida
     */
    public boolean apagarElementos(String tituloDoc, int elementoPosicao) {

        verificaTituloVaziaEspaco(tituloDoc);
        if (verificaDocumentoPeloNome(tituloDoc)) {
            List<Elemento> elementos = documentos.get(tituloDoc).getElementosNoDocumento();
            if (elementoPosicao >= 0 && elementoPosicao < elementos.size()) {
                elementos.remove(elementoPosicao);
                return true;
            } else {
                throw new NullPointerException();
            }
        } else {
            throw new NoSuchElementException();
        }
    }


}





