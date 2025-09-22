# JavaWeb-ict2025

--> Creating JDBC Connection pool:-
1. start payara server
2. right-click : view domain admin console (click)
3. payara server admin opens
4. now steps of creating JDBC connection pool:-
     1. JDBC -> JDBC Connection pools -> new -> pool name : anything you wish --> Resource Type : javax.sql.DataSource --> Database Driver Vendor: mysql --> click Next
     2. now go to additional properties:-
          1. password : root123 (you have in your localhost of phpmyadmin in seted)
          2. databasename : DbEmp
          3. serverName : localhost
          4. user : root
          5. url : jdbc:mysql://localhost:33013/dbemployee?useSSL=false (you will find this path in your netbean project .java file in your Connection code this line con = DriverManager.getConnection("jdbc:mysql://localhost:33013/dbemployee?useSSL=false", "root", ""); )
          6. portNumber : 3013 (i have 3013 but you have default 3006)
      3. now click finish
      4. go to general
      5. Datasource ClassName : com.mysql.cj.jdbc.MysqlDataSource (fill this same as )
      6. Driver ClassName : com.mysql.cj.jdbc.Driver (same as writed)
      7. click Save
      8. Click Ping --> Ping Successed (Came so your ping is created) and connection also established!.
  
------> or you are having error of server.log of Datasource classname error So follow this steps:
1. C:\payara_server\glassfish\domains\domain1\lib\mysql-connector-j-8.4.0  -->install mysql-connector .jar file and store that in path that i writed [mysql-connector-j-8.4.0 path---> https://downloads.mysql.com/archives/c-j/]
2. store that .jar file and run!






Setup: Creating a JDBC Connection Pool in Payara Server

Follow these steps to create a JDBC connection pool for your MySQL database in Payara Server.

1. Start Payara Server

Open NetBeans.

Right-click your Payara server → View Domain Admin Console.

The Payara Admin Console will open in your browser.

2. Create a JDBC Connection Pool

Navigate to:

JDBC → JDBC Connection Pools → New

Fill in the required fields:

Pool Name: Any name you like (e.g., MyPool)

Resource Type: javax.sql.DataSource

Database Driver Vendor: MySQL

Click Next

Configure Additional Properties:

Password: root123 (your MySQL password)

Database Name: DbEmp

Server Name: localhost

User: root

URL:

jdbc:mysql://localhost:33013/dbemployee?useSSL=false

(Adjust port/database based on your setup)

Port Number: 3013 (default MySQL port is usually 3306)

Click Finish.

Go to the General tab:

Datasource ClassName: com.mysql.cj.jdbc.MysqlDataSource

Driver ClassName: com.mysql.cj.jdbc.Driver

Click Save.

Test the connection:

Click Ping → You should see Ping Succeeded.

3. Fixing Datasource ClassName Errors

If you encounter errors related to Datasource ClassName:

Download the MySQL Connector J JAR file:

MySQL Connector J 8.4.0

C:\payara_server\glassfish\domains\domain1\lib\

Restart Payara Server.

✅ Result

Your JDBC Connection Pool is ready.

You can now use it in your Java web applications to connect to the MySQL database.
