package ru.stqa.pft.addressbook.models;

import java.util.Objects;

public class GroupData {
    private int groupid;
    private final String groupname;
    private final String groupheader;
    private final String groupfooter;

    public GroupData(int groupid, String groupname, String groupheader, String groupfooter) {
        this.groupid = groupid;
        this.groupname = groupname;
        this.groupheader = groupheader;
        this.groupfooter = groupfooter;
    }

    public GroupData(String groupname, String groupheader, String groupfooter) {
        this.groupid = Integer.MAX_VALUE;
        this.groupname = groupname;
        this.groupheader = groupheader;
        this.groupfooter = groupfooter;
    }

    public int getGroupid() {
        return groupid;
    }

    public String getGroupname() {
        return groupname;
    }

    public String getGroupheader() {
        return groupheader;
    }

    public String getGroupfooter() {
        return groupfooter;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "groupid='" + groupid + '\'' +
                ", groupname='" + groupname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return Objects.equals(groupname, groupData.groupname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupname);
    }
}
