<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ page
session="false" %>
<html>
  <head>
    <title>Home</title>
  </head>
  <body>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

    <h1>Hello world!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!</h1>
    <div id="list"></div>

    <script>
      var listElem = document.getElementById("list");
      /* var listTable = (response) => {
          listElem.innerHTML = response.data
        } */
      var str = "";
      axios.get("http://localhost:8080/jdbc/api/depts").then((response) =>
        response.data.forEach((element) => {
          console.log(element);
          str += "<div>" + element + "</div>";
        })
      );
      co
      listElem.innerHTML = str;
    </script>
    <P> The time on the server is ${serverTime}. </P>
    <div id="list"></div>
  </body>
</html>
<!-- // (JSON) INSERT "/api/deptjson" => deptno : 90, dname : FRONTEND, loc : JEJU -->

<!-- // (FormEncoded) INSERT "/api/deptjson" => deptno : 100, dname : TEST, loc : TEST -->
