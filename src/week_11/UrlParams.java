package week_11;

import java.util.Arrays;
import java.util.HashMap;

public class UrlParams {
    /*
     * Dada una URL con parámetros, crea una función que obtenga sus valores.
     * No se pueden usar operaciones del lenguaje que realicen esta tarea directamente.
     *
     * Ejemplo: En la url https://retosdeprogramacion.com?year=2023&challenge=0
     * los parámetros serían ["2023", "0"]
     */
    public static void main(String[] args) {
        String url = "https://retosdeprogramacion.com?year=2023&challenge=0";
        HashMap<String, String> params = getParams(url);
        System.out.println(params);
    }

    private static HashMap<String, String> getParams(String url) {
        String[] urlData = url.split("[?&]");
        HashMap<String, String> params = new HashMap<>();
        if (urlData.length >= 1) {
            for (int i = 1; i < urlData.length; i++) {
                String[] paramsData = urlData[i].split("=");
                params.put(paramsData[0], paramsData[1]);
            }
        }
        return params;
    }
}
