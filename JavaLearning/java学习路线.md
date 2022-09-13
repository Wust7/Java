# java学习路线

![image-20220607105723419](img\image-20220607105723419.png)




## 1.javaSE√

## 2.MySQL

### 2.1 基本语法

mysql [-h 127.0.0.1] [-p 3306] -u root -p

密码：1234

![image-20220607111222158](img\image-20220607111222158.png)



```mysql
##DDL

# 查询所有数据库
# show databases;

# 查询当前数据库
# select DATABASE();

# 创建数据库
# create database wust;
# create database if not exists wust;

# 删除数据库
# drop database if exists wust1;

# 使用数据库
# use wust;

# 查询当前库中所有表
# show tables;

# 创建表
create table book(
    id     int comment '编号',
    name   varchar(50) comment '姓名',
    gender varchar(1) comment '性别'
) comment '用户表';

# 查看表结构
desc book;

# 查询表的建表语句
show create table book;

create table emp(
    id int comment '编号',
    workno varchar(10) comment '工号',
    name varchar(10) comment '姓名',
    gender varchar(1) comment '性别',
    age tinyint unsigned comment '年龄',
    idcard char(18) comment  '身份证号',
    entrydate date comment '入职时间'
)comment '员工表';

# 添加字段
alter table emp add nickname varchar(20) comment '昵称';

# 修改数据类型
alter table emp change nickname username varchar(30) comment '用户名';

# 删除字段
alter table emp drop username;

# 修改表名
alter table emp rename to employee;

# 删除表
drop table if exists book;

# 删除指定表，并重新创建该表
truncate table employee;


desc employee;

## DML

# 指定字段插入语句
insert into employee(id, workno, name, gender, age, idcard, entrydate)
VALUES (1,'1','JYQ','女',23,'1234123413','2018-8-13');

# 插入全部字段数据
insert into employee values(2,'2','WST','男','24','1234123412','2022-1-1');
# insert into emp values(6,'5','WS','男','2','','2022-1-1');

# 批量插入数据
insert into employee values(3,'3','XBB','男','1','1234123412','2024-1-1'),
                            (4,'4','XJJ','女','2','1234123412','2024-1-1');

# 修改指定字段
update employee set name='XZZ' where id=3;
update employee set gender='女',age=10 where id=3;


# 修改所有字段
update employee set entrydate='2022-6-7';

# 删除指定记录
delete from employee where gender='男';

# 删除全部数据
delete from employee;

# 查询
select * from employee;


##DQL 数据查询语言
#                        执行顺序
# select 字段列表           4
# from 表名列表             1
# where 条件列表            2
# group by 分组字段列表      3
# having 分组后条件列表
# order by 排序字段列表      5
# limit 分页参数            6


# 查询多个字段
select name,workno,age from employee;
select id,workno,name,age,idcard from emp;
select * from emp;

# 设置别名
select id as '序号',workno,name,age,idcard from emp;


# 去除重复记录
select distinct idcard from emp;

# 查询指定字段
select * from emp where age=24;
select * from emp where age>=1;
select * from emp where age!=1;
# 等价于
select * from emp where age<>1;

select * from emp where age >=2 && age <=23;
# 等价于
select * from emp where age >=2 and age <=23;
select * from emp where age between 2 and 23;

select * from emp where age=2 and id>1;

select * from emp where age=2 or age=1;
select * from emp where age in(1,2);

# 模糊匹配
# _表示字符个数
select * from emp where name like '__';
# %表示任意字符
select * from emp where name like '%S';




select *from emp where idcard is null;
select *from emp where idcard is not null;


# 聚合函数
select count(*) from emp;
select count(idcard) from emp;

select avg(age) from emp;
select max(age) from emp;

select min(age) from emp;

select sum(age) from emp where gender='女';

# 分组查询

# where与having区别
# 执行时机不同：where 是分组之前进行过滤，不满足where条件不参与分组；而having是分组之后对结果进行过滤
# 判断条件不同：where不能对聚合函数进行判断，而having可以
# 执行顺序： where>聚合函数>having


select gender,count(*) from emp group by gender;

select workno,count(*) workno_count from emp where age >1 group by workno having workno_count>1;


# 排序查询
# asc:升序（默认）
# desc：降序

select * from emp order by age;
select * from emp order by age desc;

select * from emp order by entrydate desc;
# 前面一个排序优先级高于后面
select * from emp order by entrydate desc , age asc;


# 分页查询
# 从1开始查询3条数据
select * from emp limit 3;
# 从2开始查询3条数据
select *from emp limit 1,3;
# 从2开始查询2条数据
select * from emp limit 2,2;



# 练习
select * from emp where gender='女' and age in(1,2,23);

select * from emp where gender='男' and name like'___'and age between 2 and 25 ;
# 标准写法，加括号
select * from emp where gender='男' and (age between 2 and 25) and name like '___' ;

select gender,count(*) from emp where age>1 group by gender;

select name,age from emp where age >1 order by age asc, entrydate desc;

select * from emp where gender='男' and (age between 2 and 25) order by age asc,entrydate desc limit 2;


# DCL 数据控制语言 用户管理

# 查询用户
use mysql;
select * from book;


# 创建用户  没有权限
create book 'wust'@'localhost' identified by '1234';

# 可以在任意主机访问该数据库
create book 'wust1'@'%' identified by '1234';

# 修改用户密码
alter book 'wust1'@'%' identified with mysql_native_password by '12345';

# 删除用户
drop book 'wust1'@'%';

# 查询权限
show grants for 'wust'@'localhost';

# 授予权限
# grant 权限列表 on 数据库名.表名 to '用户名'@'主机名';
grant all on wust.* to 'wust'@'localhost';

# 撤销权限
# revoke 权限列表 on 数据库名.表名 from '用户名'@'主机名';
revoke all on wust.* from 'wust'@'localhost';
```

