

// let pageTitle = document.title.toLocaleLowerCase();
// document.title is not working... need to ask TA or Instructor

let pageTitle = document.URL.split('/').pop();
console.log(pageTitle)

if (pageTitle == "date") {
	alert("This is the date template");
} else if (pageTitle == "time") {
	alert("This is the time template");
}