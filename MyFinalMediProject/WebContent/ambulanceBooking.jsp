<!DOCTYPE html>
<%@page import="model.ambulance"%>
<%@page import="java.util.List"%>
<%@page import="operateDao.crud"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ambulance Booking</title>
    <link rel="stylesheet" href="css/ambulancebooking.css">
</head>
<body>
	<jsp:include page="Header Bb and Amb.jsp"></jsp:include>
<br>
<br>

<br>


    <header>
        <h1>Ambulance Booking </h1>
    </header>
    <main>
        <form action="ambbook" id="booking-form">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="tel" id="phone" name="ph_no" required>
            </div>
            <div class="form-group">
                <label for="pickup-location">Pickup Location:</label>
                <input type="text" id="pickup-location" name="pickup_location" required>
            </div>
            <div class="form-group">
                <label for="destination">Destination:</label>
                <input type="text" id="destination" name="destination" required>
            </div>
            <div class="form-group">
                <label for="date-time">Date & Time:</label>
                <input type="datetime-local" id="date-time" name="date_time" required>
            </div>
            <button type="submit">Book Ambulance</button>
            <br>
            <link href="" name="">
        </form>

       <table>
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


    <tr>
        <th>Name</th>
        <th>Phone Number</th>
        <th>Pickup Location</th>
        <th>Destination</th>
        <th>Date/Time</th>
    </tr>
    <%
    // Retrieve a list of ambulance objects
    List<ambulance> al = crud.ambulanceshow();

    // Iterate over the list of ambulance objects
    for(ambulance a : al) {
    %>
    <tr>
        <!-- Displaying ambulance information in each row -->
        <td><%=a.getName()%></td>
        <td><%=a.getPh_no()%></td>
        <td><%=a.getPickup_location()%></td>
        <td><%=a.getDestination()%></td>
        <td><%=a.getDate_time()%></td>
    </tr>
    <% } %> <!-- End of for loop -->
</table>

    </main>
    <footer>
        <p>&copy; 2024 Ambulance Booking System</p>
    </footer>


</body>
</html>
