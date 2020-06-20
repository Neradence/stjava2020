package ru.stqa.pft.addressbook.models;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.Objects;

@XStreamAlias("group")
public class GroupData {
    @XStreamOmitField
    private int groupid = Integer.MAX_VALUE;
    private String groupname;
    private String groupheader;
    private String groupfooter;

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

    public GroupData withGroupid(int groupid) {
        this.groupid = groupid;
        return this;
    }

    public GroupData withGroupname(String groupname) {
        this.groupname = groupname;
        return this;
    }

    public GroupData withGroupheader(String groupheader) {
        this.groupheader = groupheader;
        return this;
    }

    public GroupData withGroupfooter(String groupfooter) {
        this.groupfooter = groupfooter;
        return this;
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
        return groupid == groupData.groupid &&
                Objects.equals(groupname, groupData.groupname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupid, groupname);
    }
}
