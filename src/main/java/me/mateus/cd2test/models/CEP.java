package me.mateus.cd2test.models;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.mateus.cd2test.utils.HTTPUtils;

import java.io.IOException;

public class CEP {

    private final static String CEP_API_URL = "https://viacep.com.br/ws/%s/json";

    private String uf;
    private String ddd;
    private final String cep;

    public CEP(String cep) throws IOException {
        this.cep = cep;
        String url = String.format(CEP_API_URL, cep);

        String content = HTTPUtils.getContent(url);
        JsonObject json = JsonParser.parseString(content).getAsJsonObject();
        this.uf = json.get("uf").getAsString();
        this.ddd = json.get("ddd").getAsString();

    }

    public String getUf() {
        return uf;
    }

    public String getDdd() {
        return ddd;
    }

    public String getCep() {
        return cep;
    }
}
