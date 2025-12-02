package conversor;

import com.google.gson.Gson;
import conversor.RespostaAPI;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

    public class ServicoDeCambio {

        public RespostaAPI buscarTaxas(String moedaBase) throws Exception {

            String urlStr = "https://v6.exchangerate-api.com/v6/87e4dbeb3cf77910bf673e8f/latest/" + moedaBase;
            URL url = new URL(urlStr);

            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");

            InputStreamReader reader = new InputStreamReader(conexao.getInputStream());

            // Converte o JSON em objeto Java
            RespostaAPI resposta = new Gson().fromJson(reader, RespostaAPI.class);

            return resposta;
        }
    }


