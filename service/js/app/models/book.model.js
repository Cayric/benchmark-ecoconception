const sql = require("./db.js");

// constructor
const Book = function(book) {
  this.title = book.title;
  this.synopsis = book.synopsis;
  this.author_id = book.author_id;
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