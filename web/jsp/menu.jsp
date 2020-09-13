<%@ page import="java.util.ArrayList" %>
<%@ page import="com.company.Car" %>
<%@ page import="java.io.Writer" %>
<%@ page import="java.io.PrintWriter" %>
<%@include file="header.jsp"%>
<div class="all">
    <form method="POST" action="<%=request.getContextPath()%>/AdvancedJava">
    <%
        PrintWriter writer =response.getWriter();
        ArrayList<Car> cars = (ArrayList<Car>) request.getAttribute("Cars");//Здесь смы принимаем аррей
        // лист из обьектов
        try {// there we generating info about car
            for(int i=0;i<cars.size();i++){

                out.print("<div class=\"cars\">");
                out.print("<img class=\"responsive\" src=\""+cars.get(i).getImageSrc()+"\" alt=\"\"><br><br>");
                out.print("<br><br>Car Name: <h1>"+cars.get(i).getCarName()+"</h1><br><br>");
                out.print("Car Model: <p>"+cars.get(i).getModel()+"</p><br><br>");
                //out.print("Description: <div class=\"col\">"+cars.get(i).getDescription()+"</div><br><br>");
                //out.print("Engine: <p>"+cars.get(i).getEngine()+"</p><br><br>");
                //out.print("Color: <p>"+cars.get(i).getColor().toString()+"</p><br><br>");
                out.print("<input type=\"radio\"  name=\"carid\" value=\""+cars.get(i).getCarId()+"\">\n");
                out.print("</div>");
            }
        }
        catch (Exception e){
            System.out.println(e);
            throw new Exception("Something wrong at menu.jsp");
        }
     %>
        <%=application.getInitParameter("IDE")%>
        <div class="footer">
            <input type="submit">
        </div>
    </form>
</div>
<%@include file="footer.jsp"%>