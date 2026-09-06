JavaScript



comments --> //single line comment

 	     /\*multi line comment\*/



data types --> undefined, null , Boolean ,string, symbol (it is an immutable primitive value that is unique), number and object(can store a lot of key value pairs)



JavaScript is a dynamically typed language i.e. the datatype of the variables can be changed at run time.



ways to declare a variable(keywords):

1. var
2. let
3. const  //used for defining constant values, cannot be changed or reassigned (all caps)



all lines in JavaScript end with a semicolon(;)



console.log allows you to see things in the console



for initializing the variables we use the assignment operator(=)



uninitialized values hold undefined



variable names and function names in JavaScript are case sensitive



we use camelCase for writing variable and function names



OPERATORS:



arithmetic operators: +,-,\*,/,%   ---> binary operators

++,--   unary operators

+=,-=,/=,\*=,

==  --> equality operator (converts both values being compared to a common datatype)

=== --> strict equality (does not do type conversion)

!= (inequality operator), !== (strict inequality operator)

logical operators: >,<,<=,>=

\&\& (and),|| (or)



typeof is used to know the type of the variable.



String declaration: '',"",``(backticks) ${}



for escaping literal quotes we use \\.



\\' --> single quote

\\" --> double quote

\\\\ --> backslash

\\t --> tab

\\n --> new line



STRINGS:



"+" is used to concatenate strings. += can also be used for strings



stringName.length gives the length of the string



the elements/ characters of a string can be accessed using zero based indexing.



Strings are immutable i.e. they cannot be altered once created.



but this problem can be overcome by slicing (slice(),substring(),substr())



ARRAY



if the elements of an array are arrays then it is called as a nested array or a multi dimensional array



the elements of the array can be accessed by using indexing



for a two dimensional array double bracket notation is used (\[]\[])



push(): used to add elements at the end of the array



pop(): removes and returns the last element of the array



shift(): removes and returns the first element of the array



unshift(): adds an element to the beginning of the array



two arrays can be joined together by using the concat function



arr1.concat(arr2)



FUNCTION



a function allows us to create reusable code in JavaScript



they are created by using the **function** keyword



Syntax:



function function\_name(){



}



parameters are variables that act as place holders for the values that are to be input to a function when it is called.



a function can return values by using the return keyword



if the return value is not specified then it returns undefined



SCOPE



scope refers to the visibility of variables



the variables which are defined outside of a function have global scope(that means they can be seen anywhere in the JavaScript code)



if the variables are declared without the var(or any) keyword in a function they have global scope and can be used anywhere in the function.

or they become global automatically



if the var keyword is used it will be scooped to the function



variables declared within the function as well as the function parameters have local scope



it is possible to have both global and local variables with the same name (the local variable takes precedence over the global variables)



SWITCH



used when there are multiple conditions (used instead of if else statements).



Syntax:



switch (val){

 	case 1:

 		answer="a";

 		break;

 	default:

 		answer="";

}



if we have the same value for multiple cases we omit the break statement (ex: 1,2,3--> low)



OBJECTS



these are key value pairs, values can be any datatype



objects are similar to arrays but instead of using indexing we use properties/keys to access the data



the values can be accessed by dot notation or bracket notation (mostly used when the key has space in it)



the dot notation is used to set the object property to a new value



we can use both dot and bracket notation to add properties to an object



we use the delete keyword to delete the properties of obj



in order to access sub-properties of an object(i.e. nested objects) we can use chaining of dot/bracket notation





**parseInt ---> used to convert a string into an integer (if not possible it return NaN , not a number)**



parseInt(num,radix) ---> radix tell the computer what number it is (binary-2) by default it is 10





difference between let and var:



let does not allow you to declare a variable twice





"use strict" ---> catches common coding mistakes and unsafe actions



a const array cannot be reassigned directly but we can use indexing to do this



we can still mutate an array or an object even if it is declared as const



we don't want to change the data in an object we use object.freeze(obj)





ARROW FXN



if a function does not have a name then it is called as an anonymous function



The anonymous functions can be converted into an arrow function



an arrow function is more simpler to use and it is quicker



Syntax:



()=>{}



if we have only one return value we don't need curly braces and return keyword





... is called as the rest operator converts whatever is passed into an array



...array\_name



Spread operator ---> looks just like a rest operator(...)

 		     Expands an already existing array (or) spreads out an array

 		     \[...arr1]

 		     when we want a copy of the array but dont want it to be changed





destructuring assignment:



const {property : value}=obj;



when we want to assign the values of the obj to the variables (can also be used for nested objects)



it also works for arrays, the only difference is we cannot specify which element we want (we get elements based on order)



for 4th element: const \[x,y,,z]=\[1,2,3,4,5,6,7];



\[a,b]=\[b,a] --> changes the values of a and b.







DOM:



document object model



it is a built in obj that has many properties and methods



content structure and style can be manipulated



this is used to modify, create or delete elements of a website



tree of nodes



elements, attributes, text content and even lines breaks and comments are all types of nodes



it is a property of a window object (global top level object)--> tab



ids, classes and styles also nodes

