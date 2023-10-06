package Question;

public class BinaryQuestion extends Question{

    //metoder
    /*@Override
    public boolean isCorrect(int answer) {
        return answer == this.correctIndex;


        if(answer == 0 && !this.correctIndex){
            return true;
        }
        if (answer == 1 && this.correctIndex){
            return true;
        }// dette betyr at hvis svaret er nei (som er 0) som er false kommer det ut som riktig.
        også hvis spørsmålet er sant (som er 1) som er true så kommer det også ut som riktig.
        //kan også skrives med int ansver i felter som: if(answer == this.answer){return true;}

        return false;
    }*/

    @Override
    public void printAnswers() {
        System.out.println("Yes / No");
    }
}
