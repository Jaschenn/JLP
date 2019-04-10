package dataServlet;

import Hibernate.DataEntity;
import Hibernate.HiberDao;
import com.alibaba.fastjson.JSON;
import plug.Tree;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebServlet("/servlet")
public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String name = request.getParameter("method");
        HiberDao hiberDao = new HiberDao();
        response.setCharacterEncoding("utf-8");
        PrintWriter printWriter = response.getWriter();
        if (name.equals("test")){
            String result = hiberDao.getAllInfoJSON();
            printWriter.write(result);
            printWriter.flush();
        }

        if (name.equals("getDetail")){
            String title_name = request.getParameter("title_name");
            System.out.println(title_name);
            DataEntity dataEntity = hiberDao.getDetail(title_name);
            printWriter.write(JSON.toJSONString(dataEntity));
            System.out.println(JSON.toJSONString(dataEntity));
            printWriter.flush();
        }

        if(name.equals("getTree")){
            Set<Tree> trees = hiberDao.getTreeInfo();
            printWriter.write(JSON.toJSONString(trees).replaceAll("\"nodes\"","nodes").replaceAll("\"text\"","text"));
            System.out.println(JSON.toJSONString(trees).replaceAll("\"nodes\"","nodes").replaceAll("\"text\"","text"));
            printWriter.flush();
        }
    }
}
