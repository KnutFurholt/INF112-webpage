import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/runjar")
public class RunJarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Process process = Runtime.getRuntime().exec("java -jar xeno.jar");
            process.waitFor();
            response.getWriter().write("JAR file executed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error executing JAR file.");
        }
    }
}
