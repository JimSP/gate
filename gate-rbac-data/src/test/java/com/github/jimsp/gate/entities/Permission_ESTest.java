/*
 * This file was automatically generated by EvoSuite
 * Sun Feb 11 03:40:45 BRST 2018
 */

package com.github.jimsp.gate.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.github.jimsp.gate.rbac.entities.Operation;
import com.github.jimsp.gate.rbac.entities.Permission;
import com.github.jimsp.gate.rbac.entities.Resource;

public class Permission_ESTest {

  @Test
  public void test00()  throws Throwable  {
      Permission permission0 = new Permission();
      permission0.setName("C");
      permission0.hashCode();
      assertFalse(permission0.getPermanent());
  }

  @Test
  public void test01()  throws Throwable  {
      Permission permission0 = new Permission();
      permission0.setPermanent((Boolean) null);
      Boolean boolean0 = permission0.getPermanent();
      assertNull(boolean0);
  }

  @Test
  public void test02()  throws Throwable  {
      Permission permission0 = new Permission();
      permission0.setName("1");
      permission0.getName();
      assertFalse(permission0.getPermanent());
  }

  @Test
  public void test03()  throws Throwable  {
      Permission permission0 = new Permission();
      permission0.setName("");
      permission0.getName();
      assertFalse(permission0.getPermanent());
  }

  @Test
  public void test04()  throws Throwable  {
      Permission permission0 = new Permission();
      permission0.setDescription("q");
      permission0.getDescription();
      assertFalse(permission0.getPermanent());
  }

  @Test
  public void test05()  throws Throwable  {
      Permission permission0 = new Permission();
      Permission permission1 = new Permission();
      permission1.setName("Bg`2lOo?zck^_N");
      assertFalse(permission1.equals((Object)permission0));
      
      permission0.setName("Bg`2lOo?zck^_N");
      boolean boolean0 = permission1.equals(permission0);
      assertTrue(boolean0);
  }

  @Test
  public void test06()  throws Throwable  {
      Permission permission0 = new Permission();
      Permission permission1 = new Permission();
      permission0.setName("");
      boolean boolean0 = permission1.equals(permission0);
      assertFalse(permission1.equals((Object)permission0));
      assertFalse(boolean0);
  }

  @Test
  public void test07()  throws Throwable  {
      Permission permission0 = new Permission();
      Permission permission1 = new Permission();
      permission0.setName("");
      boolean boolean0 = permission0.equals(permission1);
      assertFalse(permission1.equals((Object)permission0));
      assertFalse(boolean0);
  }

  @Test
  public void test08()  throws Throwable  {
      Permission permission0 = new Permission();
      Permission permission1 = new Permission();
      boolean boolean0 = permission0.equals(permission1);
      assertTrue(boolean0);
      assertFalse(permission1.getPermanent());
  }

  @Test
  public void test09()  throws Throwable  {
      Permission permission0 = new Permission();
      boolean boolean0 = permission0.equals((Object) null);
      assertFalse(boolean0);
      assertFalse(permission0.getPermanent());
  }

  @Test
  public void test10()  throws Throwable  {
      Permission permission0 = new Permission();
      boolean boolean0 = permission0.equals(permission0);
      assertFalse(permission0.getPermanent());
      assertTrue(boolean0);
  }

  @Test
  public void test11()  throws Throwable  {
      Permission permission0 = new Permission();
      assertFalse(permission0.getPermanent());
  }

  @Test
  public void test12()  throws Throwable  {
      Permission permission0 = new Permission();
      permission0.hashCode();
      assertFalse(permission0.getPermanent());
  }

  @Test
  public void test13()  throws Throwable  {
      Permission permission0 = new Permission();
      Operation operation0 = new Operation();
      permission0.setOperation(operation0);
      permission0.getOperation();
      assertFalse(permission0.getPermanent());
  }

  @Test
  public void test14()  throws Throwable  {
      Permission permission0 = new Permission();
      Boolean boolean0 = permission0.getPermanent();
      assertFalse(boolean0);
  }

  @Test
  public void test15()  throws Throwable  {
      Permission permission0 = new Permission();
      permission0.getResource();
      assertFalse(permission0.getPermanent());
  }

  @Test
  public void test16()  throws Throwable  {
      Permission permission0 = new Permission();
      permission0.getOperation();
      assertFalse(permission0.getPermanent());
  }

  @Test
  public void test17()  throws Throwable  {
      Permission permission0 = new Permission();
      permission0.getDescription();
      assertFalse(permission0.getPermanent());
  }

  @Test
  public void test18()  throws Throwable  {
      Permission permission0 = new Permission();
      permission0.getName();
      assertFalse(permission0.getPermanent());
  }

  @Test
  public void test19()  throws Throwable  {
      Permission permission0 = new Permission();
      permission0.setDescription("");
      permission0.getDescription();
      assertFalse(permission0.getPermanent());
  }

  @Test
  public void test20()  throws Throwable  {
      Permission permission0 = new Permission();
      Boolean boolean0 = Boolean.TRUE;
      permission0.setPermanent(boolean0);
      Boolean boolean1 = permission0.getPermanent();
      assertTrue(boolean1);
  }

  @Test
  public void test21()  throws Throwable  {
      Permission permission0 = new Permission();
      Resource resource0 = new Resource();
      permission0.setResource(resource0);
      permission0.getResource();
      assertFalse(permission0.getPermanent());
  }
}
