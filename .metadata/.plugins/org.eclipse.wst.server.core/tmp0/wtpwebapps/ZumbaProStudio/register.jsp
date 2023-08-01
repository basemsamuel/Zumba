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
						<form style="width: 100%;" action="Register" method = "POST">
						    <h2>Register</h2>
						    
						    <div>
						        <p>
							        <div class='right'>
							            <label for="fname">First Name:</label>
							            <input type="text" id="fname" name="fname" value='${fname}'>
							        </div>
						        </p>
						    </div>
						    
						    <div>
						        <p>
							        <div class='right'>
							            <label for="lname">Last Name:</label>
							            <input type="text" id="lname" name="lname" value='${lname}'>
							        </div>
						        </p>
						    </div>
						    
						    <div>
						        <p>
							        <div class='right'>
							            <label for="age">Age:</label>
							            <input type="number" id="age" name="age" value='${age}'>
							        </div>
						        </p>
						    </div>
						    
						    <div>
						        <p>
							        <div class='right'>
							            <label for="gender">Gender:</label>
							            <select id="gender" name="gender" style="width:207px; height:26px">
							            	<option value="male">Male</option>
							            	<option value="female">Female</option>
							            </select>
							        </div>
						        </p>
						    </div>
						    
						    <div>
						        <p>
							        <div class='right'>
							            <label for="email">Email:</label>
							            <input type="text" id="email" name="email" value='${email}'>
							        </div>
						        </p>
						    </div>
						    
						    <div>
						        <p>
							        <div class='right'>
							            <label for="address">Address:</label>
							            <input type="text" id="address" name="address" value='${address}'>
							        </div>
						        </p>
						    </div>
						    
						    <div>
						        <p>
							        <div class='right'>
							            <label for="city">City:</label>
							            <input type="text" id="city" name="city" value='${city}'>
							        </div>
						        </p>
						    </div>
						    
						    <div>
						        <p>
							        <div class='right'>
							            <label for="zipcode">Zip:</label>
							            <input type="text" id="zipcode" name="zipcode" value='${zipcode}'>
							        </div>
						        </p>
						    </div>
						    
						    
						    <div>
						        <p>
							        <div class='right'>
							            <label for="phone">Phone:</label>
							            <input type="number" id="phone" name="phone" value='${phone}'>
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
							        <div class='right'>
							            <label for="repassword">ReEnter Password:</label>
							            <input type="password" id="repassword" name="repassword">
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
						    		Already have an account? <a href="login.jsp">Sign In</a>
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