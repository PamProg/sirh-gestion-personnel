package dev.sgp.filtre;

import java.io.IOException;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.VisiteWebService;

@WebFilter(urlPatterns = {"/*"}, description = "Visite timer filter")
public class FrequentationFilter implements Filter {

	@Inject private VisiteWebService visiteService;
	private FilterConfig config = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
		config.getServletContext().log("Visite !");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long before = System.currentTimeMillis();
		chain.doFilter(request, response);
		long after = System.currentTimeMillis();
		String path = ((HttpServletRequest) request).getRequestURI();
		visiteService.sauvegarderVisite(new VisiteWeb(UUID.randomUUID().hashCode(), path, (int) (after - before)));
	}

	@Override
	public void destroy() {
		
	}

}
