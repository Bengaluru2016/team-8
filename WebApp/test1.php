<html>
<body>
<?php
echo"<img src=\"http://localhost/CFG/bargraphimage.php/?schoolname=".$_GET['schoolname']."\"/>";
echo"<img src=\"http://localhost/CFG/marks1.php/?schoolname=".$_GET['schoolname']."\"/>";
echo"<img src=\"http://localhost/CFG/attendance.php/?schoolname=".$_GET['schoolname']."\"/>";
echo"<a href=\"http://localhost/CFG/studentinfo.php/?schoolname=".$_GET['schoolname']."\">"."Click here to know details of each student in this school"."</a>";
?>
</body>
</html>
