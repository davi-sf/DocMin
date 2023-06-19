package documin.elementos;

import java.util.*;

/**
 * Classe que representa um elemento de termos em um documento.
 */
public class Termos extends Elemento {

    private String separador;
    private String ordem;

    /**
     * Construtor da classe Termos.
     *
     * @param valor      O valor dos termos.
     * @param prioridade A prioridade dos termos.
     * @param separador  O separador utilizado para separar os termos.
     * @param ordem      A ordem dos termos (ALFABETICA ou NUMERICA).
     */
    public Termos(String valor, int prioridade, String separador, String ordem) {
        super(valor, prioridade);
        this.separador = separador;
        this.ordem = ordem;
    }

    /**
     * Gera a representação completa dos termos.
     *
     * @return A representação completa dos termos.
     */
    @Override
    public String gerarRepresentacaoCompleta() {
        List<String> listaDeTermos = obterTermosOrdenados();
        StringBuilder representacaoCompleta = new StringBuilder();

        for (int i = 0; i < listaDeTermos.size(); i++) {
            representacaoCompleta.append(listaDeTermos.get(i).trim());
            if (i < listaDeTermos.size() - 1) {
                representacaoCompleta.append(",");
            }
        }

        int qtdTermos = listaDeTermos.size();
        return "Total termos: " + qtdTermos + "\n-" + representacaoCompleta.toString();
    }

    @Override
    public String gerarRepresentacaoResumida() {
        List<String> termosOrdenados = obterTermosOrdenados();
        StringBuilder representacaoResumida = new StringBuilder();

        for (int i = 0; i < termosOrdenados.size(); i++) {
            representacaoResumida.append(termosOrdenados.get(i).trim());
            if (i < termosOrdenados.size() - 1) {
                representacaoResumida.append(" " + separador + " ");
            }
        }

        return representacaoResumida.toString();
    }

    private List<String> obterTermosOrdenados() {
        String[] termos = getValor().replaceAll(" ", "").split(separador);
        List<String> listaDeTermos = new ArrayList<>(Arrays.asList(termos));

        if (ordem.equals("ALFABETICA")) {
            Collections.sort(listaDeTermos);
        } else if (ordem.equals("NUMERICA")) {
            Collections.sort(listaDeTermos, (s1, s2) -> Integer.compare(s2.length(), s1.length()));
        }

        return listaDeTermos;
    }

}
