package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {


  @Test
  public void testDistance() {

    Point p = new Point(4, 5, 7, 9);
    Assert.assertEquals(p.distance(), 5);
  }

  @Test
  public void testDistanceBoolean() {

    Point p = new Point(4, 5, 7, 9);
    boolean r = p.distance() >= 5;
    Assert.assertTrue(r);
  }


}
