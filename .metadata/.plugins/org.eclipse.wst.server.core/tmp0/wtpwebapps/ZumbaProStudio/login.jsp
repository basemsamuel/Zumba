<jsp:include page="header.jsp"></jsp:include>
<div class="mycontainer">
	<div align="center">
	<br>
	<br>
	<br>
		<table class="formtable">
			<tr>
				<td style="padding: 10px;">
					<div class='center'>
						<form style="width: 100%;" action="Login" method = "POST">
						    <h2>Login</h2>
						    <div>
						        <p>
							        <div class='right'>
							            <label for="email">Email:</label>
							            <input type="text" id="email" name="email">
							        </div>
						        </p>
						    </div>
						    
						    <div>
						        <p>
							        <div class='right'>
							            <label for="password">Password:</label>
							            <input type="password" id="password" name="password">
							        </div>
						        </p>
						    </div>
						    
						    
						    <div>
 						        <p>
						            <button type="submit" value="Submit">Submit</button>
						            <button type="reset" value="Reset">Reset</button>
						        </p>
						    </div>

						    
						    <div>
						    	<p>
						    		Not a member yet? Regiser <a href="register.jsp">Here</a>
						    	</p>
						    </div>
						</form>
					</div>
				
				</td>
			</tr>
		</table>
		<br>
		<div class="emsg">
			<p>
				${errorMessage}
			</p>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>