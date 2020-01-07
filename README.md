**FunLive 是 Android 平台上一款观看直播视频的App 。
项目基于 MVP 架构，采用各主流开源库实现。
用户可以在FunLive内观看直播视频，可以控制弹幕的开关，App还可以记录用户的收藏以及历史纪录。
数据来自斗鱼。**

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

## 2020的ygl来观光
这个项目是2017.11-2018.2做的，当时断断续续做了3个月。
以当时的能力做这个可以称得上壮举了，
不过当时的我并不这么想，当时的我仍然觉得这是个平庸的app，它当然是，
但对于一个初学者的作品来说，它显然不是，当时的心态可见一斑。
回忆再远一些，傻事没少做，真的很傻，
但想起更多的还是那个志存高远的少年。
没有假如，也回不到过去。
如今我依然从这个app中受益良多，无论是技术的，还是心态的。
当时不知难易，对技术的专研到了令现在的我惊讶的地步，
当时对Android系统，AndroidSDK，源码的理解，至今使我受益，
以至于我总是时不时回来翻下这里的代码，回忆些知识点，
看着一些代码，一些注释，又总能想起那个少年，
一些代码有注释时间，很多都是在半夜，
欣慰的是那些努力没有白费，它们一直在润物细无声。
