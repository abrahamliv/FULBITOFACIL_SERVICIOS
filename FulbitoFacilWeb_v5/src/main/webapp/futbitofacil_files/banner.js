// JavaScript Document

// original content taken from Nic's JavaScript Page with permission
// lack of these three lines will result in copyright infringment
// made by: Nic's JavaScript Page - http://www.javascript-page.com

var currentdate = 0;
var core = 0;

function initArray() {

this.length = initArray.arguments.length;
  for (var i = 0; i < this.length; i++) {
  this[i] = initArray.arguments[i];
  }
}

link = new initArray(
"academiadefutbol.htm",
"http://www.productosbioproperu.com",
"http://www.pavimentosdeportivos.com.pe"
);

image = new initArray(
"graficos/banner.gif",
"graficos/bannerbiopro.gif",
"graficos/bannerpavimentos.gif"
);

text = new initArray(
"",
"",
""
);

var currentdate = new Date();
var core = currentdate.getSeconds() % image.length;
var ranlink  = link[core];
var ranimage = image[core];
var rantext  = text[core];

document.write('<a href=\"' +ranlink+ '\"><img src=\"'+ranimage+'\" border="0" alt=\"'+rantext+'\"></a>');

//-->
