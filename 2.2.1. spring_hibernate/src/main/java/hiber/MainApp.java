package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.Join;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;
import java.util.Queue;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Ivan", "Frolov", "frolov@mail.ru");
      User user2 = new User("Liza", "Petrova", "petrova56@mail.ru");
      User user3 = new User("Igor", "Sechin", "gazprom@yangex.ru");
      User user4 = new User("Egor", "Raykin", "jkgvjkf@gmail.com");

      Car car1 = new Car("vaz",2101);
      Car car2 = new Car("volvo",500);
      Car car3 = new Car("Maybah",800);
      Car car4 = new Car("Yamaha-R",100);

      user1.setCar(car1);
      user2.setCar(car2);
      user3.setCar(car3);
      user4.setCar(car4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      Join join = userService.getUserByCarSQL(2101);
      System.out.println(join.getId()+" "+join.getCarId()+" "+join.getUserId()+" "+join.getSeries()+" "+join.getFirstName()+" "+join.getLastName());
      context.close();
   }
}
