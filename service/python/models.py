# models.py

from config import db, ma


class Library(db.Model):

    __tablename__ = "library"
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(32), unique=True)


class LibrarySchema(ma.SQLAlchemyAutoSchema):
    class Meta:
        model = Library
        load_instance = True
        sqla_session = db.session

library_schema = LibrarySchema(many=True)
library_schema_create = LibrarySchema()

class Author(db.Model):

    __tablename__ = "author"
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(32), unique=True)


class AuthorSchema(ma.SQLAlchemyAutoSchema):
    class Meta:
        model = Author
        load_instance = True
        sqla_session = db.session

author_schema = AuthorSchema(many=True)
author_schema_create = AuthorSchema()
