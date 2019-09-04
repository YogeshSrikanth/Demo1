var express = require("express");
var session = require("express-session");

var app = express();
app.use(session({secret:'XASDASDA'}));

app.listen(7070, function(){
    console.log("Express started at 7070");
})

var bodyparser = require("body-parser");
app.use(bodyparser.urlencoded({extended:true}));
app.use(bodyparser.json());

app.get("/", function(req, res){
    res.header("content-type","text/html");
    res.status(500);
    res.sendFile(__dirname + "/home.html");   
});

// app.get("/loginpage1", function(req, res){
//     res.sendFile(__dirname+"/loginpage1.html");
// });
var router = express.Router();
app.use("/user",router);
router.get("/loginpage", function(req,res){
    res.sendFile(__dirname+"/loginpage.html");
});

router.post("/loginpage", function(req,res){

    var ssn = req.session;
    console.log("hello");
    if(req.body.username == "yogesh" && req.body.password == "abc"){
        console.log("hello2");

        ssn.role = "user";
            ssn.username = req.body.username;
            res.redirect("/user/dash");
        } else {
            res.redirect("/user/loginpage");
        }
    });
    router.get("/dash", function(req, res) {
        res.header("content-type", "text/html");
        //res.sendFile(__dirname + "/dashuser.html");
        res.write("<h4> Name : " + req.session.username + "<br> Role : " + req.session.role);
    });


var router1 = express.Router();
app.use("/admin",router1);
router1.get("/loginpage", function(req,res){
    res.sendFile(__dirname+"/loginpage.html");
});

router1.post("/loginpage", function(req,res){

    var ssn = req.session;
    console.log("hello");
    if(req.body.username == "admin" && req.body.password == "abc"){
        console.log("hello2");

        ssn.role = "admin";
            ssn.username = req.body.username;
            res.redirect("/admin/dash");
        } else {
            res.redirect("/admin/loginpage");
        }
    });
    router1.get("/dash", function(req, res) {
        res.header("content-type", "text/html");
        //res.sendFile(__dirname + "/dashuser.html");
        res.write("<h4> Name : " + req.session.username + "<br> Role : " + req.session.role);
    });

var router2 = express.Router();
app.use("/guest",router2);
router2.get("/guestpage", function(req,res){
    res.sendFile(__dirname+"/guestpage.html");
});

app.get("/home", function(req, res){
    res.header("content-type","text/html");
    res.status(500);
    res.sendFile(__dirname + "/home.html");   
});

app.get("/about", function(req, res){
    res.header("content-type","text/html");
    res.status(500);
    res.sendFile(__dirname + "/about.html");   
});

app.get("/contact", function(req, res){
    res.header("content-type","text/html");
    res.status(500);
    res.sendFile(__dirname + "/contact.html");   
});

