from datetime import datetime

from flask import abort, make_response

from config import db
from models import Library, library_schema, library_schema_create


def get_timestamp():
    return datetime.now().strftime(("%Y-%m-%d %H:%M:%S"))


def read_all():
    library = Library.query.all()
    return library_schema.dump(library)



def create(library):
    new_library = library_schema_create.load(library, session=db.session)
    db.session.add(new_library)
    db.session.commit()
    return library_schema_create.dump(new_library), 201


def read_one(name):
    person = Library.query.filter(Library.name == name).one_or_none()

    if person is not None:
        return library_schema.dump(person)
    else:
        abort(404, f"Library with last name {name} not found")



