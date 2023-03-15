const sql = require("./db.js");

// constructor
const Library = function(library) {
  this.name = library.name;
};

Library.create = (newLibrary, result) => {
  sql.query("INSERT INTO library SET ?", newLibrary, (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(err, null);
      return;
    }

    console.log("created library: ", { id: res.insertId, ...newLibrary });
    result(null, { id: res.insertId, ...newLibrary });
  });
};


Library.getAll = (result) => {
    let query = "SELECT * FROM library";
  
    sql.query(query, (err, res) => {
      if (err) {
        console.log("error: ", err);
        result(null, err);
        return;
      }
  
      console.log("librarys: ", res);
      result(null, res);
    });
  };

  module.exports = Library;