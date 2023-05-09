package client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import data.celebration;

@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/getonecelebration"}
)
public class GetOneCelebration extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {

	    response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	    PrintWriter out=response.getWriter();
		String uri = "http://127.0.0.1:8080/rest/dogservice/getdog/3";
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		Dog d=b.get(Dog.class);
		String s=b.get(String.class);
		out.println("Object: "+d);
		out.println("JSON: "+s);
  }
}