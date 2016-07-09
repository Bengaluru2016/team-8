
<?php
session_start();
include_once 'dbconnect.php';
include("phpgraphlib.php");
$graph=new PHPGraphLib(550,350); 
       
$dataArray=array();
  
  $school=$_GET["schoolname"];
$school="vijaywada";

 //get data from database
echo $school;
$sql="SELECT count(*) as counts FROM student where Location='" . $school."' AND Been_to_school=1" ;
$sql1="SELECT count(*) as counts1 FROM student where Location='" . $school."' AND Been_to_school=0" ;
$result = $con->query($sql) or die('Query failed: ' . mysql_error());
$result1 = $con->query($sql1) or die('Query failed: ' . mysql_error());
$row = mysqli_fetch_assoc($result) ;
$row1 = mysqli_fetch_assoc($result1) ;
     

  
  
//configure graph
//$graph->addData($dataArray);
//$graph->setTitle("Sales by Group");
//$graph->setGradient("lime", "green");
//$graph->setBarOutlineColor("black");
//$graph->createGraph();
?>