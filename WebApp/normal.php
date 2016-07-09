<?php
include('phpgraphlib.php');
$graph = new PHPGraphLib(500,350);

//Server connection. Put in separate file
$servername = "localhost";
    $username = "root";
    $password = "";
    $db="graphs";
    $con=  new mysqli($servername,$username,$password,$db);
    if($con->connect_error){
        die("Connection failed: ".$con->connect_error);
    }
//Server connection ends
$data=array();
 $sql = "SELECT firstname, percentage FROM student_attendance GROUP BY firstname";
 $result = $con->query($sql);
 if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
    $data[$row["firstname"]]=$row["percentage"];
    //echo $row["first"];]
    }
 }
 
$graph->addData($data);
$graph->setTitle('Widgets Produced');
$graph->setGradient('red', 'maroon');
$graph->createGraph();
?>
