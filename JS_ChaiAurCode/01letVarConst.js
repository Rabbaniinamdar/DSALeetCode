const userId = 567;
//const not allow you to change the value or we cannot reinitialized it
var userName = "rabbani"

var userName = "inamdar"
/*in JS var allow you to redefine the same name again and again and allow you to reinitializ. 
bcz of this, issue occusre in block scope and functional scope. to solve this js introduced the let keyword*/

let userMail = "rabbani@gmail.com"
//let userMail = "rabbani@gmail.com" ->
/*in JS let not allow you to redefine the same name 
 but it allow you to reinitializ*/

console.table([userId, userName, userMail, address])