<?php

include('phpgraphlib.php');
include_once 'dbconnect.php';
$school=$_GET["schoolname"];
$graph = new PHPGraphLib(500,350);
$query1 = "SELECT `stud_id` FROM student WHERE `Location` = '".$school."'";
$data = array();
      $result = $con->query($query1);
	  
    if($result->num_rows > 0){
         while($row1 = $result->fetch_assoc()) {
			
			$sql="SELECT * FROM bridge WHERE `Bid` = '".$row1['stud_id']."'";
			$data = array();
			$result1 = $con->query($sql);
			if($result1->num_rows > 0){
				while($row = $result1->fetch_assoc()) {
					$sname=$row["Science"]+$row["English"]+$row["Social"]+$row["Maths"];
			//$sname=$row["Bid"];
					$data[$row["Bid"]]="$sname";	
				}
			}
         }
	}
	/*else
	{
		$query1 = "SELECT `Location` FROM student WHERE `Location` = '".$school."'";
		 $result2 = $con->query($query1);
		 $row = $result2->fetch_assoc();
		$data[$row["Location"]]="0";
		
	}*/
$graph->addData($data);
$graph->setTitle('Students Progress Marks');
$graph->setGradient('red', 'maroon');
$graph->createGraph();		  

?>