package week_18;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WebScraping {
    /*
     * El día 128 del año celebramos en la comunidad el "Hola Mundo day"
     * Vamos a hacer "web scraping" sobre su sitio web: https://holamundo.day
     *
     * Crea un programa que se conecte a la web del evento e imprima únicamente la agenda de eventos
     * del día 8. Mostrando hora e información de cada uno.
     * Ejemplo: "16:00 | Bienvenida"
     *
     * Se permite utilizar librerías que nos faciliten esta tarea.
     *
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://retosdeprogramacion.com/semanales2023")).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String html = response.body();

        Document document = Jsoup.parse(html);

        Elements elements = document.select(".notion-h-title");

        for (Element element : elements) {
            System.out.println(element.html());
        }

    }
}