### 2.2 基本函数

```mysql
-- 字符串连接
select concat('Hello','World');

-- 字符串转小写
select lower('Hello');

-- 字符串转小写
select upper('Hello');

-- 在字符串左侧填充
select lpad('hello',7,'--');

-- 在字符串右侧填充
select rpad('hello',7,'--');

-- 去除头部和尾部空格
select trim(' hello world ');

-- 字符串截取
select substring('Hello world',1,7);

# 练习

update emp set workno=lpad(workno,5,'0');
select * from emp;


-- 向上取整
select ceil(1.3);

-- 向下取整
select floor(1.6);

-- 返回x/y的模(余数)
select mod(17,4);

-- 返回0~1内的随机数
select rand();

-- 求参数x的四舍五入的值，保留y位小数
select round(2.345,2);

-- 生成六位随机验证码
select lpad(round(rand()*1000000,0),6,'0');

-- 返回当前日期
select curdate();

-- 返回当前时间
select curtime();

-- 返回当前日期和时间
select now();

-- 获取指定date年份
select year(now());

-- 获取指定date月份
select month(now());

-- 获取指定date日期
select day(now());

-- 返回一个日期/时间值加上一个时间间隔expr后的时间值
select date_add(now(),interval 70 day);
select date_add(now(),interval 7 year);

-- 返回时间date1-时间date2所得的天数
select datediff('2021-12-01','2021-12-12');

# 练习
select name,datediff(curdate(),entrydate) as 'entrydays' from emp order by entrydays desc;


# 流程函数

# 如果前面为true则返回第一个字符串，否则返回第二个
select if(false,'ok','Error');

# 如果前面为空则返回后面，否则返回前面
select ifnull('a','Def');
select ifnull(null,'Def');

#
select
       name,
       (case gender when '男' then '帅哥' when '女' then '靓妹' else '未知' end) as '昵称'
from emp;

#
create table score(
    id int comment 'ID',
    name varchar(20) comment '姓名',
    math int comment '数学',
    english int comment '英语',
    chinese int comment '语文'
)comment '学员成绩表';
insert into score(id, name, math, english, chinese) values
(1,'JYQ',45,87,98),
(2,'YQ',80,100,96),
(3,'XBB',59,99,98),
(4,'WST',90,87,57);

select
       id,
       name,
       (case when math >=80 then '优秀' when math >=60 then '及格' else '不及格' end) '数学',
       (case when english >=80 then '优秀' when english >=60 then '及格' else '不及格' end) '数学',
       (case when chinese >=80 then '优秀' when chinese >=60 then '及格' else '不及格' end) '数学'
from score;










select * from score;
```

### 2.3 基本约束

![image-20220609125151585](img\image-20220609125151585.png)



