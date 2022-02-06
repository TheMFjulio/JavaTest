package me.mateus.cd2test.models;

import java.time.LocalDate;

public class ResponseModel {

    private final double vlTotalFrete;
    private final LocalDate dataPrevistaEntrega;
    private final String cepOrigem;
    private final String cepDestino;

    public ResponseModel(Encomenda encomenda) {
        this.vlTotalFrete = encomenda.getVlTotalFrete();
        this.dataPrevistaEntrega = encomenda.getDataPrevistaEntrega();
        this.cepOrigem = encomenda.getCepOrigem();
        this.cepDestino = encomenda.getCepDestino();
    }

    public double getVlTotalFrete() {
        return vlTotalFrete;
    }

    public LocalDate getDataPrevistaEntrega() {
        return dataPrevistaEntrega;
    }

    public String getCepOrigem() {
        return cepOrigem;
    }

    public String getCepDestino() {
        return cepDestino;
    }
}
