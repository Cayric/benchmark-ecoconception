const sql = require("./db.js");

// constructor
const Book = function(book) {
  this.name = book.name;
};

Book.create = (newBook, result) => {
  sql.query("INSERT INTO book SET ?", newBook, (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(err, null);
      return;
    }

    console.log("created book: ", { id: res.insertId, ...newBook });
    result(null, { id: res.insertId, ...newBook });
  });
};


Book.getAll = (result) => {
    let query = "SELECT * FROM book";
  
    sql.query(query, (err, res) => {
      if (err) {
        console.log("error: ", err);
        result(null, err);
        return;
      }
  
      console.log("books: ", res);
      result(null, res);
    });
  };

  module.exports = Book;