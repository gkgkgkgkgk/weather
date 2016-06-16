<html>
<head>

</head>
<body>

<h1>Weather Data</h1>

<h4>Choose city</h4>

<form action="/WeatherSite/getforcity" method="post">
    <input type="radio" name="city" value="1"> London <br/>
    <input type="radio" name="city" value="2"> Hong Kong
    <input type="submit">
</form>

<h2>Live Weather Data</h2>
<h4>Date : ${data.date}</h4>
<h4>City : ${data.city}</h4>
<h4>Outlook : ${data.outlook}</h4>
<h4>Temp (C): ${data.tempc}</h4>
<h4>Temp (F): ${data.tempf}</h4>
<h4>Sunrise : ${data.sunrise}</h4>
<h4>Sunset : ${data.sunset}</h4>
</body>
</html>