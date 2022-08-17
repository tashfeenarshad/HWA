"use strict";
//divs
let resultsDiv = document.querySelector("#results-div");


//inputs
let carMakei = document.querySelector("#carMakeInput");
let bhpi = document.querySelector("#BhpInput");



//buttons
let createBtn = document.querySelector("#createBtn");

//functions
let printResults =(result) => {
    let entryDiv = document.createElement("div")
    entryDiv.setAttribute("class", "entry-div");
    entryDiv.textContent=`${result.id}|${result.carMake} | ${result.bhp}`;

    resultsDiv.appendChild(entryDiv);
}

let getAll = () => {
    axios.get("http://localhost:8080/cars/getAll")
    .then(res=> {
        resultsDiv.innerHTML = "" ;

    let results = res.data
        // on each iteration only ony result will appeear
        for (let result of results){
            printResults(result);
        }

}).catch(err => {console.log(err);
});
}

let create = () => {
    let obj = {
        
        "carMake": carMakei.value,
        "bhp": bhpi.value
    }


    axios.post("http://localhost:8080/cars/create",obj)
    .then(res =>{
            getAll();
    }).catch(err => {console.log(err);});


}


// listeners
 createBtn.addEventListener("click",create);
