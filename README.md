优达学城Android开发进阶
# 毕业设计
原设计:https://github.com/YGLLL/Capstone-Project
## 与原设计的不同
- 取消了Video栏目

（原因：斗鱼暂未开放视频点播API）

- 去掉首页顶部的分类TAB以及使Live栏仅展示分类TAB，不展示房间

（原因：为了各个页面分工更明确）

（ps：目前直播观看5分钟后会自动停止，但刷新后可以继续观看。
这是因为播放链接抓取自斗鱼移动版网页，该链接仅能播放5分钟，这是目前唯一能实现的播放方式）

## 项目结构
![网络连接结构](https://github.com/YGLLL/FunLive/tree/master/pic/Retrofit2.jpg)

![UI结构](https://github.com/YGLLL/FunLive/tree/master/pic/MainActivity.jpg)

## 项目要求实现点
小部件
- .view.widget.FunLiveWidget

google admob
- .application.FLApplication
- .layout.fragmnt_user_room_list.xml

google analytics
- .application.FLApplication
- .view.CateActivity
- .view.RecommendFragment
- .view.ClassifyFragment
- .view.UserFragment

应用主题扩展AppCompat
- .view.MainActivity

签名
- build.gradle

ContentProvider
- .db.FunLiveProvide

使用AsyncTask
- .view.RecommendFragment

Loader
- .view.UserRoomListFragment

（ps:这里虽然使用了Loader载入数据，
但我发现在删除数据库数据后onLoadFinished方法得不到调用（见.view.adapter.user.UserRoomListAdapter），
找了很久找不到原因，
所以不得不同时使用另一种载入数据的方法，
但这里的Loader仍然是有效的）

最后：由于本人水平较差，写出来的代码比较渣，所以感谢老师耐心审阅我的代码:)