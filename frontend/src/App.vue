<template>
  <div class="layout">
    <Layout>
      <Header class="header">
      </Header>
      <Layout>
        <Sider class="sider" width="150">
          <Menu
            style="width:150px"
            :active-name="this.$store.state.menuitem.id"
            @on-select="menuitemSelect"
          >
            <MenuItem v-for="(item,index) in this.$store.state.menuitems" :key="index" :name="item.id">
              <span>{{item.name}}</span>
            </MenuItem>
          </Menu>
        </Sider>
        <Layout :style="{marginLeft: '150px'}">
          <Content>
            <router-view/>
          </Content>
        </Layout>
      </Layout>
    </Layout>
  </div>
</template>

<script>
export default {
  name: 'App',
  mounted(){
    this.initWebSocket()
    this.$store.state.menuitem = this.$store.state.menuitems[0]
  },
  methods:{
    initWebSocket() {
      const wsuri = "ws://localhost:8083/myWebSocket/0";
      this.$store.state.webSock = new WebSocket(wsuri);
      this.$store.state.webSock.onopen = this.webSocketOnOpen;
      this.$store.state.webSock.onerror = this.webSocketOnError;
      this.$store.state.webSock.onmessage = this.webSocketOnMessage;
      this.$store.state.webSock.onclose = this.webSocketOnClose;
    },

    webSocketOnOpen() {
      console.log("连接成功");
    },

    webSocketOnError() {
      console.log("连接发生错误");
    },

    webSocketOnMessage(e) {
      //const temp = JSON.parse(""+e.data)
      const temp = e.data
      if(temp[0]=="0"){
        var param = temp.split("@")
        var params = param[1]
        this.$store.state.responses = params.split(",")
        console.log(this.$store.state.responses)
      }
      else{
        console.log(temp)
      }
    },

    webSocketSend(agentData) {
      this.$store.state.webSock.send(agentData);
    },

    webSocketOnClose() {
      console.log("连接关闭");
    },
    menuitemSelect(){

    }
  }
}
</script>

<style lang="less">
.layout {
  border-top: 2px solid #d0d0d0;
}

.product-title {
  height: 50px;
  font-size: 20px;
  text-align: center;
  line-height: 50px;
  color: #fff;
  background-color: #515a6e;
}

.ivu-menu-vertical .ivu-menu-item {
  padding-left: 15px;
  padding-right: 15px;
  padding-top: 14px;
  padding-bottom: 8px;
  text-align: center;
  font-size: 20px;
}
::-webkit-scrollbar {
  display: none;
}
.sider {
  height: calc(100vh);
  position: fixed;
  left: 0;
  overflow: auto;
}
.header {
  height: 50px;
}
.ivu-layout-header {
  line-height: 50px;
  font-size: 20px;
}
</style>
