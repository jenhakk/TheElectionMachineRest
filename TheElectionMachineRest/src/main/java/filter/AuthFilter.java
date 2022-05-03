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

		System.out.println("allowuser");

		String user = request.getParameter("username");
		String pass = request.getParameter("passwd");

		System.out.println("lomakkeelta" + user + pass);

		if (auth == null) {

			if (user == null && pass == null) {

				response.sendRedirect("/adminlogin.html");
			} else {

				user = request.getParameter("username");
				pass = request.getParameter("passwd");
				
				System.out.println("ifissä" + user + pass);

				boolean match = compareCredentials(user, pass);
				System.out.println("auth == null");

				return match;
			}

		} else if (auth != null) {

			return true;

		}

		return false;
	}

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
