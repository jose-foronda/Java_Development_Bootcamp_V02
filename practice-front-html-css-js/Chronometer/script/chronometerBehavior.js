var intervalID = 0;

let soundSelector = true;
const tick_audio = document.getElementById("tick_audio");
const tock_audio = document.getElementById("tock_audio");

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

const pauseButtonHTML = '<i class="material-symbols-outlined">pause_presentation</i>';
const playButtonHTML = ' <i class="material-icons">smart_display</i>';

var startPauseState = true;

function startPauseChronometer() {
    switch (startPauseState) {
        case true:
            startPauseState = false;
            onStartChronometer();
            break;

        default:
            startPauseState = true;
            onPauseChronometer();
            break;
    }
}

function onPauseChronometer() {
    pauseChronometer();
    changeToPlayButton();
}

function onStartChronometer() {
    changeToPauseButton();
    pauseChronometer();
    intervalID = setInterval(addSecond, 1000);
}

function pauseChronometer() { 
    clearInterval(intervalID); 
}

function changeToPauseButton() { 
    let startPauseHTMLelement = document.getElementsByClassName("control-pause-start");
    startPauseHTMLelement[0].innerHTML = pauseButtonHTML;
}

function changeToPlayButton() {
    let startPlayHTMLelement = document.getElementsByClassName("control-pause-start");
    startPlayHTMLelement[0].innerHTML = playButtonHTML;
}

function addSecond() {
    seconds++;
    SoundReproduction();
    if (seconds < MAX_SECONDS) {
        updateScale(secondsId, seconds);
    } else {
        seconds = 0;
        scaleToZero(secondsId);
        addMinutes();
    } 
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

function clearChronometer() {
    pauseChronometer();
    changeToPlayButton();
    startPauseState = true;
    seconds = 0;
    minutes = 0;
    hours = 0;
    days = 0;

    scaleToZero(secondsId);
    scaleToZero(minutesId);
    scaleToZero(hoursId);
    scaleToZero(daysId);
}

function SoundReproduction() {
    if (soundSelector) {
        tick_audio.play();
    } else {
        tock_audio.play();
    }
    soundSelector = !soundSelector;
}