```mysql
use wust;
create table book(
    -- primary key 主键
    -- auto_increment 自动增长
    id int primary key auto_increment comment '主键',
    -- not null 不为空
    -- unique 唯一
    name varchar(10) not null unique comment '姓名',
    -- check 检查约束
    age int check ( age >0 && age<=120 ) comment '年龄',
    -- default 设置默认值
    status char(1) default '1' comment '状态',
    gender char(1) comment '性别'
)comment '用户表';


-- 插入数据
insert into book(name, age, status, gender)
VALUES ('JYQ',19,'1','女'),('JYQ2',19,'1','女'),('JYQ3',19,'1','女'),('JY4',19,'1','女');
select * from book;


# 外键
create table dept(
    id int auto_increment comment 'ID' primary key,
    name varchar(50) not null comment '部门名称'
)comment '部门表';
insert into dept(id, name) VALUES (1,'研发部'),(2,'市场部'),(3,'销售部'),(4,'销售部'),(5,'总经办');

# drop table dept;
create table emp(
    id int auto_increment comment 'ID'primary key,
    name varchar(50)not null comment '姓名',
    age int comment '年龄',
    job varchar(20) comment '职位',
    salary int comment  '薪资',
    entrydate date comment '入职时间',
    managerid int comment '直属领导ID',
    dept_id int comment '部门ID'
)comment '员工表';
insert into emp(id, name, age, job, salary, entrydate, managerid, dept_id) VALUES
(1,'自来也',99,'总裁',20000,'2000-01-01',null,5),
(2,'水门',70,'项目经理',10000,'2005-01-01',1,1),
(3,'卡卡西',50,'开发',7000,'2007-01-01',2,1),
(4,'鸣人',40,'开发',5000,'2020-01-01',2,1),
(5,'佐助',43,'测试',6000,'2020-01-03',3,1),
(6,'小樱',32,'测试',4000,'2020-01-05',2,1);

-- 添加外键
-- add constraint 添加约束
-- foreign key 外键约束
alter table emp add constraint fk_emp_dept_id foreign key  (dept_id) references dept(id);

-- 删除外键
alter table emp drop foreign key fk_emp_dept_id;
```

### 2.4 外键约束

![image-20220609163027741](img\image-20220609163027741.png)

```mysql
alter table emp add constraint fk_emp_dept_id foreign key  (dept_id) references dept(id) on update cascade on delete cascade;


alter table emp add constraint fk_emp_dept_id foreign key  (dept_id) references dept(id) on update set null on delete set null;

-- 外连接
use wust;
create table book(
    -- primary key 主键
    -- auto_increment 自动增长
                     id int primary key auto_increment comment '主键',
    -- not null 不为空
    -- unique 唯一
                     name varchar(10) not null unique comment '姓名',
    -- check 检查约束
                     age int check ( age >0 && age<=120 ) comment '年龄',
    -- default 设置默认值
                     status char(1) default '1' comment '状态',
                     gender char(1) comment '性别'
)comment '用户表';


-- 插入数据
insert into book(name, age, status, gender)
VALUES ('JYQ',19,'1','女'),('JYQ2',19,'1','女'),('JYQ3',19,'1','女'),('JY4',19,'1','女');
select * from book;


# 外键
create table dept(
                     id int auto_increment comment 'ID' primary key,
                     name varchar(50) not null comment '部门名称'
)comment '部门表';
insert into dept(id, name) VALUES (1,'研发部'),(2,'市场部'),(3,'销售部'),(4,'销售部'),(5,'总经办');

# drop table dept;
create table emp(
                    id int auto_increment comment 'ID'primary key,
                    name varchar(50)not null comment '姓名',
                    age int comment '年龄',
                    job varchar(20) comment '职位',
                    salary int comment  '薪资',
                    entrydate date comment '入职时间',
                    managerid int comment '直属领导ID',
                    dept_id int comment '部门ID'
)comment '员工表';
insert into emp(id, name, age, job, salary, entrydate, managerid, dept_id) VALUES
                                                                               (1,'自来也',99,'总裁',20000,'2000-01-01',null,5),
                                                                               (2,'水门',70,'项目经理',10000,'2005-01-01',1,1),
                                                                               (3,'卡卡西',50,'开发',7000,'2007-01-01',2,1),
                                                                               (4,'鸣人',40,'开发',5000,'2020-01-01',2,1),
                                                                               (5,'佐助',43,'测试',6000,'2020-01-03',3,1),
                                                                               (6,'小樱',32,'测试',4000,'2020-01-05',2,1);

-- 添加外键
-- add constraint 添加约束
-- foreign key 外键约束
alter table emp add constraint fk_emp_dept_id foreign key  (dept_id) references dept(id);

-- 删除外键
alter table emp drop foreign key fk_emp_dept_id;


alter table emp add constraint fk_emp_dept_id foreign key  (dept_id) references dept(id) on update cascade on delete cascade;


alter table emp add constraint fk_emp_dept_id foreign key  (dept_id) references dept(id) on update set null on delete set null;


-- 多表查询 --笛卡尔集(所有的组合情况)
select * from emp ,dept;
-- 删除多余组合
select * from emp ,dept where emp.dept_id = dept.id;

-- 隐式内连接
select emp.name,dept.name from emp ,dept where emp.dept_id=dept.id;

-- 显示内连接
select emp.name,d.name from emp inner join dept d on emp.dept_id = d.id;

-- 左外连接 --- 相当于查询表1（左表）  --会完全包含左表数据,包括左表中dept_id为空的数据
select *, d.name from emp e left outer join dept d on e.dept_id = d.id;
-- outer可省略
select *, d.name from emp e left join dept d on e.dept_id = d.id;


-- 右外连接 --- 相当于查询表2（右表）  --会完全包含左表数据(包括右边所有信息)
select *, d.name from emp e right outer join dept d on e.dept_id = d.id

-- 自连接
-- 查询员工及其所属领导名字
select a.name,b.name from emp a,emp b where a.managerid = b.id;

-- 左外连接 -- 查询坐标所有信息
select a.name '员工', b.name '领导' from emp a left join emp b on a.managerid = b.id;


-- 联合查询 --查询字段列表必须保持一致
-- 查询结果直接合并
select * from emp where salary <5000
union all
select * from emp where age >50;
-- 查询结果合并后会去重复
select * from emp where salary <5000
union
select * from emp where age >50;


-- 子查询 （嵌套查询）
-- 标量子查询
-- 查询销售部的所有员工
select * from emp where dept_id=(select id from dept where name='销售部');
-- 查询水门之后入职的员工信息
select entrydate from emp where name='水门';
select * from emp where entrydate >(select entrydate from emp where name='水门');

-- 列子查询
-- 查询销售部和市场部所有员工信息
select id from dept where name='销售部' or name='市场部';
select * from emp where dept_id in (select id from dept where name='销售部' or name='市场部');
-- 查询比财务部所有人工资都高的员工信息
select id from dept where name ='财务部';
select salary from emp where dept_id =(select id from dept where name ='财务部');
-- all 所有的都需要满足条件
select * from emp where salary > all(select salary from emp where dept_id =(select id from dept where name ='财务部'));
-- 查询比研发部其中任意一人工资高的员工信息
-- any or some 只需一个满足条件就行
select * from emp where salary > any(select salary from emp where dept_id =(select id from dept where name ='研发部'));


-- 行子查询
-- 查询与”水门“的薪资及直属领导相同的员工信息
select salary,managerid from emp where name ='水门';
select * from emp where (salary,managerid)=(10000,1);
select * from emp where (salary,managerid)=(select salary,managerid from emp where name ='水门');

-- 表子查询
select job,salary from emp where name ='自来也'or name='鸣人';
select * from emp where (job,salary) in(select job,salary from emp where name ='自来也'or name='鸣人');

select * from emp where entrydate >'2007-01-01';
select e.*, d.* from (select * from emp where entrydate >'2007-01-01') e left join dept d on  e.dept_id=d.id;

```
### 2.5 事务
```mysql
create  table account(
    id int auto_increment primary key  comment '主键ID',
    name varchar(10) comment '姓名',
    money int comment '余额'
)comment '账户表';
insert into account(id, name, money) values (null,'张三',2000),(null,'李四',2000);
update account set money = 2000;


-- 转账操作
-- 正常操作
select * from account where name='张三';
update account set money = money-1000 where name = '张三';
update account set money = money +1000 where name='李四';
-- 出现异常

-- 设置为手动提交
select @@autocommit;
set @@autocommit = 0;
# -- 开启事务
# start transaction ;
-- 异常操作
select * from account where name='张三';
update account set money = money-1000 where name = '张三';
错误。。。
update account set money = money +1000 where name='李四';

-- 提交事务
commit;

-- 回滚事务
rollback ;
```
![img.png](img\img.png)
![img-1.png](img\img_1.png)
![img-2.png](img\img_2.png)

