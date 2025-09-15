# URL Shortener Service

A simple **URL Shortener API** built with **Spring Boot**.  
It allows users to shorten long URLs, retrieve the original URL, and manage shortened links.

---

## 🚀 Features

- Shorten any long URL into a unique short code
- Redirect to the original URL using the short code
- Delete a shortened URL by its short code
- Fetch URL details by short code
- CORS enabled (`*`) for frontend integration

---

## 📂 Project Structure
        ├─client/
        ├  ─main.html
        ├
        ├─server/
        ├─ src/
        │ ├─ main/
        │ │ ├─ java/personal/urlshortener/
        │ │ │ ├─ controllers/ # REST Controllers
        │ │ │ ├─ business/ # Business logic (UrlManager)
        │ │ │ └─ entities/ # JPA Entities
        │ │ └─ resources/
        │ │ └─ application.properties
        ├─ pom.xml
        └─ ...

## 🛠️ Tech Stack

    Java 17+
    Spring Boot
    Spring Web
    Spring Data JPA (Hibernate)
    PostgreSQL (or any SQL database)



