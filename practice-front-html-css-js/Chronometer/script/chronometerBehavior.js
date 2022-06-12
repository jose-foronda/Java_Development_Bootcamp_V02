var intervalID = 0;

const MAX_SECONDS = 60;
const MAX_MINUTES = 60;
const MAX_HOURS = 24;
const MAX_DAYS = 100;

let seconds = 0;
let minutes = 0;
let hours = 0;
let days = 0;

const secondsId = "seconds";
const minutesId = "minutes";
const hoursId = "hours";
const daysId = "days";

function startChronometer() {
   intervalID = setInterval(addSecond, 1000);
}

function addSecond() {
    seconds++;
    if (seconds < MAX_SECONDS) {
        updateScale(secondsId, seconds);
    } else {
        seconds = 0;
        scaleToZero(secondsId);
        addMinutes();
    }
    // console.log(seconds);
}

function updateScale(id, unit) {
    document.getElementById(id).innerText = unit < 10 ? '0' + unit : unit; 
}

function scaleToZero(id) {
     document.getElementById(id).innerText = '00'; 
}

function addMinutes() {
    minutes++;
    if (minutes < MAX_MINUTES) {
        updateScale(minutesId, minutes);
    } else {
       minutes = 0; 
       scaleToZero(minutesId);
       addHour();
    }
}

function addHour() {
    hours++;
    if (hours < MAX_HOURS) {
        updateScale(hoursId, hours);
    } else {
        hours = 0;
        scaleToZero(hoursId);
        addDay();
    }
}

function addDay() {
    days++;
    if (days < MAX_DAYS) {
        updateScale(daysId, days);
    } else {
      days = 0;
      scaleToZero(daysId);  
    }
}
 

function pauseChronometer() {
    clearInterval(intervalID);
}

function clearChronometer() {
    pauseChronometer();
    seconds = 0;
    minutes = 0;
    hours = 0;
    days = 0;

    scaleToZero(secondsId);
    scaleToZero(minutesId);
    scaleToZero(hoursId);
    scaleToZero(daysId);
}