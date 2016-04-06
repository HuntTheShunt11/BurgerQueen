package fr.tp.isima.BurgerQueen.presentation.burger;

import static fr.tp.isima.BurgerQueen.presentation.ErrorFields.newErrorBuilder;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.validation.ConstraintViolationException;
import fr.tp.isima.BurgerQueen.persistence.UniqueConstraintException;
import fr.tp.isima.BurgerQueen.presentation.ErrorFields;
import fr.tp.isima.BurgerQueen.presentation.Form;
import fr.tp.isima.BurgerQueen.business.User;
import fr.tp.isima.BurgerQueen.presentation.Page;


@WebServlet("/connection")
public class ConnectionServlet extends BurgersServlet {

	@Override
	protected Page process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		final HttpSession session = req.getSession();

        if (session == null || session.getAttribute("user") == null) {
            final String name = req.getParameter("pseudo");
            
            
            User user = findUserByName(name);

            if (user == null) {
            	user = getUsers().createUser();
            	user.setNom(name);
            	try{
            		user.save();
            	} catch (final ConstraintViolationException e) {
                    return returnToConnectionPage(user, newErrorBuilder().addErrorWithUniqueContraintException(e).build());
                } catch (final UniqueConstraintException e) {
                    return returnToConnectionPage(user, newErrorBuilder().addErrorWithUniqueContraintException(e).build());
                }
            }
        }

		return redirectOnListBurgers(req).build();
		
		
	}
	
	 private Page returnToConnectionPage(User user, ErrorFields fields) {
		 	final UserViewBean useViewBean = new UserViewBean(user);
	        final Form<UserViewBean> form = new Form<UserViewBean>(useViewBean, fields);

	        return forwardOnConnection().withForm(form).build();
	}

	private User findUserByName(String name) {
	        if (name != null) {
	            return getUsers().findUserByName(name);
	        }
	        return null;
	    }
}