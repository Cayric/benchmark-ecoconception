from datetime import datetime

from flask import abort, make_response

from config import db
from models import Author, author_schema, author_schema_create, Library


def get_timestamp():
    return datetime.now().strftime(("%Y-%m-%d %H:%M:%S"))


def read_all():
    author = Author.query.all()
    return author_schema.dump(author)



def create(author):
    library_id = author.get("library_id")
    library = Library.query.get(library_id)

    if library:
        author = author_schema_create.load(author, session=db.session)
        db.session.add(author)
        db.session.commit()
        return author_schema_create.dump(author), 201
    else:
        abort(
            404,
            f"Library not found for ID: {library_id}"
        )


def read_one(name):
    person = Author.query.filter(Author.name == name).one_or_none()

    if person is not None:
        return author_schema.dump(person)
    else:
        abort(404, f"Library with last name {name} not found")



