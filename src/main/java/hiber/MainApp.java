package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }


        User user11 = new User("User11", "lastname11", "user11@mail.ru");
        User user12 = new User("User12", "lastname12", "user12@mail.ru");
        User user13 = new User("User13", "lastname13", "user13@mail.ru");
        User user14 = new User("User14", "lastname14", "user14@mail.ru");
        Car car11 = new Car("Mazda", 323);
        Car car12 = new Car("Porsche", 911);
        Car car13 = new Car("Mercedes-Benz", 124);
        Car car14 = new Car("Audi", 100);

        user11.setCar(car11);
        user12.setCar(car12);
        user13.setCar(car13);
        user14.setCar(car14);

        userService.add(user11);
        userService.add(user12);
        userService.add(user13);
        userService.add(user14);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car for user = " + user.getCar());
            System.out.println();
        }

        List<User> carOwner = userService.getUser("Audi", 100);

        for(User user : carOwner){
            System.out.println(user.getFirstName() + " "
                    + user.getLastName() + " is the owner of the " + user.getCar());
        }

        context.close();
    }
}