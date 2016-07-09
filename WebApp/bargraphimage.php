<?php
include('phpgraphlib.php');
include_once 'dbconnect.php';
$graph = new PHPGraphLib(500,350);
$school="vijaywada";
$sql="SELECT count(*) as counts FROM student where Location='" . $school."' AND Been_to_school=1" ;
$sql1="SELECT count(*) as counts1 FROM student where Location='" . $school."' AND Been_to_school=0" ;
$result = $con->query($sql) or die('Query failed: ' . mysql_error());
$result1 = $con->query($sql1) or die('Query failed: ' . mysql_error());
$row = mysqli_fetch_assoc($result) ;
$row1 = mysqli_fetch_assoc($result1);
$data=array("Bridge"=>$row["counts"],"Main"=>$row1["counts1"]);
$graph->addData($data);
$graph->setTitle('Bridge vs Main Stream');
$graph->setGradient('red', 'maroon');
$graph->createGraph();
?>