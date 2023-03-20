const sql = require("./db.js");

// constructor
const Author = function(author) {
  this.name = author.name;
  this.library_id = author.library_id;
};

Author.create = (newAuthor, result) => {
  sql.query("INSERT INTO author SET ?", newAuthor, (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(err, null);
      return;
    }

    console.log("created author: ", { id: res.insertId, ...newAuthor });
    result(null, { id: res.insertId, ...newAuthor });
  });
};


Author.getAll = (result) => {
    let query = "SELECT * FROM author";
  
    sql.query(query, (err, res) => {
      if (err) {
        console.log("error: ", err);
        result(null, err);
        return;
      }
  
      console.log("authors: ", res);
      result(null, res);
    });
  };

  module.exports = Author;