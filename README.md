# Android_SQLite
## SQLite数据库
SQLite是一款轻量级的关系型数据库，并且内置在Android系统中，支持标准SQL语法，还遵循了数据库的ACID事务，创建出来的数据库表一般都存放在/data/data/<package name>/databases/目录下。

Andorid提供了SQLiteOpenHelper帮助类，帮助我们来管理SQLite数据库，SQLiteOpenHelper有两个抽象方法，需要我们去现，分别是onCreate()和onUpgrade()
getReadableDatabase()、getWriteDatabase()方法，这两个方法都可以创建或者打开一个现有的数据库（如果数据库已存在则直接打开，否者创建一个新的数据库）,关于构造方法，SQLiteOpenHelper有两个构造方法可重写。看图


## 使用adb来管理SQLite数据库

我们配置好环境变量之后，在命令行中输入adb shell即可，然后我们可以看到当前连接设备的/dev，然后我们进入数据库表存储位置/data/data/<package name>/databases/目录下即可，只需要用sqlite3 数据库名 就可以进入这个数据库，我们可以使用.table来查看已经创建了的表,还可以用.schema命令查看建表语句,输入.exit 或者.quit就可以退出数据库的编辑

## 数据库的升级
  我们知道的，SQLiteOpenHelper类里我们要重写 **onCreate()** 方法和**onUpgrade()** 方法，**onCreate()** 方法会在数据库第一次创建的时候使用，那么 **onUpgrade()** 方法则是在数据库版本更新的时候调用。而不会调用 **onCreate()** 
## SQLite数据的CRUD
  我们知道，我们使用SQLiteOpenHelper类中的方法getReadableDatabase()或者getWritableDatabase()方法，满足一定条件的情况下，是会创建或者升级数据的，同时这个数据库会返回一个SQLiteDatabase对象，我们可以通过这个对象进行数据库的增删改。
1.	添加数据
  使用SQLiteDatabase对象的insert(“String“,null,ContentValues)方法,这个方法第一个参数就是我们要添加数据的表名，第二参数就是若是没有提供数据的情况下给某些可空的列自动赋值，第三个参数就是行数据的封装对象。我们可以使用ContentValues对象的put()方法，来封装数据。
2.	更新表内容
     更新数据库使用的方法就是 update(String,ContenteView,String,String[]),有四个参数，第一个参数就是你要更新的表名，第二参数就是要更改的数据的封装，第三个参数就是进行update tablename set var1=? Var2=? Where …，where后面的参数，来进行筛选用的,第三个参数就是为？赋值的，有多少？号，数组元素就应该由多少。
3.	删除表内容
删除表内容跟更新表内容差不多，要用到的方法就是delete(String ,String,String),第一个参数也是表名，二、三参数就是限制删哪一行的数据。
4.	查询数据
数据的查询可以说是安卓里面最复杂的了，使用的方法是query()，最少也得有七个参数，使用之后会返回一个Cursor对象，这个对象封装了查询得到的数据。

## 使用SQL操作数据库
1.	添加数据的方法：
db.execSQL(“insert into Book(x,x,x) values(?,?,?)”,new String[] {“x”,”x”,”x”});
2.	更新数据的方法
db,execSQL(“update Book set xxx=? Where name=?”,new String[]{“x”,”x”});

3.	删除数据的方法
db.execSQL(“delete from Book where x=?”,new String[]{“x”});
4.	查询数据的方法
db.rawQuery(“select * from Book”,new String[]{}(相当于Null));






