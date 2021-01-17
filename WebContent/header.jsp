<html>
<head>
<title>Patient portal</title>

<style>

fieldset {
	display: block;
	padding-top: 0.35em;
	padding-bottom: 0.625em;
	padding-left: 10%;
	padding-right: 10%;
	border: 2px groove(internal value);
}
.error{
color: red;
}

.header {
	height: 100% width: 25%;
	background-color: #c1d7d7;
	padding-bottom: 50px;
	border: 1;
	font-family:cursive;
}

.footer {
	position: absolute; left : 0;
	bottom: 0;
	height: 40px;
	width: 100%;
	background-color: #5a8c8c;
	padding-bottom: 20px;
	left: 0;
}
a:link, a:visited {
  background-color: #5a8c8c;
  color: white;
  padding: 5px 12px;
  text-align: center;
  text-decoration : none;
  display: inline-block;
}

a:hover, a:active {
  background-color: #34abeb;
}

#doctorlist {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#doctorlist td, #doctorlist th {
  border: 1px solid #ddd;
  padding: 8px;
}

#doctorlist tr:nth-child(even){background-color: #f2f2f2;}

#doctorlist tr:hover {background-color: #ddd;}

#doctorlist th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: #5a8c8c;
  color: white;
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<div class="header">
		<h1 align="center">Hospital management</h1>
	</div>
	<hr>