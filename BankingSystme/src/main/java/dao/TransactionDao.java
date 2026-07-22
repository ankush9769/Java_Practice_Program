package dao;

import config.DatabaseConnection;
import model.Status;
import model.Transaction;
import model.Type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDao {
    public static Transaction create(Transaction transaction) throws SQLException {

        String sql = "insert into transaction(userid,type,amount,balanceafter,status,reason)values(?,?,?,?,?,?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, transaction.getUserid());
            statement.setString(2, transaction.getType().name());
            statement.setDouble(3, transaction.getAmount());
            statement.setDouble(4, transaction.getBalanceafter());
            statement.setString(5, transaction.getStatus().name());
            statement.setString(6, transaction.getReason());

            statement.executeUpdate();

            return transaction;
        }
    }
    public static List<Transaction> transactionHistory(int id) throws SQLException {

        List<Transaction> list = new ArrayList<>();

        String sql = "select * from transaction where userid=?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    list.add(map(resultSet));
                }
            }
        }
        return list;
    }
    public static Transaction map(ResultSet resultSet) throws SQLException {
        return new Transaction(
                resultSet.getInt("userid"),
                Type.valueOf(resultSet.getString("type")),
                resultSet.getDouble("amount"),
                resultSet.getDouble("balanceafter"),
                Status.valueOf(resultSet.getString("status")),
                resultSet.getString("reason")
        );
    }
}
