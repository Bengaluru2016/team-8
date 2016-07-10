<?php
include_once 'dbconnect.php';
$school=$_GET["schoolname"];
$query1 = "SELECT * FROM student WHERE `Location` = '".$school."'";
      $result = $con->query($query1);
	  echo "<table style= 'border-collapse:collapse'; border='1'>
	  <tr><th>student_id</th><th>Student_name</th><th>Gender</th><th>Student_Age</th><th>Parents_name</th><th>Phone</th><th>Sibblings</th><th>Language</th><th>Native</th><th>Par_Occupation</th><th>Par_income</th><th>Relocation</th></tr>";
    if($result->num_rows > 0){
         while($row1 = $result->fetch_assoc()) {
			 
					echo "<tr><td>".$row1["stud_id"]."</td><td>".$row1["stud_name"]."</td><td>".$row1["gender"]."</td><td>".$row1["stud_age"]."</td><td>".$row1["Parents_name"]."</td><td>".$row1["Phone"]."</td><td>".$row1["Siblings"]."</td><td>".$row1["Language"]."</td><td>".$row1["Native"]."</td><td>".$row1["Par_Occupation"]."</td><td>".$row1["Par_Income"]."</td><td>".$row1["Relocation"]."</td></tr>";
					//$data[$row["Bid"]]="$sname";	
				}
	}  

?>