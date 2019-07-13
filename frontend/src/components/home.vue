<template>
  <div class="form-container">
    <div  class="form-title">
      <span>输入文件</span>
    </div>
    <div class="form-form">
      <div style="display:flex;flex-wrap:wrap">
        <div class="demo-upload-list" v-for="(item,index) in uploadList">
          <template>
          <div class="img-p">
            <img src="../assets/txt.png" v-if="item.pic==1">
            <img src="../assets/csv.png" v-if="item.pic==2">
            <img src="../assets/xlsx.png" v-if="item.pic==3">
            <div class="img-font">{{item.name}}</div>
          </div>
          <div class="demo-upload-list-cover">
            <Icon type="ios-trash-outline" @click.native="handleRemove(index)"></Icon>
          </div>
          </template>
        </div>
        <Upload
        ref="upload"
        :show-upload-list="false"
        :default-file-list="defaultList"
        :format="['jpg','jpeg','png']"
        :max-size="3072"
        :on-format-error="handleFormatError"
        :on-exceeded-size="handleMaxSize"
        :before-upload="handleBeforeUpload"
        multiple
        type="drag"
        action="//jsonplaceholder.typicode.com/posts/"
        style="display: inline-block;width:163px;">
          <div class="uploader">
            <Icon type="md-add" size="50"></Icon>
            <span style="font-size:15px">点击上传文件</span>
          </div>
        </Upload>
      </div>
    </div>
    <div class="form-container">
      <div class="form-title">
        <span>输入文字</span>
      </div>
      <div class="form-form">
        <Input height:20px size="large"  v-model="inputContent" placeholder="请输入内容"></Input>
        <div style="width:100%;margin:10px;display:flex;justify-content:center">
        <Button ghost type="success" @click="confirm">确定</Button>
        </div>
      </div>
    </div>
    <div class="form-container" v-if="showResult">
      <div class="form-title">
        <span>结果</span>
      </div>
      <div class="form-form">
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'home',
  data(){
    return{
      uploadList:[],
      defaultList:[],
      inputContent:"",
      showResult:false
    }
  },
  methods:{
    confirm(){
      console.log(this.uploadList)
      console.log(this.inputContent)
    },
    handleRemove:function(index){
      this.$refs.upload.fileList.splice(index,1)
    },
    handleFormatError(file){
      console.log(1)
      this.$Notice.warning({
        title: 'The file format is incorrect',
        desc: 'File format of ' + file.name + ' is incorrect, please select jpg or png.'
      });
    },
    handleMaxSize (file) {
      this.$Notice.warning({
          title: 'Exceeding file size limit',
          desc: 'File  ' + file.name + ' is too large, no more than 2M.'
      });
    },
    handleBeforeUpload (file) {
      /*let reader = new FileReader()
      reader.readAsDataURL(file)
      const _this = this
      reader.onloadend = function (e) {
        file.url = reader.result
        console.log(file.name)
        _this.$refs.upload.fileList.push(file.url)
      }*/
      var validList=['csv','txt','xlsx']
      var name = file.name.split('.')
      var suffix = name[name.length-1]
      if(validList.indexOf(suffix) > -1){
        var pic = 1
        if(suffix==='csv'){
          pic=2
        }
        else if(suffix==='xlsx'){
          pic=3
        }
        this.uploadList.push({name:file.name,pic:pic})
        this.$Notice.success({
          desc: file.name + '添加成功'
        });
      }
      else{
        this.$Notice.warning({
          title: '文件格式不正确',
          desc: file.name + '文件格式不正确，请使用txt,csv或xlsx'
        });
      }

      //handleMaxSize和handleFormatError由于返回false所以不被执行
      return false
    }
  },
  mounted() {
    this.uploadList = this.$refs.upload.fileList;
  },
  computed:{

  }
}
</script>

<style scoped>
.uploader{
  width:163px;
  height:163px;
  display:flex;
  flex-direction:column;
  align-items:center;
  justify-content:center
}

.uploader:hover{
  color:#57a3f3
}

.demo-upload-list{
    display: inline-block;
    width: 140px;
    height: 163px;
    text-align: center;
    line-height: 163px;
    border: 1px solid transparent;
    border-radius: 4px;
    background: #fff;
    position: relative;
    box-shadow: 0 1px 1px rgba(0,0,0,.2);
    margin-right: 4px;
}
.demo-upload-list .img-p{
    width: 140px;
    height: 163px;
    display:flex;
    flex-direction:column
}
.demo-upload-list img{
    width:140px;
    height:140px
}
.demo-upload-list .img-font{
    width:140px;
    height:23px;
    font-size:18px;
    line-height:20px;
    color:#57a3f3;
    z-index:1
}
.demo-upload-list-cover{
    display: none;
    position: absolute;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    background: rgba(0,0,0,.6);
}
.demo-upload-list:hover .demo-upload-list-cover{
    display: block;
}

.demo-upload-list-cover i{
    color: #fff;
    font-size: 30px;
    cursor: pointer;
    margin: 0 2px;
}

.demo-upload-list-cover i:hover{
  color:#57a3f3
}

.form-container{
  margin-bottom:20px;
  border:1px solid #e6e6e6;
  background:#ffffff;
}

.form-title{
  border-bottom:1px solid #e6e6e6;
  height:40px;
  display:flex;
  align-items:center;
  padding-left:10px
}

.form-title span{
  font-size:15px;
  font-weight:700
}

.form-form{
  margin:10px;
  padding-right:20px
}
</style>
