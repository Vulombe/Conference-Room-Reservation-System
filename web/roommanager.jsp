<%-- 
    Document   : roommanager
    Created on : 03 Sep 2022, 4:20:29 AM
    Author     : MCDAVE MAKHUBELE
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="com.confrenseroom.model.Status"%>
<%@page import="com.confrenseroom.service.impl.RmServiceImpl"%>
<%@page import="com.confrenseroom.service.impl.EmServiceImpl"%>
<%@page import="com.confrenseroom.service.CRUDService"%>
<%@page import="com.confrenseroom.model.Room"%>
<%@page import="java.util.List"%>
<%@page import="com.confrenseroom.model.Employee"%>
<%@page import="com.confrenseroom.model.Meeting"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="custom.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css" integrity="sha512-mSYUmp1HYZDFaVKK//63EcZq4iFWFjxSL+Z3T/aCt4IO9Cejm03q3NKKYN6pFQzY0SBOr8h+eCIAZHPXcpZaNw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-timepicker/0.5.2/css/bootstrap-timepicker.css" integrity="sha512-E4kKreeYBpruCG4YNe4A/jIj3ZoPdpWhWgj9qwrr19ui84pU5gvNafQZKyghqpFIHHE4ELK7L9bqAv7wfIXULQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />


        <title>JSP Page</title>
    </head>
    <body>

        <nav class="navbar navbar-expand-lg bg-dark navbar-dark">

            <a href="#">
                <img src="img/l3.jpg " class="rounded-circle" alt="" width="35" height="35">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            Our Services
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Reserve Room</a>
                            <a class="dropdown-item" href="#">Room Manager</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">About Us</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link " href="#">Contact Us</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
        <!-- Section -->
        <section class="bg-light text-dark p-3 p-lg-3 pt-lg-3 text-center">
            <div class="container">
                <div class="align-items-center ">
                    <h2>
                        Room Confrence Reservation System.
                    </h2>
                    <img class="img-fluid w-1 rounded-circle" src="img/3.jpg" alt="">
                </div>
        </section>
        <section class="bg-info text-light p-5 p-lg-5 pt-lg-5 text-center">
            <div class="row">
                <div class="col-sm-6">
                    <table class="table table-responsive" >
                        <% Employee emp = (Employee) request.getAttribute("emp");
                            Meeting met = (Meeting) request.getAttribute("met");%>
                        <thead>
                            <tr>
                                <th>
                                    Meeting Holder
                                </th>
                                <th>
                                    Meeting Date
                                </th>
                                <th>
                                    Start Time
                                </th>
                                <th>
                                    End Time
                                </th>
                                <th>
                                    Number of Attendies
                                </th>
                            </tr></thead>
                        <tr>
                            <%
                                out.print("<td>" + emp.getFullName() + " </td>");
                                out.print("<td>" + met.getDate() + " </td>");
                                out.print("<td>" + met.getStartTime() + " </td>");
                                out.print("<td>" + met.getEndTime() + " </td>");
                                out.print("<td>" + met.getAttendies() + " </td>");
                            %>
                        </tr>
                    </table>
                </div>
                <div class="col-sm-5">
                    <table class="table table-responsive" >

                        <thead>
                            <tr>
                                <th>
                                    Room Name
                                </th>
                                <th>
                                    Room Capacity
                                </th>
                                <th>
                                    Room Status
                                </th>

                            </tr></thead>
                            <%
                                CRUDService<Room> roomCrud = new RmServiceImpl();
                                List<Room> rooms = (ArrayList) roomCrud.getAll();
                                
                                for (Room roomr : rooms) {
                                    if(roomr.getStatus().equals(Status.AVAILABLE)){
                                    out.print("<tr>");
                                    out.print("<td>" + roomr.getRoomName() + " </td>");
                                    out.print("<td>" + roomr.getCapacity() + " </td>");
                                    out.print("<td>" + roomr.getStatus() + " </td>");
                                    out.print("<tr>");
                                }
                                }
                            %>
                       
                    </table>
                </div>
            </div>
        </section>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
                integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
                integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
                integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
    </body>
</html>
