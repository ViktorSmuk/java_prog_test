package ru.stqa.pft.sandbox;

public class Task2 {

  public static void main(String[] args) {


    Point p1 = new Point(4, 5);
    Point p2 = new Point(7, 9);

    System.out.println("Расстояние между точками = " + p1.distance(p2));
  }


//  public static double distance(Point p1, Point p2) {
//    return Math.sqrt((Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2)));
//  }
}


