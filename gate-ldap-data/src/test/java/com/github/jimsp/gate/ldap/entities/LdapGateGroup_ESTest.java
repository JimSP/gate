package com.github.jimsp.gate.ldap.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Set;

import javax.naming.CompositeName;
import javax.naming.CompoundName;
import javax.naming.Name;

import org.junit.Test;

public class LdapGateGroup_ESTest {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Properties properties0 = new Properties();
      CompoundName compoundName0 = new CompoundName("[", properties0);
      LinkedHashSet<Name> linkedHashSet0 = new LinkedHashSet<Name>();
      LdapGateGroup ldapGateGroup0 = new LdapGateGroup(compoundName0, "", linkedHashSet0);
      ldapGateGroup0.hashCode();
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      LdapGateGroup ldapGateGroup0 = new LdapGateGroup();
      ldapGateGroup0.addMember((Name) null);
      ldapGateGroup0.removeMember((Name) null);
      assertNull(ldapGateGroup0.getName());
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      LinkedList<CompositeName> linkedList0 = new LinkedList<CompositeName>();
      LinkedHashSet<Name> linkedHashSet0 = new LinkedHashSet<Name>(linkedList0);
      Properties properties0 = new Properties();
      CompoundName compoundName0 = new CompoundName("", properties0);
      LdapGateGroup ldapGateGroup0 = new LdapGateGroup(compoundName0, (String) null, linkedHashSet0);
      String string0 = ldapGateGroup0.getName();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Properties properties0 = new Properties();
      CompoundName compoundName0 = new CompoundName("", properties0);
      LinkedHashSet<Name> linkedHashSet0 = new LinkedHashSet<Name>();
      LdapGateGroup ldapGateGroup0 = new LdapGateGroup(compoundName0, "", linkedHashSet0);
      ldapGateGroup0.setName(",");
      String string0 = ldapGateGroup0.getName();
      assertEquals(",", string0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      LdapGateGroup ldapGateGroup0 = new LdapGateGroup();
      Set<Name> set0 = ldapGateGroup0.getMembers();
      assertNull(set0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      LdapGateGroup ldapGateGroup0 = new LdapGateGroup();
      ldapGateGroup0.addMember((Name) null);
      Set<Name> set0 = ldapGateGroup0.getMembers();
      assertFalse(set0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Properties properties0 = new Properties();
      CompoundName compoundName0 = new CompoundName("", properties0);
      LinkedHashSet<Name> linkedHashSet0 = new LinkedHashSet<Name>();
      LdapGateGroup ldapGateGroup0 = new LdapGateGroup(compoundName0, "", linkedHashSet0);
      Name name0 = ldapGateGroup0.getDn();
      assertSame(name0, compoundName0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      LdapGateGroup ldapGateGroup0 = new LdapGateGroup();
      ldapGateGroup0.addMember((Name) null);
      String string0 = ldapGateGroup0.toString();
      assertEquals("LdapGateGroup [dn=null, name=null, members=[null]]", string0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      LdapGateGroup ldapGateGroup0 = new LdapGateGroup();
      String string0 = ldapGateGroup0.toString();
      assertEquals("LdapGateGroup [dn=null, name=null, members=null]", string0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      CompositeName compositeName0 = new CompositeName("");
      LinkedList<CompositeName> linkedList0 = new LinkedList<CompositeName>();
      LinkedHashSet<Name> linkedHashSet0 = new LinkedHashSet<Name>(linkedList0);
      LdapGateGroup ldapGateGroup0 = new LdapGateGroup(compositeName0, "", linkedHashSet0);
      Properties properties0 = new Properties();
      CompoundName compoundName0 = new CompoundName("", properties0);
      LdapGateGroup ldapGateGroup1 = new LdapGateGroup(compoundName0, (String) null, linkedHashSet0);
      assertFalse(ldapGateGroup1.equals((Object)ldapGateGroup0));
      
      ldapGateGroup1.setDn(compositeName0);
      boolean boolean0 = ldapGateGroup0.equals(ldapGateGroup1);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      CompositeName compositeName0 = new CompositeName("");
      LinkedList<CompositeName> linkedList0 = new LinkedList<CompositeName>();
      LinkedHashSet<Name> linkedHashSet0 = new LinkedHashSet<Name>(linkedList0);
      LdapGateGroup ldapGateGroup0 = new LdapGateGroup(compositeName0, "", linkedHashSet0);
      Properties properties0 = new Properties();
      CompoundName compoundName0 = new CompoundName("", properties0);
      LdapGateGroup ldapGateGroup1 = new LdapGateGroup(compoundName0, (String) null, linkedHashSet0);
      boolean boolean0 = ldapGateGroup0.equals(ldapGateGroup1);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      CompositeName compositeName0 = new CompositeName("");
      LinkedList<CompositeName> linkedList0 = new LinkedList<CompositeName>();
      LinkedHashSet<Name> linkedHashSet0 = new LinkedHashSet<Name>(linkedList0);
      LdapGateGroup ldapGateGroup0 = new LdapGateGroup(compositeName0, "", linkedHashSet0);
      boolean boolean0 = ldapGateGroup0.equals(ldapGateGroup0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      LdapGateGroup ldapGateGroup0 = new LdapGateGroup();
      boolean boolean0 = ldapGateGroup0.equals((Object) null);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      LdapGateGroup ldapGateGroup0 = new LdapGateGroup();
      ldapGateGroup0.hashCode();
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      LdapGateGroup ldapGateGroup0 = new LdapGateGroup();
      ldapGateGroup0.addMember((Name) null);
      ldapGateGroup0.addMember((Name) null);
      assertNull(ldapGateGroup0.getName());
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      LdapGateGroup ldapGateGroup0 = new LdapGateGroup();
      Name name0 = ldapGateGroup0.getDn();
      assertNull(name0);
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      CompositeName compositeName0 = new CompositeName("");
      LinkedList<CompositeName> linkedList0 = new LinkedList<CompositeName>();
      LinkedHashSet<Name> linkedHashSet0 = new LinkedHashSet<Name>(linkedList0);
      LdapGateGroup ldapGateGroup0 = new LdapGateGroup(compositeName0, "", linkedHashSet0);
      ldapGateGroup0.setMembers(linkedHashSet0);
      assertEquals(0, linkedHashSet0.size());
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      CompositeName compositeName0 = new CompositeName("");
      LinkedList<CompositeName> linkedList0 = new LinkedList<CompositeName>();
      LinkedHashSet<Name> linkedHashSet0 = new LinkedHashSet<Name>(linkedList0);
      LdapGateGroup ldapGateGroup0 = new LdapGateGroup(compositeName0, "", linkedHashSet0);
      Set<Name> set0 = ldapGateGroup0.getMembers();
      assertTrue(set0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      CompositeName compositeName0 = new CompositeName("");
      LinkedList<CompositeName> linkedList0 = new LinkedList<CompositeName>();
      LinkedHashSet<Name> linkedHashSet0 = new LinkedHashSet<Name>(linkedList0);
      LdapGateGroup ldapGateGroup0 = new LdapGateGroup(compositeName0, "", linkedHashSet0);
      String string0 = ldapGateGroup0.getName();
      assertEquals("", string0);
  }
}
