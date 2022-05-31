package databases;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import RowMapper.AccountDetailsMapper;
import entities.Entity;
import entities.GupshupAccountDetails;

@Component
public class AccountDetails implements DBManager{
    @Autowired
    JdbcTemplate template;

    @Override
    public int insert(Entity entity)
    {
        return 0;
    }

    @Override
    public int update(Entity entity)
    {
        return 0;
    }

    @Override
    public int delete(Entity entity)
    {
        return 0;
    }

    public String retrieve(int Account_ID)
    {
        String querry = "select * from Gupshup_Account_Details where Account_ID = ?";
        RowMapper<GupshupAccountDetails> rowMapper =new AccountDetailsMapper();
        GupshupAccountDetails credential = this.template.queryForObject(querry, rowMapper, Account_ID);
        System.out.println(credential.getGupshup_API_Key());
        return credential.getGupshup_API_Key();
    }

    
}
