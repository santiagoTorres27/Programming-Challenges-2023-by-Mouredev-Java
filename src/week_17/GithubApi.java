package week_17;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class GithubApi {
    /*
     * ¡Estoy de celebración! He publicado mi primer libro:
     * "Git y GitHub desde cero"
     * - Papel: mouredev.com/libro-git
     * - eBook: mouredev.com/ebook-git
     *
     * ¿Sabías que puedes leer información de Git y GitHub desde la gran
     * mayoría de lenguajes de programación?
     *
     * Crea un programa que lea los últimos 10 commits de este repositorio y muestre:
     * - Hash
     * - Autor
     * - Mensaje
     * - Fecha y hora
     *
     * Ejemplo de salida:
     * Commit 1 (el más reciente) | 12345A | MoureDev | Este es un commit | 24/04/2023 21:00
     *
     * Se permite utilizar librerías que nos faciliten esta tarea.
     *
     */
    public static void main(String[] args) {
        String apiUrl = "https://api.github.com/repos/mouredev/retos-programacion-2023/commits";
        callApi(apiUrl);
    }

    private static void callApi(String apiUrl) {
        try {
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

            // JSON conversion
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response.toString());

            // JSON to ArrayList (Commit)
            List<Data> commitList = objectMapper.readValue(jsonNode.traverse(), objectMapper.getTypeFactory().constructCollectionType(List.class, Data.class));

            // Print 10 last commits
            for (int i = 0; i < 10; i++) {
                System.out.println(commitList.get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
