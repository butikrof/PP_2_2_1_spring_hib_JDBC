package hiber.service;

import hiber.model.Join;
import hiber.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    User getUserByCarHQL(String model, int series);

    Join getUserByCarSQL(int series) throws SQLException;


}
