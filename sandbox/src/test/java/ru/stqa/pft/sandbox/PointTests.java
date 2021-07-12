package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {


  @Test
  public void testDistance() {

    Point p1 = new Point(4, 5);
    Point p2 = new Point(7, 9);
    Assert.assertEquals(p1.distance(p2), 5);
  }

  @Test
  public void testDistanceBoolean() {

     Point p1 = new Point(4, 5);
    Point p2 = new Point(7, 9);
    boolean r = p1.distance(p2) >= 5;
    Assert.assertTrue(r);
  }


}
