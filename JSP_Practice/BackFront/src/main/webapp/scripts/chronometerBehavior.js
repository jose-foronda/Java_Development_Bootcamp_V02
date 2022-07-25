var intervalID = 0;
 
const SECONDS_UPPER_INTERVAL = 5;
const SECONDS_LOWER_INTERVAL = 0; 

let seconds = 5; 

const secondsId = "seconds"; 
 
function onStartChronometer() { 
    pauseChronometer();
    intervalID = setInterval(addSecond, 1000);
}

function pauseChronometer() { 
    clearInterval(intervalID); 
} 

function addSecond() {
    seconds--;
     if ( seconds >= SECONDS_LOWER_INTERVAL && seconds <= SECONDS_UPPER_INTERVAL) {
        updateScale(secondsId, seconds);
    } else {
        seconds = 0; 
        clearChronometer();
        redirectToNewURL();
    } 
}

function updateScale(id, unit) {
    document.getElementById(id).innerText = unit;
}

function scaleToZero(id) {
    document.getElementById(id).innerText = '0';
} 
  
function clearChronometer() {
    pauseChronometer();  
    seconds = 0;  
    scaleToZero(secondsId); 
} 

function redirectToNewURL() {
     location.assign("UserHome.jsp");
}

//calling method
onStartChronometer();


 