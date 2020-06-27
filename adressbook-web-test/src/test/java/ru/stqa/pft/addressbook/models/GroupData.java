package ru.stqa.pft.addressbook.models;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@XStreamAlias("group")
@Entity
@Table(name = "group_list")
public class GroupData {
    @XStreamOmitField
    @Id
    @Column(name = "group_id")
    private int groupid = Integer.MAX_VALUE;
    @Expose
    @Column(name = "group_name")
    private String groupname;
    @Expose
    @Column(name = "group_header")
    @Type(type = "text")
    private String groupheader;
    @Expose
    @Column(name = "group_footer")
    @Type(type = "text")
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
