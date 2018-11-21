package paf;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class EditCake extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        DB db = new DB();
        Cake cake = new Cake();
        if(req.getParameter("Id")!=null){
            cake.setId(Integer.parseInt(req.getParameter("Id")));
            cake.setName(req.getParameter("Name"));
            cake.setCost(req.getParameter("Cost")!=null?Float.parseFloat(req.getParameter("Cost")):0);
            cake.setCount(req.getParameter("Count")!=null?Float.parseFloat(req.getParameter("Count")):0);
            resp.getWriter().write(String.valueOf(db.Update(cake)));
        }
        else {
            resp.getWriter().write("error");
        }


    }
}
