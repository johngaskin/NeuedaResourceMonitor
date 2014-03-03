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

    @Enumerated (EnumType.STRING)
    @Constraints.Required
    public static County county;

    @Constraints.Required
    @Constraints.Pattern("regex ='(GIR 0AA)|((([A-Z-[QVX]][0-9][0-9]?)|(([A-Z-[QVX]][A-Z-[IJZ]][0-9][0-9]?)|(([A-Z-[QVX]][0-9][A-HJKSTUW])|([A-Z-[QVX]][A-Z-[IJZ]][0-9][ABEHMNPRVWXY])))) [0-9][A-Z-[CIKMOV]]{2})'")
    public static String postCode;

    @OneToMany(mappedBy="address")
    public static List<User> users;


    public enum County{     //list of all 32 counties in alphabetical order (not too sure about this one lel)
        ANTRIM("Antrim"), ARMAGH("Armagh"), CARLOW("Carlow"), CAVAN("Cavan"), CLARE("Clare"), CORK("Cork"), DONEGAL("Donegal"), DOWN("Down"),
        DUBLIN("Dublin"), FERMANAGH("Fermanagh"), GALWAY("Galway"), KERRY("Kerry"),
        KILDARE("Kildare"), KILKENNY("Kilkenny"), LAOIS("Laois"), LEITRIM("Leitrim"), LIMERIK("Limerik"), LONDONDERRY("Londonderry"),
        LONGFORD("Longford"), LOUTH("Louth"), MAYO("Mayo"), MEATH("Meath"), MONAGHAN("Monaghan"),
        OFFALY("Offaly"), ROSOMMON("Roscommon"), SLIGO("Sligo"), TIPPERARY("Tipperary"), TYRONE("Tyrone"), WATERFORD("Waterford"),
        WESTMEATH("Westmeath"), WEXFORD("Wexford"), WIKLOW("Wiklow");

        public final String text;

        County (final String text) {
            this.text = text;
        }
    }
}
