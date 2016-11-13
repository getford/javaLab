import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//@WebServlet(name = "LoginController", urlPatterns = "/LoginController")
public class LoginController extends HttpServlet {
    private static final Logger log = Logger.getLogger(LoginController.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            login(request, response);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       /* try {
            login(request, response);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }*/
    }

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {

        HttpSession session = request.getSession();

        request.setCharacterEncoding("UTF-8");
        Connect connect = new Connect();
        System.out.println("Попытка авторизации");

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        PreparedStatement statement = connect.getConnection().prepareStatement("SELECT * FROM auth WHERE login like ?");

        statement.setString(1, login);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String lgn = resultSet.getString(2);
            String psw = resultSet.getString(3);
            if (lgn.equals(login) && psw.equals(password)) {
                if (lgn.equals("admin")) {
                    session.setAttribute("acc", lgn);
                    GetCars cars = new GetCars();
                    cars.selectAllCars(request, response);
                    statement.close();
                    connect.closeConnect();
                    log.info("Выполнен вход под Admin");
                    System.out.println("Выполнен вход под Admin");
                }
                if (lgn.equals("user")) {
                    session.setAttribute("acc", lgn);
                    GetCars cars = new GetCars();
                    cars.selectAllCars(request, response);
                    statement.close();
                    connect.closeConnect();
                    log.info("Выполнен вход под User");
                    System.out.println("Выполнен вход под User");
                }
            } else {
                log.error("Ошибка авторизации");
                log.error("Неверный логин или пароль");
                System.out.println("Ошибка авторизации");
                System.out.println("Неверный логин или пароль");
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
        }
    }
}
