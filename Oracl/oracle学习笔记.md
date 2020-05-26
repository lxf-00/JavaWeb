# oracle 学习笔记

### 1. 创建表空间
```oracle
create tablespace test1       // 为表空间名称
datafile 'c:\test1.dbf'      // 指定表空间对应的数据文件
size 100m                   // 后定义的是表空间的初始大小
autoextend on              // 自动增长 ，当表空间存储都占满时，自动增长
next 10m                  // 后指定的是一次自动增长的大小。
```

### 2. 创建用户
```oracle
create user lxf       
identified by lxf        // 是用户的密码
default tablespace test1   // 后边是表空间名称

oracle 数据库与其它数据库产品的区别在于，表和其它的数据库对象都是存储在用户
下的。
```
### 3. 用户赋权限
- 新创建的用户没有任何权限，登陆后会提示
- Oracle 中已存在三个重要的角色：connect 角色，resource 角色，dba 角色。
  - CONNECT 角色: 是授予最终用户的典型权利，最基本的
    - ALTER SESSION --修改会话
    - CREATE CLUSTER --建立聚簇
    - CREATE DATABASE LINK --建立数据库链接
    - CREATE SEQUENCE --建立序列
    - CREATE SESSION --建立会话
    - CREATE SYNONYM --建立同义词
    - CREATE VIEW --建立视图
  - RESOURCE 角色： --是授予开发人员的
    - CREATE CLUSTER --建立聚簇
    - CREATE PROCEDURE --建立过程
    - CREATE SEQUENCE --建立序列
    - CREATE TABLE --建表
    - CREATE TRIGGER --建立触发器
    - CREATE TYPE --建立类型
  - DBA 角色：拥有全部特权，是系统最高权限，只有 DBA 才可以创建数据库结构.并且系统
权限也需要 DBA 授出，且 DBA 用户可以操作全体用户的任意基表，包括删除.
```oracle
grant dba to lxf;
```
### 4, 数据类型
| 数据类型 | 描述  |
| :------| :--- |
| Varchar,varchar2 | 表示一个字符串|
| NUMBER | NUMBER(n)表示一个整数，长度是 n;
| |NUMBER(m,n):表示一个小数，总长度是 m，小数是 n，整数是 m-n
| DATA | 表示日期类型 |
| CLOB | 大对象，表示大文本数据类型，可存 4G|
| BLOB | 大对象，表示二进制数据，可存 4G|

### 5, 表的管理
- 1. 建表
  - 语法
  ``` oracle
  Create table 表名（
  字段 1 数据类型 [default 默认值],
  字段 2 数据类型 [default 默认值],
  ...
  字段 n 数据类型 [default 默认值]
  ）;

  示例：
  create table person(
  pid number(10),
  name varchar2(10),
  gender number(1) default 1,
  birthday date
  );
  ```
- 2. 删除表
```oracle
DROP TABLE 表名
```
- 3. 表的修改
```oracle
添加语法：ALTER TABLE 表名称 ADD(列名 1 类型 [DEFAULT 默认值]，列名 1 类型[DEFAULT 默认值]...);
修改语法：ALTER TABLE 表名称 MODIFY(列名 1 类型 [DEFAULT 默认值]，列名 1 类型[DEFAULT 默认值]...);
修改列名: ALTER TABLE 表名称 RENAME 列名 1 TO 列名 2;
```
- 4. 数据库表数据的更新
```oracle
INSERT（增加）:

    INSERT INTO 表名[(列名 1，列名 2，...)]VALUES(值 1，值 2，...); // 标准写法
    INSERT INTO 表名 VALUES(值 1，值 2，...); // 简写

UPDATE（修改) :
   全部修改：UPDATE 表名 SET 列名 1=值 1，列名 2=值 2，....;
   局部修改：UPDATE 表名 SET 列名 1=值 1，列名 2=值 2，....WHERE 修改条件;
```
- 5. DELETE（删除）
```oracle
DELETE FROM 表名 WHERE 删除条件;
```
- 6. 序列
 - 在很多数据库中都存在一个自动增长的列,如果现在要想在 oracle 中完成自动增长的功能,则只能依靠序列完成,所有的自动增长操作,需要用户手工完成处理
