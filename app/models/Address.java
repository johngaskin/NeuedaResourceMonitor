package models;

import play.db.ebean.*;
import javax.persistence.*;
import play.data.validation.*;
import java.util.*;

/**
 * Created by francis on 01/03/14.
 *      Holds data for a User address
 *      More than one user can live at an address so it's been linked as a OneToMany
 *      All counties of Ireland have been hard-coded, this Address class cant hold information on people outside of Ireland
 *      This may be a major issue
 */
@Entity
public class Address extends Model{
    @Id
    public static Long id;

    @Constraints.Required
    public static String address;

    @Constraints.Required
    public static String town;

    @Constraints.Required
    public static County county;

    @Constraints.Required
    @Constraints.Pattern("regex ='(GIR 0AA)|((([A-Z-[QVX]][0-9][0-9]?)|(([A-Z-[QVX]][A-Z-[IJZ]][0-9][0-9]?)|(([A-Z-[QVX]][0-9][A-HJKSTUW])|([A-Z-[QVX]][A-Z-[IJZ]][0-9][ABEHMNPRVWXY])))) [0-9][A-Z-[CIKMOV]]{2})'")
    public static String postCode;

    @OneToMany(mappedBy="address")
    public static List<User> users;

    public enum County{     //list of all 32 counties in alphabetical order (not too sure about this one lel)
        ANTRIM, ARMAGH, CARLOW, CAVAN, CLARE, CORK, DONEGAL, DOWN, DUBLIN, FERMANAGH, GALWAY, KERRY,
        KILDARE, KILKENNY, LAOIS, LEITRIM, LIMERIK, LONDONDERRY, LONGFORD, LOUTH, MAYO, MEATH, MONAGHAN,
        OFFALY, ROSCOMMON, SLIGO, TIPPERARY, TYRONE, WATERFORD, WESTMEATH, WEXFORD, WIKLOW;
    }
}
