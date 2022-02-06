package me.mateus.cd2test.utils;

import me.mateus.cd2test.models.CEP;

import java.time.LocalDate;
import java.util.Objects;

public class EncomendaUtils {

    public static double getFrete(CEP cepOrigem, CEP cepDestino, double peso) {
        double discount = getDiscount(cepOrigem, cepDestino);
        if (discount != 0.0) {
            discount = peso * discount;
        }
        return peso - discount;
    }

    private static double getDiscount(CEP cepOrigem, CEP cepDestino) {
        if (Objects.equals(cepDestino.getDdd(), cepOrigem.getDdd())) {
            return 0.5;
        } else if (Objects.equals(cepDestino.getUf(), cepOrigem.getUf())) {
            return 0.75;
        } else {
            return 0.0;
        }
    }

    public static LocalDate getPredictedDate(CEP cepOrigem, CEP cepDestino, LocalDate currentDate) {
        if (Objects.equals(cepDestino.getDdd(), cepOrigem.getDdd())) {
            return currentDate.plusDays(1L);
        } else if (Objects.equals(cepDestino.getUf(), cepOrigem.getUf())) {
            return currentDate.plusDays(3L);
        } else {
            return currentDate.plusDays(10L);
        }
    }
}
