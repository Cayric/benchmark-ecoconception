package fr.memoire.benchmark.bdd;

import fr.memoire.benchmark.model.Author;
import fr.memoire.benchmark.model.Book;
import fr.memoire.benchmark.model.Library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnexionBook {

    static String PILOTE = "com.mysql.jdbc.Driver";
    static String BDD = "jdbc:mysql://localhost:3306/library";
    static String UTILISATEUR = "root";
    static String MOT_DE_PASSE = "j8LH9u2Qh";

    /**
     * La connexion à la base déclarée comme un singleton.
     */
    public static Connection connexion;

    /**
     * Récupération de la connexion à la base de données.
     * Si la connexion n'est pas encore établie (l'objet connexion n'a pas encore était cré alors
     * il faut le créer avant le retourner.<br/>
     * Les exceptions ne seront pas traitées.
     * @return La connexion à la base de données.
     * @throws ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static Connection getConnexion() throws ClassNotFoundException, SQLException {
        if (connexion == null) {

            Class.forName(PILOTE);
            connexion = DriverManager.getConnection(BDD, UTILISATEUR, MOT_DE_PASSE);

        }
        return connexion;
    }

    public static List<Book> findAll() throws SQLException, ClassNotFoundException {
        List<Book> reponse = new ArrayList<>();

        String requete = "Select * From book";
        Statement statement = getConnexion().createStatement();

        ResultSet resultat = statement.executeQuery(requete);

        while (resultat.next()) {
            Long id = resultat.getLong("id");
            String title = resultat.getString("title");
            String synopsis = resultat.getString("synopsis");
            Long authorId = resultat.getLong("author_id");

            Book book = new Book(id, title, synopsis, authorId);
            reponse.add(book);

        }
        return reponse;
    }

    public static Book save(Book book) throws ClassNotFoundException, SQLException {
        Book reponse = null;
        long id = -1;

        String requete = "Insert into book (title, synopsis, author_id) Values (?,?,?)";
        PreparedStatement statement = getConnexion().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, book.getTitle());
        statement.setString(2, book.getSynopsis());
        statement.setLong(3, book.getAuthor_id());
        statement.executeUpdate();

        ResultSet rs = statement.getGeneratedKeys();

        if (rs.next()) {
            id = rs.getLong(1);
        }
        reponse = new Book(id, book.getTitle(), book.getSynopsis(), book.getAuthor_id());

        return reponse;
    }
}
