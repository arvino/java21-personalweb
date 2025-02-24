package com.arvinozulka.web;

import com.arvinozulka.web.config.MongoConfig;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.bson.Document;
import java.io.Serializable;
import java.time.LocalDateTime;

@Named
@RequestScoped
public class ContactBean implements Serializable {
    
    @Inject
    private MongoConfig mongoConfig;
    
    private String name;
    private String email;
    private String subject;
    private String message;
    
    public String sendMessage() {
        try {
            Document contactDoc = new Document()
                .append("name", name)
                .append("email", email)
                .append("subject", subject)
                .append("message", message)
                .append("timestamp", LocalDateTime.now().toString());
            
            mongoConfig.getContactCollection().insertOne(contactDoc);
            
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, 
                               "Success", 
                               "Thank you for your message. I will get back to you soon!"));
            
            // Clear the form
            this.name = null;
            this.email = null;
            this.subject = null;
            this.message = null;
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                               "Error", 
                               "Failed to save your message. Please try again later."));
        }
        
        return null;
    }
    
    // Getters and Setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}
