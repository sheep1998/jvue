# -*- coding: utf-8 -*-
"""
Created on Fri Jul 12 01:44:37 2019

@author: 1535725170
"""
import sys
import time
import wrider

def atime():
    d1 = time.time()
    d1 = int(round(d1*1000))
    time.sleep(1)
    d2 = time.time()
    d2 = int(round(d2*1000))
    print(d2-d1)
    
def trans():
    tl = wrider.Translator()
    print(tl.s2i("123"))
    print(tl.num2s(123.45))
    print(tl.s2f("1.428"))
    print(tl.s2low("IUs"))

def main():
    return

#if __name__ == '__main__':
#    params = sys.argv[1]
#    params = params.split('-')
#    for i in range(len(params)):
#        print("params",i,params[i])
#    main()
        
