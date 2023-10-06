import Question.Question;
import Question.BinaryQuestion;
import Question.MultiQuestion;

import java.util.Scanner;

public class Program {
    //Denne klassen kjører hele programmet med menyene.

    public void run() {
        printMainMenu();
    }

    private void printMainMenu() {
        // Dette er test om det fungerte: System.out.println("dette gikk?"); Det fungerte ^^
        System.out.println("1: Start the Game");
        System.out.println("2: Exit");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        // Sjekket om inputen fungerte og lagret System.out.println(input); det gjorde det ^^

        switch (input) {
            case "1":
                // Teste om det gikk ^^System.out.println("You did start the game ^^"); det gikk
                startGame();
                break;
            case "2":
                System.out.println("Exit now");
                break;
            default:
                System.out.println("Wrong input");
        }

    }

    private User createUser() {
        // testet om jeg kom hit: System.out.println("You did start the game ^^"); det gikk ^^
        System.out.println("Create your username");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        User user = new User();
        user.setUserName(input); //nå blir inputet lagret som en objekt i user som username.
        return user; //her returner vi brukeren (inputet er lagret i den)

    }

    private void startGame() {
        User user = createUser(); // for å starte spillet må du lage en bruker

        System.out.println("What category do you want to play?");
        System.out.println("1: Movies");
        System.out.println("2: Music");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch (input) {
            case "1":
                startMovieQuiz(user);
                break;
            case "2":
                startMusicQuiz(user);
                break;
            default:
                System.out.println("Wrong input");
        }

    }

    private void startMusicQuiz(User user) { //  dette bryr seg ikke om akkurat spørsmålene. Men hvordan de blir brukt.
        Quiz quiz = new Quiz();
        Scanner scanner = new Scanner(System.in);

        initMusicQuiz(quiz);
        quiz.shuffleQuestion();
        for (int i = 0; i < quiz.questionsAmount(); i++) {
            quiz.printCurrentQuestion(); // her printer vi spørsmålet
            quiz.printCurrentAnswer(); // her printer vi valget
            String input = scanner.nextLine(); //her kan user skrive svaret de tror er
            boolean correct = false;
            if (input.equalsIgnoreCase("yes")) {
                correct = quiz.answerQuestion(1);
            } else if (input.equalsIgnoreCase("no")) {
                correct = quiz.answerQuestion(0); // sjekker hva user skriver
            } else {
                System.out.println("Du valgte ikke å svare");
            }


            if (correct) {
                System.out.println("Du hadde helt rett");
            } else {
                System.out.println("Dessverre det var galt"); //sjekker hvilke som er rett
            }

            System.out.println("Vil du fortsette Quizen?"); //kommer hver runde slik at de kan avsliutte quizen^^
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("no")) {
                break;
            }
            quiz.nextQuestion();
        }
        user.addScore(quiz.getScore());
        System.out.println(user.getUserName() + " fikk " + quiz.getScore() + " ut av " + quiz.questionsAmount());
        System.out.println("men du har nå " + user.getScore());
    }

    private void startMovieQuiz(User user) {
        Quiz quiz = new Quiz();
        Scanner scanner = new Scanner(System.in);

        initMovieQuiz(quiz);
        quiz.shuffleQuestion();
        for (int i = 0; i < quiz.questionsAmount(); i++) {
            quiz.printCurrentQuestion(); // her printer vi spørsmålet
            quiz.printCurrentAnswer(); // her printer vi valget
            String input = scanner.nextLine(); //her kan user skrive svaret ded tror er
            boolean correct = false;
            correct = quiz.answerQuestion(Integer.parseInt(input)-1);
            if (correct){
                System.out.println("Du hadde riktig");
            } else {
                System.out.println("Det var feil");
            }
            System.out.println("Vil du fortsette Quizen?"); //kommer hver runde slik at de kan avsliutte quizen^^
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("no")) {
                break;
            }
            quiz.nextQuestion();
        }
        user.addScore(quiz.getScore());
        System.out.println(user.getUserName() + " fikk " + quiz.getScore() + " ut av " + quiz.questionsAmount());
        System.out.println("men du har nå " + user.getScore());
    }

    //midlertidig metode, siden er slik det skal skje, bare far databasen istedenfor
    //dette er bare for å se at det fungerer
    private void initMusicQuiz(Quiz quiz) { // betyr å gjøre klart
        Question question1 = new BinaryQuestion();
        Question question2 = new BinaryQuestion();
        Question question3 = new BinaryQuestion();


        question1.setQuestion("Har Madonna skrevet shivers?");
        question2.setQuestion("Er Michael Jackson i live?");
        question3.setQuestion("Er Shape of you skrevet av Ed Sharen?");

        question1.setCorrectIndex(0); //nei er svaret her fordi det er 0.
        question2.setCorrectIndex(0); //nei er svaret her fordi det er 0.
        question3.setCorrectIndex(1); //ja er svaret her fordi det er 1.

        quiz.addQuestion(question1);
        quiz.addQuestion(question2);
        quiz.addQuestion(question3);


    }
    private void initMovieQuiz(Quiz quiz){
        MultiQuestion question1 = new MultiQuestion();
        MultiQuestion question2 = new MultiQuestion();
        question1.setQuestion("Hvem spiller Jack i Titanic?");
        question1.addAnswer("Tom Cruise");
        question1.addAnswer("Tom Hanks");
        question1.addAnswer("Leonardo Dekaperio");
        question2.setQuestion("Hvilke film spiser hovedkarakteren sjokolade som hans mor mener livet er basert på?");
        question2.addAnswer("Avengers end game");
        question2.addAnswer("Forest Gump");
        question2.addAnswer("Charlie og sjokoladefabrikken");
        question1.setCorrectIndex(2);
        question2.setCorrectIndex(1);
        quiz.addQuestion(question1);
        quiz.addQuestion(question2);
    }

}