```mysql
-- 事务隔离级别
-- 查看事务隔离级别  -- mysql默认repeatable-read
select @@transaction_isolation;

-- 设置事务隔离级别
set session transaction isolation level read uncommitted ;
set session transaction isolation level read committed ;
-- 事务隔离级别越高，数据越安全，但性能越低
```
### 2.6 进阶-存储结构
![img-3.png](img\img_3.png)
```mysql
-- 查询建表语句 -- 默认存储引擎为InnoDB
show create table account;

-- 查询当前数据库支持的存储引擎
show engines;

-- 创建表，指定MyISAM存储引擎
create table my_myISAM(
id int,
name varchar(30)
) engine =MyISAM;

-- 查看系统变量
show variables like 'innodb_file_per_table';
```
进阶版未学完-65（先学其他）
## 3.JDBC
![img-4.png](img\img_4.png)
###3.1JDBC程序编写步骤
![img-5.png](img\img_5.png)
![img-6.png](img\img_6.png)
```java
/**
* 方式五：将数据库需要的4哥基本信息声明在配置文件中，通过读取配置文件来获取连接
* 好处：
*  1.实现代码与数据分离。--- 解耦
*  2.如果需要修改配置文件信息，可以避免程序重新打包
* @throws IOException
* @throws ClassNotFoundException
* @throws SQLException
*/
@Test
public void testConnection5() throws IOException, ClassNotFoundException, SQLException {
//读取配置文件信息 -- 通过系统类加载器
InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
Properties pros = new Properties();
pros.load(is);
String book = pros.getProperty("book");
String password = pros.getProperty("password");
String url = pros.getProperty("url");
String driverClass = pros.getProperty("driverClass");

        // 加载驱动
        Class.forName(driverClass);
        Connection conn = DriverManager.getConnection(url, book, password);
        System.out.println(conn);


    }
```

