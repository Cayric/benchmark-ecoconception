const Library = require("../models/library.model.js");

exports.create = (req, res) => {
    // Validate request
    if (!req.body) {
      res.status(400).send({
        message: "Content can not be empty!"
      });
    }
  
    // Create a library
    const library = new Library({
      name: req.body.name,
    });
  
    // Save Library in the database
    Library.create(library, (err, data) => {
      if (err)
        res.status(500).send({
          message:
            err.message || "Some error occurred while creating the Library."
        });
      else res.send(data);
    });
  };

  exports.findAll = (req, res) => {

    
  
    Library.getAll((err, data) => {
      if (err)
        res.status(500).send({
          message:
            err.message || "Some error occurred while retrieving Librarys."
        });
      else res.send(data);
    });
  };
  