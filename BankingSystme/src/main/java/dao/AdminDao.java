package dao;

import config.DatabaseConnection;
import model.Status;
import model.Transaction;
import model.Type;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {
    private static User map(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("email"),
                resultSet.getInt("accountno"),
                resultSet.getString("ifsc"),
                resultSet.getString("branch"),
                resultSet.getString("role"),
                resultSet.getDouble("balance")
        );
    }

    public static List<User> findAllUsers() throws SQLException {
        String sql = "select * from user where role='user'";
        List<User> users = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                users.add(map(resultSet));
            }
        }
        return users;
    }


    public static List<Transaction> findAllTransactions() throws SQLException {
        String sql = "select * from transaction";
        List<Transaction> transactions = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Transaction transaction = new Transaction(
                        resultSet.getInt("userid"),
                        Type.valueOf(resultSet.getString("type")),
                        resultSet.getDouble("amount"),
                        resultSet.getDouble("balanceafter"),
                        Status.valueOf(resultSet.getString("status")),
                        resultSet.getString("reason")
                );
                transactions.add(transaction);
            }
        }
        return transactions;
    }


    public static List<Transaction> AllfailTransaction() throws SQLException {
        String sql = "select * from transaction where status = 'FAILED'";
        List<Transaction> transactions = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Transaction transaction = new Transaction(
                        resultSet.getInt("userid"),
                        Type.valueOf(resultSet.getString("type")),
                        resultSet.getDouble("amount"),
                        resultSet.getDouble("balanceafter"),
                        Status.valueOf(resultSet.getString("status")),
                        resultSet.getString("reason")
                );
                transactions.add(transaction);
            }
        }
        return transactions;
    }

    public static List<User> highestBalanceUser() throws SQLException {
        String sql = "select * from user where role='user' AND balance = (select MAX(balance) from user)";
        List<User> users = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                users.add(map(resultSet));
            }
        }
        return users;
    }

    public static List<Transaction> transactionBetweenDate(String start,String end) throws SQLException {
        String sql = "select * from transaction where date BETWEEN ? AND ?";
        List<Transaction> transactions = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery())
        {
            statement.setString(1,start);
            statement.setString(2,end);
            while (resultSet.next()) {
                Transaction transaction = new Transaction(
                        resultSet.getInt("userid;"),
                        Type.valueOf(resultSet.getString("type")),
                        resultSet.getDouble("amount"),
                        resultSet.getDouble("balanceafter"),
                        Status.valueOf(resultSet.getString("status")),
                        resultSet.getString("reason")
                );
                transactions.add(transaction);
            }

        }
        return transactions;
    }


}
