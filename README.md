bigcalendar-sb
--------
###测试url
<a>www.bigcalendar.cn


>springboot实现日历<br/>
>同时显示github关注者仓库动态,与动态缓存


###日历结构
>commit 0bada9前使用VUE前后端分离实现

>此后使用springboot+thymeleaf服务器渲染实现

###Github关注者仓库
>使用githubApiTools，地址<a>https://github.com/s-lion-h/githubApiTools<br/>
多线程获取结果

``
List<Repository> getThreadFollowingRepo(String username,String token);
List<Repository> getFollowingRepo(String username,String token);
List<Owner> getFollowingList(String username,String token);
List<Repository> getRepositoryLists(String username,String token)``

