/**
 * 
 */

//***********************************************************************************************
//***********************************************************************************************
//Print Obstacle detected
//Database table Obstacle_Detected (id int not null auto_increment primary key, distance int, time timestamp)

function printAllObstacles(list){
	var s="<table border='1'>";
	s += "<tr><th>No.</th><th>Cycle Obstacle Was Detected</th></tr>";
	for (i in list){//or for (var i=0;i<list.length;i++){
		s=s+"<tr>";
		s=s+"<td>"+list[i].id;
		s=s+"<td>"+list[i].distance;
	}
	s=s+"</table>";
	document.getElementById("alldistance").innerHTML=s;
}

//Read Obstacle Detected

function readAllObstacles(){
	var xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
	  if (this.readyState == 4 && this.status == 200) {
		  var jsonobstaclelist=this.responseText;
		  //Add JSON string as a content of element resultall
		  document.getElementById("resultallobstacles").innerHTML = jsonobstaclelist;
		  var obstaclelist=JSON.parse(jsonobstaclelist);
		  //print celebration by function printAllCelebrations.
		  printAllObstacles(obstaclelist);
	  }
	};
	xmlhttp.open("GET", "/rest/obstacledetectedservices/allobstacles", true);
	xmlhttp.send();	
}

// PRINT COUNT 
function printOnecount(co){
    var s="<table border='1'>";
    s += "<tr><th>Obstacle Count</th></tr>";
    s=s+"<tr>";
    s=s+"<td>"+co;
    s=s+"</table>";
    document.getElementById("count").innerHTML=s;
}
//Read count?

function readAllCount(){
    var xmlhttp=new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
          var jsonCount=this.responseText;
          //Add JSON string as a content of element resultall
          document.getElementById("allcount").innerHTML = jsonCount;
          var countlist=JSON.parse(jsonCount);
          //print celebration by function printAllCelebrations.
          printOnecount(countlist);
      }
    };
    xmlhttp.open("GET", "/rest/obstacledetectedservices/obstaclecount", true);
    xmlhttp.send();
}

//***********************************************************************************************
//***********************************************************************************************
// Print all light
//Table Light (intensity_level int primary key)

// Read light
function readAllLight(){
	var xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
	  if (this.readyState == 4 && this.status == 200) {
		  var jsonlightlist=this.responseText;
		  //Add JSON string as a content of element resultalllight
		  document.getElementById("resultalllight").innerHTML = jsonlightlist;
		  var lightlist=JSON.parse(jsonlightlist);
		  //print fish by function printOneFish.
		  printAllLight(lightlist);
	  }
	};
	xmlhttp.open("GET", "/rest/lightservices/readlinecolor", true);
	xmlhttp.send();	
}

//Print light

function printAllLight(list){
	var s="<table border='1'>";
	s += "<tr><th>Light Intensity</th></tr>";
	for (i in list){//or for (var i=0;i<list.length;i++){
		s=s+"<tr>";
		s=s+"<td>"+list[i].intensity_level;
	}
	s=s+"</table>";
	document.getElementById("alllight").innerHTML=s;
}




//***********************************************************************************************
//***********************************************************************************************
//Print SlayRobot
//SlayRoboto (base_speed int not null, cycle int not null, 
//safety_distance decimal not null, linecolor int not null)


function printAllSlayRobot(list){
	var s="<table border='1'>";
	for (i in list){//or for (var i=0;i<list.length;i++){
		s=s+"<tr>";
		s=s+"<td>Base Speed</td><td>"+list[i].base_speed;
		s=s+"<td>Cycle</td><td>"+list[i].cycle;
		s=s+"<td>Safety Distance</td><td>"+list[i].safety_distance;
		s=s+"<td>Line Color</td><td>"+list[i].linecolor;
	}
	s=s+"</table>";
	document.getElementById("allbase_speed").innerHTML=s;
}

//Read SlayRoboto


function readAllSlayRoboto(){
    var xmlhttp=new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
          var jsonslayrobotolist=this.responseText;
          //Add JSON string as a content of element resultall
          document.getElementById("resultallslayroboto").innerHTML = jsonslayrobotolist;
          var slayrobotolist=JSON.parse(jsonslayrobotolist);
          //print celebration by function printAllCelebrations.
          printAllSlayRobot(slayrobotolist);
      }
    };
    xmlhttp.open("GET", "/rest/slayrobotoservices/readall", true);
    xmlhttp.send();
}


