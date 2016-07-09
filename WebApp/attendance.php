<?php

include('phpgraphlib.php');
include_once 'dbconnect.php';
$graph = new PHPGraphLib(500,350);
$school=$_GET["schoolname"];
$query1 = "SELECT `stud_id` FROM student WHERE `Location` = '".$school."'";
//$sql="SELECT * FROM attendance";
$data = array();
      $result = $con->query($query1);

	  if($result->num_rows > 0){
         while($row1 = $result->fetch_assoc()) {
			
			$sql="SELECT * FROM attendance WHERE `id` = '".$row1['stud_id']."'";
			$data = array();
			$result1 = $con->query($sql);
			if($result1->num_rows > 0){
				while($row = $result1->fetch_assoc()) {
					$data[$row["id"]]=$row["present"];	
				}
			}
         }
	}
	  
	  
	  
$graph->addData($data);
$graph->setTitle('Students Attendance');
$graph->setGradient('red', 'maroon');
$graph->createGraph();		  

?>