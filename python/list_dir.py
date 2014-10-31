#!/usr/bin/env python
import os, sys, sqlite3
def get_dirs(dir):
    path = dir
    dir_list = os.listdir( path )
    return( dir_list )


print("This will list the dirs and save them to a sqlite database")
print("Please enter a valid path")
dir_list = get_dirs(input())

if os.path.exists("db.db"):
    print("[db]database exists")
    sys.exit

connection = sqlite3.connect("db.db")
cursor = connection.cursor()

sql = "CREATE TABLE dirs(" \
      "name TEXT, " \
      "number INTEGER PRIMARY KEY)"
cursor.execute(sql)

count = 0
for file in dir_list:
    cursor.execute("INSERT INTO dirs (name, number) values (?,?)", (file, count))
    count = count + 1
connection.commit()
connection.close

#fobj = open("db.txt", "w")
#for file in dir_list:
#    fobj.write(file)
#fobj.close()
