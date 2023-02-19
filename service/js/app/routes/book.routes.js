module.exports = app => {
    const book = require("../controllers/book.controller.js");
  
    var router = require("express").Router();
  
    // Create a new Book
    router.post("/", book.create);
  
    // Retrieve all books
    router.get("/", book.findAll);
  
  
    app.use('/book', router);
  };