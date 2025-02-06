package org.example.task4_point;

/**
 * Создайте класс Point с приватными полями x и y для координат точки на плоскости.
 * Реализуйте методы для получения (get) и установки (set) этих полей.
 * создайте интерфейс Movable с методами moveUp(), moveDown(), moveLeft(), moveRight() для изменения положения точки
 */
public class Point implements Movable{
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public void moveUp(double val) {
        this.y = y+val;
        System.out.println("Вверх на " +val +", Y = "+ this.y);
    }

    @Override
    public void moveDown(double val) {
        this.y = y-val;
        System.out.println("Вниз на " + val +", Y = "+ this.y);
    }

    @Override
    public void moveLeft(double val) {
        this.x = x-val;
        System.out.println("Влево на " +val +", Х = "+ this.x);
    }

    @Override
    public void moveRight(double val) {
        this.x = x+val;
        System.out.println("Вправо на " +val +", Х = "+ this.x);
    }

    public void getCoordinates(){
        System.out.println("Координаты: X = "+getX() +", Y = "+getY());
    }
}
