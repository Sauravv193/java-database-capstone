

# Schema Design: Smart Clinic Management System

This document outlines the MySQL database schema design for the Smart Clinic Management System. It includes core entities like Doctor, Patient, Appointment, and Admin, and describes their relationships.

---

## 🧑‍⚕️ Doctor Table

```sql
CREATE TABLE Doctor (
    doctor_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15),
    specialization VARCHAR(100),
    availability JSON,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

---

## 🧑‍🦽 Patient Table

```sql
CREATE TABLE Patient (
    patient_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15),
    dob DATE,
    gender ENUM('Male', 'Female', 'Other'),
    address TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

---

## 📅 Appointment Table

```sql
CREATE TABLE Appointment (
    appointment_id INT AUTO_INCREMENT PRIMARY KEY,
    doctor_id INT NOT NULL,
    patient_id INT NOT NULL,
    appointment_date DATE NOT NULL,
    appointment_time TIME NOT NULL,
    status ENUM('Scheduled', 'Completed', 'Cancelled') DEFAULT 'Scheduled',
    notes TEXT,
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id),
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

---

## 💊 Prescription Table

```sql
CREATE TABLE Prescription (
    prescription_id INT AUTO_INCREMENT PRIMARY KEY,
    appointment_id INT NOT NULL,
    doctor_id INT NOT NULL,
    patient_id INT NOT NULL,
    prescription_text TEXT NOT NULL,
    issued_date DATE DEFAULT CURRENT_DATE,
    FOREIGN KEY (appointment_id) REFERENCES Appointment(appointment_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id),
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id)
);
```

---

## 🛠 Admin Table

```sql
CREATE TABLE Admin (
    admin_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL
);
```

---

## 🔐 User Login Table

```sql
CREATE TABLE User (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    role ENUM('Doctor', 'Patient', 'Admin') NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);
```

---

## Relationships

- One **doctor** can have many **appointments**
- One **patient** can have many **appointments**
- Each **appointment** can have one **prescription**
- The **User** table provides authentication and role-based access