```oracle
语法：CREATE SEQUENCE 序列名
    [INCREMENT BY n]
    [START WITH n]
    [{MAXVALUE/ MINVALUE n|NOMAXVALUE}]
    [{CYCLE|NOCYCLE}]
    [{CACHE n|NOCACHE}];
```
### 6. 单行函数
- 1. 字符函数: 接收字符输入返回字符或者数值，dual 是伪表
  - 把小写的字符转换成大小的字符:  **upper**
  ```oracle
  select upper('smith') from dual;
  ```
  - 把大写字符变成小写字符: **lower**
  ```oracle
  select lower('SMITH') from dual;
  ```
  - 首字母大写函数: **initcap**
  ```oracle
  select initcap('hello') from dual;
  ```
  - 字符串链接函数: **concat**
  ```oracle
  select concat('hello', 'world') from dual;
  ```
  - 字符串截取函数: **substr**
  ```oracle
  select substr('hellworld', 1, 5) from dual; // 从1开始计数
  ```
  - 字符串替换函数: **replace**
  ```oracle
  select replace('abcd', 'c', 'm') from dual;
  ```
  - 获取字符串长度函数: **length**
  ```oracle
  select length('abds') from dual;
  ```
  - 显示查找的字符在字符串中的位置: **instr**
  ```oracle
  select instr('andsss', 's') from dual;
  ```
  - 字符不够的时候，在用规定字符凑够字符长度: **lpad, rpad**
  ```oracle
  select lpad('sdf', 6, '*') from dual;
  select rpad('sdf', 6, '*') from dual;
  ```
  - 删除字符串开头或结尾规定的字符: **trim**
  ```oracle
  select trim('p' from 'hellp') from dual;
  ```
- 2. 数值函数
  - 四舍五入函数：**ROUND()**
  ```oracle
  select round(521.2345, 2) from dual;   // 指定保留的小数位数
  select round(521.2345) from dual;
  ```
  - 数值截取函数(截断小数位数): **TRUNC**
  ```oracle
  select trunc(34.2342, 2) from dual;  // 指定保留的小数位数，不会四舍五入
  ```
  - 取余函数: **MOD**
  ```oracle
  select mod(6, 2) from dual;
  ```
- 3. 日期函数
  - 返回当前时间： **sysdate**
  ```oracle
  select sysdate from dual;
  ```
  - 日期的加减:日期 – 数字 = 日期;日期 + 数字 = 日期;日期 – 日期 = 数字
  ```oracle
  示例： 使用scott查询员工入职周数
  select ename, round((sysdate - hiredate)/7) from emp;
  ```
  - 两个时间段中的月数: **MONTHS_BETWEEN()**
  ```oracle
  示例：查询所有雇员进入公司的月数
  select round(MONTHS_BETWEEN(sysdate, hiredate)) from emp;
  ```
- 4. 转换函数
  - 字符串日期转换为date: **to_date**
  ```oracle
  select to_date('2009-10-23', 'yyyy-MM-dd') from dual;
  ```
  - 字符串转换函数： **to_char**
  ```oracle
  示例： 查询所有的雇员将将年月日分开
  select empno,ename,to_char(hiredate, 'yyyy') 年,
                    to_char(hiredate, 'MM') 月,
                    to_char(hiredate, 'dd') 日 from emp;
  ```
- 5. 通用函数
  - 空值处理: **nvl**
  ```oracle
  示例： 查询所有的雇员的年薪
  select ename, nvl(comm, 0), sal*12 + nvl(comm, 0) from emp;
  ```
  - if...else...: **decode**
    - 语法：DECODE(col/expression, [search1,result1],[search2,result2]....[default])
    ```oracle
    示例：查询出所有雇员的职位的中文名
    select ename,decode(job, 'CLERK','业务员','SALESMAN', '销售', 'PRESIDENT','总裁','MANAGER','经理', '无业') from emp;

    case when
    ```
### 7. 多行函数（聚合函数）
- 统计记录数： **count()**
```oracle
select count(*) from emp;

不建议使用 count(*)，可以使用一个具体的列以免影响性能。
select count(ename) from emp;
```
- 最小值查询: **min()**
```oracle
select min(sal) from emp;
```
- 最大值查询: **max()**
```oracle
select max(sal) from emp;
```
- 查询平均值: **avg()**
```oracle
select avg(sal) from emp;
```
- 求和函数: **sum()**
```oracle
select sum(sal) from emp t where t.deptno = 20;
```
### 8.分组统计
- 分组统计： **GROUP BY**
  - 语法：SELECT * |列名 FROM 表名 {WEHRE 查询条件} {GROUP BY 分组字段} ORDER BY 列
名 1 ASC|DESC，列名 2...ASC|DESC
```oracle
示例：查询每个部门的人数
select deptno, count(ename) from emp group by deptno;
```
### 9. 多表查询
- 1. 多表连接基本查询
  - 语法： SELECT {DISTINCT} * |列名.. FROM 表名 别名，表名 1 别名
{WHERE 限制条件 ORDER BY 排序字段 ASC|DESC...}
```oracle
示例： 查询员工表和部门表
select * from emp, dept;
select * from emp e, dept t where e.deptno = t.deptno;
```
- 2. 外连接（左右连接）
  - 使用(+)表示左连接或者右连接，当(+)在左边表的关联条件字段上时是左连接，如果是在右
