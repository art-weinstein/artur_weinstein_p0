package bankApp.repositories;

import bankApp.models.Account;
import bankApp.util.JDCConnection;


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

        Account account;
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

    @Override
    public Account addAccount(String username, String password, double funds){
        String sql = "INSERT INTO account VALUES (default, ?, ?, ?, default, default) RETURNING *";
        Account account = new Account();
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setDouble(3, funds);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
//                account = new Account();
                account.setUsername(rs.getString("username"));
                account.setUsername(rs.getString("password"));
                account.setFunds(rs.getDouble("funds"));

                return buildAccount(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account getAccount(int id) {
        //Make a String for the SQL statement you want executed. Use Placeholders for data values.
        String sql = "SELECT * FROM account WHERE a_id = ? and username = ? and password = ? and funds = ? and savings = ? and checking = ?";

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

    @Override
    public Account transferFundsToChecking(Account change) {
        String sql = "UPDATE account set funds = ?, checking = ? WHERE a_id = ? RETURNING*";

        try{
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, change.getFunds());
            ps.setDouble(2, change.getChecking());
            ps.setInt(3, change.getId());
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return buildAccount(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Account transferFundsToSavings(Account change) {
        String sql = "UPDATE account set funds = ?, savings = ? WHERE a_id = ? RETURNING*";

        try{
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, change.getFunds());
            ps.setDouble(2, change.getSavings());
            ps.setInt(3, change.getId());
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return buildAccount(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Account transferCheckingToSavings(Account change) {
        String sql = "UPDATE account set checking = ?, savings = ? WHERE a_id = ? RETURNING*";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, change.getChecking());
            ps.setDouble(2, change.getSavings());
            ps.setInt(3, change.getId());
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return buildAccount(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Account transferSavingsToChecking(Account change) {
        String sql = "UPDATE account set savings = ?, checking = ? WHERE a_id = ? RETURNING*";

        try{
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, change.getSavings());
            ps.setDouble(2, change.getChecking());
            ps.setInt(3, change.getId());
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return buildAccount(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Account withdrawFromSavings(Account change) {
        String sql = "UPDATE account set savings = ?, funds = ? WHERE a_id = ? RETURNING*";

        try{
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, change.getSavings());
            ps.setDouble(2, change.getFunds());
            ps.setInt(3, change.getId());
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return buildAccount(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Account withdrawFromChecking(Account change) {
        String sql = "UPDATE account set checking = ?, funds = ? WHERE a_id = ? RETURNING*";

        try{
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, change.getChecking());
            ps.setDouble(2, change.getFunds());
            ps.setInt(3, change.getId());
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return buildAccount(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    private Account buildAccount(ResultSet rs) throws  SQLException{
        Account a = new Account();
        a.setId(rs.getInt("a_id"));
        a.setUsername(rs.getString("username"));
        a.setPassword(rs.getString("password"));
        a.setFunds(rs.getDouble("funds"));
        a.setSavings(rs.getDouble("savings"));
        a.setChecking(rs.getDouble("checking"));

        return a;
    }
}
