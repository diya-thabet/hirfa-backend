# Freelancing App for Handy Jobs

---

## Description

This is a backend API for a freelancing platform. It focuses on handy jobs like plumbing, electrical work, and cooking. The platform connects freelancers offering services with users needing jobs done.

---

## Technologies

* **Spring Boot**
* **MySQL** (using XAMPP)
* **JWT Authentication**
* Lombok
* Spring Security
* Spring Data JPA

---

## Installation

### Prerequisites

* Java 17+
* Maven
* MySQL (XAMPP recommended)
* IDE (IntelliJ or Eclipse)

### Setup Steps

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/diya-thabet/khatwa.git
    ```

2.  **Set up MySQL:**
    * Create a database named `freelance_db`.
    * Update your `application.properties` file with your MySQL credentials.

3.  **Build the project:**
    ```bash
    mvn clean install
    ```

4.  **Run the application:**
    ```bash
    mvn spring-boot:run
    ```

---

## Usage

The API runs at `http://localhost:8080`.

### Key Endpoints

* `/auth/signup`: Register as a **USER** or **FREELANCER**.
* `/auth/login`: Get your **JWT token**.
* `/admin/users`: List all users (admin access).
* `/user/job-requests`: Manage job requests (for users).
* `/freelancer/job-offers`: Manage job offers (for freelancers).
* `/user/reviews`: Manage reviews (for users).

For more details, refer to `API.md` or `/swagger-ui.html` (if enabled).

---

## API Documentation

Detailed API documentation is available in `API.md`. You can also access it via `/swagger-ui.html` if Swagger UI is enabled.

---

## Contributing

We welcome contributions!

1.  Fork the repository.
2.  Create a new feature branch.
3.  Commit your changes.
4.  Push your branch.
5.  Submit a pull request.

Please see `CONTRIBUTING.md` for more guidelines.

---

## License

This project is licensed under the **MIT License**. See the `LICENSE` file for details.

---

## Contact

* Email: email@example.com
* GitHub: [Open an issue](https://github.com/diya-thabet/khatwa.git)

---

## Frontend

This API serves as the backend for the following applications:

* [Mobile App](link-to-mobile-app-repo)
* [Web App](link-to-web-app-repo)
