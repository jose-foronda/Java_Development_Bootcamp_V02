/**
 * 
 */



 var string1 = document.getElementById("hiddenText").innerHTML;
//  console.log(string2);
//  document.getElementById("hiddenText2").innerHTML = string2;

//  var string1 = document.getElementById("hiddenText2").innerText;

 var searchedText = document.getElementById("searchedText").innerText;
 
 const regex1 = RegExp(searchedText, 'ig');
 const str1 = string1;//'table football, foosball';
 let array1;
 
 let counter = 0;
 
 while ((array1 = regex1.exec(str1)) !== null) {
 //   console.log(`Found ${array1[0]}. Next starts at ${regex1.lastIndex}.`);
     counter++;
   // expected output: "Found foo. Next starts at 9."
   // expected output: "Found foo. Next starts at 19."
 }
 
document.getElementById("coincidences").innerText = " " +  counter + " ";
document.getElementById("hiddenText").innerHTML = "";
document.getElementById("hiddenText").innerText = "";

//  console.log("counter is: " + counter); 