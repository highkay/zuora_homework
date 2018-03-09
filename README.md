# Three page path

Given a dataset that represents a user's navigation of a website, find the top N most frequently visited paths.
Data
The data comes from a web server's access logs where you typically get the following fields: timestamp, IP address, request string, response code, user agent and cookies. For brevity, we provide a dataset that has the user and page parsed out.

<pre>
User	Page
U1	/
U1	login
U1	subscriber
U2	/
U2	login
U2	subscriber
U3	/
U3	login
U3	product
U1	/
U4	/
U4	login
U4	product
U5	/
U5	login
U5	subscriber
</pre>

The following words are used to describe the function that needs to be written: Find the top N most popular 3-page paths, where a path is three sequential page visits by a user.
The example I use is from U1, where the traversal is: / -> login -> subscriber -> /
In the above example, we have two paths:

<pre>
     1.     / -> login -> subscriber
     2.     login -> subscriber -> /
</pre>

Expected Output
Examples of output for the above example data.

<pre>
Top 10
/ -> login -> subscribers : 3
/ -> login -> product : 2
login -> subscriber -> / : 1
Top 2
/ -> login -> subscribers : 3
/ -> login -> product : 2
</pre>

You are recommended to implement the following interface, however you are still free to define your own interface. 

```java
public interface TopNPopularPathService { 
    void setup(String[][] data); 
    String[] getTopNPopularPaths(int n); 
}
```

### Requirements: 

1) Coding should be completed with production like quality. 
2) Write at least one positive unit test. 
3) Use JDK and common utility lib (e.g. apache-common), introduce too many 3rd libs is not recommended. 
4) The program you write can run independently, it should not depend on external application or service. 

### Build and run

Build

```
mvn install
```

Run

```
mvn test
```


