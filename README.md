# jvue

###前端初始化
1. vue init webpack "项目名称"
2. 进入项目文件
3. npm install
4. npm run dev

###自动打开前端
1. 进入config/index.js
2. 修改autoOpenBrowser: true

###配置ivew
1. npm install iview --save
2. 在main.js中
	1. import iView from 'iview'
	2. import 'iview/dist/styles/iview.css'
	3. Vue.use(iView)

###配置vuex
1. npm install vuex --save
2. 在main.js中
	1. import store from './store/store'
	2. new Vue -> store
	3. 配置store(store.js,state.js)文件
3. 重启vue

###配置less
1. npm install less less-loader --save
2. 创建index.less设置全局样式变量





