## Process.API  

* Refer to comments in the MyServlet.java file

## Create Directories & Files 

* mkdir projectname
* cd projectname
* mkdir -p web/WEB-INF
* touch web/index.jsp
* touch web/WEB-INF/web.xml

* mkdir -p src/main/java/com/example
* touch src/main/java/com/example/MyServlet.java

* touch script.py 

## Files 

* script.py: Your python script. (script.py can be located anywhere as long as the .java code maintains the correct path of it).
* index.jsp: An HTML file. 
* web.xml: Deployment descriptor. Map the servlet to a URL pattern.

## Compiling  

* javac -cp /path/to/your/main/tomcat/lib/servlet-api.jar -d build/WEB-INF/classes /src/main/java/com/example/MyServlet.java

* jar -cvf Projectname.war -C web/ .

Note: ensure that .war file was compiled properlly! The .war file content should look like this:

* META-INF/
* META-INF/MANIFEST.MF
* WEB-INF/
* index.jsp
* WEB-INF/classes/
* WEB-INF/classes/com
* WEB-INF/classes/com/example/
* WEB-INF/classes/com/example/MyServlet.java

Note: if the .war content is different, you have to add/update the compiled .war file manually. 
To manually update the .war file: 

* jar -uvf projectname.war -C build/ .

## File Transfer  

* cp Projectname.war /path/to/your/tomcat/instance/webapps/

## Access 

* http://ip_addr:port/Projectname
