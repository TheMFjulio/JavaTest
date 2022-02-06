package me.mateus.cd2test.models;

public class InputModel {


    private final double peso;
    private final String cepOrigem;
    private final String cepDestino;
    private final String nomeDestinatario;

    public InputModel(double peso, String cepOrigem, String cepDestino, String nomeDestinatario) {

        this.peso = peso;
        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
        this.nomeDestinatario = nomeDestinatario;
    }

    public double getPeso() {
        return peso;
    }

    public String getCepOrigem() {
        return cepOrigem;
    }

    public String getCepDestino() {
        return cepDestino;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }
}
