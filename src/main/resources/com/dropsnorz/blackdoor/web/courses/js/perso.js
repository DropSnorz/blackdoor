/*Configuration des elements qui changent lorsque l'on utilise le menu */
$("#menu-toggle").click(function(e) {
    e.preventDefault();
    $("#wrapper").toggleClass("toggled");
    $("#spanMenu").toggleClass("glyphicon-menu-hamburger glyphicon-remove");
});

/* Configuration Zone de code CodeMirror */
var zones =  document.getElementsByClassName("zoneCode");

Array.prototype.forEach.call(zones, function(z) {
    console.log("coucou");
    var editeur = CodeMirror.fromTextArea(z, {
        lineNumbers: true,
        matchBrackets: true,
        mode:  "text/x-java",
        theme: "night",
        viewportMargin: Infinity,
        indentUnit: 3,
        readOnly: "nocursor",
    });
});
