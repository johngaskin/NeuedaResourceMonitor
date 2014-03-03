package controllers;

import play.mvc.*;
import views.html.*;
import models.*;
import play.data.Form;
import java.util.*;

/**
 * Created by francis on 01/03/14.
 *      Handles User creation and updating
 */

public class Users extends Controller {

    public static final Form<User> userForm = Form.form(User.class);

            //Receives completed form from registration.scala.html, if it hasErrors the form is returned
            //else a new user is created and saved to the database
    public static Result newUser(){
        Form<User> tempForm = userForm.bindFromRequest();
        if (tempForm.hasErrors()){
            return badRequest(registration.render(tempForm));
        }
        User newUser = tempForm.get();
        User.saveOrUpdate(newUser);
        return redirect(routes.Application.index());
    }

    public static Map<String, String> countyOptions() {
        LinkedHashMap<String, String> options = new LinkedHashMap<String, String>();

        for (Address.County county : Address.County.values()) {
            options.put (county.name(), county.text);
        }
        return options;
    }
}