边表的关联条件字段上就是右连接。
```oracle
select e.empno, e.ename, d.deptno, d.dname from emp e, dept d where e.deptno(+) = d.deptno;
```
### 10. 子查询
- 子查询：在一个查询的内部还包括另一个查询，则此查询称为子查询。Sql的任何位置都可以加入子查询.
```oracle
示例： 查询工资高于编号7567的员工
select * from emp e where e.sal > (select e1.sal from emp e1 where e1.empno = 7567);
```
### 11. Rownum与分页查询
- ROWNUM:表示行号，实际上是一个列,但是这个列是一个伪列,此列可以在每张表中出现。
```oracle
select rownum, e.* from emp e;
```
- 可以根据 rownum 来取结果集的前几行，比如前 5 行
```oracle
select rownum, e.* from emp e where rownum <6;
```
- rownum不支持大于号，只支持小于号;是使用子查询，实现分页查询
```oracle
select * from (select rownum, emp.* from emp) b where b.r > 5 and b.r < 11;
```

### 12. 视图
- 语法 1.：CREATE VIEW 视图名称 AS 子查询
```oracle
范例：建立一个视图，此视图包括了 20 部门的全部员工信息
create view empvd20 as select * from emp t where t.deptno=20;
select * from empvd20;
```
- 语法 2：CREATE OR REPLACE VIEW 视图名称 AS 子查询(视图存在的话，会被覆盖。)
- 设置视图为只读： CREATE OR REPLACE VIEW 视图名称 AS 子查询 WITH READ ONLY；
### 13. 索引
- 索引是用于加速数据存取的数据对象。合理的使用索引可以大大降低 i/o 次数，从而提高数据访问性能。
- 1． 单列索引：单列索引是基于单个列所建立的索引（CREATE index 索引名 on 表名(列名)）
- 2． 复合索引：复合索引是基于两个列或多个列的索引。在同一张表上可以有多个索引，要求列的组合必须不同。
```oracle
Create index emp_idx1 on emp(ename,job);
Create index emp_idx1 on emp(job,ename);
```
- 3. 索引的使用原则：
  - 在大表上建立索引才有意义
  - 在 where 子句后面或者是连接条件上的字段建立索引
  - 表中数据修改频率高时不建议建立索引
### 13. pl/sql 基本语法
- 1. pl/sql 程序语法： PL/SQL（Procedure Language/SQL）
  - PLSQL 是 Oracle 对 sql 语言的过程化扩展，指在 SQL 命令语言中增加了过程处理语句（如支、循环等），使 SQL 语言具有过程处理能力
  - 程序语法：
  ```oracle
  declare
  说明部分 （变量说明，游标申明，例外说明 〕
  begin
   语句序列 （DML 语句〕…
  exception
   例外处理语句
  End;
  ```
- 2. 常量和变量定义
  - 变量的基本类型就是 oracle 中的建表时字段的变量
  ```oracle
  定义语法：varl char(15);
          Psal number(9,2);
          常量定义：married constant boolean:=true
  ```
  - 引用变量: Myname emp.ename%type;即 my_name 的类型与 emp 表中 ename 列的类型一样,在 sql中使用 into 来赋值
  ```oracle
  declare
    emprec emp.ename%type;
  begin
    select t.ename into emprec from emp t where t.empno = 7369;
    dbms_output.put_line(emprec);
  end;
  ```
  - 记录型变量： Emprec emp%rowtype  记录变量分量的引用 emp_rec.ename:='ADAMS';
  ```oracle
  declare
    p emp%rowtype;
  begin
    select * into p from emp t where t.empno = 7369;
    dbms_output.put_line(p.ename || ' ' || p.sal);
  end;
  ```  
- 3. if 分支
  - 语法1
  ```oracle
  IF 条件 THEN 语句 1;
    语句 2;
    END IF;
  ```
  - 语法2
  ```oracle
  IF 条件 THEN 语句序列 1；
    ELSE 语句序列 2；
    END IF；
  ```
  - 语法3
  ```oracle
  IF 条件 THEN 语句;
  ELSIF 语句 THEN 语句;
  ELSE 语句;
  END IF;
  ```
  ```oracle
  范例 1：如果从控制台输入 1 则输出我是 1
  declare
    pnum number := &num;
  begin
    if pnum = 1 then
    dbms_output.put_line('我是1');
    end if;
  end;
  ```
