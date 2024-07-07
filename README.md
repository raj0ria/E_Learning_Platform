# E-Learning Platform Database Schema

## Introduction

Welcome to the E-Learning Platform! This platform is designed to provide a robust and scalable database schema to support various e-learning functionalities, including courses, authors, lectures, sections, and resources.

## Database Schema Overview

The database schema consists of the following entities:

- **Course**
- **Author**
- **Section**
- **Lecture**
- **Resource**
- **Video**
- **File**
- **Text**

Each entity is designed to represent a different aspect of the e-learning platform, and they are interconnected through various relationships to ensure data integrity and coherence.

## Entities and Relationships

### Course

| Field        | Type         | Description            |
|--------------|--------------|------------------------|
| `id`         | Integer (PK) | Unique identifier      |
| `title`      | String       | Title of the course    |
| `description`| String       | Description of the course|

**Relationships:**
- A Course can have multiple Sections (One to Many)
- A Course can have multiple Authors (Many to Many)

### Author

| Field        | Type         | Description           |
|--------------|--------------|-----------------------|
| `id`         | Integer (PK) | Unique identifier     |
| `first_name` | String       | First name of the author|
| `last_name`  | String       | Last name of the author|
| `email`      | String (UN)  | Email of the author   |

**Relationships:**
- An Author can be associated with multiple Courses (Many to Many)

### Section

| Field        | Type         | Description             |
|--------------|--------------|-------------------------|
| `id`         | Integer (PK) | Unique identifier       |
| `name`       | String       | Name of the section     |
| `order`      | String       | Order of the section    |

**Relationships:**
- A Section can have multiple Lectures (One to Many)
- A Section belongs to a Course (Many to One)

### Lecture

| Field        | Type         | Description            |
|--------------|--------------|------------------------|
| `id`         | Integer (PK) | Unique identifier      |
| `name`       | String       | Name of the lecture    |

**Relationships:**
- A Lecture can have one Resource (One to One)
- A Lecture belongs to a Section (Many to One)

### Resource

| Field        | Type         | Description            |
|--------------|--------------|------------------------|
| `id`         | Integer (PK) | Unique identifier      |
| `name`       | String       | Name of the resource   |
| `size`       | Integer      | Size of the resource   |
| `url`        | String       | URL of the resource    |

**Relationships:**
- A Resource can be a Video, File, or Text (Inheritance)

### Video (Extends Resource)

| Field        | Type         | Description            |
|--------------|--------------|------------------------|
| `length`     | Integer      | Length of the video    |

### File (Extends Resource)

| Field        | Type         | Description            |
|--------------|--------------|------------------------|
| `type`       | String       | Type of the file       |

### Text (Extends Resource)

| Field        | Type         | Description            |
|--------------|--------------|------------------------|
| `content`    | String       | Content of the text    |

## Setting Up the Database

To set up the database, follow these steps:

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-repo/elearning-platform.git
   cd elearning-platform
2. **Configure the Database:**
   Update the application.properties file with your database configuration:
   '''bash
   spring.datasource.url=jdbc:postgresql://localhost:5432/elearning
   spring.datasource.username=yourusername
   spring.datasource.password=yourpassword
3. ***Run the Application:***
   '''bash
   ./mvnw spring-boot:run
4. ***Access the Application:***
   Open your browser and navigate to http://localhost:8080.
5. ***Contributing***
   Contributions are welcome! Please fork the repository and submit pull requests for any enhancements or bug fixes.
6. ***License***
   This project is licensed under the MIT License - see the LICENSE file for details.
7. ***Contact***
   For any questions or feedback, please contact ashish13102376@gmail.com.

****Thank you for using the E-Learning Platform! Happy development****
