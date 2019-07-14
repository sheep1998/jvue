# -*- coding: utf-8 -*-
"""
Created on Fri Jul 12 01:44:37 2019

@author: 1535725170
"""
import time
import pandas as pd
from websocket import create_connection

def atime():
    d1 = time.time()
    d1 = int(round(d1*1000))
    time.sleep(1)
    d2 = time.time()
    d2 = int(round(d2*1000))
    print(d2-d1)
    
def csvRead2Df(filename):
    path = "C:\\Users\\1535725170\\Documents\\GitHub\\jvue\\csv\\"+filename
    #ws = pd.read_csv(path,header=None,names=['t1','t2','t3'])
    ws = pd.read_csv(path)
    return ws

    
def main():
    return

#if __name__ == "__main__":
#    ws = create_connection("ws://localhost:8083/myWebSocket")
#    ws.send("Hello, World")
#    while(True):
#        result =  ws.recv()
#        print ("Received '%s'")% result
#    ws.close()

    
from ws4py.client.threadedclient import WebSocketClient
 
class DummyClient(WebSocketClient):
    def opened(self):
        print("websocket打开")
 
    def closed(self, code, reason=None):
        print("Closed down", code, reason)
 
#服务器返回消息
    def received_message(self, m):
        print("recv:", m)
        m = str(m)
        if m[0]=="1":
            params = m.split("@")
            inputContent = params[1]
            files = params[2].split(',')
            print("inputContent",inputContent)
            print(files)
            self.send("1@"+",".join(files))
 
 
if __name__ == '__main__':
    try:
        # 服务器连接地址wss://real.okex.com:10440/websocket/okexapi  (该地址需翻墙，测试可找其他地址)
        ws = DummyClient('ws://localhost:8083/myWebSocket/1', protocols=['chat'])
        ws.connect()
        ws.run_forever()
    except KeyboardInterrupt:
        ws.close()
    