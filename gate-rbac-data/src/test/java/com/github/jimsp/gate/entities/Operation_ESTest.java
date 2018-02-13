package com.github.jimsp.gate.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.github.jimsp.gate.rbac.entities.Operation;

public class Operation_ESTest {

  @Test
  public void test00()  throws Throwable  {
      Operation operation0 = new Operation();
      operation0.setName("O");
      operation0.hashCode();
      assertFalse(operation0.getPermanent());
  }

  @Test
  public void test01()  throws Throwable  {
      Operation operation0 = new Operation();
      operation0.setPermanent((Boolean) null);
      Boolean boolean0 = operation0.getPermanent();
      assertNull(boolean0);
  }

  @Test
  public void test02()  throws Throwable  {
      Operation operation0 = new Operation();
      operation0.setName("O");
      operation0.getName();
      assertFalse(operation0.getPermanent());
  }

  @Test
  public void test03()  throws Throwable  {
      Operation operation0 = new Operation();
      operation0.setName("");
      operation0.getName();
      assertFalse(operation0.getPermanent());
  }

  @Test
  public void test04()  throws Throwable  {
      Operation operation0 = new Operation();
      operation0.setDescription("2");
      operation0.getDescription();
      assertFalse(operation0.getPermanent());
  }

  @Test
  public void test05()  throws Throwable  {
      Operation operation0 = new Operation();
      operation0.setName("o/\"[Ndp|f");
      Operation operation1 = new Operation();
      assertFalse(operation1.equals((Object)operation0));
      
      operation1.setName("o/\"[Ndp|f");
      boolean boolean0 = operation0.equals(operation1);
      assertTrue(operation1.equals((Object)operation0));
      assertTrue(boolean0);
  }

  @Test
  public void test06()  throws Throwable  {
      Operation operation0 = new Operation();
      operation0.setName("");
      Operation operation1 = new Operation();
      boolean boolean0 = operation1.equals(operation0);
      assertFalse(operation1.getPermanent());
      assertFalse(boolean0);
  }

  @Test
  public void test07()  throws Throwable  {
      Operation operation0 = new Operation();
      Operation operation1 = new Operation();
      boolean boolean0 = operation1.equals(operation0);
      assertFalse(operation1.getPermanent());
      assertTrue(boolean0);
  }

  @Test
  public void test08()  throws Throwable  {
      Operation operation0 = new Operation();
      Object object0 = new Object();
      boolean boolean0 = operation0.equals(object0);
      assertFalse(operation0.getPermanent());
      assertFalse(boolean0);
  }

  @Test
  public void test09()  throws Throwable  {
      Operation operation0 = new Operation();
      boolean boolean0 = operation0.equals((Object) null);
      assertFalse(boolean0);
      assertFalse(operation0.getPermanent());
  }

  @Test
  public void test10()  throws Throwable  {
      Operation operation0 = new Operation();
      boolean boolean0 = operation0.equals(operation0);
      assertTrue(boolean0);
      assertFalse(operation0.getPermanent());
  }

  @Test
  public void test11()  throws Throwable  {
      Operation operation0 = new Operation();
      operation0.setName("");
      Operation operation1 = new Operation();
      boolean boolean0 = operation0.equals(operation1);
      assertFalse(boolean0);
      assertFalse(operation1.getPermanent());
  }

  @Test
  public void test12()  throws Throwable  {
      Operation operation0 = new Operation();
      operation0.hashCode();
      assertFalse(operation0.getPermanent());
  }

  @Test
  public void test13()  throws Throwable  {
      Operation operation0 = new Operation();
      operation0.getDescription();
      assertFalse(operation0.getPermanent());
  }

  @Test
  public void test14()  throws Throwable  {
      Operation operation0 = new Operation();
      operation0.getName();
      assertFalse(operation0.getPermanent());
  }

  @Test
  public void test15()  throws Throwable  {
      Operation operation0 = new Operation();
      Boolean boolean0 = new Boolean(true);
      operation0.setPermanent(boolean0);
      Boolean boolean1 = operation0.getPermanent();
      assertTrue(boolean1);
  }

  @Test
  public void test16()  throws Throwable  {
      Operation operation0 = new Operation();
      operation0.setDescription("");
      operation0.getDescription();
      assertFalse(operation0.getPermanent());
  }

  @Test
  public void test17()  throws Throwable  {
      Operation operation0 = new Operation();
      Boolean boolean0 = operation0.getPermanent();
      assertFalse(boolean0);
  }
}
