package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import bean.Student;
import service.StudentDatabase;
import java.util.List;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>StudentManagmentApp</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/Style.css\" >\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <script>\n");
      out.write("        function setId(id) {\n");
      out.write("            document.getElementById(\"studentIdDelete\").value = id;\n");
      out.write("        }\n");
      out.write("        function setIdForUpdate(id) {\n");
      out.write("            document.getElementById(\"studentIdUpdate\").value = id;\n");
      out.write("            return id;\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("    ");

        String action = request.getParameter("action");
        if (action != null && !action.isEmpty()) {
            if (action.equalsIgnoreCase("delete")) {
                String studentId = request.getParameter("studentIdDelete");
                if (studentId != null && !studentId.isEmpty()) {
                    StudentDatabase.delete(Integer.parseInt(studentId));
                }
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

        }
        Integer age = null;
        if (agestr == "") {
            agestr = "0";
        }
        if (agestr != null && agestr.isEmpty()) {
            age = Integer.parseInt(agestr);
        }
        List<Student> students = StudentDatabase.getAll(name, surname, age);

    
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <form class=\"col-md-3\"  action=\"main.jsp\" >\n");
      out.write("                <br/>\n");
      out.write("                <input class=\"form-control\"type=\"text\" name=\"name\"  placeholder=\"name\">\n");
      out.write("                <br/>\n");
      out.write("                <input type=\"text\" class=\"form-control\"name=\"surname\"  placeholder=\"surname\">\n");
      out.write("                <br/>\n");
      out.write("                <input type=\"number\" class=\"form-control\" name=\"age\" placeholder=\"age\">\n");
      out.write("                <br/>\n");
      out.write("                <input type=\"submit\"  class=\"btn btn-primary\" name=\"add\" value=\"Add\"/>\n");
      out.write("                <input type=\"submit\" class=\"btn btn-primary\" name=\"search\" value=\"Search\"/>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("            <br/>\n");
      out.write("\n");
      out.write("            <div class=\"modal fade\" id=\"myDeleteModal\" role=\"dialog\">\n");
      out.write("                <div class=\"modal-dialog\">\n");
      out.write("\n");
      out.write("                    <!-- Modal content-->\n");
      out.write("                    <div class=\"modal-content\">\n");
      out.write("                        <form action=\"\">\n");
      out.write("                            <div class=\"modal-header\">\n");
      out.write("                                <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                                <h1>Delete Student</h1>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"modal-body\">\n");
      out.write("                                <p>Are you want to delete this person?</p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"modal-footer\">\n");
      out.write("                                <input type=\"hidden\" name=\"studentIdDelete\" id=\"studentIdDelete\" />\n");
      out.write("                                <input type=\"hidden\" name=\"action\" value=\"delete\" />\n");
      out.write("                                <input type=\"submit\" class=\"btn btn-danger\"value=\"Yes\"/>\n");
      out.write("                                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">No</button>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal fade\" id=\"myUpdateModal\" role=\"dialog\">\n");
      out.write("                <div class=\"modal-dialog\">\n");
      out.write("\n");
      out.write("                    <!-- Modal content-->\n");
      out.write("                    <div class=\"modal-content\">\n");
      out.write("                        <div class=\"modal-header\">\n");
      out.write("                            <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                            <h1>Update Student</h1>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <form class=\"form-group\" action=\"main.jsp\">\n");
      out.write("                            <p>Enter new values</p>\n");
      out.write("                            <input type=\"text\" name=\"newname\"class=\"form-control\" placeholder=\"newname\"/>\n");
      out.write("                            <br/>\n");
      out.write("                            <input type=\"text\" name=\"newsurname\"class=\"form-control\"placeholder=\"newsurnmae\"/>\n");
      out.write("                            <br/>\n");
      out.write("                            <input type=\"text\" name=\"newage\"class=\"form-control\"placeholder=\"newage\"/>\n");
      out.write("                            <br/>\n");
      out.write("                            <div class=\"modal-footer\">\n");
      out.write("                                <input type=\"hidden\" name=\"studentIdUpdate\" id=\"studentIdUpdate\"/>\n");
      out.write("                                <input type=\"hidden\" name=\"action\"value=\"update\"/>\n");
      out.write("                                <input type=\"submit\" class=\"btn btn-dark \"  value=\"Save\"/>\n");
      out.write("                                <button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\" >Cancel</button>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <table class=\" table table-dark\">\n");
      out.write("                <thead>\n");
      out.write("                <th>#</th> \n");
      out.write("                <th>Name</th> \n");
      out.write("                <th>Surname</th> \n");
      out.write("                <th>Age</th> \n");
      out.write("                <th>Actions</th> \n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");
for (int i = 0; i < students.size(); i++) {
                            Student s = students.get(i);
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print(i + 1);
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(s.getName());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(s.getSurname());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(s.getAge());
      out.write("</td>\n");
      out.write("                        <td>\n");
      out.write("                            <input type=\"submit\"  class=\"btn btn-secondary\" data-toggle=\"modal\" data-target=\"#myUpdateModal\" value=\"Edit\"\n");
      out.write("                                   onclick=\"setIdForUpdate('");
      out.print(s.getId());
      out.write("')\"/>\n");
      out.write("                            <input type=\"submit\"class=\"btn btn-danger\" data-toggle=\"modal\" data-target=\"#myDeleteModal\"value=\"Delete\" onclick=\"setId('");
      out.print(s.getId());
      out.write("')\" />\n");
      out.write("\n");
      out.write("                        </td>   \n");
      out.write("                    </tr>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
