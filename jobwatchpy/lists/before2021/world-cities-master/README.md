List of major cities in the world

## Data

The data is extracted from [geonames][geonames], a very exhaustive list of worldwide toponyms.

This [datapackage][datapackage] only list cities above 15,000 inhabitants. Each city is associated with its 
country and subcountry to reduce the number of ambiguities. Subcountry can be the name of a state (eg in 
United Kingdom or the United States of America) or the major administrative section (eg ''region'' in France''). 
See ``admin1`` field on [geonames website][geonames] for further info about subcountry.

Notice that :
* some cities like *Vatican city* or *Singapore* are a whole state so they don't belong to any subcountry. Therefore subcountry is ``N/A``.
* There is no guaranty that a city has a unique name in a country and subcountry (At the time of writing, there are about 60 ambiguities). But for each city, 
the source data primary key ``geonameid`` is provided.

[geonames]: http://www.geonames.org/
[datapackage]: http://dataprotocols.org/data-packages/


## Preparation

You can run the script yourself to update the data and publish them to github : see [scripts README](scripts/README.md)

## License

All data is licensed under the [Creative Common Attribution License][CC] as is the original data from [geonames][geonames]. This means you have to credit [geonames][geonames] when using the data. And while no credit is formally required a link back or credit to [Lexman][lexman] and the [Open Knowledge Foundation][okfn] is much appreciated.

All source code is licensed under the [MIT licence][mit].

[CC]: http://creativecommons.org/licenses/by/3.0/
[mit]: https://opensource.org/licenses/MIT
[geonames]: http://www.geonames.org/
[pddl]: http://opendatacommons.org/licenses/pddl/1.0/
[lexman]: http://github.com/lexman
[okfn]: http://okfn.org/




