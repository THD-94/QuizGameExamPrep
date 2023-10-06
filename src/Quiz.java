import Question.Question;

import java.util.ArrayList;
import java.util.Collections;

public class Quiz {
    //her er spill metoder. her samles spørmålene, printe de vidre sende svar.

    //Felter som String er, det er en klasse og denne arraylisten og Question.Question klasse
    private ArrayList<Question> questions = new ArrayList<>();
    private int score;
    private int currentQuestion = 0;

    //getter
    public int getScore() {
        return score;
    }

    //Metoder
    public void addQuestion(Question question){
        questions.add(question);
    }
    public void printCurrentQuestion(){
        questions.get(currentQuestion).printQuestion();
    }
    public boolean answerQuestion(int answer){
        if (questions.get(currentQuestion).isCorrect(answer)){
            score++;
            return true;
        }return false;
    }
    public void nextQuestion() {
        currentQuestion++;
        if (currentQuestion >= questions.size()){
            currentQuestion = 0;
        }
    }
    public void shuffleQuestion(){
        Collections.shuffle(questions);
        // Collection er en interface (som er en oppskrift/kontrakt/svakere verson av en abstrakt klasse hva man kan gjøre)
        //Mens Collections er en klasse som kan jobbe på Coleection.

    }
    public void printCurrentAnswer(){
        questions.get(currentQuestion).printAnswers();
    }
    public int questionsAmount(){
        return questions.size();
    }


}
