package hva.core;

import java.io.Serializable;

public class Arvore implements Serializable {
    private String _arvoreId;
    private String _arvoreNome;
    private int _arvoreIdade;
    private String _tipoFolha;
    private int _dificuldadeLimpeza;
    private String _estacao;

    // Construtor
    public Arvore(String arvoreId, String arvoreNome, int arvoreIdade, String tipoFolha, int dificuldadeLimpeza,
            String estacaoAtual) {
        _arvoreId = arvoreId;
        _arvoreNome = arvoreNome;
        _arvoreIdade = arvoreIdade;
        _tipoFolha = tipoFolha;
        _dificuldadeLimpeza = dificuldadeLimpeza;
        _estacao = estacaoAtual;
    }

    // Getters
    public String getArvoreId() {
        return _arvoreId;
    }

    public String getArvoreNome() {
        return _arvoreNome;
    }

    public int getArvoreIdade() {
        return _arvoreIdade;
    }

    public String getTipoFolha() {
        return _tipoFolha;
    }

    public int getDificuldadeLimpeza() {
        return _dificuldadeLimpeza;
    }

    public String getEstacao() {
        return _estacao;
    }

}
