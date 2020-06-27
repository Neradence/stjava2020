package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.models.Groups;

import java.sql.*;

public class DBConnectTest {

    @Test
    public void testDBConnect() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password");
            Statement st = conn.createStatement();
            ResultSet rS = st.executeQuery("select group_id from group_list");
            Groups groups = new Groups();

            while (rS.next()) {
                groups.add(new GroupData().withGroupid(rS.getInt("group_id")));
            }

            rS.close();
            st.close();
            conn.close();

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
