import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

//@WebServlet(name = "AdminServlet", urlPatterns = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(AdminServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            addAutos(request, response);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            addAutos(request, response);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void addAutos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        request.setCharacterEncoding("UTF-8");

        String mark = request.getParameter("marka");
        String model = request.getParameter("model");

        Connect connect = new Connect();
        Statement statement = connect.getConnection().createStatement();

        String queryAdd = "INSERT INTO auto (name_auto, model, take) VALUES ('" + mark + "','" + model + "'," + 0 + ")";
        log.info("Автомобиль " + mark + " " + model + " добавлен!");
        statement.executeUpdate(queryAdd);
        connect.closeConnect();
        request.getRequestDispatcher("/GetCars").forward(request, response);
    }
}