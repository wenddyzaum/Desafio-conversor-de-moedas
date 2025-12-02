package conversor;

import com.google.gson.Gson;

public class ConversorDeMoedas {

    private final String apiKey = "87e4dbeb3cf77910bf673e8f";
    private final String API_URL_TEMPLATE =
            "https://v6.exchangerate-api.com/v6/%s/latest/%s";

    public double converter(String origem, String destino, double valor) throws Exception {

        String url = String.format(API_URL_TEMPLATE, apiKey, origem.toUpperCase());

        String json = ClientHttp.get(url);

        Gson gson = new Gson();
        RespostaAPI resposta = gson.fromJson(json, RespostaAPI.class);

        if (!"success".equalsIgnoreCase(resposta.getResult())) {
            throw new Exception("Erro na API: result = " + resposta.getResult());
        }

        Double taxa = resposta.getTaxas().get(destino.toUpperCase());

        if (taxa == null) {
            throw new Exception("Moeda de destino não encontrada: " + destino);
        }

        return valor * taxa;
    }
}


