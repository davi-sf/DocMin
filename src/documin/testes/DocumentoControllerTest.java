package testes;

import documin.DocumentoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DocumentoControllerTest {

    private DocumentoController test = new DocumentoController();

    // Criando uma instância de DocumentoController antes de cada teste

    // Antes de cada teste, cria um documento chamado "Exemplo"
    @BeforeEach
    void documentoExemplo() {
        test.criarDocumento("Exemplo");
    }

    // Antes de cada teste, cria um documento chamado "Exemplo2" com um tamanho máximo de 1 elemento
    // e adiciona um elemento de texto a ele
    @BeforeEach
    void documentoExemploTamanhoLimitado() {
        test.criarDocumento("Exemplo2", 1);
        test.criarTexto("Exemplo2", "Lab 05 é complicado de se entender", 4);
    }

    // Antes de cada teste, cria um documento chamado "Exemplo3"
    @BeforeEach
    void documentoExemplo3(){
        test.criarDocumento("Exemplo3");
    }

    // Antes de cada teste, cria um elemento de texto no documento "Exemplo"
    @BeforeEach
    void exemploElementoTexto() {
        test.criarTexto("Exemplo", "Esse lab é confuso", 4);
    }

    // Antes de cada teste, cria um documento chamado "Documento Titulo" e adiciona um elemento de título a ele
    @BeforeEach
    void DocumentoComElementoTitulo(){
        test.criarDocumento("Documento Titulo");
        test.criarTitulo("Documento Titulo","Exemplo de um documento do tipo título",3,4,true);
    }


    @Test
    void criarDocumentoJaCadastrado() {
        boolean expected = false;
        boolean resposta = test.criarDocumento("Exemplo");
        assertEquals(expected,resposta);

    }


    @Test
    void criarDocumentoTituloVazio() {
        assertThrows(IllegalArgumentException.class, () -> {
            test.criarDocumento("");
        });
    }

    @Test
    void criaDocumentoTituloVazio2() {
        assertThrows(IllegalArgumentException.class, () -> {
            test.criarDocumento("   ");
        });
    }



    @Test
    void criarDocumentoTamanhoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> test.criarDocumento("fla", 0));
    }

    @Test
    void removeDocumento() {
        boolean resposta = test.removerDocumento("Exemplo");
        assertTrue(resposta);
    }

    @Test
    void removeDocumentoInexistente() {
        assertThrows(NoSuchElementException.class,() ->{
            test.apagarElementos("Inexistente",4);
        });

    }

    @Test
    void retornaQuantidadeElementosNoDoc() {
        int resposta = 1;
        int resultado = test.contarElementos("Exemplo");
        assertEquals(resposta, resultado);
    }


    @Test
    void exibeDocumentoComElemento(){
        String expected = "[Elemento{valor='Esse lab é confuso', prioridade=4}]";
        String resposta = Arrays.toString(test.exibirDocumento("Exemplo"));
        assertEquals(expected,resposta);
    }


    @Test
    void exibeDocumentoSemElemento(){
        String expected = "[]";
        String resposta = Arrays.toString(test.exibirDocumento("Exemplo3"));

    }

    // começam os testes de elementos


    @Test
    void elementoEmDocumentoCapacidadeJaAtingida(){
        assertThrows(IllegalArgumentException.class, () -> test.criarTexto("Exemplo2","Este é uma tentativa de inserir um elemento em documento sem espacço",3));
    }

    @Test
    void criaTextoEmNovoDocumento() {
        test.criarDocumento("DocumentoTeste");
        int resposta = test.criarTexto("DocumentoTeste", "Exemplo de texto", 4);
        int resultado = 0;
        assertEquals(resposta, resultado);
    }

    @Test
    void criaTituloEmNovoDocumento() {
        test.criarDocumento("DocumentoTeste");
        int respota = test.criarTitulo("DocumentoTeste", "Documento Texto", 4, 1, true);
        int resultado = 0;
        assertEquals(respota, resultado);
    }

    @Test
    void criaListaEmNovoDocumento() {
        test.criarDocumento("DocumentoTeste");
        int resposta = test.criarLista("DocumentoTeste", "flamengo | grande", 4, "|", "-");
        int resultado = 0;
        assertEquals(resposta, resultado);
    }

    @Test
    void criaTermosEmNovoDocumenti() {
        test.criarDocumento("DocumentoTeste");
        int resposta = test.criarTermos("DocumentoTeste", "teste / termos / exemplo", 4, "/", "ALFABETICA");
        int resultado = 0;
        assertEquals(resposta, resultado);
    }

    @Test
    void moverElementoAbaixo() {
        test.criarTexto("Exemplo", "Elemento Texto pra ser adicionado em documento 'Exemplo'", 4);
        int novaPosicao = test.moverParaBaixo("Exemplo", 1);
        assertEquals(0, novaPosicao);

    }

    @Test
    void moverElementoAcima() {
        test.criarTexto("Exemplo", "Elemento Texto pra ser adicionado em documento 'Exemplo'", 4);
        int novaPosicao = test.moverParaCima("Exemplo", 0);
        assertEquals(1, novaPosicao);

    }

    @Test
    void apagaElemento() {
        boolean resposta = test.apagarElementos("Exemplo", 0);
        assertTrue(resposta);
    }

    // começam os testes das representacoes - lista


    @BeforeEach
    public void configuraTeste() {
        test.criarDocumento("TesteLista");
        String valorLista = "Item 1, Item 2, Item 3";
        int prioridade = 1;
        String separador = ",";
        String charLista = "-";
        test.criarLista("TesteLista", valorLista, prioridade, separador, charLista);
    }

    @Test
    public void testGerarRepresentacaoCompletaLista() {
        // Verifica se a representação completa é gerada corretamente
        String expected = "-Item 1\n-Item 2\n-Item 3" + "\n";
        String actual = test.geraRepresentaoCompleta("TesteLista",0);
        assertEquals(expected, actual);
    }

    @Test
    public void testGerarRepresentacaoResumidaLista() {
        // Verifica se a representação resumida é gerada corretamente
        String expected = "Item 1, Item 2, Item 3" + "\n";
        String actual = test.geraRepresentacaoResumida("TesteLista",0);
        assertEquals(expected, actual);
    }

    /// testes de representacoes - termos
    // ordem alfabetica

    @BeforeEach
    public void configuraTesteTermosOrdemAlfabetica() {
        test.criarDocumento("TesteTermos");
        String valorTermos = "testes / termos / aleatorios";
        int prioridade = 1;
        String separador = "/";
        String ordem = "ALFABETICA";
        test.criarTermos("TesteTermos", valorTermos, prioridade, separador, ordem);
    }

    @Test
    void testGerarRepresentacaoCompletaOrdemAlfabetica() {
        String expected = "Total termos: 3\n" +
                "-aleatorios,termos,testes" + "\n";
        String actual = test.geraRepresentaoCompleta("TesteTermos",0);
        assertEquals(expected, actual);
    }

    @Test
    void testaGerarRepresentacaoResumidaOrdemAlfabetica() {
        String expected = "aleatorios / termos / testes" + "\n";
        String actual = test.geraRepresentacaoResumida("TesteTermos",0);
        assertEquals(expected, actual);
    }


    // ordem numerica

    @BeforeEach
    void configuraTesteTermosOrdemNumerica() {
        test.criarDocumento("TesteTermos2");
        String valorTermos = "teste / termos / aleatorios";
        int prioridade = 1;
        String separador = "/";
        String ordem = "NUMERICA";
        test.criarTermos("TesteTermos2", valorTermos, prioridade, separador, ordem);
    }


    @Test
    public void testGerarRepresentacaoCompletaOrdemNumerica() {
        // Verifica se a representação resumida é gerada corretamente
        String expected = "Total termos: 3\n" +
                "-aleatorios,termos,teste" + "\n";
        String actual = test.geraRepresentaoCompleta("TesteTermos2",0);
        assertEquals(expected, actual);
    }


    @Test
    public void testGerarRepresentacaoResumidaOrdemNumerica() {
        // Verifica se a representação resumida é gerada corretamente
        String expected = "aleatorios / termos / teste" + "\n";
        String actual = test.geraRepresentacaoResumida("TesteTermos2",0);
        assertEquals(expected, actual);
    }

    // testes para o elemento titulo

    @BeforeEach
    void criaDocumentoParaTesteTitulo() {
        test.criarDocumento("TesteTitulo");
    }

    @Test
    public void testGerarRepresentacaoCompletaLinkavel() {
        test.criarTitulo("TesteTitulo", "Elemento simples", 3, 3, true);
        String representacaoCompleta = test.geraRepresentaoCompleta("TesteTitulo",0);
        String expected = "3. Elemento simples -- ELEMENTOSIMPLES" + "\n";
        assertEquals(expected, representacaoCompleta);
    }

    @Test
    public void testGerarRepresentacaoCompletaNaoLinkavel() {
        test.criarTitulo("TesteTitulo", "Elemento simples", 3, 3, false);
        String representacaoCompleta = test.geraRepresentaoCompleta("TesteTitulo",0);
        String expected = "3. Elemento simples" + "\n";
        assertEquals(expected, representacaoCompleta);
    }

    @Test
    public void testGerarRepresentacaoResumidaLinkavel() {
        test.criarTitulo("TesteTitulo", "Elemento simples", 3, 3, false);
        String representacaoResumida = test.geraRepresentacaoResumida("TesteTitulo",0);
        String expected = "3. Elemento simples" + "\n";
        assertEquals(expected, representacaoResumida);
    }

    @Test
    public void testGerarRepresentacaoResumidaNaoLinkavel() {
        test.criarTitulo("TesteTitulo", "Elemento simples", 3, 3, false);
        String representacaoResumida = test.geraRepresentacaoResumida("TesteTitulo",0);
        String expected = "3. Elemento simples" + "\n";
        assertEquals(expected, representacaoResumida);
    }

    //// testes para atalho

    @BeforeEach
    void configuraDocumentosParaTestAtalho() {
        test.criarDocumento("TesteAtalho");
        test.criarTexto("TesteAtalho", "Flamengo maior do mundo", 4);
        test.criarTexto("TesteAtalho", "O brasil é lindo", 3);
        test.criarTexto("TesteAtalho", "Campina grande é linda", 4);
        test.geraRepresentaoCompleta("TesteAtalho",0);
        test.criarDocumento("TesteAtalho2");
        test.criarLista("TesteAtalho2", "Exemplo | de uma lista | de 3 termos", 4, "/", "-");
        test.criarLista("TesteAtalho2", "Exemplo | de outra lista | de 3 termos", 5, "/", "*");
        test.geraRepresentaoCompleta("TesteAtalho2",0);


    }

    @Test
    void testaValorAtalho() {
        test.criarDocumento("DocumentoAtalho");
        int expected = 0;
        int resposta = test.criarAtalho("DocumentoAtalho", "TesteAtalho");
        assertEquals(expected, resposta);
    }

    @Test
    void gerarRepresentacaoCompletaAtalho() {
        test.criarDocumento("DocumentoAtalho");
        String expected = "Flamengo maior do mundo\n" +
                "Campina grande é linda" + "\n" + "\n";
        test.criarAtalho("DocumentoAtalho", "TesteAtalho");
        String resposta = test.geraRepresentacaoResumida("DocumentoAtalho",0);
        assertEquals(expected, resposta);
    }

    @Test
    void gerarRepresentacaoCompletaAtalho2() {
        test.criarDocumento("DocumentoAtalho");
        String expected = "-Exemplo | de uma lista | de 3 termos\n" +
                "*Exemplo | de outra lista | de 3 termos" + "\n" + "\n";
        test.criarAtalho("DocumentoAtalho", "TesteAtalho2");
        String resposta = test.geraRepresentaoCompleta("DocumentoAtalho",0);
        assertEquals(expected, resposta);
    }

    @Test
    void gerarRepresentacaoResumidaAtalho2() {
        test.criarDocumento("DocumentoAtalho");
        String expected = "Exemplo | de uma lista | de 3 termos\n" +
                "Exemplo | de outra lista | de 3 termos" + "\n" + "\n";
        test.criarAtalho("DocumentoAtalho", "TesteAtalho2");
        String resposta = test.geraRepresentacaoResumida("DocumentoAtalho",0);
        assertEquals(expected, resposta);
    }

    // Testes visao

    @Test
    void criarVisaoCompleta(){
        int expected = 0;
        int resposta = test.criarVisaoCompleta("Exemplo");
        assertEquals(expected,resposta);
    }

    @Test
    void criarVisaoCompletaNomeDocVazio(){
        assertThrows(IllegalArgumentException.class, () -> test.criarVisaoCompleta(""));
    }

    @Test
    void criarVisaoCompletaDocInexistente(){
        assertThrows(NoSuchElementException.class, () -> test.criarVisaoCompleta("DocInexistente"));
    }

    @Test
    void criarVisaoResumida(){
        int expected = 1;
        int resposta = test.criarVisaoResumida("Exemplo");
        assertEquals(expected,resposta);
    }

    @Test
    void criarVisaoResumidaNomeDocVazio(){
        assertThrows(IllegalArgumentException.class, () -> test.criarVisaoResumida(""));
    }

    @Test
    void criarVisaoResumidaDocInexistente(){
        assertThrows(NoSuchElementException.class, () -> test.criarVisaoResumida("DocInexistente"));
    }


    @Test
    void criarVisaoPrioritaria(){
        int expected = 2;
        int resposta = test.criarVisaoPrioritaria("Exemplo",3);
        assertEquals(expected,resposta);
    }

    @Test
    void criarVisaoPrioritariaComPrioridadeSuperiorAoDocRef(){
        assertThrows(NoSuchElementException.class, () -> test.criarVisaoPrioritaria("Exemplo",5));
    }

    @Test
    void criarVisaoPrioritariaDocInexistente(){
        assertThrows(NoSuchElementException.class, () -> test.criarVisaoPrioritaria("DocInexistente",5));
    }
    @Test
    void criarVisaoPrioritariaNomeDocVazio(){
        assertThrows(IllegalArgumentException.class, () -> test.criarVisaoPrioritaria("",5));
    }

    @Test
    void criarVisaoTitulo(){
        int expected = 3;
        int resposta = test.criarVisaoTitulo("Documento Titulo");
        assertEquals(expected,resposta);
    }

    @Test
    void criarVisaoTituloDocInexistente(){
        assertThrows(NoSuchElementException.class, () -> test.criarVisaoTitulo("DocInexistente"));
    }
    @Test
    void criarVisaoTituloNomeDocVazio(){
        assertThrows(IllegalArgumentException.class, () -> test.criarVisaoTitulo(""));
    }

    @Test
    void criarVisaoTituloQuandoElementoNaoEhTitulo(){
        assertThrows(NoSuchElementException
                .class, () -> test.criarVisaoTitulo("Exemplo"));
    }









}

