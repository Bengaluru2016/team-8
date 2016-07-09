<?php

include('phpgraphlib.php');
include_once 'dbconnect.php';
$graph = new PHPGraphLib(500,350);

$sql="SELECT * FROM bridge";
$data = array();
      $result = $con->query($sql);
    if($result->num_rows > 0){
         while($row = $result->fetch_assoc()) {
		$sname=$row["Science"]+$row["English"]+$row["Social"]+$row["Maths"];
		//$sname=$row["Bid"];
	$data[$row["Bid"]]="$sname";	
          }
		  }
$graph->addData($data);
$graph->setTitle('Widgets Produced');
$graph->setGradient('red', 'maroon');
$graph->createGraph();		  

?>