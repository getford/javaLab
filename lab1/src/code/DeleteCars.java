import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteCars extends HttpServlet {
    private static final Logger log = Logger.getLogger(AdminServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            delAuto(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            delAuto(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void delAuto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {

        request.setCharacterEncoding("UTF-8");

        Connect connect = new Connect();
        PreparedStatement preparedStatement;

        String id = request.getParameter("id_car");
        String query = "DELETE FROM auto WHERE id =" + id;

        preparedStatement = connect.getConnection().prepareStatement(query);
        preparedStatement.execute();
        log.info("Автомобиль удален из базы. ID автомобиля: " + id + ".");
        request.getRequestDispatcher("/GetCars").forward(request, response);
    }
}
