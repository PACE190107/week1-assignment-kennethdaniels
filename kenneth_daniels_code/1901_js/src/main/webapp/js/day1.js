"use strict" //ensures the declaration of all variables
//have to specify type when declaring variables
var x = 10;
//alert("never use this!!");
//document.write("bad practice - never use this!!");
console.log(x);

var y=20;
console.log(y + typeof(y));
var y="hello world";
console.log(y + typeof(y));
//this is not possible --why?
//cannot re-declare var variable into a let variable inside of the same scope
//let y = 30
//console.log(y + typeof(y));

//cannot re-declare or re-assign let variable into a var variable inside of the same scope
//let z = 30;
//var z = 40;

//values of constants cannot be changed/re-assigned/re-declared after declaration
//const a = 12345;
//const a = 23;

//scopes - global, local, and lexical
//const is block scope
//let is block scope
//var can't be blocked inside a block scope

//var b = 10;
//if (b == 10){
//	var variableDeclaredUsingVar = "some string";
//}
//console.log(b);
//console.log(variableDeclaredUsingVar);

let c = 20;
if (c == 20) {
	let variableDeclaredUsingLet = "some string";
	console.log(c);
	console.log(variableDeclaredUsingLet);
}
console.log(c);
//console.log(variableDeclaredUsingLet);

//commonly seen error messages --> TypeError, NameError, ReferenceError

//js has methods and functions
//functions are objects in js

let d = "20";
let e = true;
let f = {};
let g = [];
let h = null;
let i = 0/0;
let j = Yuvi;
//k
//NaN -> Not a number

console.log(typeof(c)+ " " + typeof(d) + " " + typeof(e) + " " + typeof(f) + " " + typeof(g) + " " + typeof(h) + " "
		+ typeof(i));

// === checks for equality AND type
//Truthy and Falsy
/*Truthy --> all values are considered truthy unless they are defined as falsy
Falsy --> False, 0, null, undefined, NaN, ""
	-false, 0, and "" are equivalent
	-null and undefined are not equal to anything except each other and themselves
	-NaN is not equal to anything including NaN
*/
//simplest function
function f1(){
	return true;
}

//anonymous function
let f2 = function(){
	return true;
}

console.log(f1);          //printing the function
console.log(typeof(f1));
console.log(f2); 
console.log(typeof(f2));


(function() {
	console.log("does this work? what does self-invoking really mean?")
} ());

(function () {
	console.log("syntax 1");
} ());

(function (){
	console.log("syntax 2")
})();

let l = (function (){
	return true;
})();

console.log("value of 1 " + 1);


//function declaration
function add(a, b){
	return a + b;
}

//function expression (cannot hoist)
let c = function (a,b){
	return a + b;
}

//Arrow function - ES6 feature; multiple arguments
let d = (a,b) => {return a + b;}
//Arrow function - concise syntax
let e = (a,b) => a + b;

function square(x){
	return x * x
}

//arrow function - single argument
const q = x => {return x * x};
const p = x => x * x;

const name = "Yuvi"
function sayName(){
	const mesg = "My name is " + name;
	console.log(mesg);
}

//Arrow function - no argument
const sn = () => {
	const mesg = "My name is " + name;
	console.log(mesg);
}

//closure
// 1,2,3
//var is lexical scope and can't be blocked in a block scope (unlike global scope)
function add(){
	var count = 0
	count += 1;
	console.log(count);
}

add();
add();
add();

let close = (function () {
	var count = 0;
	return function() {
		count += 1;
		return count;
	}
})();
console.log(close());
console.log(close());
console.log(close());

function simulateMouseOver(){
	document.getElementById("modifyThisByJS").innerHTML = "Did this get modified by JS, really?"
}
