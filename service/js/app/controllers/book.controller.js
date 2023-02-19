const Book = require("../models/book.model.js");

exports.create = (req, res) => {
    // Validate request
    if (!req.body) {
      res.status(400).send({
        message: "Content can not be empty!"
      });
    }
  
    // Create a book
    const book = new Book({
      name: req.body.name,
    });
  
    // Save Book in the database
    Book.create(book, (err, data) => {
      if (err)
        res.status(500).send({
          message:
            err.message || "Some error occurred while creating the Book."
        });
      else res.send(data);
    });
  };

  exports.findAll = (req, res) => {

    
  
    Book.getAll((err, data) => {
      if (err)
        res.status(500).send({
          message:
            err.message || "Some error occurred while retrieving Books."
        });
      else res.send(data);
    });
  };
  