- 4. LOOP 循环语句
  - 语法1
  ```oracle
  WHILE total <= 25000 LOOP
  .. .
  total : = total + salary;
  END LOOP;
  ```
  - 语法2
  ```oracle
  Loop
  EXIT [when 条件];
  ……
  End loop
  ```
  - 语法3
  ```oracle
  FOR I IN 1 . . 3 LOOP
  语句序列 ;
  END LOOP ;
  ```
  ```oracle
  范例:使用语法 1 输出 1 到 10 的数字
  declare
    step number := 1;
  begin
    while step <= 10 loop
    dbms_output.put_line(step);
    step := step + 1;
    end loop;
  end;
  ```
- 5. 游标 Cursor
  -  pl/sql 中也会用到多条记录，这时候我们就要用到游标，游标可以存储查询返回的多条数据。
  - 语法
  ```oracle
  CURSOR 游标名 [ (参数名 数据类型,参数名 数据类型,...)] IS SELECT 语句;

  示例： cursor c1 is select ename from emp;
  ```
  - 游标的使用步骤：
    - 打开游标： open c1; (打开游标执行查询)
    - 取一行游标的值：fetch c1 into pjob; (取一行到变量中)
    - 关闭游标： close c1;(关闭游标释放资源)
    - 游标的结束方式 exit when c1%notfound
    - 注意： 上面的 pjob 必须与 emp 表中的 job 列类型一致：pjob emp.empjob%type;
    ```oracle
    示例： 使用游标方式输出 emp 表中的员工编号和姓名
    declare
      cursor pc is
        select * from emp;
      pemp emp%rowtype;
    begin
      open pc;
      loop
        fetch pc
          into pemp;
        exit when pc%notfound;
        dbms_output.put_line(pemp.empno || ' ' || pemp.ename);
      end loop;
      close pc;
    end;
    ```

- 6. 终端运行：末尾必须空行敲入/ 执行

### 14. 存储过程
- 存储过程（Stored Procedure）是在大型数据库系统中,一组为了完成特定功能的 SQL 语句集,经编译后存储在数据库中，用户通过指定存储过程的名字并给出参数（如果该存储过程带有参数）来执行它。存储过程是数据库中的一个重要对象，任何一个设计良好的数据库应用程序都应该用到存储过程。
- 创建存储过程语法：
```oracle
create [or replace] PROCEDURE 过程名[(参数名 in/out 数据类型)]
AS
begin
  PLSQL 子程序体；
End;
或者
create [or replace] PROCEDURE 过程名[(参数名 in/out 数据类型)]
is
begin
 PLSQL 子程序体；
End 过程名;

范例：创建一个输出 helloword 的存储过程
create or replace procedure helloworld is
begin
 dbms_output.put_line('helloworld');
end helloworld;

调用存储过程
在 plsql 中调用存储过程
begin
 -- Call the procedure
 helloworld;
end;
```
### 15.存储函数
```oracle
create or replace function 函数名(Name in type, Name in type, ...) return 数据类型 is
 结果变量 数据类型;
begin

 return(结果变量);
end 函数名;
```
- 存储过程和存储函数的区别
  - 一般来讲，过程和函数的区别在于函数可以有一个返回值；而过程没有返回值。
但过程和函数都可以通过 out 指定一个或多个输出参数。我们可以利用 out 参数，在过程和函数中实现返回多个值。
### 16.触发器
- 数据库触发器是一个与表相关联的、存储的 PL/SQL 程序,每当一个特定的数据操作语句(Insert,update,delete)在指定的表上发出时，Oracle 自动地执行触发器中定义的语句序列。
- 触发器可用于:
  - 数据确认
  - 实施复杂的安全性检查
  - 做审计，跟踪表上所做的数据操作等
  - 数据的备份和同步
- 触发器的类型
  - 语句级触发器 ：在指定的操作语句操作之前或之后执行一次，不管这条语句影响了多少行 。
  - 行级触发器（FOR EACH ROW）: 触发语句作用的每一条记录都被触发。在行级触发器中使用 old 和 new 伪记录变量, 识别值的状态.
```oracle
语法：
CREATE [or REPLACE] TRIGGER 触发器名
 {BEFORE | AFTER}
 {DELETE | INSERT | UPDATE [OF 列名]}
 ON 表名
 [FOR EACH ROW [WHEN(条件) ] ]
begin
 PLSQL 块
End 触发器名

范例：插入员工后打印一句话“一个新员工插入成功”
create or replace trigger testTrigger
 after insert on person
declare
 -- local variables here
begin
 dbms_output.put_line('一个员工被插入');
end testTrigger;
```
