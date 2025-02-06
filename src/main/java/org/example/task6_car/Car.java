package org.example.task6_car;

/**
 * Создайте класс Car с полями для марки, модели, и года выпуска.
 * Реализуйте методы для получения и установки этих полей.
 * Создайте интерфейс Drivable c методами start(), stop(), drive(distance), которые реализует класс Car для имитации вождения автомобиля
 */
public class Car implements Drivable{
    String mark;
    String model;
    int year;

    public Car(String mark, String model, int year) {
        this.mark = mark;
        this.model = model;
        this.year = year;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void start() {
        System.out.println("Двигатель запущен");
    }

    @Override
    public void stop() {
        System.out.println("Двигатель остановлен");
    }

    @Override
    public void drive(int distance) {
        System.out.println("Автомобиль проехал "+ distance + "km");
    }

    public void getInfoAboutCar(){
        System.out.println("Марка: " + this.getMark() + ", Модель: " + this.getModel() + ", Год: " + this.getYear());
    }
}
