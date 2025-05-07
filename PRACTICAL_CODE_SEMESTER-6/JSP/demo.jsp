<%@ page import="java.sql.*, java.util.*" %>

<h2>EMPLOYEE DETAILS</h2>
<table border="1">
    <tr>
        <th>EMPLOYEE ID</th>
        <th>EMPLOYEE NAME</th>
        <th>EMPLOYEE POSITION</th>
        <th>EMPLOYEE WORKING HOUR</th>
    </tr>

    <%
        Connection conn = null;
        Statement statement = null;
        ResultSet result = null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Pratham@2002");
            if(conn != null)
            	out.println("CONNECTION ESTABLISHED");
            	
            statement = conn.createStatement();
            result = statement.executeQuery("select * from employee;");

            while (result.next()) {
    %>
    <tr>
        <td><%= result.getInt(1) %></td>
        <td><%= result.getString(2) %></td>
        <td><%= result.getString(3) %></td>
        <td><%= result.getInt(4) %></td>
    </tr>
    <%
            }
        } catch (Exception ex1) {
            ex1.printStackTrace();
        } finally {
            if (result != null) {
                result.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    %>
</table>

