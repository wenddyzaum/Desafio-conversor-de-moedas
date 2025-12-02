package conversor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClientHttp {

    public static String get(String urlStr) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

        conexao.setRequestMethod("GET");
        conexao.setRequestProperty("Accept", "application/json");

        BufferedReader br = new BufferedReader(
                new InputStreamReader(conexao.getInputStream())
        );

        StringBuilder resposta = new StringBuilder();
        String linha;

        while ((linha = br.readLine()) != null) {
            resposta.append(linha);
        }

        conexao.disconnect();
        return resposta.toString();
    }
}