### 3.2Java与SQL对应数据类型转换表
![img-7.png](img\img_7.png)
### 3.2 查询操作流程
![img-8.png](img\img_8.png)

### 3.3 JDBC概述
1.数据的持久化
持久化（persistence）:把数据保存到可掉电式存储设备中以供之后使用

2.JDBC(Java Database Connectivity)是一个独立于特定数据库管理系统、通用的SQL数据库存取和操作的公共接口（一组API）
简单理解为：JDBC是oracle公司提供的一套API，使用这套API可以实现对具体数据库的操作（获取连接、关闭连接、DML、DDL、DCL）

3.图示理解
![img-9.png](img\img_9.png)
好处：

1.面向应用的API：Java API，抽象接口，供应用程序开发人员使用（连接数据库、执行SQL语句、获得结果）

2.面向数据库的API：Java Driver API，供开发商开发数据库驱动程序用

4.数据库驱动：
数据库厂商针对于JDBC这套接口，提供的具体实现类的集合

### 3.4 数据库的连接
```java
    public static Connection getConnection() throws Exception{
        //读取配置文件
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros = new Properties();
        pros.load(is);

        String book = pros.getProperty("book");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        //加载驱动
        Class.forName(driverClass);

        //获取连接
        Connection conn = DriverManager.getConnection(url, book, password);
        return conn;
    }
```
其中配置文件声明在src下：
```
book=root
password=1234
url=jdbc:mysql://localhost:3306/test?rewriteBatchedStatements=true
driverClass=com.mysql.cj.jdbc.Driver
```
### 3.5 JDBCUtils
```java
/**
 * 操作数据库的工具类
 */
public class JDBCUtils {
    /**
     * 获取数据库的连接
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception{
        //读取配置文件
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros = new Properties();
        pros.load(is);

        String book = pros.getProperty("book");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        //加载驱动
        Class.forName(driverClass);

        //获取连接
        Connection conn = DriverManager.getConnection(url, book, password);
        return conn;
    }

    /**
     * 关闭连接和Statement的操作
     * @param conn
     * @param ps
     */
    public static void closeResource(Connection conn, Statement ps){
        //资源关闭
        try{
            if(ps!=null)
                ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        try{
            if(conn!=null)
                conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * 关闭资源
     * @param conn
     * @param ps
     * @param rs
     */
    public static void closeResource(Connection conn, Statement ps, ResultSet rs){
        //资源关闭
        try{
            if(ps!=null)
                ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        try{
            if(conn!=null)
                conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        try{
            if(rs!=null)
                rs.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

```

### 3.6 Statement弊端
```java
	// 使用Statement的弊端：需要拼写sql语句，并且存在SQL注入的问题
	// 如何避免sql注入：只需要PreparedStatement（从Statement扩展而来）取代Statement
	public static void testLogin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("用户名：");
		String book = sc.nextLine();
		System.out.println("密码：");
		String password = sc.nextLine();
//		select book,password from user_table where book = '1' or ' and password = '=1 or '1' = '1';
		String sql = "select book,password from user_table where book = '"+book+"' and password = '"+password+"';";
		User returnUser = get(sql, User.class);
		if(returnUser != null){
			System.out.println("登录成功！");
		}else{
			System.out.println("登录失败！");
		}
	}
```
####1.PreparedStatement是Statement子类---预编译语句
* 使用preparedStatement解决sql注入问题
* 1.除了解决Statement的拼串、sql诸如问题
* 2.PreparedStatement能操作Blob数据，而Statement不行
* 3.PreparedStatement批量处理更加高效
####2.PreparedStatement实现通用CRU操作，version1.0:
```java
    public int update(String sql,Object ...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0;i<args.length;i++) {
                ps.setObject(i+1,args[i]);//小心参数声明
            }
            /**
             * ps.execute()
             * 如果执行查询操作，有返回结果则返回true
             * 如果执行增删改操作，没有返回结果，怎返回false
             */
//            ps.execute();
            /**
             * either (1) the row count for SQL Data Manipulation Language (DML) statements
             * (2) 0 for SQL statements that return nothing
             */
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps);
        }
        return 0;
        
```
####3.PreparedStatement实现通用D操作，version1.0:
```java
    public <T>T getInstance(Class<T> clazz,String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            if (rs.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = rs.getObject(i + 1);
                    //获取列名  -- 不建议使用
//                    String columnName = rsmd.getColumnName(i + 1);
                    //获取列的别名
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }
```
####4.总结
* 两种思想：
  * 面向接口编程
  * ORM编程思想
* 两种技术：
  * 使用结果集的元数据：ResultSetMetaData
    * getColumnCount():获取列
    * getColumnLabel():获取列的列名
    * 使用ResultSetMetaData时，需要使用getColumnLabel（）来替换getColumnName(),来获取别名，没有别名的话就获取列名

