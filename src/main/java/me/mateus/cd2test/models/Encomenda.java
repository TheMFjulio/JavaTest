package me.mateus.cd2test.models;

import me.mateus.cd2test.utils.EncomendaUtils;

import javax.persistence.*;
import java.io.IOException;
import java.time.LocalDate;


@Entity
@Table
public class Encomenda {

    @Id
    @SequenceGenerator(
            name = "encomenda_sequence",
            sequenceName = "encomenda_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "encomenda_sequence")
    private Long id;
    private final double peso;
    private final String cepOrigem;
    private final String cepDestino;
    private final String nomeDestinatario;
    private final double vlTotalFrete;
    private final LocalDate dataPrevistaEntrega;
    private final LocalDate dataConsulta;

    public Encomenda(InputModel inputModel) throws IOException {
        this(inputModel.getPeso(), inputModel.getCepOrigem(), inputModel.getCepDestino(), inputModel.getNomeDestinatario());
    }

    public Encomenda(double peso, String cepOrigem, String cepDestino, String nomeDestinatario) throws IOException {
        this.peso = peso;
        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
        this.nomeDestinatario = nomeDestinatario;
        CEP cepOrigemObject = new CEP(cepOrigem);
        CEP cepDestinoObject = new CEP(cepDestino);
        LocalDate localDate = LocalDate.now();
        this.vlTotalFrete = EncomendaUtils.getFrete(cepOrigemObject, cepDestinoObject, peso);
        this.dataPrevistaEntrega = EncomendaUtils.getPredictedDate(cepOrigemObject, cepDestinoObject, localDate);
        this.dataConsulta = localDate;

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

    public double getVlTotalFrete() {
        return vlTotalFrete;
    }

    public LocalDate getDataPrevistaEntrega() {
        return dataPrevistaEntrega;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }
}
