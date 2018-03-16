```
由于本应用使用了google analytics，
在开始构建前你需要一个关于google analytics的google-services.json，
以及你需要在res/xml/tracker_app.xml内输入你的Tracking ID
```

**FunLive 是 Android 平台上一款观看直播视频的App 。项目基于 MVP 架构，采用各主流开源库实现。用户可以在FunLive内观看直播视频，可以控制弹幕的开关，App还可以记录用户的收藏以及历史纪录。数据来自斗鱼。**

## 界面展示
![](https://github.com/YGLLL/FunLive/blob/master/screenshot/1.jpg)
![](https://github.com/YGLLL/FunLive/blob/master/screenshot/2.jpg)
![](https://github.com/YGLLL/FunLive/blob/master/screenshot/3.jpg)
![](https://github.com/YGLLL/FunLive/blob/master/screenshot/4.jpg)
![](https://github.com/YGLLL/FunLive/blob/master/screenshot/6.jpg)
![](https://github.com/YGLLL/FunLive/blob/master/screenshot/7.jpg)
![](https://github.com/YGLLL/FunLive/blob/master/screenshot/5.jpg)

## 项目特点
- 使用MVP设计模式
- 使用Retrofit2+Rxjava构成网络组件
- 使用了SQLite和SharedPreferences实现数据持久化
- 使用了google admob服务，用于在应用内展示广告
- 使用了google analytics服务，用于获取用户操作应用的数据，以改进应用
- 应用配备签名配置，可以生成已签名的安装包
- 使用Loader载入数据

## 项目结构
- 网络组件结构大意
![](https://github.com/YGLLL/FunLive/blob/master/screenshot/Retrofit2.jpg)
- UI结构
![](https://github.com/YGLLL/FunLive/blob/master/screenshot/MainActivity.jpg)

## 项目使用的开源库
- Retrofit2
- RxJava
- fresco
- butterknife
- FlycoTabLayout
- eventbus
- SmartRefreshLayout
- DanmakuFlameMaster