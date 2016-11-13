import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public class UserAddCars extends HttpServlet {
    private static final Logger log = Logger.getLogger(UserAddCars.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            addCar(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            addCar(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void addCar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        request.setCharacterEncoding("UTF-8");

        String tmp = request.getParameter("id_auto");

        String query = "UPDATE auto SET take = 1 WHERE id = " + tmp;

        Connect connect = new Connect();

        Statement statement = connect.getConnection().createStatement();
        statement.execute(query);

        statement.close();
        connect.closeConnect();

        request.setAttribute("addSuccess", "done");
        log.info("Пользователь взял в прокат автомобиль. ID автомобиля: " + tmp + ".");
        request.getRequestDispatcher("/GetCars").forward(request, response);
    }
}
