# Android_SQLite
## SQLite数据库
SQLite是一款轻量级的关系型数据库，并且内置在Android系统中，支持标准SQL语法，还遵循了数据库的ACID事务，创建出来的数据库表一般都存放在/data/data/<package name>/databases/目录下。

Andorid提供了SQLiteOpenHelper帮助类，帮助我们来管理SQLite数据库，SQLiteOpenHelper有两个抽象方法，需要我们去现，分别是onCreate()和onUpgrade()
getReadableDatabase()、getWriteDatabase()方法，这两个方法都可以创建或者打开一个现有的数据库（如果数据库已存在则直接打开，否者创建一个新的数据库）,关于构造方法，SQLiteOpenHelper有两个构造方法可重写。看图


## 使用adb来管理SQLite数据库

我们配置好环境变量之后，在命令行中输入adb shell即可，然后我们可以看到当前连接设备的/dev，然后我们进入数据库表存储位置/data/data/<package name>/databases/目录下即可，只需要用sqlite3 数据库名 就可以进入这个数据库，我们可以使用.table来查看已经创建了的表,还可以用.schema命令查看建表语句,输入.exit 或者.quit就可以退出数据库的编辑

## 数据库的升级
  我们知道的，SQLiteOpenHelper类里我们要重写 **onCreate()** 方法和**onUpgrade()** 方法，**onCreate()** 方法会在数据库第一次创建的时候使用，那么 ** onUpgrade()** 方法则是在数据库版本更新的时候调用。而不会调用 **onCreate() ** 





