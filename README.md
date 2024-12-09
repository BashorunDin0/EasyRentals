Online Property Rental System
An advanced and user-friendly platform that connects property owners and tenants. The system simplifies property rentals with a focus on security, efficiency, and accessibility.

Features
1. User Roles
Admin: Manage users, properties, and oversee system activities.
Owner: Register properties, manage listings, and interact with tenants.
Tenant: Search and rent properties, manage rental agreements, and communicate with owners.
2. Core Functionalities
User Registration and Authentication:

Secure login and registration using JWT (JSON Web Tokens).
Role-based access control (RBAC).
Property Management:

Owners can list, update, and remove properties.
Tenants can browse and filter properties by location, price, or other criteria.
Search and Filter:

Advanced property search with customizable filters.
3. Admin Features
Manage users and roles.
Monitor system activity and reports.
Handle disputes and issues.
Tools and Technologies
Backend
Java: Core programming language.
Spring Boot: Framework for rapid and secure development.
Spring Security: Manages authentication and authorization.
Hibernate: ORM for database interactions.
Database
PostgreSQL: Persist application data.
Other Tools
JWT: Secure token-based authentication.
Lombok: Reduces boilerplate code.
Maven: Dependency management.
Installation
1. Clone the Repository
bash
Copy code
git clone https://github.com/BashorunDin0/EasyRentals.git
cd EasyRentals
2. Configure the Database
Update application.yml or use environment variables:

yaml
Copy code
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/easyrentals
    username: <postgres>
    password: <jarule>
3. Run the Application
bash
Copy code
mvn spring-boot:run
API Endpoints
Authentication
POST /auth/register - Register a new user.
POST /auth/login - Authenticate a user and retrieve a token.
Admin
GET /api/admin/users - View all users.
Owner
POST /api/owners/register - Register as an owner.
POST /api/properties - Add a new property.
Tenant
GET /api/properties - Browse available properties.
(Add other endpoints as needed.)

Contributing
Contributions are welcome!

Fork the repository.
Create a new branch (git checkout -b feature-name).
Commit changes (git commit -m 'Add some feature').
Push to the branch (git push origin feature-name).
Open a pull request.
License
This project is licensed under the FLEXISAF License.

Contact
Author: [Yusuff Ibrahim Olawale]
Email: [ibrahimolawale02@gmail.com]
LinkedIn: [www.linkedin.com/in/yusuffibrahimolawale]
