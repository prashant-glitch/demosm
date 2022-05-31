package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import entities.GupshupAccountDetails;

public class AccountDetailsMapper implements org.springframework.jdbc.core.RowMapper<GupshupAccountDetails>{


    @Override
    public GupshupAccountDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
       
        GupshupAccountDetails accountDetails = new GupshupAccountDetails();
        accountDetails.setAccount_ID(rs.getInt(1));
        accountDetails.setGupshup_API_Key(rs.getString(2));
        return accountDetails;
    }
}
