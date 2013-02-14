<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="Ads.*"%>

<jsp:useBean id="adsDAO" type="Ads.AdsDAO" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
      Welcome to SciPro
</head>

<body>

<p> To Bachelor Students only: This is a page for finding author partners
    with whom to write your thesis  </p>

Looking for author

    <form method="POST" action="adspage.html">
        <textarea name="name" cols=60 rows=6>
        </textarea>     <br>
       <input type="submit" value="Publish Ads" /> <br>
    </form>

<table border =0 bgcolor="#708090" width="600">
    <% for (AdsEntity ads : adsDAO.getAllAds()) { %>

    <tr>
        <td width="25%" height="60">
            <p>  <%= ads.getContent() %>   <br>
          Posted on:  <%= ads.getPostDate() %> </p>

        </td>
    </tr>
    <% } %>
</table>




</body>
</html>