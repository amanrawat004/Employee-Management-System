# 👨‍💼 Employee Management System

> A Java-based Employee Management System developed using **Hibernate ORM**, **JPA (Jakarta Persistence)**, **PostgreSQL**, and **Maven** following a **Layered Architecture (DAO-Service Pattern)**.

![Java](https://img.shields.io/badge/Java-17-orange)
![Hibernate](https://img.shields.io/badge/Hibernate-6.4.4.Final-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue)
![Maven](https://img.shields.io/badge/Maven-Build-red)
![License](https://img.shields.io/badge/License-Educational-lightgrey)

---

# 📌 Project Overview

The **Employee Management System** is a console-based application designed to manage employee and department records efficiently.

The project demonstrates the implementation of:

- Object-Oriented Programming (OOP)
- Hibernate ORM
- Jakarta Persistence API (JPA)
- PostgreSQL Database Connectivity
- DAO Design Pattern
- Service Layer Architecture
- CRUD Operations

---

# 🚀 Features

### 👨 Employee Module

- ➕ Add Employee
- 🔍 Search Employee by ID
- 📋 View All Employees
- ✏️ Update Employee Details
- ❌ Delete Employee

### 🏢 Department Module

- ➕ Add Department
- 📋 View All Departments
- 🔍 Search Department

---

# 🛠 Technologies Used

| Technology | Version |
|------------|---------|
| Java | 17 |
| Hibernate ORM | 6.4.4.Final |
| Jakarta Persistence (JPA) | 3.1 |
| PostgreSQL | Latest |
| Maven | 3.x |
| Eclipse IDE | 2025+ |

---

# 📂 Project Structure

```
EmployeeManagementSystem
│
├── src
│   └── main
│       │
│       ├── java
│       │
│       ├── entity
│       │      Employee.java
│       │      Department.java
│       │
│       ├── dao
│       │      EmployeeDAO.java
│       │      EmployeeDAOImpl.java
│       │      DepartmentDAO.java
│       │      DepartmentDAOImpl.java
│       │
│       ├── service
│       │      EmployeeService.java
│       │      EmployeeServiceImpl.java
│       │      DepartmentService.java
│       │      DepartmentServiceImpl.java
│       │
│       ├── util
│       │      HibernateUtil.java
│       │
│       └── main
│              EmployeeManagementApp.java
│
├── resources
│      META-INF
│           persistence.xml
│
├── pom.xml
│
└── README.md
```

---

# ⚙ Project Workflow

```
                User
                  │
                  ▼
      EmployeeManagementApp
                  │
                  ▼
          Service Layer
                  │
                  ▼
            DAO Layer
                  │
                  ▼
         Hibernate (JPA)
                  │
                  ▼
        PostgreSQL Database
```

---

# 🔄 Application Flow

```
User
 │
 ▼
Main Menu
 │
 ├───────────────┐
 │               │
 ▼               ▼
Department     Employee
 Module         Module
 │               │
 ▼               ▼
Service Layer  Service Layer
 │               │
 ▼               ▼
DAO Layer      DAO Layer
 │               │
 └───────┬───────┘
         ▼
Hibernate ORM
         ▼
 PostgreSQL Database
```

---

# 🏗 Layered Architecture

## 📌 Entity Layer

Contains database entities.

```
Employee.java
Department.java
```

Responsible for mapping Java objects to database tables.

---

## 📌 DAO Layer

Responsible for database operations.

```
EmployeeDAO
EmployeeDAOImpl

DepartmentDAO
DepartmentDAOImpl
```

Functions

- Save
- Update
- Delete
- Search
- Display

---

## 📌 Service Layer

Contains business logic.

```
EmployeeService
EmployeeServiceImpl

DepartmentService
DepartmentServiceImpl
```

Acts as a bridge between UI and DAO.

---

## 📌 Utility Layer

```
HibernateUtil.java
```

Responsibilities

- Create EntityManagerFactory
- Create EntityManager
- Close Resources

---

## 📌 Main Layer

```
EmployeeManagementApp.java
```

Console Interface

- Menu Driven Program
- User Input
- Calls Service Layer

---

# 🗄 Database Design

## Department

| Column | Type |
|---------|------|
| dept_id | Primary Key |
| dept_name | VARCHAR |
| location | VARCHAR |

---

## Employee

| Column | Type |
|---------|------|
| emp_id | Primary Key |
| emp_name | VARCHAR |
| email | VARCHAR |
| salary | DOUBLE |
| department_id | Foreign Key |

---

# 🔗 Entity Relationship

```
          Department
      -----------------
      dept_id (PK)
      dept_name
      location
            ▲
            │
            │ One
            │
            │
           Many
            │
            ▼
          Employee
      ----------------
      emp_id (PK)
      emp_name
      email
      salary
      department_id (FK)
```

---

# 📚 Hibernate Annotations Used

- ✅ @Entity
- ✅ @Table
- ✅ @Id
- ✅ @GeneratedValue
- ✅ @Column
- ✅ @ManyToOne
- ✅ @OneToMany
- ✅ @JoinColumn

---

# 💻 CRUD Operations

| Operation | Description |
|-----------|-------------|
| Create | Add Employee / Department |
| Read | Search & Display Records |
| Update | Modify Employee Details |
| Delete | Remove Employee |

---

# ▶ How to Run

### Step 1

Clone Repository

```bash
git clone https://github.com/prajot2610/EmployeeManagementSystem.git
```

---

### Step 2

Open in Eclipse

```
File
    ↓
Import
    ↓
Existing Maven Project
```

---

### Step 3

Create PostgreSQL Database

```sql
CREATE DATABASE Love;
```

(or update `persistence.xml` with your database name)

---

### Step 4

Update Database Credentials

```xml
User
Password
Database URL
```

---

### Step 5

Update Maven

```
Right Click Project
        ↓
Maven
        ↓
Update Project
```

---

### Step 6

Run

```
EmployeeManagementApp.java
```

---

# 📸 Console Menu

```
===============================
 EMPLOYEE MANAGEMENT SYSTEM
===============================

1. Add Department
2. View Departments
3. Add Employee
4. Search Employee
5. View All Employees
6. Update Employee
7. Delete Employee
8. Exit
```

---

# 📈 Time Complexity

| Operation | Complexity |
|-----------|------------|
| Add Employee | O(1) |
| Search by ID | O(1) |
| Update Employee | O(1) |
| Delete Employee | O(1) |
| Display Employees | O(n) |
| Display Departments | O(n) |

---

# 🎯 Learning Outcomes

✔ Hibernate ORM

✔ Jakarta Persistence (JPA)

✔ PostgreSQL Connectivity

✔ DAO Design Pattern

✔ Service Layer Architecture

✔ CRUD Operations

✔ Maven Project Structure

✔ One-to-Many Relationship

✔ Exception Handling

✔ Layered Software Architecture

---

# 👨‍💻 Author

**Prajot Nikam**

B.Tech Computer Science & Engineering

Lovely Professional University

GitHub: https://github.com/prajot2610

---

# ⭐ If you like this project

Give this repository a ⭐ on GitHub!
