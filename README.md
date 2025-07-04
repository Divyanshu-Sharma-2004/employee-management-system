# Employee Management System

The **Employee Management System** is a desktop-based Java application built using **Java Swing** for the user interface, **Hibernate ORM** for database interaction, and **MySQL** as the backend database. It provides a structured and user-friendly interface to manage employee records — including adding, updating, viewing, and deleting employee information.

---

## 🧠 Features

- **Add New Employee**  
  Enter employee details including name, DOB, address, contact info, education, designation, and salary.

- **Update Employee Details**  
  Fetch employee details by ID, modify them, and update the record in the database.

- **View All Employees**  
  Display a formatted JTable with all employee records, styled for readability.

- **Delete Employee**  
  Select an employee by ID from a dropdown and delete the corresponding record.

- **Splash Screen**  
  A simple and professional splash screen that appears at application startup.

---

## 🛠️ Technologies Used

| Category         | Tools / Frameworks                |
|------------------|-----------------------------------|
| Programming      | Java (JDK 8 or higher)            |
| GUI              | Java Swing, AWT                   |
| ORM              | Hibernate (hibernate.cfg.xml)     |
| Database         | MySQL                             |
| Build Tool       | Manual build or IDE-based         |
| IDE Recommended  | Eclipse / IntelliJ / NetBeans     |

---

## ⚙️ Project Structure

com.ems
│
├── ui // GUI classes (Swing)
│ ├── Splash.java
│ ├── Home.java
│ ├── Login.java
│ ├── Main.java
│ ├── AddEmployee.java
│ ├── ViewEmployee.java
│ ├── UpdateEmployee.java
│ └── RemoveEmployee.java
│
├── dao // Data access layer
| ├── LoginDao.java
│ └── EmployeeDao.java
│
├── model // POJO mapped to database
│ ├── EmployeeEntity.java
| └── LoginEntity.java
│
└── util
└── HibernateUtil.java // Singleton SessionFactory

---

## 🗃️ Database Design (MySQL)

Table: `employee`

| Column       | Data Type    | Description             |
|--------------|--------------|-------------------------|
| emp_id       | VARCHAR(20)  | Primary Key             |
| name         | VARCHAR(50)  | Employee name           |
| fname        | VARCHAR(50)  | Father's name           |
| dob          | DATE         | Date of birth           |
| salary       | VARCHAR(20)  | Salary amount           |
| address      | VARCHAR(100) | Employee address        |
| phone        | VARCHAR(10)  | Phone number            |
| email        | VARCHAR(50)  | Email address           |
| education    | VARCHAR(20)  | Qualification           |
| designation  | VARCHAR(30)  | Job title               |
| aadhar       | VARCHAR(12)  | Aadhar number (unique)  |

---

## 🔧 How to Run

1. **Install Dependencies**
   - Java JDK 8+
   - MySQL Server
   - JDBC Driver (added to your project build path)
   - Hibernate JARs (hibernate-core, commons-logging, etc.)

2. **Set Up Database**
   - Create MySQL database and table using appropriate SQL script.
   - Update `hibernate.cfg.xml` with your DB credentials.

3. **Compile and Run**
   - Run `Main.java` which launches the `Splash.java` → `Home.java`.

4. **Use Application**
   - Navigate via GUI to manage employee records.

---

## ✅ Validation Features

- Prevents submission of empty fields
- Validates phone number length (must be exactly 10 digits)
- Tooltips for buttons
- Formatted and bordered text fields
- Header styling in tables for better readability

---

## 📌 Notes

- **Hibernate only** is used for DB operations. **JDBC is not used directly**.
- The application uses a **modular MVC-style structure**.
- Easily extendable for more modules (e.g., department, payroll).

---

## 👨‍💻 Author

**Divyanshu Sharma**  
https://www.linkedin.com/in/divyanshu-sharma-39720629a/
---

## 📝 License

This project is open source for educational or personal use. Please give credit if reused or modified.
