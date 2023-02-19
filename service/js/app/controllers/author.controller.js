const Author = require("../models/author.model.js");

exports.create = (req, res) => {
    // Validate request
    if (!req.body) {
      res.status(400).send({
        message: "Content can not be empty!"
      });
    }
  
    // Create a author
    const author = new Author({
      name: req.body.name,
    });
  
    // Save Author in the database
    Author.create(author, (err, data) => {
      if (err)
        res.status(500).send({
          message:
            err.message || "Some error occurred while creating the Author."
        });
      else res.send(data);
    });
  };

  exports.findAll = (req, res) => {

    
  
    Author.getAll((err, data) => {
      if (err)
        res.status(500).send({
          message:
            err.message || "Some error occurred while retrieving Authors."
        });
      else res.send(data);
    });
  };
  