import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Stack;

public class Database {
    //dette må du ha med når du skal koble til database:
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/QuizDB"; // /shop betyr akkurat den databasen som heter shop som skal brukes
        String username = "root"; //husk å bytt til sensors brukernavn
        String password = "Kristiania2022"; //husk å bytt til sensor sitt passord

        // checks if jdbc driver for MySQL exist
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Connects to tghe DB
        //Connection.setAutoCommit(false);

        return DriverManager.getConnection(url, username, password);
    } //helt hit
    private void addBinaryQuestions(){
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();

            String insertSQL = "INSERT INTO BinaryQuestions (Question, CorrectAnswer)" +
                    "VALUES ('" + "Har Madonna skrevet shivers?', '" +
                    "Nei')";
            statement.execute(insertSQL);

            insertSQL = "INSERT INTO BinaryQuestions (Question, CorrectAnswer) VALUES ('Er Michael Jackson i live?', 'Nei')";
            statement.execute(insertSQL);

            insertSQL = "INSERT INTO BinaryQuestions (Question, CorrectAnswer) VALUES ('Er Shape of you skrevet av Ed Sharen?', 'Ja')";
            statement.execute(insertSQL);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void addMultiQuestions(){
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();

            String insertSQL = "INSERT INTO MultiQuestions (Question, Answer1, Answer2, Answer3, CorrectAnswer)" +
                    "VALUES ('Hvem spiller Jack i Titanic?', '" +
                    "Tom Cruise', '" +
                    "Tom Hanks', '" +
                    "Leonardo Dekaperio','" +
                    "2')";
            statement.execute(insertSQL);

            insertSQL = "INSERT INTO MultiQuestions (Question, Answer1, Answer2, Answer3, CorrectAnswer) VALUES ('Hvilke film spiser hovedkarakteren sjokolade som hans mor mener livet er basert på?', '')";
            statement.execute(insertSQL);

            insertSQL = "INSERT INTO BinaryQuestions (Question, CorrectAnswer) VALUES ('Er Shape of you skrevet av Ed Sharen?', 'Ja')";
            statement.execute(insertSQL);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
