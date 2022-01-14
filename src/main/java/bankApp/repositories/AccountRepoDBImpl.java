package bankApp.repositories;

import bankApp.models.Account;
//import bankApp.util.GenericLinkedList;
import bankApp.util.JDCConnection;
//import bankApp.util.ResourceNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepoDBImpl implements AccountRepo {

    private JDCConnection JDBCConnection;
    Connection conn = JDBCConnection.getConnection();


    @Override
    public Account login(String username, String password) {
        //Make a String for the SQL statement you want executed. Use Placeholders for data values.
        String sql = "SELECT * FROM account WHERE username = ? and password = ?";

        Account account = null;
        try {
            //Set up PreparedStatement
            PreparedStatement ps = conn.prepareStatement(sql);
            //Set values for any Placeholders
//            ps.setInt(1, id);
            ps.setString(1, username);
            ps.setString(2, password);

            //Execute the query, store the results -> ResultSet
            ResultSet rs = ps.executeQuery();
//            account = null;

            //Extract results our of ResultSet
            if (rs.next()) {
                account = new Account();
//                ps.setInt(1, id);
                account.setUsername(rs.getString("username"));
                account.setUsername(rs.getString("password"));

                return buildAccount(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    @Override
//    public Account login(int id) {
//        return null;
//    }

//    @Override
//    public Account login(int id) {
//        return null;
//    }


    @Override
    public Account addAccount(String username, String password){
        String sql = "INSERT INTO account VALUES (default, ?, ?) RETURNING *";
        Account account = null;
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                account = new Account();
                account.setUsername(rs.getString("username"));
                account.setUsername(rs.getString("password"));

                return buildAccount(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account getAccount(int id) {
        //Make a String for the SQL statement you want executed. Use Placeholders for data values.
        String sql = "SELECT * FROM account WHERE a_id = ?";

        try {
            //Set up PreparedStatement
            PreparedStatement ps = conn.prepareStatement(sql);
            //Set values for any Placeholders
            ps.setInt(1, id);

            //Execute the query, store the results -> ResultSet
            ResultSet rs = ps.executeQuery();

            //Extract results our of ResultSet
            if(rs.next()) {
                return buildAccount(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Account buildAccount(ResultSet rs) throws  SQLException{
        Account a = new Account();
        a.setId(rs.getInt("a_id"));
        a.setUsername(rs.getString("username"));
        a.setPassword(rs.getString("password"));
        return a;
    }
}
