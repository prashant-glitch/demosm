package databases;

import org.springframework.stereotype.Repository;

import entities.Entity;

@Repository
public interface DBManager {
    public int insert(Entity entity);
    public int update(Entity entity);
    public int delete(Entity entity);
    
}
