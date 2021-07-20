package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EquetionTests {

  @Test
  public void test0(){
    Equetion e = new Equetion(1,1,1);
    Assert.assertEquals(e.rootNumber(),0);
  }

  @Test
  public void test1(){
    Equetion e = new Equetion(1,2,1);
    Assert.assertEquals(e.rootNumber(),1);
  }

  @Test
  public void test2(){
    Equetion e = new Equetion(1,5,6);
    Assert.assertEquals(e.rootNumber(),2);
  }

}
