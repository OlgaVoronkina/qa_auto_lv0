package org.example.task5_clock;

/**
 * Создайте класс Clock с полями для хранения часов, минут, секунд
 * Реализуйте методы для установки и получения времени, а также метод tick() для увеличения времени на одну секунду
 * Создайте интерфейс Readable с методом readTime(), который выводит текущее время часов
 */
public class Clock implements Readable{
    int hours;
    int minutes;
    int seconds;

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void tick(){
        System.out.println("Увеличиваем время на 1с");
        this.seconds ++;
    }

    @Override
    public void readTime() {
        System.out.println("Время: " + getHours() + ":" + getMinutes() + ":" + getSeconds());
    }
}
