package hiber.dao;

import hiber.model.User;
import hiber.util.Util;
import hiber.model.Join;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    Util util = new Util();
    private static String nameTableUsers= "users";
    private static String nameTableCar= "car";


   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }


   @Override
   public User getUserByCarHQL(String model, int series) {
      User singleResult = sessionFactory.getCurrentSession()
              .createQuery("FROM User where car.model = :carModel and car.series = :carSeries", User.class)
              .setParameter("carModel", model)
              .setParameter("carSeries", series)
              .getSingleResult();
      return singleResult;
   }

   @Override
   public Join getUserByCarSQL(int series) {

      Join join = new Join();
      String query = "SELECT * FROM users INNER JOIN car ON users.id = car.id WHERE  car.series = "+series+" limit 4";
      Util util = new Util();

      try {
         Statement statement = util.conection().createStatement();
         ResultSet resultSet = statement.executeQuery(query);
         while (resultSet.next()){

            int id = resultSet.getInt(1);
            String email= resultSet.getString(2);
            String firstName= resultSet.getString(3);
            String lastName= resultSet.getString(4);
            int carId = resultSet.getInt(5);
            int userId = resultSet.getInt(6);
            String model= resultSet.getString(7);
            String seria= resultSet.getString(8);



       //     System.out.println(id+" "+email+" "+firstName+" "+lastName+" "+carId+" "+userId+" "+model+" "+seria);
            join.setId(id);
            join.setEmail(email);
            join.setFirstName(firstName);
            join.setLastName(lastName);
            join.setCarId(carId);
            join.setUserId(userId);
            join.setModel(model);
            join.setSeries(seria);





         }



      } catch (SQLException e) {
         e.printStackTrace();
      }


      return join;
   }




   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }



}



/*

 } catch (SQLException e) {
         System.out.println("При поиске юзера произошло исключение.\nPrint exception: "+e);
         }
         try {
         util.conection().close();
         } catch (SQLException e) {
         System.out.println("conection.close - exeption");
         e.printStackTrace();
         }*/
