package Question;

public abstract class Question {

    private String question;
     private int correctIndex;

     //setter
    public void setQuestion(String question) {
        this.question = question;
    }
    public void setCorrectIndex(int correctIndex) {
        this.correctIndex = correctIndex;
    }

    public void printQuestion() {
        System.out.println(question);
    }

    public boolean isCorrect(int answer) {

        return answer == correctIndex;
    }

    public abstract void printAnswers();
}