![img-8.png](img\img_8.png)
#### 5.PreparedStatement操作Blob类型的变量
```java
/**
 * PreparedStatement操作Blob
 */
public class BlobTest {
    //Customers中插入Blob类型的字段
    @Test
    public void testInsert()throws Exception{
        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into customers(name,email,birth,photo) values (?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setObject(1,"XCG");
        ps.setObject(2,"CUG");
        ps.setObject(3,"2024-01-01");
        FileInputStream fis = new FileInputStream(new File("D:\\GitCode\\Java\\JavaLearning\\jdbc\\src\\com\\wust\\blob\\2.jpg"));
        ps.setBlob(4,fis);
        ps.execute();
        JDBCUtils.closeResource(conn,ps);
    }

    @Test
    public void testQuery(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select id, name,email, birth, photo from customers where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,22);
            rs = ps.executeQuery();
            if(rs.next()){
                //方法一
                //            int id = rs.getInt(1);
                //            String name = rs.getString(2);
                //            String email = rs.getString(3);
                //            Date birth = rs.getDate(4);

                //方法二
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date birth = rs.getDate("birth");
                Customer cust = new Customer(id, name, email, birth);
                System.out.println("**"+cust);

                //下载Blob类型数据并保存本地
                Blob photo = rs.getBlob("photo");
                is = photo.getBinaryStream();
                fos = new FileOutputStream("xcg.jpg");
                byte[] bys = new byte[1024];
                int len;
                while((len = is.read(bys))!=-1){
                    fos.write(bys,0,len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(is!=null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos!=null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JDBCUtils.closeResource(conn,ps,rs);
        }
    }
}

```
#### 6.PreparedStatement快速批量操作数据
```java
    public void testInsert3(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            conn = JDBCUtils.getConnection();

            //设置不允许自动提交数据
            conn.setAutoCommit(false);

            String sql = "insert into goods(name)values(?)";
            ps = conn.prepareStatement(sql);
            for (int i = 1; i <= 100; i++) {
                ps.setObject(1,"name_"+i);
//                ps.execute();

                //1."攒"sql
                ps.addBatch();
                if(i%50 == 0){
                    //2.执行
                    ps.executeBatch();
                    //3.清空batch
                    ps.clearBatch();
                }
            }
            //统一提交
            conn.commit();
            long end = System.currentTimeMillis();
            System.out.println(end-start);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps);
        }
    }
```


### 3.7数据库事务
* 事务：一组逻辑操作单元 ，使数据从一种状态变换到另一种状态
* 事务处理原则： 一个事务中的操作要么都执行要么都不执行
```java
    public void testUpdateWithTx(){
        Connection conn = null;
        try {
            //默认在关闭时，就会自动提交数据,故把关闭拿出来统一关闭
            conn = JDBCUtils.getConnection();
            System.out.println(conn.getAutoCommit());

            //取消DML操作的自动提交
            conn.setAutoCommit(false);
            String sql1 = "update user_table set balance = balance -100 where book = ?";
            update(conn,sql1,"AA");

            //模拟异常     ---  上面的sql1执行，下面的sql2不执行
            System.out.println(10/0);

            String sql2 = "update user_table set balance = balance +100 where book = ?";
            update(conn,sql2,"BB");

            //统一提交DML操作
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //出现异常回滚数据
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                //针对于使用数据库连接池中，需要归还连接，上面的置false，会使得该连接默认为false，故需要更改回原来true
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JDBCUtils.closeResource(conn,null);
        }
    }
```

#### 2.考虑了事务默认在关闭时，就会自动提交数据，因而连接需要从外部传入
```java
    public int update(Connection conn, String sql,Object ...args) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0;i<args.length;i++) {
                ps.setObject(i+1,args[i]);//小心参数声明
            }
            /**
             * ps.execute()
             * 如果执行查询操作，有返回结果则返回true
             * 如果执行增删改操作，没有返回结果，怎返回false
             */
//            ps.execute();
            /**
             * either (1) the row count for SQL Data Manipulation Language (DML) statements
             * (2) 0 for SQL statements that return nothing
             */
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null,ps);
        }
        return 0;
    }
```

#### 3.事务的四大属性
![img.png](img\img.png)

#### 4.并发问题
![img_1.png](img\img_1.png)
![img_2.png](img\img_2.png)

### 3.8 DAO及其Impl类
* BaseDAO 父类：抽象出不同表的共同操作
* CustomerDAO 接口类：定义实现类的具体方法
* CustomerDAOImpl 实现类：实现相应的方法
* CustomerDAOImplTest 测试类

