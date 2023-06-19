package documin.elementos;

import documin.Documento;

import java.util.ArrayList;

/**
 * Classe que representa um elemento de atalho em um documento.
 */
public class Atalho extends Elemento {

    private Documento docRef;

    /**
     * Construtor da classe Atalho.
     *
     * @param valor     O valor do atalho.
     * @param prioridade A prioridade do atalho.
     */
    public Atalho(String valor, int prioridade) {
        super(valor, prioridade);
    }

    /**
     * Adiciona um documento de referência ao atalho.
     *
     * @param doc O documento de referência.
     */
    public void addDoc(Documento doc) {
        this.docRef = doc;
    }

    /**
     * Gera a representação completa do atalho, exibindo os elementos do documento de referência com prioridade maior ou igual a 4.
     *
     * @return A representação completa do atalho.
     */
    @Override
    public String gerarRepresentacaoCompleta() {
        String representacao = "";
        ArrayList<Elemento> elementosDocReferenciado = this.docRef.getElementosNoDocumento();
        for (Elemento elemento : elementosDocReferenciado) {
            if (elemento.prioridade >= 4) {
                representacao += elemento.gerarRepresentacaoCompleta() + "\n";
            }
        }
        return representacao;
    }

    /**
     * Gera a representação resumida do atalho, exibindo os elementos do documento de referência com prioridade maior ou igual a 4.
     *
     * @return A representação resumida do atalho.
     */
    @Override
    public String gerarRepresentacaoResumida() {
        String representacao = "";
        ArrayList<Elemento> elementosDocReferenciado = this.docRef.getElementosNoDocumento();
        for (Elemento elemento : elementosDocReferenciado) {
            if (elemento.prioridade >= 4) {
                representacao += elemento.gerarRepresentacaoResumida() + "\n";
            }
        }
        return representacao;
    }
}
