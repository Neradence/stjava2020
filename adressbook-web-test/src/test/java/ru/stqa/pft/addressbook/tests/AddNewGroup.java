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

    int index = before.size() + 1;
    app.group().initGroupCreation();

    GroupData group = new GroupData().withGroupname("Family");
    app.group().fillGroupForm(group);
    app.group().saveFilledGroupForm();
    app.goTo().groupTab();
    Groups after = app.group().allGroup();
    assertThat(after.size(), equalTo(before.size()+ 1));

    assertThat(after, equalTo(before.withAdded(group.withGroupid(after.stream().mapToInt((g) -> g.getGroupid()).max().getAsInt()))));
  }

}
