package fr.tp.isima.BurgerQueen.presentation;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.tp.isima.BurgerQueen.common.ApplicationsObjects;

@WebListener
public class AppInit implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		final ApplicationsObjects appObjects = ApplicationsObjects.loadAll();

		sce.getServletContext().setAttribute("app-objects", appObjects);
		sce.getServletContext().setInitParameter("javax.faces.INTERPRET_EMPTY_STRING_SUBMITTED_VALUES_AS_NULL", "true");
	}

}
