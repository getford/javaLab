import car.Car;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//@WebServlet(name = "selectCars", urlPatterns = "/selectCars")
public class GetCars extends HttpServlet {
    private static final Logger log = Logger.getLogger(GetCars.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            selectAllCars(request, response);
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
            selectAllCars(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selectAllCars(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        LoginController loginController = new LoginController();
        request.setCharacterEncoding("UTF-8");
        Connect connect = new Connect();

        String login = request.getParameter("login");

        Statement statement = connect.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT id, name_auto, model, take FROM auto");

        ArrayList<Car> arrayList = new ArrayList<Car>();
        ArrayList<Car> arrayFreeList = new ArrayList<Car>();
        ArrayList<Car> arrayTakeList = new ArrayList<Car>();
        while (resultSet.next()) {
            arrayList.add(new Car(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4)));
            if (resultSet.getInt(4) == 0) {
                arrayFreeList.add(new Car(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
            }
            if (resultSet.getInt(4) == 1) {
                arrayTakeList.add(new Car(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
            }
        }
        request.setAttribute("arrListCar", arrayList);
        request.setAttribute("arrFreeListCar", arrayFreeList);
        request.setAttribute("arrTakeListCar", arrayTakeList);

        HttpSession session = request.getSession();

        if (session.getAttribute("acc").equals("user")) {
            request.getRequestDispatcher("/userPage.jsp").forward(request, response);
            System.out.println("Получен список автомобилей");
            connect.closeConnect();
        }
        if (session.getAttribute("acc").equals("admin")) {
            request.getRequestDispatcher("/adminPage.jsp").forward(request, response);
            System.out.println("Получен список автомобилей");
            connect.closeConnect();
        }
    }
}
