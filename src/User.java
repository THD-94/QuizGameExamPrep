public class User {
    //Felter
    private String userName;
    private int score;

    //Konstruktører


    //Gettere og settere
    public String getUserName() {
        return userName;
    }

    public int getScore() {
        return score;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setScore(int score) {
        this.score = score;
    }


    //metoder

    public void  addScore(int score){
        this.score += score;
    }

}
