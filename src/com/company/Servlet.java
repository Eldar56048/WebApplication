package com.company;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Servlet extends HttpServlet {
    public ArrayList<Car> imitateDB(){//вот этот метод имитирует базы данных создает лист из обьектов и запольняет
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car.CarBuilder(1,"Nissan","Qashqai")
                .withYear(2012)
                .withColor(Color.BLUE)
                .withDescription("Технологии Nissan Intelligent Mobility меняют привычное представление о движении, вождении и интеграции автомобиля в повседневную жизнь. Nissan Qashqai — это совершенное воплощение Nissan Intelligent Mobility. От интеллектуальной системы помощи при парковке до интеллектуальной системы экстренного торможения — Nissan Qashqai буквально соткан из технологий, обеспечивающих ваш комфорт и спокойствие за рулем.")
                .withEngine(1.7)
                .withImage("https://www-europe.nissan-cdn.net/content/dam/Nissan/ru/vehicles/qashqai/MC18/Overview/black-thingy-3.png.ximg.l_full_m.smart.png")
                .build());
        cars.add(new Car.CarBuilder(2,"Audi","A8")
                .withYear(2015)
                .withColor(Color.WHITE)
                .withDescription("Выпуск автомобилей представительского класса под маркой Audi начался в 1979 году. Первым из них стал Audi 200 (Typ 43), базировавшийся на платформе Audi 100 C2. В 1983 году в качестве люксовой версии нового Audi 100 C3 был выпущен Audi 200 Typ 44[1]. В 1988 году Audi V8 стал первой самостоятельной моделью представительского класса. Тем не менее, и он, несмотря на новую с технической точки зрения конструкцию, базировался на платформе Audi 100[2]. С этим связан ряд конструктивных особенностей, обусловивших, в частности, недостаток простора и комфорта. Три первые модели привлекли к себе внимание, в первую очередь, благодаря полному приводу quattro. Значительная часть его технических компонентов применялась также в модели Volkswagen Phaeton.")
                .withEngine(2.0)
                .withImage("https://cdn.motor1.com/images/mgl/PKl7y/s1/audi-a8-with-predictive-active-suspension.jpg")
                .build());
        return cars;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int carid = Integer.parseInt(req.getParameter("carid"));//вот здесь мы принимаем кар ид
        ArrayList<Car> cars = imitateDB();//заполняем лист
        Car car=null;
        for(int i=0;i<cars.size();i++){
            if(cars.get(i).getCarId()==carid) {//находим информацию о машине
                car = cars.get(i);
                break;
            }
        }
        req.setAttribute("Car",car);//заполняем аттрибут
        req.getRequestDispatcher("/jsp/about.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Car> cars = imitateDB();//заполняем лист
        req.setAttribute("Cars",cars);//заполняем аттрибут
        req.getRequestDispatcher("/jsp/menu.jsp").forward(req, resp);
    }
}
