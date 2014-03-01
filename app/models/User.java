package models;

import play.data.validation.Constraints;
import play.db.ebean.*;
import javax.persistence.*;
import java.util.*;

/**
 * Created by francis on 01/03/14.
 */
@Entity
public class User extends Model{
            //Account information
    @Id
    @Constraints.Required
    @Constraints.Email
    public static String email;

    @Constraints.Required
    public static String password;

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




    public static void saveOrUpdate(User usr){      //Creates a new user if the email doesn't already exist, else updates existing user
        if (usr.email == null){
            usr.save();
        }
        else{
            usr.update();
        }
    }
}
