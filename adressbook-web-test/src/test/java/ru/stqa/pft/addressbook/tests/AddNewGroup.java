package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.models.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddNewGroup extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
    String line = reader.readLine();
    while (line != null) {
      String[] split = line.split(";");
      list.add(new Object[] {new GroupData().withGroupname(split[0]).withGroupheader(split[1]).withGroupfooter(split[2])});
      line = reader.readLine();
    }
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
