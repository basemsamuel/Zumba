
<jsp:include page="adminheader.jsp"></jsp:include>
<div id="mycontainer">
	<div align="center">
		<br>
		<h3>ADMIN DASHBOARD</h3>
		<br>
		<br>
		<div>
			<table class="formtable">
				<tr>
					<td style="padding: 10px;">
						<div class='center'>
							<form style="width: 100%;" action="Admin" method = "POST">
							    <h2>View Batches</h2>
							    <input type="hidden" name="htmlFormName" value="ViewUsers" />
							    <button type="submit" value="Submit">Refresh</button>
							</form>
						    <table class="batchviewtable">
						    	<tr>
							    	<th style="padding:5px,">User Id</th>
							    	<th>First Name</th>
							    	<th>Last Time</th>
							    	<th>Age</th>
							    	<th>Gender</th>
							    	<th>Email</th>
							    	<th>Address</th>
							    	<th>City</th>
							    	<th>ZipCode</th>
							    	<th>Phone</th>
							    	<th>Delete</th>
						    	</tr>
								${userListTableDate}			    								
						    </table>
						</div>
					
					</td>
				</tr>
			</table>
			<br>
			<div class="emsg">
				<p>
					${UserTableErrorMessage}
				</p>
			</div>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>