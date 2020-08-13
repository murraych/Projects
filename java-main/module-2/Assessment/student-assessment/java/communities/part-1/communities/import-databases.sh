dropdb -U postgres assessment
createdb -U postgres assessment
psql -U postgres -d assessment -f communities.sql
psql -U postgres -d assessment -f properties.sql