### 3.9 数据库连接池
* 数据库连接存在的问题
![img_10.png](img\img_10.png)
* 数据库连接池的优点
![img_11.png](img\img_11.png)
* 不同的数据库连接技术
![img_12.png](img\img_12.png)
* common-dbutils是Apache组织提供的一个开源JDBC工具类库，封装了针对于数据库的CRUD（增删改查）操作
## 4.web前端
先不学
## 5.javaweb
                名称后缀
web层        com.wust.servlet、controller 
service层    service(接口包)、impl(实现类)
dao持久层     dao(接口包)、impl(实现类)
实体bean对象   pojo、entity、domain、bean
测试包         test、junit
工具包         utils


### 5.1 Servlet技术
* 功能：通过HTTP（超文本传输协议）接收和响应来自web客户端的请求
* 请求转发：服务器收到请求后，从一次资源跳到另一个资源的操作
* 相对路径：
  * .         表示当前目录
  * ..        表示上一级目录
  * 资源名     表示当前目录/资源名
* 绝对路径：http://ip:port/工程路径/资源路径
* jsp可以很好解决html页面回传的问题

## 6.Spring5
### 6.1 基本概念
* 轻量级开源JavaEE框架，为了解决企业复杂性包括IOC和AOP
* 创建Spring配置文件，在配置文件配置创建的对象

### 6.2 IOC容器

#### 6.2.1 IOC基本概念
* IOC:控制反转（Inversion of Control）,把对象创建和对象之间的调用过程，交给Spring进行管理
* 使用IOC的目的：为了降低耦合度
* 工厂模式：如调用UserDao类中的方法，可以先创建一个UserFactory类，在该类中创建一个静态方法，直接返回new UserDao()
  ,然后在需要调用UserDao的方法的地方直接调用UserFactory的静态方法，实现降低耦合度
* 原理：
  * 第一步 xml配置文件，配置创建的对象  <bean id="user1" class="com.wust.spring5.User"></bean>
  * 第二步 有service类和dao类，创建工厂类，在工厂类中创建静态方法，静态方法中解析xml获取相关数据，然后通过反射创建对象，因而进一步降低耦合度
* Spring提供IOC容器实现两种方式：（两个接口）
  * BeanFactory：IOC容器基本实现，是Spring内部使用的接口，开发人员一般不用这个
    BeaFactory加载配置文件时候不会创建对象，而是在获取的时候创建对象
  * ApplicationContext：是BeanFactory的子接口，提供更强大的功能，开发人员一般使用这个
    加载配置文件时候就会把在配置文件对象进行创建

#### 6.2.2 IOC操作 Bean管理
* Bean管理是指Spring创建对象和Spring注入属性
##### Bean管理操作两种方式
  * DI：依赖注入 ,就是注入属性
    * 使用set方法进行注入
    ```java
    public void setbName(String bName) {
             this.bName = bName;
    }
    ```        
    * 使用有参构造进行注入
     ```java
     private String bName;

      public Book(String bName) {
            this.bName = bName;
    }
    ```
##### 基于xml配置文件方式实现（无参）
  ```xml
  <bean id="book" class="com.wust.spring5.Book">
       <property name="bName" value="弟子规"></property>
  </bean>
  ```
  * id：唯一标识
  * class：类全路径
  * property:对象属性
  * 创建对象时默认调用无参构造
  * 有参创建对象
    ```xml
    <bean id="Orders" class="com.wust.spring5.Orders">
        <constructor-arg name="name" value="JYQ"></constructor-arg>
        <constructor-arg name="age" value="15"></constructor-arg>
    </bean>
    ```
  * p名称空间注入
##### 基于注解方式实现
  * bean的生命周期 com.wust.spring5.bean.Orders
    * 第一步 执行无参构造创建bean实例
    * 第二步  调用set方法设置属性值
    * 第三步 执行初始化方法
    * 第四步  获取对象
    * 第五步  执行销毁方法 
##### 基于注解实现bean
  * 注解
    * 注解是代码特殊标记，格式：@注解名称(属性名称=属性值,属性名称=属性值,...)
    * 注解作用于类、方法、属性上面
    * 使用注解目的：简化xml配置
  * Spring针对Bean管理中创建对象提供注解
    * @Component    标记为普通组件
    * @Service      标记为服务层组件
    * @Controller   标记为控制层组件
    * @Repository   标记为持久层组件
    * 注：上面四个注解功能是一样的都可用来创建bean实例
  * 注解方式创建对象
    * 1.引入aop依赖
    * 2.开启组件扫描
      ```text 
      <context:component-scan base-package="com.zhujie.spring5.service,com.zhujie.spring5.dao"></context:component-scan>
      ```
    * 3.在类上面添加注解
      ```text
      @Component(value = "userService") //<bean id="userService class="...">
      public class UserService {
           public void add(){
              System.out.println("service add....");
           }
      }
      ```
    * 4.获取对象
      ```text
      ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("zhujie.xml");
      UserService userService = con.getBean("userService", UserService.class);
      userService.add();
      ```
  * 注解方式实现属性注入  UserService中
    * @Autowired :根据属性类型进行自动注入             ---不需要写get和set方法
    * @Qualifier ：根据属性名称进行注入 ，该注解的使用需要和@Autowired一起使用
    * @Resource ：可以根据类型或名称进行注入
    * @Value : 注入普通类型属性
