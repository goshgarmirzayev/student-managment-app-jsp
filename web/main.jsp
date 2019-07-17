<%-- 
    Document   : main
    Created on : Sep 5, 2018, 4:04:39 PM
    Author     : Goshgar
--%>




<%@page import="bean.Student"%>
<%@page import="service.StudentDatabase"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>StudentManagmentApp</title>
        <meta charset="UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="css/Style.css" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <script>
        function setId(id) {
            document.getElementById("studentIdDelete").value = id;
        }
        function setIdForUpdate(id) {
            document.getElementById("studentIdUpdate").value = id;
            return id;
        }
        function setPropertiesUpdate(name, surname, age) {
            document.getElementById("newName").value = name;
            document.getElementById("newSurname").value = surname;
            document.getElementById("newAge").value = age;
        }
    </script>
    <%
        String action = request.getParameter("action");
        if (action != null && !action.isEmpty()) {
            if (action.equalsIgnoreCase("delete")) {
                String studentId = request.getParameter("studentIdDelete");
                if (studentId != null && !studentId.isEmpty()) {
                    StudentDatabase.delete(Integer.parseInt(studentId));
                }
                response.sendRedirect("main.jsp");
            }
            if (action.equalsIgnoreCase("update")) {
                String studentId = request.getParameter("studentIdUpdate");
                if (studentId != null && !studentId.isEmpty()) {
                    String idStr = request.getParameter("studentIdUpdate");
                    String newname = request.getParameter("newname");
                    String newsurname = request.getParameter("newsurname");
                    String newagestr = request.getParameter("newage");
                    Student s = new Student(Integer.parseInt(idStr), newname, newsurname, Integer.parseInt(newagestr));
                    StudentDatabase.update(s);
                }
            }

        }
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String agestr = request.getParameter("age");

        if (request.getParameter("add") != null) {
            if (name == null && name.equals("") || surname == null && surname.equals("") || agestr == null && agestr.equals("")) {
                response.sendRedirect("main.jsp");
            } else {
                Student s = new Student(name, surname, Integer.parseInt(agestr));
                StudentDatabase.add(s);
                List<Student> students = StudentDatabase.getAll(null, null, null);
            }
          response.sendRedirect("main.jsp");
        }
        Integer age = null;
        if (agestr == "") {
            agestr = "0";
        }
        if (agestr != null && agestr.isEmpty()) {
            age = Integer.parseInt(agestr);
        }
        List<Student> students = StudentDatabase.getAll(name, surname, age);
    %>
    <body>
        <div class="container col-md-12">
            <form style="margin-top: 10px;" class="form-inline mt-2 mt-md-0" role="search" method="GET" action="main.jsp">
                <input class="form-control mr-sm-2" type="text" name="name" placeholder="Search" aria-label="Search"/>
                <input class="btn btn-outline-success my-2 my-sm-0" type="submit" name="search" value="Search"/>
            </form>

            <input style="margin-top: 10px;margin-bottom: 10px;"type="submit"class="btn btn-danger" data-toggle="modal" data-target="#myAddModal"value="Add" />
            <div class="modal fade" id="myAddModal" role="dialog">
                <div class="modal-dialog">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <form class="col-md-8 mx-auto"  action="main.jsp" >
                            <br/>
                            <input class="form-control"type="text" name="name"  placeholder="name">
                            <br/>
                            <input type="text" class="form-control"name="surname"  placeholder="surname">
                            <br/>
                            <input type="number" class="form-control" name="age" placeholder="age">
                            <br/>


                            <div class="modal-footer">

                                <input type="submit"  class="btn btn-primary" name="add" value="Add"/>
                                <button type="button" class="btn btn-default" data-dismiss="modal" >Cancel</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="myUpdateModal" role="dialog">
                <div class="modal-dialog">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <p>Enter new values</p>
                        </div>
                        <form class="form-group" action="main.jsp">
                            <input type="text" name="newname" class="form-control" id="newName"/>
                            <br/>
                            <input type="text" name="newsurname"class="form-control"id="newSurname"/>
                            <br/>
                            <input type="text" name="newage"class="form-control"id="newAge"/>
                            <br/>
                            <div class="modal-footer">
                                <input type="hidden" name="studentIdUpdate" id="studentIdUpdate"/>
                                <input type="hidden" name="action"value="update"/>
                                <input type="submit" class="btn btn-dark "  value="Save"/>
                                <button type="button" class="btn btn-danger" data-dismiss="modal" >Cancel</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <div class="modal fade" id="myDeleteModal" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <form action="">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h1>Delete Student</h1>
                            </div>
                            <div class="modal-body">
                                <p>Are you want to delete this person?</p>
                            </div>
                            <div class="modal-footer">
                                <input type="hidden" name="studentIdDelete" id="studentIdDelete" />
                                <input type="hidden" name="action" value="delete" />
                                <input type="submit" class="btn btn-danger"value="Yes"/>
                                <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
            <table class="table">
                <thead>
                <th class="row">#</th> 
                <th class="row">Name</th> 
                <th class="row">Surname</th> 
                <th class="row">Age</th> 
                <th class="row">Actions</th> 
                </thead>
                <tbody>
                    <%for (int i = 0; i < students.size(); i++) {
                            Student s = students.get(i);
                    %>
                    <tr>
                        <td scope="col"><%=i + 1%></td>
                        <td scope="col"><%=s.getName()%></td>
                        <td scope="col"><%=s.getSurname()%></td>
                        <td scope="col"><%=s.getAge()%></td>
                        <td scope="col">
                            <button type="submit"  class="btn btn-warning" data-toggle="modal" data-target="#myUpdateModal"
                                    onclick="setIdForUpdate('<%=s.getId()%>'), setPropertiesUpdate('<%=s.getName()%>', '<%=s.getSurname()%>', '<%=s.getAge()%>')">Edit</button>
                            <input type="submit"class="btn btn-danger" data-toggle="modal" data-target="#myDeleteModal"value="Delete" onclick="setId('<%=s.getId()%>')" />

                        </td>   
                    </tr>
                    <%}%>
                </tbody>

            </table>
        </div>
    </body>
</html>
