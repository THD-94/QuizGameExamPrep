package Question;

import java.util.ArrayList;

public class MultiQuestion extends Question {
    // felter
    private ArrayList<String> answerOptions = new ArrayList<>();

    //metoder
    /*@Override
    public boolean isCorrect(int answer) {

        return answer == correctIndex; //dette er en enklere måte å sende true eller false istedenfor If else.
        // if (answer == correctIndex){
        * return true; } else {return false;}
    }*/

    @Override
    public void printAnswers() {
        for (int i = 0; i <answerOptions.size() ; i++) {
            System.out.println((i+1) + " " + answerOptions.get(i)); //dette betyr plass +1 med mellomrom også svararternativet
        }
    }

    public void addAnswer(String answer){
        answerOptions.add(answer);
    }
}
