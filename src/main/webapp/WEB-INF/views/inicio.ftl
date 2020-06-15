<html>
<head>
  <title>Struts2 - FreeMarker</title>
</head>

<body>
  <div id="header">
    <h2>FreeMarker Struts2</h2>
  </div>

  <div id="content">
    <fieldset>
      <legend>Add User</legend>

	<@s.form action="add" method="post">
	    <@s.textfield label="First name" name="user.firstname"/>
	    <@s.textfield label="Last name" name="user.lastname"/>
	    <@s.submit value="Save"/>
	</@s.form>

    </fieldset><br />

    <table class="datatable">
      <tr>
        <th>Firstname</th>
        <th>Lastname</th>
      </tr>
	<#list userList as user>
  	<tr>
  		<td>${user.firstname}</td> <td>${user.lastname}</td>
  	</tr>
    </#list>	  
    </table>
  </div>
</body>
</html>