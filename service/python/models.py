# models.py
from marshmallow_sqlalchemy import fields

from config import db, ma

class Book(db.Model):

    __tablename__ = "book"
    id = db.Column(db.Integer, primary_key=True)
    title = db.Column(db.String(32))
    synopsis = db.Column(db.UnicodeText)
    author_id = db.Column(db.Integer, db.ForeignKey("author.id"))

class BookSchema(ma.SQLAlchemyAutoSchema):
    class Meta:
        model = Book
        load_instance = True
        sqla_session = db.session
        include_fk = True

book_schema = BookSchema(many=True)
book_schema_create = BookSchema()
class Author(db.Model):

    __tablename__ = "author"
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(32), unique=True)
    library_id = db.Column(db.Integer, db.ForeignKey("library.id"))

class AuthorSchema(ma.SQLAlchemyAutoSchema):
    class Meta:
        model = Author
        load_instance = True
        sqla_session = db.session
        include_fk = True

author_schema = AuthorSchema(many=True)
author_schema_create = AuthorSchema()

class Library(db.Model):

    __tablename__ = "library"
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(32), unique=True)


class LibrarySchema(ma.SQLAlchemyAutoSchema):
    class Meta:
        model = Library
        load_instance = True
        sqla_session = db.session
        include_relationships = True

    authors = fields.Nested(author_schema_create, many=True)


library_schema = LibrarySchema(many=True)
library_schema_create = LibrarySchema()


