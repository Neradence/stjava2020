package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.models.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class DeleteGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupTab();

    if (app.group().allGroup().size() == 0) {
      app.group().createGroup(new GroupData().withGroupname("Works"));
      app.goTo().groupTab();
    }
  }

  @Test
  public void testDeleteGroup() throws Exception {
    Groups before = app.group().allGroup();
    GroupData delGroup = before.iterator().next();
    app.group().deleteGroup(delGroup);
    app.goTo().groupTab();
    assertThat(app.group().getGroupCount(), equalTo(before.size() - 1));
    Groups after = app.group().allGroup();
    assertThat(after, equalTo(before.withOut(delGroup)));
  }

}
