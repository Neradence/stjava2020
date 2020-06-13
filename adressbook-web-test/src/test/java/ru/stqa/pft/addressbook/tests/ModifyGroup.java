package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.models.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ModifyGroup extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupTab();

        if (app.group().allGroup().size() == 0) {
            app.group().createGroup(new GroupData().withGroupname("Sport").withGroupfooter("logo-1").withGroupheader("header-1"));
            app.goTo().groupTab();
        }
    }

    @Test
    public void testModifyGroup() throws Exception {

        Groups before = app.group().allGroup();
        GroupData modGroup = before.iterator().next();
        GroupData group = new GroupData().withGroupid(modGroup.getGroupid()).withGroupname("Bar").withGroupfooter("logo-2").withGroupheader("header-2");

        app.group().modifyGroup(group);
        app.goTo().groupTab();

        Groups after = app.group().allGroup();
        assertEquals(after.size(), before.size());

        assertThat(after, equalTo(before.withOut(modGroup).withAdded(group)));
    }

}
