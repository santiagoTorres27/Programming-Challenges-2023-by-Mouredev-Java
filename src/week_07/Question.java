package week_07;

import java.util.List;

public class Question {
    private String question;
    private List<Option> options;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    private String printOptions() {
        String options = "\n";
        for (int i = 0; i < getOptions().size(); i++) {
            options += (i + 1) + " - " + getOptions().get(i).getText() + " (" +
                    getOptions().get(i).getValue() + " puntos)\n";
        }
        return options;
    }

    @Override
    public String toString() {
        return question + printOptions();
    }
}
