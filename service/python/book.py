from datetime import datetime

from flask import abort, make_response

from config import db
from models import Book, book_schema, book_schema_create, Author


def get_timestamp():
    return datetime.now().strftime(("%Y-%m-%d %H:%M:%S"))


def read_all():
    book = Book.query.all()
    return book_schema.dump(book)



def create(book):
    print(book)
    author_id = book.get("author_id")
    author = Author.query.get(author_id)
    print(author)
    if author:
        book = book_schema_create.load(book, session=db.session)
        db.session.add(book)
        db.session.commit()
        return book_schema_create.dump(book), 201
    else:
        abort(
            404,
            f"Author not found for ID: {author_id}"
        )


def read_one(name):
    book = Book.query.filter(Book.name == name).one_or_none()

    if book is not None:
        return book_schema.dump(book)
    else:
        abort(404, f"Book with name {name} not found")



