<html>
<head><title>RPS Multipart POST</title></head>
<body>
Choose your move.
<form method="POST" action="./multipart"  enctype="multipart/form-data">
  <label><input type="radio" name="move" value="R"> Rock</label>
  <label><input type="radio" name="move" value="P"> Paper</label>
  <label><input type="radio" name="move" value="S"> Scissors</label>
  <input type="submit" value="Shoot!">
</form>
</body>
</html>
