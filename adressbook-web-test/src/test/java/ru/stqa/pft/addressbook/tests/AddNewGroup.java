package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.models.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddNewGroup extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroupsFromXML() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")));
    String xml = "";
    String line = reader.readLine();
    while (line != null) {
      xml += line;
      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(GroupData.class);
    List<GroupData> groups = (List<GroupData>) xstream.fromXML(xml);
    return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
  }

  @DataProvider
  public Iterator<Object[]> validGroupsFromJSON() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")));
    String json = "";
    String line = reader.readLine();
    while (line != null) {
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
    List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>(){}.getType());
    return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
  }

  @Test(dataProvider = "validGroupsFromJSON")
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
