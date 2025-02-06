import org.example.task2_book.Book;
import org.example.task3_student.Student;
import org.example.task4_point.Point;
import org.example.task5_clock.Clock;
import org.example.task6_car.Car;
import org.junit.jupiter.api.Test;

public class TestsForTasks {
    @Test
    public void book(){
        Book book = new Book();
        book.setName("География");
        book.setAuthor("Волков Антон");
        book.setYear(2021);

        book.display();
    }

    @Test
    public void student(){
        Student student = new Student();
        student.setName("Иванова Мария Олеговна");
        student.setTubNumber("43-РП-6765");
        student.setGpa(4.5);

        student.print();
    }

    @Test
    public void point(){
        Point point = new Point();
        point.setX(0);
        point.setY(0);
        point.getCoordinates();

        point.moveUp(10.8);
        point.moveRight(14.3);
        point.moveLeft(5.1);
        point.moveDown(2);
        point.getCoordinates();
    }

    @Test
    public void clock(){
        Clock clock = new Clock();
        clock.setHours(10);
        clock.setMinutes(10);
        clock.setSeconds(10);
        clock.readTime();
        clock.tick();
        clock.readTime();
    }

    @Test
    public void car(){
        Car car = new Car("VW", "Tiguan", 2022);
        car.getInfoAboutCar();
        car.start();
        car.drive(50);
        car.stop();
    }
}
