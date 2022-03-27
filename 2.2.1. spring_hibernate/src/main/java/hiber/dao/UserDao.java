package hiber.dao;

import hiber.model.Join;
import hiber.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   User getUserByCarHQL(String model, int series);

   Join getUserByCarSQL(int series) throws SQLException;


}
