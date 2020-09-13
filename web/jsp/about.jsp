<%@ page import="java.util.Calendar" %>
<%@ page import="com.company.Car" %>
<%@include file="header.jsp"%>
<%
    Car car = (Car) request.getAttribute("Car");
    try{//здесь мы генерируем информацию о машине
        out.print("<div class=\"car\">");
        out.print("<img class=\"responsive\" src=\""+car.getImageSrc()+"\" alt=\"\"><br><br>");
        out.print("<br><br>Car Name: <h1>"+car.getCarName()+"</h1><br><br>");
        out.print("Car Model: <p>"+car.getModel()+"</p><br><br>");
        out.print("Description: <div class=\"col\">"+car.getDescription()+"</div><br><br>");
        out.print("Engine: <p>"+car.getEngine()+"</p><br><br>");
        out.print("Color: <p>"+car.getColor().toString()+"</p><br><br>");
        out.print(page.toString());
        out.print("</div>");
    }
    catch (Exception e){
        System.out.println(e);
        throw new Exception("Something wrong at about.jsp");
    }


%>
<div class="footer">
    <form method="post" action="<%=request.getContextPath()%>/Send">
        <input type="submit">
    </form>
</div>
<%@include file="footer.jsp"%>