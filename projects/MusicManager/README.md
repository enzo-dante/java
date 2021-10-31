# java database connectivity (jdbc)

JDBC acts like the middleman between a java application and the data source
- JDBC works with databases, flat files, and spreadsheets

to work with sqlite 3, JDBC needs the sqlite driver

switching between drivers like SQLite and mySQL drivers is relatively easy

# DB Browser for SQLite

it is a GUI for handling a SQLite DB which is compatible with JDBC

when you are using the GUI, the app will lock the DB file and wont be able to access the db from a java application
- solution: open file drown down and select 'close database' to release lock

# Intelli J

__steps to connect SQLite 3 driver to JDBC__

1. download sqlite-jdbc driver jar file from github and save to desired dir
https://github.com/xerial/sqlite-jdbc/releases

2. download DB Browser for SQLite from sqlite.org
3. create a new Intelli J java project with the command line template
4. open file drown down -> project structure -> Libraries -> plus symbol -> java
5. open sqlite-jdbc driver from saved location -> OK
6. define CONSTANTS for DB_NAME and CONNECTION_STRING outside of main method
6. define try and catch block inside main method
7. in try define and establish jdbc:sqlite connection

# Constants 

use Constants for static variables for scalability

hard coding static variables is a bad practice because it makes updating very error-prone

# JDBC Statement and Execute 

to execute SQL with JDBC, create Statement objects with the DriverManager connection

__you can reuse a statement object to execute multiple CRUD SQL commands BUT not SELECT commands__
- each SELECT having it's own statement ensures data integrity, especially if multiple SELECT are running concurrently

# review SQL commands with DB Browser with SQLite

1. open DB Browser with SQLite
2. select Open Database panel and select & open target db
2. select Browse Data view

