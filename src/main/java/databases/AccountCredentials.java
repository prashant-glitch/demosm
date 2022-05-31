package databases;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import RowMapper.AccountCredentialsMapper;
import entities.Account_Credentials;
import entities.Entity;

@Component
public class AccountCredentials implements DBManager{

    @Autowired
    JdbcTemplate template;
    
    @Override
    public int insert(Entity entity)
    {
        String querry ="insert into Account_Credential (userName,password) values(?,?)";
        int res =template.update(querry,((Account_Credentials)entity).getUserName(),((Account_Credentials)entity).getPassword());
        return res;
    }
    @Override
    public int delete(Entity entity)
    {
        return 0;
    }

    public Account_Credentials retrieve(String userName)
    {
        String querry = "select * from Account_Credential where userName = ?";
        RowMapper<Account_Credentials> rowMapper= new AccountCredentialsMapper();
        Account_Credentials credential =this.template.queryForObject(querry, rowMapper, userName);
        System.out.println(credential);
        return credential;
    }
    @Override
    public int update(Entity entity) {
        return 0;
    }
    
}
