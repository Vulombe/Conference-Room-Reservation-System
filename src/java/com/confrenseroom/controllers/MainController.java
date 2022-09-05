package com.confrenseroom.controllers;

import com.confrenseroom.model.Employee;
import com.confrenseroom.model.Equipment;
import com.confrenseroom.model.Meeting;
import com.confrenseroom.model.Room;
import com.confrenseroom.model.Status;
import com.confrenseroom.service.CRUDService;
import com.confrenseroom.service.impl.EmServiceImpl;
import com.confrenseroom.service.impl.EqServiceImpl;
import com.confrenseroom.service.impl.MtServiceImpl;
import com.confrenseroom.service.impl.RmServiceImpl;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import static java.util.stream.Collectors.toList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.RandomStringUtils;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class MainController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CRUDService<Meeting> mtCrudobj = new MtServiceImpl();
        RmServiceImpl rmCrudobj = new RmServiceImpl();
        CRUDService<Equipment> eqCrudobj = new EqServiceImpl();
        CRUDService<Employee> emCrudobj = new EmServiceImpl();
        RequestDispatcher dispatcher;

        String pro = request.getParameter("probe");
        if (pro != null) {
            if (pro.equalsIgnoreCase("reserve")) {
                String fullname = request.getParameter("fullname");
                String title = request.getParameter("titlelist");
                String dept = request.getParameter("dept");
                String cell = request.getParameter("cell");
                String id = RandomStringUtils.random(5, false, true);
                Employee emp = new Employee(id, fullname, title, dept, cell);
                boolean createEmp = emCrudobj.create(emp);
                Employee emp2 = null;

                if (createEmp) {
                    emp2 = emCrudobj.readById(emp);
                    List<Room> available = rmCrudobj.getAll()
                            .stream()
                            .filter(room -> room.getStatus().equals(Status.AVAILABLE))
                            .collect(toList());

                    Room first = available.get(0);
                    int attendies = Integer.parseInt(request.getParameter("attendies"));
                    String stringDate = request.getParameter("mtday");
                    String stringStime = request.getParameter("mtstime");
                    String stringSEtime = request.getParameter("mtetime");
                    LocalDate mtdate = LocalDate.parse(stringDate);
                    LocalTime mtStime = LocalTime.parse(stringStime);
                    LocalTime mtEtime = LocalTime.parse(stringSEtime);
                    Meeting met = new Meeting(mtdate, mtStime, mtEtime, attendies, first.getRoomID(), emp2.getEmpID());
                    boolean createM = mtCrudobj.create(met);
                    if (createM) {
                        request.setAttribute("met", met);
                        first.setStatus(Status.NOTAVAILABLE);
                        rmCrudobj.update(first);
                        dispatcher = request.getRequestDispatcher("roommanager.jsp");
                    } else {
                        dispatcher = request.getRequestDispatcher("error.jsp");
                    }
                    dispatcher.forward(request, response);
                }

            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
