package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.models.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddNewGroup extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new GroupData().withGroupname("test1").withGroupheader("header1").withGroupfooter("footer1")});
    list.add(new Object[] {new GroupData().withGroupname("test2").withGroupheader("header2").withGroupfooter("footer2")});
    list.add(new Object[] {new GroupData().withGroupname("test3").withGroupheader("header3").withGroupfooter("footer3")});
    return list.iterator();
  }

  @Test(dataProvider = "validGroups")
  public void testAddNewGroup(GroupData group) throws Exception {
    app.goTo().groupTab();
    Groups before = app.group().allGroup();
    app.group().initGroupCreation();
    app.group().fillGroupForm(group);
    app.group().saveFilledGroupForm();
    app.goTo().groupTab();
    assertThat(app.group().getGroupCount(), equalTo(before.size() + 1));
    Groups after = app.group().allGroup();
    assertThat(after, equalTo(before.withAdded(group.withGroupid(after.stream().mapToInt((g) -> g.getGroupid()).max().getAsInt()))));
  }

  @Test(enabled = false)
  public void testAddBadNewGroup() throws Exception {
    app.goTo().groupTab();
    Groups before = app.group().allGroup();
    app.group().initGroupCreation();
    GroupData group = new GroupData().withGroupname("Bar'");
    app.group().fillGroupForm(group);
    app.group().saveFilledGroupForm();
    app.goTo().groupTab();
    assertThat(app.group().getGroupCount(), equalTo(before.size()));
    Groups after = app.group().allGroup();
    assertThat(after, equalTo(before));
  }

}
