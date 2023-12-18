package week_07;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HarryPotterQuiz {
    /*
     * Crea un programa que simule el comportamiento del sombrero selccionador del
     * universo mágico de Harry Potter.
     * - De ser posible realizará 5 preguntas (como mínimo) a través de la terminal.
     * - Cada pregunta tendrá 4 respuestas posibles (también a selecciona una a través de terminal).
     * - En función de las respuestas a las 5 preguntas deberás diseñar un algoritmo que
     *   coloque al alumno en una de las 4 casas de Hogwarts:
     *   (Gryffindor, Slytherin , Hufflepuff y Ravenclaw)
     * - Ten en cuenta los rasgos de cada casa para hacer las preguntas
     *   y crear el algoritmo seleccionador:
     *   Por ejemplo, en Slytherin se premia la ambición y la astucia.
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hola");
        String input = sc.nextLine();
        System.out.println(input);
    }

    private static void initQuizz() {
        List<Question> questions = loadJSON();
    }

    private static List<Question> loadJSON() {
        File file = new File("/mnt/nvme0n1p4/Projects/JavaProjects/Programming Challenges 2023/src/week_07/data.json");
        ObjectMapper objectMapper = new ObjectMapper();
        List<Question> questions = new ArrayList<>();

        try (InputStream inputStream = new FileInputStream(file)) {
            questions = objectMapper.readValue(inputStream, objectMapper.getTypeFactory().constructCollectionType(List.class, Question.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;

//        try {
//            JsonNode rootNode = objectMapper.readTree(new File("/mnt/nvme0n1p4/Projects/JavaProjects/Programming Challenges 2023/src/week_07/data.json"));
//            System.out.println("JSON File");
//            System.out.println(rootNode.toPrettyString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
