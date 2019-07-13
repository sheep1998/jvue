# -*- coding: utf-8 -*-
"""
Created on Sat Jul 13 21:09:46 2019

@author: 1535725170
"""
import wrider
import uuid

import matplotlib.pyplot as plt
import pandas as pd
import numpy as np
import matplotlib
import seaborn as sns 


#y-x图
def plt1():
    #读取
    df = wrider.csvRead2Df("Wine.csv")
    #排序
    df = df.sort_values('Alcohol',axis = 0,ascending = True)
    #画图
    #plt.plot('Alcohol','Proline',data = df)
    #勾芡
    plt.style.use('seaborn-paper')
    plt.rcParams['font.family'] = 'Times New Roman'
    #图片大小
    #plt.rcParams['figure.dpi'] = 600 #set figure resolution
    #说明
    plt.xlabel(u'Alcohol', fontsize=8)
    plt.ylabel(u'Proline', fontsize=8)
    plt.xticks(fontsize=8)
    plt.yticks(fontsize=8)
    plt.title("Relationship of Alcohol and Proline")
    
    #<--------------------------------------------------------------------------------->
    #画图
    #plt.plot(df['Alcohol'],df['Proline'])
    #换为点线图 星状
    #plt.plot(df['Alcohol'],df['Proline'],'r*--')
    #换为点线图 正常
    #plt.plot(df['Alcohol'],df['Proline'],'ko:')
    #换为点图
    plt.plot(df['Alcohol'],df['Proline'],'.')
    plt.plot(np.log(df['Alcohol']),np.log(df['Proline']),'b.')
    #<--------------------------------------------------------------------------------->
    #保存图片
    picname="tmp.png"
    plt.savefig('C:\\Users\\1535725170\\Documents\\GitHub\\jvue\\pic\\'+picname,format='png',dpi=800)
    
#散点图
def plt2():
    #读取
    df = wrider.csvRead2Df("Wine.csv")
    #排序
    df = df.sort_values('Alcohol',axis = 0,ascending = True)
    #新建画布
    plt.figure(figsize=(15.0,10.0))
    sns.scatterplot(x="Alcohol", y="Proline",hue="Type", data=df)
    #保存图片
    picname="tmp.png"
    plt.savefig('C:\\Users\\1535725170\\Documents\\GitHub\\jvue\\pic\\'+picname,format='png',dpi=800)
    
#直方图
def plt3():
    #读取
    df = wrider.csvRead2Df("Wine.csv")
    #排序
    #df = df.sort_values('Alcohol',axis = 0,ascending = True)
    #画图
    plt.hist(df["Alcohol"], bins=10, rwidth=0.9, range=(11,15)) 
    #保存图片
    picname="tmp.png"
    plt.savefig('C:\\Users\\1535725170\\Documents\\GitHub\\jvue\\pic\\'+picname,format='png',dpi=800)
    
#柱状图
def plt4():
    #读取
    df = wrider.csvRead2Df("Wine.csv")
    #排序
    #df = df.sort_values('Alcohol',axis = 0,ascending = True)
    #新建画布
    plt.figure(figsize=(15.0,10.0))
    sns.countplot(df["Type"])
    #保存图片
    picname="tmp.png"
    plt.savefig('C:\\Users\\1535725170\\Documents\\GitHub\\jvue\\pic\\'+picname,format='png',dpi=800)
    
#饼状图
def plt5():
    # Data to plot
    labels = ['Python', 'C++', 'Ruby', 'Java']
    sizes = [215, 130, 245, 210]
    #colors = ['gold', 'yellowgreen', 'lightcoral', 'lightskyblue']
    # See https://matplotlib.org/examples/color/named_colors.html for more named colors.
    #colors = ['tab:green', 'tab:red', 'tab:purple', 'tab:brown']
    #colors =['xkcd:yellow','xkcd:spring green','xkcd:azure','xkcd:watermelon']
    # See https://xkcd.com/color/rgb/ for more xkcd colors.
    explode = (0.03, 0, 0, 0)  # explode 1st slice
    
    plt.rc('font', size=8) #control font size of labels
    # Plot
    plt.pie(sizes, explode=explode, labels=labels,
            autopct='%2.1f%%', shadow=False, startangle=30)
     
    plt.axis('equal') # See https://matplotlib.org/2.0.2/api/pyplot_api.html#matplotlib.pyplot.axis
    #保存图片
    picname="tmp.png"
    plt.savefig('C:\\Users\\1535725170\\Documents\\GitHub\\jvue\\pic\\'+picname,format='png',dpi=800)

def getName():
    return uuid.uuid4().hex

print(getName())
print(getName())
print(getName())
print(getName())
print(getName())