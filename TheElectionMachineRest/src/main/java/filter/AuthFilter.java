package filter;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE,
		DispatcherType.ERROR }, urlPatterns = { "/jsp/adminhome.jsp", "/jsp/adminbrowse.jsp", "/jsp/adminviewcand.jsp",
				"/jsp/addcandidate.jsp", "/jsp/addquestion.jsp", "/jsp/browsequestions.jsp", "/jsp/editcandidate.jsp",
				"/jsp/editquestion.jsp", "/rest/Rest.java" }) // Which URI's come through this filter
public class AuthFilter implements Filter {

	public AuthFilter() {
	}

	public void destroy() {
	}

	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		doFilter((HttpServletRequest) request, (HttpServletResponse) response, chain);
	}

	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/*
		 * Getting the Authorization string from the request header. It looks like:
		 * Basic aGtqaGtqaGtqOg== Starting with Basic and the crypted part is crypted
		 * version of pattern someuser:somepassword
		 */
		HttpSession session = request.getSession(true);
		String auth = (String) session.getAttribute("authUser");
		System.out.println(auth);

		// Check if the user is allowed?
		if (!allowUser(auth, request, response)) {
			// The client (browser) is not allowed, so report the situation to the browser
			System.out.println("allowuser !");
			response.sendRedirect("/adminlogin.html");
		} else {
			// The client is allowed to forward the request to the URI "/sercretservlet"
			System.out.println("else");
			session.setAttribute("authUser", "ok");
			chain.doFilter(request, response);
			System.out.println("else 2");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	protected boolean allowUser(String auth, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String user = request.getParameter("username");
		String pass = request.getParameter("passwd");
		System.out.println(user + pass);

		if (auth == null) {
			System.out.println("auth == null");

			String uname = "admin";
			String passwd = "password";

			if (uname.equals(user) && pass.equals(passwd)) {

				System.out.println("Tunnukset ok");

				
				return true;

			} else {

				System.out.println("userauth on false");
				return false;
			}
		} else if (auth != null) {
			
			return true;
			
		}
		
		return false;
	}

	@POST
	@Consumes("application/x-www-form-urlencoded")
	public void checkUser(@FormParam("username") String username, @FormParam("passwd") String passwd,
			HttpServletResponse response) {
		System.out.println("ollaanko checkuser");
		boolean userauth = false;
		String uname = "admin";
		String pass = "password";

		if (uname.equals(username) && pass.equals(passwd)) {

			System.out.println("Tunnukset ok");
			userauth = true;
			try {
				response.sendRedirect("/jsp/adminhome.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			userauth = false;
			System.out.println("userauth on false");
			try {
				response.sendRedirect("/adminlogin.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
