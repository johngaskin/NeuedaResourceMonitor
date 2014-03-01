package models;

import play.data.validation.Constraints;
import play.db.ebean.*;
import javax.persistence.*;
import java.util.*;

/**
 * Created by francis on 01/03/14.
 *      Holds data for Users, data input on a registration form and is used to generate a profile page
 *      start should be a Date after todays date
 *      end should be a Date after start
 *      Maximum range between start and end should be limited to be 4months?
 */
@Entity
public class User extends Model{
            //Account information
    @Id
    @Constraints.Required
    @Constraints.Email
    public static String email;

    @Constraints.Required
    public static String password;       //passwords currently stored in plain text - Need to work out how to secure them

    @Constraints.Required
    public static String confirmPassword;


          //Contact details
    @Constraints.Required
    @Constraints.Pattern("regex = '\\d+'")
    public static String phoneNo;

    @Constraints.Required
    @Constraints.Pattern("regex = '/^[a-z ,.'-]+$/i'")
    public static String firstName;

    @Constraints.Required
    @Constraints.Pattern("regex = '/^[a-z ,.'-]+$/i'")
    public static String secondName;

    @ManyToOne(cascade = CascadeType.ALL)
    public static Address address;


          //Skills
    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL)
    public static List<UserSkill> skills;


          //Availability
    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL)
    public static List<Timesheet> availability;




    public static Finder<String, User> find(){
        return new Finder(String.class, User.class);
    }

    public static void saveOrUpdate(User user){      //Creates a new user if the email doesn't already exist, else updates existing user
        User temp = find().where().eq("email", user.email).findUnique();
        if (temp == null){
            user.save();
        }
        else{
            user.update();
        }
    }
}
