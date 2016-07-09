<?php

include('phpgraphlib.php');
include_once 'dbconnect.php';
$graph = new PHPGraphLib(500,350);

$sql="SELECT * FROM attendance";
$data = array();
      $result = $con->query($sql);
    if($result->num_rows > 0){
         while($row = $result->fetch_assoc()) {
		
		
	$data[$row["id"]]=$row["present"];	
          }
		  }
$graph->addData($data);
$graph->setTitle('Students Attendance');
$graph->setGradient('red', 'maroon');
$graph->createGraph();		  

?>