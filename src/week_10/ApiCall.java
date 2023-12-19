package week_10;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ApiCall {
    /*
     * Llamar a una API es una de las tareas más comunes en programación.
     *
     * Implementa una llamada HTTP a una API (la que tú quieras) y muestra su
     * resultado a través de la terminal. Por ejemplo: Pokémon, Marvel...
     *
     * Aquí tienes un listado de posibles APIs:
     * https://github.com/public-apis/public-apis
     */
    public static void main(String[] args) {
        String apiUrl = "https://animechan.xyz/api/quotes";
        callApi(apiUrl);
    }

    private static void callApi(String apiUrl) {
        try {
            // Api call
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            connection.disconnect();

            // Json Conversion
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response.toString());

            // Json to ArrayList (Anime)
            List<Anime> animeList = objectMapper.readValue(jsonNode.traverse(), objectMapper.getTypeFactory().constructCollectionType(List.class, Anime.class));

            // ArrayList printing
            for (Anime anime : animeList) {
                System.out.println(anime);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
