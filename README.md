# 🧾 SQL Account Creation with Replication

Organization: MEMMCOL Apps
Project Name: AccountCreationWithReplication
Author: Engr. Okeola Mudashiru
Technology Stack: Java 21 • Spring Boot • SQL Server • HikariCP • JDBC Template

⸻

## 📘 Overview

This project implements a multi-database SQL application using Spring Boot, designed to handle customer account creation and real-time data replication between multiple business unit databases and a central consolidated hub.

New SQL application using Spring Boot that can perform real-time replication to business hub servers.

The system ensures synchronization between 25 business databases and a consolidated central database, supporting both upstream (branch → hub) and downstream (hub → branch) data consistency.

⸻

## ⚙️ Key Features

•	🔁 Real-time replication between distributed SQL Server databases
•	🧩 Modular connection pools (HikariCP) for each database
•	🏗️ Scalable structure for multiple business units
•	🔐 Robust transaction management and error handling
•	🗄️ Integration-ready architecture for enterprise systems
•	🧠 Designed for future integration with IBEDC and HES systems

⸻

## 📂 Project Structure

AccountCreationWithReplication/
├── src/main/java/com/memmcolapps/accountcreation/
│     ├── config/         # Database and replication configuration
│     ├── model/          # Entity classes
│     ├── repository/     # Data access layer
│     ├── service/        # Business logic and replication methods
│     └── controller/     # REST API endpoints
├── src/main/resources/
│     ├── application.yml # DataSource and environment setup
│     └── schema.sql      # Optional DB schema script
├── pom.xml
└── README.md

⸻

## 🚀 Getting Started

Prerequisites
•	Java 21+
•	Maven 3.9+
•	SQL Server databases (configured in application.yml)
•	Git access to the MEMMCOL Apps organization

Run Locally

## Clone the repo

git clone https://github.com/memmcolapps/AccountCreationWithReplication.git

## Navigate to folder

cd AccountCreationWithReplication

## Build and run

mvn spring-boot:run

⸻

## 🤝 Collaboration

•	Create feature branches for all updates:
git checkout -b feature/replication-enhancement
•	Submit pull requests for code review before merging into main.

⸻

## 📜 License

© 2025 MEMMCOL Apps. All rights reserved.
Unauthorized duplication or use of this software is prohibited.
