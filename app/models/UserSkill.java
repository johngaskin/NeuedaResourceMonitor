package models;

import play.db.ebean.*;
import play.data.validation.*;
import javax.persistence.*;

/**
 * Created by francis on 01/03/14.
 *      Skills data with a hard-coded selection of Areas for a skill to belong to
 *      Area is hard-coded to help with querying data
 *
 *      This class is Linked ManyToOne with User
 */
@Entity
public class UserSkill extends Model{
    @Id
    public static Long id;

    @Constraints.Required
    public static Area area;

    @Constraints.Required
    public static String skill;

    @Constraints.Required
    @Constraints.Min(1)
    @Constraints.Max(4)
    public static Long rating;

    @ManyToOne
    public static User user;

    public enum Area{       //list of areas a skill can be a part of
        PROGRAMMER, PROJECT_DEVELOPER, PROJECT_DESIGN, BUSINESS_ANALYST;
    }
}
