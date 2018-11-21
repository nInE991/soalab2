package paf;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteCake extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        DB db = new DB();
        int id = (req.getParameter("Id")!=null?Integer.parseInt(req.getParameter("Id")):0);
        resp.getWriter().write(String.valueOf(db.Delete(id)));
    }
}
