package sessionremove;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    private static String LOGINNAME = "admin";
    private static String PWD = "123";

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) {
        String loginName = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        if (LOGINNAME.equals(loginName) && PWD.equals(pwd)) {
            User user = new User();
            user.setLoginName(loginName);
            user.setPwd(pwd);

            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            //获得之前session
            HttpSession preSession = Data.table.get(loginName);
            if (preSession != null) {
                try {
                    preSession.invalidate();//销毁session
                } catch (Exception e) {
                    System.out.println("已经被销毁");
                }

            }
            //存帐号和当前session的对应关系
            Data.table.put(loginName, session);

        } else {
            System.out.println("帐号或密码错误");
        }

    }

}
