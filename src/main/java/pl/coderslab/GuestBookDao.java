package pl.coderslab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuestBookDao {

    private String CREATE_GUEST_QUERY = "INSERT INTO guest_book(description) VALUES (?);";
    private String FIND_ALL_GUESTS_QUERY = "SELECT*FROM guest_book;";

    public GuestBook saveToDBDao(GuestBook guest) {
        try (Connection connection = DbUtil.getConn();
             PreparedStatement insertStm = connection.prepareStatement(CREATE_GUEST_QUERY,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            insertStm.setString(1, guest.getDescription());
            int result = insertStm.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }
            try (ResultSet generatedKeys = insertStm.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    guest.setId(generatedKeys.getInt(1));
                    return guest;
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

    public List<GuestBook> findAllDescriptions() {
        List<GuestBook> guestBookList = new ArrayList<>();
        try (Connection connection = DbUtil.getConn();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_GUESTS_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                GuestBook usersToAdd = new GuestBook();
                usersToAdd.setId(resultSet.getInt("id"));
                usersToAdd.setDescription(resultSet.getString("description"));
                guestBookList.add(usersToAdd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guestBookList;
    }

}
