dropdb -U postgres assessment
createdb -U postgres assessment
psql -U postgres -d assessment -f users.sql
psql -U postgres -d assessment -f items.sql