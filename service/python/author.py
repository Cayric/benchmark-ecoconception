from datetime import datetime

from flask import abort, make_response

from config import db
from models import Author, author_schema


def get_timestamp():
    return datetime.now().strftime(("%Y-%m-%d %H:%M:%S"))


def read_all():
    author = Author.query.all()
    return author_schema.dump(author)



def create(author):
    new_person = author_schema.load(author, session=db.session)
    db.session.add(new_person)
    db.session.commit()
    return author_schema.dump(new_person), 201


def read_one(name):
    person = Author.query.filter(Author.name == name).one_or_none()

    if person is not None:
        return author_schema.dump(person)
    else:
        abort(404, f"Library with last name {name} not found")



