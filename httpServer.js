var http = require("http");
var server = http.createServer(function(request,response){
    console.log("response recieved");
    response.setHeader("Content-type","text/html");
    response.write("Hello World<br>");
    response.write("<br>Request url is: "+request.url);
    response.write("<br>Requested method is "+request.method);
    response.write("<br>Request keys is: "+request.headers["accept-encoding"]);
    response.end();
});
server.listen(7070, function(){
    console.log("Listener started at 7070");
});