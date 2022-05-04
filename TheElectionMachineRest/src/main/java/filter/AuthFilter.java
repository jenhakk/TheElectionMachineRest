package filter;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
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

import dao.Daojpa;
import datarest.Admin;

/**
 * Servlet Filter implementation class AuthFilter
 * Servlet for login sessions and filtering pages
 * @author jenna, amanda, ansku
 * Date: May 4-2022
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

	/**
	 * Method for checking if session exists and redirecting to login page if not
	 * @param request
	 * @param response
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 */
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		HttpSession session = request.getSession(true);
		String auth = (String) session.getAttribute("authUser");
		System.out.println(auth);

		// Check if the user is allowed?
		if (!allowUser(auth, request, response)) {
			
			response.sendRedirect("/adminlogin.html");
		} else {
			session.setAttribute("authUser", "ok");
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	/**
	 * Method for checking if session is null or not, gets username and password from login form and calls method compareCredentials() to compare credentials with database
	 * @param auth
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	protected boolean allowUser(String auth, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String user = request.getParameter("username");
		String pass = request.getParameter("passwd");

		if (auth == null) {

			if (user == null && pass == null) {

				response.sendRedirect("/adminlogin.html");
			} else {

				user = request.getParameter("username");
				pass = request.getParameter("passwd");

				boolean match = compareCredentials(user, pass);

				return match;
			}

		} else if (auth != null) {

			return true;

		}

		return false;
	}

	/**
	 * Method for encrypting password from form (taken from course materials)
	 * @param str String value to encrypt
	 * @return encrypted password
	 */
	public static String crypt(String str) {
		if (str == null || str.length() == 0) {
			throw new IllegalArgumentException("String to encript cannot be null or zero length");
		}

		MessageDigest digester;
		try {
			digester = MessageDigest.getInstance("MD5");

			digester.update(str.getBytes());
			byte[] hash = digester.digest();
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < hash.length; i++) {
				if ((0xff & hash[i]) < 0x10) {
					hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
				} else {
					hexString.append(Integer.toHexString(0xFF & hash[i]));
				}
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * Method for getting username and encrypted password from database (with Daojpa) and comparing them with login credentials
	 * @param user
	 * @param pass
	 * @return boolean value of comparison result
	 */
	public boolean compareCredentials(String user, String pass) {

		Admin admin = new Admin();
		admin = Daojpa.getCredentials();
		String uname = admin.getUsername();
		String encrypted = admin.getPassword();
		String encryptedps = crypt(pass);

		System.out.println("username " + uname + " encrypted " + encrypted);

		if (user.equals(uname)) {

			if (encryptedps.equals(encrypted)) {

				System.out.println("Tunnukset ok");
				return true;
			}

		} else {

			System.out.println("userauth on false");
			return false;
		}
		return false;

	}
}
