module.exports = app => {
    const library = require("../controllers/library.controller.js");
  
    var router = require("express").Router();
  
    // Create a new Library
    router.post("/", library.create);
  
    // Retrieve all librarys
    router.get("/", library.findAll);
  
  
    app.use('/library', router);
  };