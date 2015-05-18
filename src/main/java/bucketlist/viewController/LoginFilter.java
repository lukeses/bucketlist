/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.viewController;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Klasa filtrująca dostęp do zabezpieczonych stron.
 * Zapobiega nieautoryzowanemu dostępowi do stron użytkoników.
 * @author AdamS
 */
public class LoginFilter implements Filter {

    /**
     * Implementacja abstrakcyjnej metody init.
     * @param fc obiekt FilterConfig
     * @throws ServletException wyjątek inicjalizacji
     */
    @Override
    public void init(FilterConfig fc) throws ServletException {
    }

    /**
     * Metoda filtrująca żądania dostępu
     * @param request żądanie dostępu
     * @param response odpowiedź serwera
     * @param chain obiekt klasy filtrującej
     * @throws IOException wyjątek IO
     * @throws ServletException wyjątek servletu
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LoginController login = (LoginController) ((HttpServletRequest) request).getSession().getAttribute("loginController");

        if (login == null || !login.isLoggedIn()) {
            String contextPath = ((HttpServletRequest) request).getContextPath();
            ((HttpServletResponse) response).sendRedirect(contextPath + "/logpanel.xhtml");
        }
        chain.doFilter(request, response);
    }

    /**
     * Implementacja abstrakcyjnej metody destroy
     */
    @Override
    public void destroy() {
    }

}
