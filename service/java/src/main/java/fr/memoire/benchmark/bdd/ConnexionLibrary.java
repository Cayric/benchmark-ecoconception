package fr.memoire.benchmark.bdd;

import fr.memoire.benchmark.model.Library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnexionLibrary {

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

    public static List<Library> findAll() throws SQLException, ClassNotFoundException {
        List<Library> reponse = new ArrayList<>();

        String requete = "Select * From library";
        Statement statement = getConnexion().createStatement();

        ResultSet resultat = statement.executeQuery(requete);

        while (resultat.next()) {
            Long id = resultat.getLong("id");
            String name = resultat.getString("name");

            Library library = new Library(id, name);
            reponse.add(library);

        }

        return reponse;
    }

    public static Library save(Library library) throws ClassNotFoundException, SQLException {
        Library reponse = null;
        long id = -1;

        String requete = "Insert into library (name) Values (?)";
        PreparedStatement statement = getConnexion().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, library.getName());
        statement.executeUpdate();

        ResultSet rs = statement.getGeneratedKeys();

        if (rs.next()) {
            id = rs.getLong(1);
        }
        reponse = new Library(id, library.getName());

        return reponse;
    }



}
