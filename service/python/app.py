
from flask import render_template

# Remove: import connexion

import config

from models import Library


app = config.connex_app

app.add_api(config.basedir / "swagger.yml")


@app.route("/")

def home():

    library = Library.query.all()

    return render_template("home.html", library=library)


if __name__ == "__main__":

    app.run(host="0.0.0.0", port=8000, debug=True)