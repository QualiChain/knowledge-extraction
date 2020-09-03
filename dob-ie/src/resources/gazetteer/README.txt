Some of these lists are simply different case versions of each other to ensure
that even if the gazetteer is used case sensitive we will match other variations.
This is especially important for newswire text where headlines are often in
all caps etc.

The following lists are identical except for case

country.lst, country_lower.lst, country_cap.lst


In the above cases the first list is considered to be the master copy, the other
case variations can then be generated easily from the command line

sed 's/\([^:]*\)/\L\1/' < master.lst > lower.lst
sed 's/\([^:]*\)/\U\1/' < master.lst > upper.lst

The regular expression used ensures that only the entry and not any features
are case converted.
