# Mandarin Library-Automation（图书馆管理系统）



## 项目简介：

本项目是基于SSH框架开发的图书馆管理系统，现仅兼容Windows系统。



## 开发环境：

操作系统：Windows 10 64位

IDE：Eclipse

数据库：MySQL5.x

服务器：Tomcat8.5或以上



## 运行项目：

1. 用Eclipse从外部文件夹打开本项目，打开Eclipse，选择"File"下的"Open Projects from File System"
2. 导入项目之后，因为是在Tomcat容器中进行操作的，需要配置Tomcat环境。右击项目名，选择"Build Path"，点击"Add Library"，选择"Server Library"（可能需要删除项目自带的Tomcat配置）
3. 建立数据库：在MySQL的控制台中，创建数据库“mandarin”，配置其默认字符集为"utf-8"（请使用MySQL5.x版本的数据库，使用MySQL8.x可能会出现无法CRUD操作的问题）
4. 修改/Java Resources/src/hibernate.cfg.xml：根据自己设定数据库的用户名和密码，修改hibernate.cfg.xml中的用户名和密码，示例图如下：
   1. ![1571024485416](C:\Users\HJN\AppData\Roaming\Typora\typora-user-images\1571024485416.png)
5. 运行登录页面：在完成前三步之后，选择/WebContent目录下的login.jsp，右击使用Tomcat容器运行（如果有问题，请先对该项目进行clean后再重新运行）
6. 请注意：在点击login.jsp中的Login按钮前，请在数据库中librarian表中创建一条记录（所有属性都是非空的）。此后，根据自己创建的用户名和密码在login.jsp中输入对应的数据，点击login进行登录。



## 功能简介：

1. Reader Mangement：
   1. Add Reader：输入reader所有的信息，点击Add按钮即可添加一个reader账户
2. Book Management：
   1. Add Book：输入书的ISBN号，点击Find the detail of book，系统将自动获取书的title,author,publisher,description信息，需要自己填写location和categoryNo（由于开发进度问题，两个属性暂时没有输入限制，后期将添加限制条件）**请注意**：由于Add Book生成的条形码和位置图片将输出到本地路径，使用该功能前，请先在本地磁盘D盘根目录下创建两个文件夹，分别命名为：barcode和booklocation
3. Announcement Mangement:
   1. Add Announcement：输入公告所需数据，点击Add按钮即可添加一个公告
   2. Edit Announcement：点击View按钮即可查看公告对应的详细信息，在新界面中的输入框中修改公告的属性，再点击Edit按钮即可完成修改（有小bug，后期将完善）
   3. Delete Announcement：点击红色的Delete按钮即可删除对应的公告
4. logout：
   1. 点击Logout.jsp页面中导航栏中的Logout按钮即可退出登录



## 开发文档：

暂不公布



## 贡献者（排名不分先后）：

1. 黄江南
2. 凌翔
3. 冯憬天
4. 裴致远
5. 郭咏瑞