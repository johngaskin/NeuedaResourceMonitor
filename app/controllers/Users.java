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

    public static Result register(){
        return ok(registration.render(userForm));
    }

            //Receives completed form from registration.scala.html, if it hasErrors the form is returned
            //else a new user is created and saved to the database
    public static Result newUser(){
        Form<User> tempForm = userForm.bindFromRequest();
        if (tempForm.hasErrors()){
            return badRequest(registration.render(tempForm));
        }
        User newUser = tempForm.get();
        User.saveOrUpdate(newUser);
        return ok(routes.Application.index());
    }
}
