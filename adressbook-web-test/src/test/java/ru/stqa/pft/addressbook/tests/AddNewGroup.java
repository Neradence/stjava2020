package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.models.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddNewGroup extends TestBase {

  @Test
  public void testAddNewGroup() throws Exception {
    app.goTo().groupTab();
    Groups before = app.group().allGroup();
    app.group().initGroupCreation();
    GroupData group = new GroupData().withGroupname("Sport");
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
