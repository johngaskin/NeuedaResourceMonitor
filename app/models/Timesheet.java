package models;

import play.data.format.Formats;
import play.db.ebean.*;
import play.data.validation.*;
import javax.persistence.*;
import java.util.*;

/**
 * Created by francis on 01/03/14.
 *      Timesheet holds a record of a users availability between two dates
 *      Linked with user as a ManyToOne
 *      User has 4 states of availability hard-coded in Type enum
 */
@Entity
public class Timesheet extends Model{
    @Id
    public static Long id;

    @Formats.DateTime(pattern="dd/MM/yyyy")
    @Constraints.Required
    public static Date start;       //validate to be after today

    @Formats.DateTime(pattern="dd/MM/yyyy")
    @Constraints.Required
    public static Date end;     //validate to be after start

    @Constraints.Required
    public static Type type;

    @ManyToOne
    public static User user;

    public enum Type{       //type of availability
        BOOKED, TENTATIVELY_BOOKED, ON_LEAVE, FREE;
    }
}
