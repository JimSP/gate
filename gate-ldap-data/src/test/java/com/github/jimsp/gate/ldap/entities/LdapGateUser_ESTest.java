package com.github.jimsp.gate.ldap.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Properties;

import javax.naming.CompositeName;
import javax.naming.CompoundName;
import javax.naming.Name;

import org.junit.Test;

public class LdapGateUser_ESTest {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      LdapGateUser ldapGateUser0 = new LdapGateUser();
      Properties properties0 = new Properties();
      CompoundName compoundName0 = new CompoundName("6", properties0);
      ldapGateUser0.setId(compoundName0);
      ldapGateUser0.hashCode();
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      LdapGateUser ldapGateUser0 = new LdapGateUser();
      String string0 = ldapGateUser0.getUsername();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      String[] stringArray0 = new String[8];
      LdapGateUser ldapGateUser0 = new LdapGateUser((Name) null, "I", "", stringArray0);
      String string0 = ldapGateUser0.getUsername();
      assertEquals("I", string0);
      assertEquals("", ldapGateUser0.getPassword());
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      LdapGateUser ldapGateUser0 = new LdapGateUser();
      String[] stringArray0 = new String[1];
      ldapGateUser0.setRole(stringArray0);
      String[] stringArray1 = ldapGateUser0.getRoles();
      assertSame(stringArray1, stringArray0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      LdapGateUser ldapGateUser0 = new LdapGateUser();
      String[] stringArray0 = new String[0];
      ldapGateUser0.setRole(stringArray0);
      String[] stringArray1 = ldapGateUser0.getRoles();
      assertSame(stringArray1, stringArray0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      LdapGateUser ldapGateUser0 = new LdapGateUser();
      String string0 = ldapGateUser0.getPassword();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      String[] stringArray0 = new String[0];
      LdapGateUser ldapGateUser0 = new LdapGateUser((Name) null, "", "H", stringArray0);
      String string0 = ldapGateUser0.getPassword();
      assertEquals("H", string0);
      assertEquals("", ldapGateUser0.getUsername());
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      CompositeName compositeName0 = new CompositeName("");
      String[] stringArray0 = new String[2];
      LdapGateUser ldapGateUser0 = new LdapGateUser(compositeName0, "", "", stringArray0);
      Name name0 = ldapGateUser0.getId();
      assertSame(compositeName0, name0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      CompositeName compositeName0 = new CompositeName();
      LdapGateUser ldapGateUser0 = new LdapGateUser(compositeName0, "", "", (String[]) null);
      String string0 = ldapGateUser0.toString();
      assertEquals("LdapGateUser [id=, username=, password=, roles=null]", string0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      LdapGateUser ldapGateUser0 = new LdapGateUser();
      String string0 = ldapGateUser0.toString();
      assertEquals("LdapGateUser [id=null, username=null, password=, roles=null]", string0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      LdapGateUser ldapGateUser0 = new LdapGateUser();
      LdapGateUser ldapGateUser1 = new LdapGateUser((Name) null, "", "", (String[]) null);
      boolean boolean0 = ldapGateUser0.equals(ldapGateUser1);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      LdapGateUser ldapGateUser0 = new LdapGateUser();
      Object object0 = new Object();
      boolean boolean0 = ldapGateUser0.equals(object0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      LdapGateUser ldapGateUser0 = new LdapGateUser();
      boolean boolean0 = ldapGateUser0.equals(ldapGateUser0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      LdapGateUser ldapGateUser0 = new LdapGateUser();
      boolean boolean0 = ldapGateUser0.equals((Object) null);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      LdapGateUser ldapGateUser0 = new LdapGateUser();
      ldapGateUser0.hashCode();
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      CompositeName compositeName0 = new CompositeName();
      LdapGateUser ldapGateUser0 = new LdapGateUser(compositeName0, "", "", (String[]) null);
      ldapGateUser0.setUsername("");
      assertEquals("", ldapGateUser0.getPassword());
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      CompositeName compositeName0 = new CompositeName();
      LdapGateUser ldapGateUser0 = new LdapGateUser(compositeName0, "", "", (String[]) null);
      String string0 = ldapGateUser0.getUsername();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      LdapGateUser ldapGateUser0 = new LdapGateUser();
      Name name0 = ldapGateUser0.getId();
      assertNull(name0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      LdapGateUser ldapGateUser0 = new LdapGateUser();
      String[] stringArray0 = ldapGateUser0.getRoles();
      assertNull(stringArray0);
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      CompositeName compositeName0 = new CompositeName();
      LdapGateUser ldapGateUser0 = new LdapGateUser(compositeName0, "", "", (String[]) null);
      String string0 = ldapGateUser0.getPassword();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      LdapGateUser ldapGateUser0 = new LdapGateUser();
      ldapGateUser0.setPassword((String) null);
      assertNull(ldapGateUser0.getPassword());
  }
}
