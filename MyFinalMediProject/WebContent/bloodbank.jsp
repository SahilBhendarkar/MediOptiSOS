<!DOCTYPE html>
<%@page import="model.showblood"%>
<%@page import="java.util.List"%>
<%@page import="operateDao.crud"%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Blood Bank</title>
  <link rel="stylesheet" href="css/bloodbank.css">
</head>
<body>
	<jsp:include page="Header Bb and Amb.jsp"></jsp:include>
<br>
  <div class="container">
    <h1>Blood Bank</h1>
    <form  action="bloodBank" onsubmit="return showPopup()">
      <label for="name">Name:</label>
      <input type="text" id="name" name="name" required><br>

      <label for="address">Address:</label>
      <input type="text" id="address" name="address" required><br>

      <label for="age">Age:</label>
      <input type="number" id="age" name="age" required><br>

      <label for="gender">Gender:</label>
      <select id="gender" name="gender" required>
        <option value="">Select Gender</option>
        <option value="male">Male</option>
        <option value="female">Female</option>
        <option value="other">Other</option>
      </select><br>

      <label for="bloodType">Select Blood Type:</label>
      <select id="bloodType" name="bloodType">
        <option value="A+">A+</option>
        <option value="A-">A-</option>
        <option value="B+">B+</option>
        <option value="B-">B-</option>
        <option value="AB+">AB+</option>
        <option value="AB-">AB-</option>
        <option value="O+">O+</option>
        <option value="O-">O-</option>
      </select><br>

      <button type="submit">Request Blood</button>
    </form>

    <div id="bloodInventory">
      <h2>Blood Inventory</h2>
      <ul id="bloodList">
        <!-- Blood inventory will be dynamically populated here -->
      </ul>
    </div>
  </div>

   <style>
    table {
        width: 100%;
        border-collapse: collapse;
    }

    th, td {
        padding: 8px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #f2f2f2;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
</style>

<table>
    <tr>
        <th>Name</th>
        <th>Address</th>
        <th>Age</th>
        <th>Gender</th>
        <th>Blood Type</th>
    </tr>
    <%
    // Retrieve a list of Blood Donors objects
    List<showblood> bloodDonors = crud.getAllBloodDonors();

    // Iterate over the list of Blood Donors objects
    for (showblood donor : bloodDonors) {
    %>
    <tr>
        <!-- Displaying blood donor information in each row -->
        <td><%= donor.getName() %></td>
        <td><%= donor.getAddress() %></td>
        <td><%= donor.getAge() %></td>
        <td><%= donor.getGender() %></td>
        <td><%= donor.getBloodType() %></td>
    </tr>
    <% } %> <!-- End of for loop -->
</table>



  <script>
    function showPopup() {
      // Perform any form validation here if needed
      // For simplicity, let's assume the form is always valid
      alert("Your blood request has been successfully sent!");
      return true; // Returning true to submit the form
    }
  </script>
</body>
</html>
