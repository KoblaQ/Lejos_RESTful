
//Celebrations

function readOneCelebration(){
	var xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
	  if (this.readyState == 4 && this.status == 200) {
		  var jsonCelebration=this.responseText;
		  //Add JSON string as a content of element resultone
		  document.getElementById("resultone").innerHTML = jsonCelebration;
		  //Parse json string to a Javascript object
		  var celebration=JSON.parse(jsonCelebration);
		  //print fish by function printOneFish.
		  printOneCelebration(celebration);
	  }
	};
	xmlhttp.open("GET", "/rest/celebrationservices/readallcelebrations", true);
	xmlhttp.send();	
}
function printOneCelebration(c){
	var s="<table border='1'>";
	s=s+"<tr>";
	s=s+"<td>"+c.id;
	s=s+"<td>"+c.name;
	s=s+"</table>";
	document.getElementById("name").innerHTML=s;
}

function readAllCelebrations(){
	var xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
	  if (this.readyState == 4 && this.status == 200) {
		  var jsoncelebrationlist=this.responseText;
		  //Add JSON string as a content of element resultall
		  document.getElementById("resultall").innerHTML = jsoncelebrationlist;
		  var celebrationlist=JSON.parse(jsoncelebrationlist);
		  //print celebration by function printAllCelebrations.
		  printAllCelebrations(celebrationlist);
	  }
	};
	xmlhttp.open("GET", "/rest/celebrationservices/readallcelebrations", true);
	xmlhttp.send();	
}

function printAllCelebrations(list){
	var s="<table border='1'>";
	for (i in list){//or for (var i=0;i<list.length;i++){
		s=s+"<tr>";
		s=s+"<td>"+list[i].id;
		s=s+"<td>"+list[i].name;
	}
	s=s+"</table>";
	document.getElementById("allnames").innerHTML=s;
}


//***********************************************************************************************
//***********************************************************************************************
// Print Messages
//create table Display_Message (id int not null auto_increment primary key, message varchar(100) not null )
function printOneMessage(m){
	var s="<table border='1'>";
	s=s+"<tr>";
	s=s+"<td>"+m.id;
	s=s+"<td>"+m.message;
	s=s+"</table>";
	document.getElementById("message").innerHTML=s;
}


function printAllMessage(list){
	var s="<table border='1'>";
	for (i in list){//or for (var i=0;i<list.length;i++){
		s=s+"<tr>";
		s=s+"<td>"+list[i].id;
		s=s+"<td>"+list[i].message;
	}
	s=s+"</table>";
	document.getElementById("allmessages").innerHTML=s;
}

//Read Messages
function readOneMessage(){
	var xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
	  if (this.readyState == 4 && this.status == 200) {
		  var jsonmessage=this.responseText;
		  //Add JSON string as a content of element resultone
		  document.getElementById("resultonemessage").innerHTML = jsonmessage;
		  //Parse json string to a Javascript object
		  var message=JSON.parse(jsonmessage);
		  //print fish by function printOneFish.
		  printOneMessage(message);
	  }
	};
	xmlhttp.open("GET", "/rest/displaymessageservices/allmessages", true);
	xmlhttp.send();	
}

function readAllMessage(){
	var xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
	  if (this.readyState == 4 && this.status == 200) {
		  var jsonmessagelist=this.responseText;
		  //Add JSON string as a content of element resultall
		  document.getElementById("resultallmessages").innerHTML = jsonmessagelist;
		  var messagelist=JSON.parse(jsonmessagelist);
		  //print celebration by function printAllCelebrations.
		  printAllMessages(messagelist);
	  }
	};
	xmlhttp.open("GET", "/rest/displaymessageservices/allmessages", true);
	xmlhttp.send();	
}


//***********************************************************************************************
//***********************************************************************************************
//Print Obstacle detected
//Database table Obstacle_Detected (id int not null auto_increment primary key, distance int, time timestamp)
function printOneObstacle(o){
	var s="<table border='1'>";
	s=s+"<tr>";
	s=s+"<td>"+o.id;
	s=s+"<td>"+o.distance;
	s=s+"<td>"+o.time;
	s=s+"</table>";
	document.getElementById("distance").innerHTML=s;
}


function printAllObstacles(list){
	var s="<table border='1'>";
	for (i in list){//or for (var i=0;i<list.length;i++){
		s=s+"<tr>";
		s=s+"<td>"+list[i].id;
		s=s+"<td>"+list[i].distance;
		s=s+"<td>"+list[i].time;
	}
	s=s+"</table>";
	document.getElementById("alldistance").innerHTML=s;
}

//Read Obstacle Detected

