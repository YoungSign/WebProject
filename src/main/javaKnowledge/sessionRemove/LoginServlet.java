package sessionRemove;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) {
        String loginName = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        if ("admin".equals(loginName) && "123".equals(pwd)) {
            User user = new User();
            user.setLoginName(loginName);
            user.setPwd(pwd);

            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            HttpSession preSession = Data.table.get(loginName);//获得之前session
            if (preSession != null) {
                try {
                    preSession.invalidate();//销毁session
                } catch (Exception e) {
                    System.out.println("已经被销毁");
                }

            }

            Data.table.put(loginName, session);//存帐号和当前session的对应关系

        } else {
            System.out.println("帐号或密码错误");
        }

    }

}
