<jsp:include page="adminheader.jsp"></jsp:include>
<div class="mycontainer">
	<div align="center">
	<br>
	<h3>ADD NEW BATCH</h3>
	<br>
	<br>

	<div>
		<table class="formtable">
			<tr>
				<td style="padding: 10px;">
					<div class='center'>
						<form style="width: 100%;" action="Admin" method = "POST">
						    <h2>Create Batch</h2>
						    <input type="hidden" name="htmlFormName" value="AddBatch" />
						    <div>
						        <p>
							        <div class='right'>
							            <label for="name">Batch Name:</label>
							            <input type="text" id="name" name="name">
							        </div>
						        </p>
						    </div>
						    
						    <div>
						        <p>
							        <div class='right input-group date'>
							            <label for="stime">Start Time:</label>
										<input id="startDate" class="form-control" type="time" id="stime" name="stime">
							        </div>
						        </p>
						    </div>
						    
						    
						    <div>
						        <p>
							        <div class='right input-group date'>
							            <label for="etime">End Time:</label>
							            <input id="startDate" class="form-control" type="time" id="etime" name="etime">
							        </div>
						        </p>
						    </div>
						    
						    <div>
						        <p>
							        <div style="padding-left:20px;">
							        	<Table width="100%">
							        		<tr>
							        			<td>M</td>
							        			<td>Tu</td>
							        			<td>W</td>
							        			<td>Th</td>
							        			<td>F</td>
							        			<td>S</td>
							        			<td>Su</td>
							        		</tr>
							        		<tr>
							        			<td>
										            <input type="checkbox" id="M" name="M" value="M">
							        			</td>
							        			<td>
										            <input type="checkbox" id="Tu" name="Tt" value="Tu">
							        			</td>
							        			<td>
										            <input type="checkbox" id="W" name="W" value="W">
							        			</td>
							        			<td>
										            <input type="checkbox" id="Th" name="Th" value="Th">
							        			</td>
							        			<td>
										            <input type="checkbox" id="F" name="F" value="F">
							        			</td>
							        			<td>
										            <input type="checkbox" id="S" name="S" value="S">
							        			</td>
							        			<td>
										            <input type="checkbox" id="Su" name="Su" value="Su">
							        			</td>
							        		</tr>
							        	</Table>
							            
							        </div>
						        </p>
						    </div>
						    
						    <div>
						        <p>
							        <div class='right'>
							            <label for="capacity">Capacity:</label>
							            <input type="number" id="capacity" name="capacity">
							        </div>
						        </p>
						    </div>
						    
						    <div>
						        <p>
							        <div class='right'>
							            <label for="description">Description:</label>
							            <input type="text" id="description" name="description">
							        </div>
						        </p>
						    </div>
						    <div>
 						        <p>
						            <button type="submit" value="Submit">Submit</button>
						            <button type="reset" value="Reset">Reset</button>
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
				${batcherrorMessage}
			</p>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>