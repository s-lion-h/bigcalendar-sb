bigcalendar-sb
--------
# 测试url<a href="www.bigcalendar.cn">www.bigcalendar.cn</a>


>springboot实现日历<br/>
>同时显示github关注者仓库动态,与动态缓存


### 日历结构
>commit 0bada9前使用VUE前后端分离实现

>此后使用springboot+thymeleaf服务器渲染实现

### Github关注者仓库
>使用githubApiTools，地址<a>https://github.com/s-lion-h/githubApiTools<br/>
多线程获取结果

```
List<Repository> getThreadFollowingRepo(String username,String token);
List<Repository> getFollowingRepo(String username,String token);
List<Owner> getFollowingList(String username,String token);
List<Repository> getRepositoryLists(String username,String token)
```

##  添加每日IPO信息
> 每日的ipo查询，定期查询，yyyy-mm-dd

![image](https://raw.githubusercontent.com/s-lion-h/bigcalendar-sb/master/image/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE(216).png)
