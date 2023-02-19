module.exports = app => {
    const author = require("../controllers/author.controller.js");
  
    var router = require("express").Router();
  
    // Create a new Author
    router.post("/", author.create);
  
    // Retrieve all authors
    router.get("/", author.findAll);
  
  
    app.use('/author', router);
  };