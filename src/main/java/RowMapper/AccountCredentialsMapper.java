package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import entities.Account_Credentials;

public class AccountCredentialsMapper implements RowMapper<Account_Credentials> {
    @Override
    public Account_Credentials mapRow(ResultSet resultset, int rownum) throws SQLException {

        Account_Credentials credential = new Account_Credentials();
        credential.setAccount_ID(resultset.getInt(1));
        credential.setUserName(resultset.getString(2));
        credential.setPassword(resultset.getString(3));
        return credential;
}
}
