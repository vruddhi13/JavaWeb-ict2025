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
3. click save
4. click ping!...


# JNDI MessagingModule :-
1. Create Project -> Java With Ant -> Java Enterprise -> EJB Module -> name: MessagingModule -> next
2. go to the services -> servers -> payara server -> Right-Click -> start server -> after server started -> click view domain admin console ->
   a. JMS Resources -> Destination Resources -> new -> JNDI name : jms/ictQue -> Physical Destination name: ictQue -> Resource Type : jakarta.jms.Queue -> OK.
   b. create another JNDI -> new -> JNDI name : jms/ictTopic -> Physical Destination name: ictTopic -> Resource Type : jakarta.jms.Topic -> OK.
3. Connection Factories -> new -> JNDI Name : jms/ictqueFactory -> Resource Type: jakarta.jms.QueueConnectionFactory -> OK. create same factory as Topic -> new -> JNDI Name : jms/icttopicFactory -> Resource Type: jakarta.jms.TopicConnectionFactory -> OK.
4. now go to the netbean messaginmodule Project in this -> source package -> new -> other -> Enterprise Java -> Message Driven Bean -> Name : FirstQueueBean -> Package: ejb -> server Destination that gived in admin console of server -> Server Destination: jms/ictQue -> next.

1. in this i had error when creating FirstQueueBean File like ->  
     The error message, "This feature is not fully supported in J2EE 1.3. You have to upgrade your project to J2EE 1.4,", so go with maven project

# Maven With MessagingModule
1. new project -> Java with maven -> EJB Module -> name -> MessagingModule -> Next ->Finish
2. go to pom.xml ->
   <modelVersion>4.0.0</modelVersion>
    <groupId>com.mycompany</groupId>
    <artifactId>MessagingModule</artifactId>
    <version>1</version>
    <packaging>ejb</packaging> -> war to change ejb
    <name>MessagingModule</name> -> Snapshot-1.0 delete
3. source package -> right click -> Other ->Enterprice JavaBeans -> Message driven bean -> EJB Name: FirstqueueBean-> package: ejb ->server destination : jms/ictQue -> Next ->Destination type -> QUEUE -> Finish.
4. create now Topic for  same as queue we created  --> source package -> right click -> Other ->Enterprice JavaBeans -> Message driven bean -> EJB Name: FirstTopicBean-> package: ejb ->server destination : jms/icttopic -> Next ->Destination type -> TOPIC -> Finish.
5. create all two files of SecondQueueBean and SecondTopicBean like First

Now creating SenderServlet and RecieverServlet same as like:
1. New project -> Java with maven -> web application -> name : MessageClientApp -> package: servlet -> Next
2. source package -> new -> Servlet -> SenderServlet and RecieverServlet create
3. write code and run first SenderServlet and FirstQueueBean project and then now run RecieverServlet -> and now FirstTopicBean or FirstQueueBean

==> output :
payara server in i am queue sender like output come in console


# Persistance CRUD Operation
first make to session bean like testBean.java and testBeanLocal.java so these is performes CRUD Operation. as a backend side Of EJB
    
  
   









