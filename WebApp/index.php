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
</header>
		<div id="banner">
		
			<a href="https://www.facebook.com" title="FACEBOOK" target="_blank">
				<img src="Facebook-icon-logo.jpg" align="right" style="width:42px;height:42px;top:100px;border:0;margin: 0;
             padding: 0;position:absolute;right:20px;" >
			</a>
			<a href="https://www.twitter.com" title="TWITTER" target="_blank">
				<img src="twitter-icon.png" align="right" style="width:42px;height:42px;top:150px;border:0;margin: 0;
              padding: 0;position:absolute;right:20px;">
			</a>
			<a href="https://www.linkedin.com" title="LINKEDIN" target="_blank">
			<img src="download.png" align="right" style="width:42px;height:42px;top:200px;border:0;margin: 0;
             padding: 0;position:absolute;right:20px;" >
	         </a>
			 <a href="https://www.plus.google.com" title="GOOGLE+" target="_blank">
			<img src="Google-plus-icon.png" align="right"style="width:42px;height:42px;top:250px;border:0;margin: 0;
             padding: 0;position:absolute;right:20px;" >
	         </a>
		</div>
		<div id="content">
						<!--<iframe width="844" height="475" src="https://www.youtube.com/embed/lBBO0T8iCjA" frameborder="0" allowfullscreen></iframe>-->
		</div>
		
	</div>
<div class="wrapper" style="background-image: url('logo12.png'); background-repeat: no-repeat;
    background-position: center;
    background-size: 100%;
	min-width:100%;
    width: 100%;
    height: 100%;">
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
			echo "<p style='color:red;font-size:28px;font-family:TimesNewRoman;'>The List of Branches managed by Samridhdhi Trust..<br/></p>";
			if ($result->num_rows > 0) {
    // output data of each row
			while($row = $result->fetch_assoc()) {
				
			echo "<a style='font-size:25px;font-family:TimesNewRoman;' href='http://localhost/CFG/test1.php/?schoolname=".$row["Location"]."'>" . $row["Location"]. "<br>";
			}
			} else {
			echo "0 results";
		}
			$con->close();

			 } ?>
			</ul>
	</div>	
	
<br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br>	
</div>
<script src="js/jquery-1.10.2.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>

</html>

