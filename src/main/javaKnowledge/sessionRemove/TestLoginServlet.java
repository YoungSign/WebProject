package sessionRemove;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestLoginServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("user");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        if (obj != null) {
            //登录状态
            out.write("登录状态");
        } else {
            //未登录状态
            out.write("未登录状态");
        }
        out.flush();
        out.close();

    }

}
