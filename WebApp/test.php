<?php 
echo "hello";
$school=$_GET["schoolname"];
echo $school;


?>
<?php
session_start();
include_once 'dbconnect.php';
//include("phpgraphlib.php");
//$graph=new PHPGraphLib(550,350); 
       
//$dataArray=array();
  
  $school=$_GET["schoolname"];
//get data from database
echo $school;
$sql="SELECT * FROM student";
$result = $con->query($sql) or die('Query failed: ' . mysql_error());
if ($result) {
  while ($row = mysqli_fetch_assoc($result)) {
      //$salesgroup=$row["schoolname"];
      //$count=$row["count"];
      //add to data areray
    //  $dataArray[$row[schoolname]]=1000;
	echo $row["schoolname"];
  }
}
  
//configure graph
//$graph->addData($dataArray);
//$graph->setTitle("Sales by Group");
//$graph->setGradient("lime", "green");
//$graph->setBarOutlineColor("black");
//$graph->createGraph();
?>