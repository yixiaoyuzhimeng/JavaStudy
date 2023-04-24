package controller;

import model.Choose;
import service.Service;
import service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/view/teaScoreList")
public class TeaScoreListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sPage = request.getParameter("page");
        int page = (sPage == null || sPage.equals(""))?1:Integer.parseInt(sPage);
        int pageSize = 10;
        request.setAttribute("page", page);
        request.setAttribute("pageSize", pageSize);
        Service service = new ServiceImpl();
        List<Choose> chooseList = service.findPage(page,pageSize);
        request.setAttribute("chooseList", chooseList);
        String sql = "select count(*) from choose";
        int chooseCount = service.getCount(sql);
        request.setAttribute("chooseCount", chooseCount);
        request.setAttribute("chooseCount", chooseCount % pageSize ==0?chooseCount/pageSize:chooseCount/pageSize+1);
        request.getRequestDispatcher("TeaScoreList.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
