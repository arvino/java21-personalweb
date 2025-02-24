# Personal Website - Arvino Zulka

A modern personal website built with Java 21, Jakarta EE 10, PrimeFaces, and MongoDB, deployed on WildFly 35.

## Development Requirements

### Software Requirements
- Java Development Kit (JDK) 21
- Apache Maven 3.9+
- WildFly 35
- MongoDB 7.0+
- IDE with Jakarta EE support (e.g., Visual Studio Code, Eclipse, IntelliJ IDEA)

### System Requirements
- Operating System: Windows/Linux/macOS
- Minimum 4GB RAM
- 1GB free disk space

## Development Setup

### 1. Install Required Software

1. **Java 21**
   - Download and install JDK 21 from [Oracle](https://www.oracle.com/java/technologies/downloads/#java21) or use OpenJDK
   - Set JAVA_HOME environment variable

2. **Apache Maven 3.9+**
   - Download from [Maven website](https://maven.apache.org/download.cgi)
   - Add Maven bin directory to PATH

3. **WildFly 35**
   - Download from [WildFly website](https://www.wildfly.org/downloads/)
   - Extract to desired location (e.g., C:\java\wildfly-35)

4. **MongoDB**
   - Install MongoDB Community Edition
   - Ensure MongoDB service is running on default port 27017

### 2. Configure Development Environment

1. **Clone Repository**
   ```bash
   git clone <repository-url>
   cd personalweb-java21-wildfly35
   ```

2. **Build Project**
   ```bash
   mvn clean package
   ```

3. **Deploy to WildFly**
   ```bash
   copy target\personal-web.war C:\java\wildfly-35\standalone\deployments\
   ```

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── arvinozulka/
│   │           └── web/
│   │               ├── config/
│   │               │   └── MongoConfig.java
│   │               └── ContactBean.java
│   └── webapp/
│       ├── resources/
│       │   ├── css/
│       │   │   └── style.css
│       │   └── images/
│       ├── WEB-INF/
│       │   ├── faces-config.xml
│       │   ├── web.xml
│       │   └── template.xhtml
│       ├── index.xhtml
│       ├── portfolio.xhtml
│       └── contact.xhtml
```

## Technical Documentation

### Architecture

The application follows a standard Jakarta EE web application architecture:

- **Presentation Layer**: JSF with PrimeFaces
- **Business Layer**: CDI Beans
- **Data Layer**: MongoDB

### Key Components

1. **Web Pages**
   - `template.xhtml`: Base template with common layout
   - `index.xhtml`: Home page with introduction
   - `portfolio.xhtml`: Project showcase
   - `contact.xhtml`: Contact form

2. **Java Classes**
   - `MongoConfig`: MongoDB connection configuration
   - `ContactBean`: Contact form handling and MongoDB integration

3. **Configuration Files**
   - `faces-config.xml`: JSF configuration
   - `web.xml`: Web application configuration

### Technologies Used

1. **Frontend**
   - Jakarta Faces (JSF) 4.0
   - PrimeFaces 13.0.5
   - CSS3 with custom styling

2. **Backend**
   - Java 21
   - Jakarta EE 10
   - CDI (Contexts and Dependency Injection)
   - MongoDB Driver 4.11.1

3. **Build & Deployment**
   - Maven 3.9
   - WildFly 35

### Database Schema

MongoDB Collection: `contact`

Document Structure:
```json
{
  "_id": ObjectId,
  "name": String,
  "email": String,
  "subject": String,
  "message": String,
  "timestamp": String
}
```

### Features

1. **Responsive Design**
   - Mobile-friendly layout
   - Fluid grid system
   - Modern UI components

2. **Contact Form**
   - Input validation
   - MongoDB storage
   - Email format verification
   - Success/Error notifications

## Deployment

### Production Deployment Steps

1. **Prepare WildFly**
   ```bash
   # Start WildFly
   C:\java\wildfly-35\bin\standalone.bat
   ```

2. **Build Application**
   ```bash
   mvn clean package
   ```

3. **Deploy WAR**
   ```bash
   copy target\personal-web.war C:\java\wildfly-35\standalone\deployments\
   ```

4. **Verify Deployment**
   - Check WildFly logs for successful deployment
   - Access application at http://localhost:8080/personal-web/

### MongoDB Setup

1. **Create Database**
   ```javascript
   use personalweb
   ```

2. **Create Collection**
   ```javascript
   db.createCollection("contact")
   ```

3. **Verify Connection**
   ```javascript
   db.contact.find()
   ```

## Troubleshooting

Common issues and solutions:

1. **MongoDB Connection Issues**
   - Verify MongoDB service is running
   - Check MongoDB connection string in MongoConfig.java
   - Ensure no firewall blocking port 27017

2. **Deployment Failures**
   - Check WildFly logs in standalone/log/server.log
   - Verify WAR file is properly built
   - Ensure no port conflicts

3. **Runtime Errors**
   - Enable development mode in web.xml
   - Check browser console for JavaScript errors
   - Review server logs for exceptions

## Security Considerations

1. **Input Validation**
   - All form inputs are validated
   - Email format verification
   - XSS prevention through JSF encoding

2. **MongoDB Security**
   - Local database access only
   - No sensitive data stored
   - Connection pooling for efficiency

## Maintenance

1. **Regular Tasks**
   - Monitor WildFly logs
   - Check MongoDB disk usage
   - Update dependencies regularly

2. **Backup Procedures**
   - MongoDB backup
   ```bash
   mongodump --db personalweb
   ```
   - Application backup
   ```bash
   copy C:\java\wildfly-35\standalone\deployments\personal-web.war backup\
   ```

Development By Arvino Zulka
