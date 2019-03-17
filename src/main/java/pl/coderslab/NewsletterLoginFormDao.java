package pl.coderslab;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsletterLoginFormDao {
    private String CREATE_USER_QUERY = "INSERT INTO newsletter_users(name,email) VALUES (?,?);";
    private String FIND_ALL_USERS_QUERY = "SELECT*FROM newsletter_users;";

    public NewsletterUser saveToDBDao(NewsletterUser user) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement insertStm = connection.prepareStatement(CREATE_USER_QUERY,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            insertStm.setString(1, user.getName());
            insertStm.setString(2, user.getEmail());
            int result = insertStm.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }
            try (ResultSet generatedKeys = insertStm.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    user.setId(generatedKeys.getInt(1));
                    return user;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * lists all users from newsletter_users table
     *
     * @return
     */

    public List<NewsletterUser> findAllUsers() {
        List<NewsletterUser> adminsList = new ArrayList<>();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_USERS_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                NewsletterUser usersToAdd = new NewsletterUser();
                usersToAdd.setId(resultSet.getInt("id"));
                usersToAdd.setName(resultSet.getString("name"));
                usersToAdd.setEmail(resultSet.getString("email"));
                adminsList.add(usersToAdd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminsList;
    }

}
