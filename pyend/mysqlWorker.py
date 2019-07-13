# -*- coding: utf-8 -*-
"""
Created on Fri Jul 12 19:59:32 2019

@author: 1535725170
"""

import pymysql

def insert():
    db = pymysql.connect("localhost","root","pp1819sdf","jvue")
    cursor = db.cursor()
    sql = "INSERT INTO USER(NAME) VALUES ('%s')"%("Chen Yu")
    try:
        cursor.execute(sql)
        db.commit()
    except:
        db.rollback()
    db.close()
    
def search():
    db = pymysql.connect("localhost","root","pp1819sdf","jvue")
    cursor = db.cursor()
    sql = "SELECT * FROM USER WHERE NAME = '%s'"%("Li Hu")
    try:
        cursor.execute(sql)
        results = cursor.fetchall()
        for row in results:
            print(row)
    except:
        db.rollback()
    db.close()
    
def update():
    db = pymysql.connect("localhost","root","pp1819sdf","jvue")
    cursor = db.cursor()
    sql = "UPDATE USER SET NAME = '%s' WHERE NAME = '%s'"%("Girl Friend","Chen Yu")
    try:
        cursor.execute(sql)
        db.commit()
    except:
        db.rollback()
    db.close()
    
update()