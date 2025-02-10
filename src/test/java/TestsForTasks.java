import org.example.task10_tasks.Task;
import org.example.task10_tasks.TaskManager;
import org.example.task11_musicLibrary.MusicLibrary;
import org.example.task11_musicLibrary.MusicTrack;
import org.example.task2_book.Book;
import org.example.task3_student.Student;
import org.example.task4_point.Point;
import org.example.task5_clock.Clock;
import org.example.task6_car.Car;
import org.example.task7_student2.StudentManager;
import org.example.task7_student2.Student2;
import org.example.task8_book2.Book2;
import org.example.task8_book2.BookCollection;
import org.example.task9_products.PriceList;
import org.example.task9_products.Product;
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

    //Управление списком студентов
    @Test
    public void students(){
        //если id не меняется
        Student2 student1 = new Student2("Olga", "1");
        Student2 student2 = new Student2("Katya", "2");
        Student2 student3 = new Student2("Nik", "3");
        Student2 student0 = new Student2();
        Student2 student4 = new Student2("Mia");

        System.out.println(student0.toString());
        System.out.println(student1);
        System.out.println(student4);

        StudentManager studentManager = new StudentManager();
        studentManager.addStudent(student1);
        studentManager.addStudent(student2);
        studentManager.addStudent(student3);
        studentManager.addStudent(student0);
        studentManager.addStudent(student4);
        System.out.println(studentManager.getStudentsList());

        studentManager.removeStudent(student2);
        studentManager.removeStudent("id_Mia");
        System.out.println(studentManager.getStudentsList());
    }

    //Уникальный набор книг
    @Test
    public void books(){
        Book2 book1 = new Book2("Title1", "Author1");
        Book2 book2 = new Book2("Title2", "Author2");
        Book2 book3 = new Book2("Title3", "Author3");

        System.out.println("Добавление книг в коллекцию");
        BookCollection bookCollection = new BookCollection();
        bookCollection.addBook(book1);
        bookCollection.addBook(book2);
        bookCollection.addBook(book3);
        bookCollection.addBook(book2);
        System.out.println(bookCollection.getBooks());

        System.out.println("Удаление книги из коллекции");
        bookCollection.removeBook(book1);
        System.out.println(bookCollection.getBooks());

        System.out.println("Проверка наличия книги в коллекции");
        bookCollection.checkBooks(book1);
    }

    //Отображение товаров и их цен
    @Test
    public void products(){
        Product product1 = new Product("Product1", 100);
        Product product2 = new Product("Product2", 200);
        Product product3 = new Product("Product3", 30.23);
        Product product4 = new Product("Product1", 120);

        //добавление продуктов в список
        PriceList priceList = new PriceList();
        priceList.addNewProduct(product1);
        priceList.addNewProduct(product2);
        priceList.addNewProduct(product3);
        System.out.println(priceList.getPriceList());

        //изменение цены продукта
        priceList.changePrice(product4);
        System.out.println(priceList.getPriceList());

        //получение цены товара по его наименованию
        System.out.println("Цена продукта = " + priceList.getPrice(product1));
    }

    //Список дел с приоритетами
    @Test
    public void tasks(){
        Task task1 = new Task("Task1", 3);
        Task task2 = new Task("Task2", 1);
        Task task3 = new Task("Task3", 3);
        Task task4 = new Task("Task4", 5);
        Task task5 = new Task("Task5");

        //добавление задач в список
        TaskManager taskManager = new TaskManager();
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);
        taskManager.addTask(task4);
        taskManager.addTask(task5);
        System.out.println(taskManager.getTasks());

        //удаление задачи из списка
        taskManager.removeTask(task3);
        System.out.println(taskManager.getTasks());

        //получение списка задач с сортировкой
        taskManager.sortTasksList();
    }

    //Каталог музыкальных треков
    @Test
    public void musicLibrary(){
        MusicTrack musicTrack1 = new MusicTrack("Track1", "Performer1");
        MusicTrack musicTrack2 = new MusicTrack("Track2", "Performer2");
        MusicTrack musicTrack3 = new MusicTrack("Track3", "Performer1");

        MusicLibrary musicLibrary = new MusicLibrary();
        //добавление трека
        musicLibrary.addTrack("genre1", musicTrack1);
        musicLibrary.addTrack("genre2", musicTrack2);
        musicLibrary.addTrack("genre1", musicTrack3);

        musicLibrary.getMusicLibrary();

        //получение всех треков заданного жанра
        System.out.println("получение всех треков заданного жанра");
        System.out.println("Все треки жанра genre1: " +musicLibrary.getTracksOfGenre("genre1"));
        System.out.println("Все треки жанра genre2: " +musicLibrary.getTracksOfGenre("genre2"));

        //получение жанра заданного трека
        System.out.println("получение жанра заданного трека");
        musicLibrary.getGenreOfTracks(musicTrack1);
        musicLibrary.getGenreOfTracks(musicTrack2);
        musicLibrary.getGenreOfTracks(musicTrack3);

        //удаление трека
        System.out.println("удаление трека");
        musicLibrary.removeTrack(musicTrack1);
        musicLibrary.removeTrack(musicTrack2);
        musicLibrary.getMusicLibrary();
    }
}
