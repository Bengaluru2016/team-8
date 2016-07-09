<?php
session_start();
include_once 'dbconnect.php';
?>
<!DOCTYPE html>
<html>
<head>
	<title>Samridhi Trust</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" >
	<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
	
</head>
<body>

<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar1">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.php">Samridhi Trust</a>
		</div>
		<div class="collapse navbar-collapse" id="navbar1">
			<ul class="nav navbar-nav navbar-right">
				<?php if (isset($_SESSION['usr_id'])) { ?>
				<li><p class="navbar-text">Signed in as <?php echo $_SESSION['usr_name']; ?></p></li>
				<li><a href="logout.php">Log Out</a></li>
				<?php } else { ?>
				<li><a href="pmlogin1.php">Login</a></li>
				<li><a href="adlogin.php">Admin</a></li>
				
				
				
				<?php } ?>
			</ul>
			</div>
			</div>
			</nav>
			<div>
			<ul>
							
			<?php if (isset($_SESSION['usr_id'])) {  
			$sql = "SELECT * FROM student";
					$result = $con->query($sql);

			if ($result->num_rows > 0) {
    // output data of each row
			while($row = $result->fetch_assoc()) {
				
			echo "<a href='http://localhost/CFG/test1.php/?schoolname=".$row["Location"]."'>" . $row["Location"]. "<br>";
			}
			} else {
			echo "0 results";
		}
			$con->close();

			 } ?>
			</ul>
	</div>	
	


<script src="js/jquery-1.10.2.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>