function readOneObstacle(){
	var xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
	  if (this.readyState == 4 && this.status == 200) {
		  var jsonobstacle=this.responseText;
		  //Add JSON string as a content of element resultone
		  document.getElementById("resultoneobstacle").innerHTML = jsonobstacle;
		  //Parse json string to a Javascript object
		  var obstacle=JSON.parse(jsonobstacle);
		  //print fish by function printOneFish.
		  printOneObstacle(obstacle);
	  }
	};
	xmlhttp.open("GET", "/rest/obstacledetectedservices/allobstacles", true);
	xmlhttp.send();	
}

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

//***********************************************************************************************
//***********************************************************************************************
// Print all light
//Table Light (intensity_level int primary key)

function printOneLight(l){
	var s="<table border='1'>";
	s=s+"<tr>";
	s=s+"<td>"+l.intensity_level;
	s=s+"</table>";
	document.getElementById("intensity_level").innerHTML=s;
}


function printAllLight(list){
	var s="<table border='1'>";
	for (i in list){//or for (var i=0;i<list.length;i++){
		s=s+"<tr>";
		s=s+"<td>"+list[i].intensity_level;
	}
	s=s+"</table>";
	document.getElementById("allintensity_level").innerHTML=s;
}

//Read light


function readOneLight(){
	var xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
	  if (this.readyState == 4 && this.status == 200) {
		  var jsonlight=this.responseText;
		  //Add JSON string as a content of element resultone
		  document.getElementById("resultonelight").innerHTML = jsonlight;
		  //Parse json string to a Javascript object
		  var light=JSON.parse(jsonlight);
		  //print fish by function printOneFish.
		  printOneLight(light);
	  }
	};
	xmlhttp.open("GET", "/rest/lightservices/readlinecolor", true);
	xmlhttp.send();	
}

function readAllLight(){
	var xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
	  if (this.readyState == 4 && this.status == 200) {
		  var jsonlightlist=this.responseText;
		  //Add JSON string as a content of element resultall
		  document.getElementById("resultallLight").innerHTML = jsonlightlist;
		  var lightlist=JSON.parse(jsonlightlist);
		  //print celebration by function printAllCelebrations.
		  printAllLight(lightlist);
	  }
	};
	xmlhttp.open("GET", "/rest/lightservices/readlinecolor", true);
	xmlhttp.send();	
}


//***********************************************************************************************
//***********************************************************************************************
//Print SlayRobot
//SlayRoboto (base_speed int not null, cycle int not null, 
//safety_distance decimal not null, linecolor int not null)
function printOneSlayRobot(sr){
	var s="<table border='1'>";
	s=s+"<tr>";
	s=s+"<td>"+sr.base_speed;
	s=s+"<td>"+sr.cycle;
	s=s+"<td>"+sr.safety_distance;
	s=s+"<td>"+sr.linecolor;
	s=s+"</table>";
	document.getElementById("base_speed").innerHTML=s;
}


function printAllSlayRobot(list){
	var s="<table border='1'>";
	for (i in list){//or for (var i=0;i<list.length;i++){
		s=s+"<tr>";
		s=s+"<td>"+list[i].base_speed;
		s=s+"<td>"+list[i].cycle;
		s=s+"<td>"+list[i].safety_distance;
		s=s+"<td>"+list[i].linecolor;
	}
	s=s+"</table>";
	document.getElementById("allbase_speed").innerHTML=s;
}

//Read SlayRoboto


function readOneLight(){
	var xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
	  if (this.readyState == 4 && this.status == 200) {
		  var jsonslayroboto=this.responseText;
		  //Add JSON string as a content of element resultone
		  document.getElementById("resultoneslayroboto").innerHTML = jsonslayroboto;
		  //Parse json string to a Javascript object
		  var slayroboto=JSON.parse(jsonslayroboto);
		  //print fish by function printOneFish.
		  printOneSlayRobot(slayroboto);
	  }
	};
	xmlhttp.open("GET", "/rest/slayrobotoservices/readall", true);
	xmlhttp.send();	
}

function readAllLight(){
	var xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
	  if (this.readyState == 4 && this.status == 200) {
		  var jsonslayrobotolist=this.responseText;
		  //Add JSON string as a content of element resultall
		  document.getElementById("resultallslayrobotot").innerHTML = jsonslayrobotolist;
		  var slayrobotolist=JSON.parse(jsonslayrobotolist);
		  //print celebration by function printAllCelebrations.
		  printAllSlayRobot(slayrobotolist);
	  }
	};
	xmlhttp.open("GET", "/rest/slayrobotoservices/readall", true);
	xmlhttp.send();	
}
