


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/NewConnHandlerPage")
public class NewConnHandlerPage extends HttpServlet
{

    public NewConnHandlerPage()
    {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {  
    	
           request.getRequestDispatcher("/WEB-INF/jsp/newConn1.jsp").forward(request, response);
    }

    private static final long serialVersionUID = 1L;
}