### 6.3 AOP
  * 基本概念：面向切面编程，利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高了开发的效率
  * 通俗描述：不通过修改源代码方式，在主干功能里面添加新功能
#### 6.3.1 底层原理（动态代理）
  * 第一种 ：有接口情况，使用JDK动态代理
    * 创建接口实现类代理对象，增强类的方法
    * 连接点：类中可以被增强的方法
    * 切入点：实际被增强的方法
      * 表达式：execution([权限修饰符][返回类型][类全路径][方法名称]([参数列表]))
      * execution(* com.wust.dao.Bookdao.add(..))  --对com.wust.dao.Bookdao类下的add方法进行增强，权限类型任意
      * execution(* com.wust.dao.*.*(..))   --对com.wust.dao包下的所有类的所有方法进行增强，权限类型任意
      * 切入点提取：
      *     @Pointcut(value = "execution(* com.aopanno.User.add(..))")
      *     public void pointDemo(){}  
    * 通知（增强）：实际被增强的逻辑部分
      * 前置通知
      * 后置通知
      * 环绕通知
      * 异常通知
      * 最终通知
    * 切面：是动作，把通知应用到切入点过程
    * 不同代理增强同一方法，设置优先级，在类上添加@Order(1)    //值越小优先级越高
    * AspectJ不是Spring组成部分，独立AOP框架，一般把AspectJ和Spring框架一起使用，进行AOP操作
  * 第二种 ： 没有接口情况，使用CGLIB动态代理
    * 创建子类的代理对象，增强类的方法
### 6.4JdbcTemplate
* Spring框架对JDBC进行封装，使用JdbcTemplate方便实现对数据库操作
* com.JdbcTemplate
* @Transactional :该注解可放在类、方法上，放在类上表示该类所有方法都添加事务，若方法在方法则为该方法添加事务
* 事务传播行为：当一个事务方法被另一个事务方法调用时，该事务方法该如何处理
### 6.5 Spring5新功能
* log4j2.xml 日志操作
* @Nullable:可以使用在方法、属性、参数上，表示该方法返回值、属性值、参数可以为空 

## 7.SpringMVC
* 基本概念：MVC是一种软件架构思想，将软件按照模型、视图、控制器来划分
* M：Model，模型层，指工程中的JavaBean，作用是处理数据
* V：View，视图层，指工程中html和jsp等页面，作用是与用户进行交互，展示数据
* C：Controller，控制层，指工程中的servlet，作用是接收和响应浏览器

* GET请求乱码是由tomcat造成的，只需要在conf/service.xml中端口号处加一个URIEncoding="UTF-8"即可
* POST请求乱码需要在web.xml中配置过滤器组件，通过设置过滤器组件中的encoding和forceResponseEncoding来达到设置编码格式 
* 拦截器用于拦截控制器方法


### 7.1  转发与重定向区别？
 * 转发：浏览器发送一次请求，第一次是浏览器发送，第二次是发送在服务器内部，因为第二次是发送是在服务器内部，
   * 所以地址栏地址不变，因而在如书本添加等操作时不能用转发，否则会刷新一次添加一本。
   * 转发可以获取request请求域中的数据，因为浏览器是一次请求所以请求域中的数据是同一个
   * 转发可以获取WEB-INF中的资源，因为WEB-INF中的数据具有安全性，只能通过服务器内部来访问不能通过浏览器访问，同时转发中存在的第二次发送发生在服务器内部，所以可以访问WEB-INF
   * 转发不能跨域（跨域：转发既然是发生在服务器内部的，因而其只能访问服务器内部资源，重定向是浏览器发送的请求，因而可以访问外部任何可访问资源）
   
 * 重定向:浏览器发送两次请求，第一次访问servlet，第二次访问重定向地址，因为是浏览器发送了两次请求，所以浏览器地址会发生改变，所以可以用于书本添加等操作，刷新时不再响应该操作
   * 重定向不能获取request请求域中的数据，因为浏览器发送两次请求，两次请求对应两个request域数据，因而获取不到域中数据
   * 重定向不能获取WEB-INF中的资源，因为两次请求都发生在浏览器
   * 重定向可以跨域


## 8.项目笔记

### 8.1注解
* @RestController=@ResponseBody+@Controller
* springboot资源加载顺序：
  * META/resources
  * resources
  * static
  * public
  * "classpath:/META-INF/resources/", "classpath:/resources/", "classpath:/static/", "classpath:/public/"