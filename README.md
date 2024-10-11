# Assignment-Submission-Portal

A backend system for an assignment submission portal. The system should support users and admins where:

- **Users** can upload assignments.
    - Assignments in this case can just be an object like below
        
- **Admins** can accept or reject these assignments.
    - Admin can see all assignments tagged to them
    - Admins will see each the user name, task and timedate data
    - Admin can either reject or accept them

## Technologies Used
- Java 17
- Spring Boot
- MongoDB
- Spring Data MongoDB

## Installation Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/assignment-portal-backend.git
   ```

2. Navigate to the project directory:
   ```bash
   cd assignment-portal-backend
   ```

3. Install the necessary dependencies using Maven or Gradle:
   ```bash
   ./mvnw install
   ```

4. Set up your MongoDB Atlas cluster and add the connection string in `src/main/resources/application.properties`:
   ```properties
   spring.data.mongodb.uri=mongodb+srv://<username>:<password>@<cluster-url>/<db-name>?retryWrites=true&w=majority
   ```

5. Run the project:
   ```bash
   ./mvnw spring-boot:run
   ```

6. Access the API at `http://localhost:8080`.

### Environment Variables:
- `MONGO_URI` 


## API Documentation

### User APIs

### 1.Register a new user
- **URL**: `user/register`
- **Method**: `POST`
- **Request Body**:
  ```json
  {
    "id": "string",
    "username": "string",
    "password": "string"
  }
  ```
### 2. Login User
- **URL**: `user/login`
- **Method**: `POST`
- **Request Body**:
  ```json
  {
    "id": "string",
    "username": "string",
    "password": "string"
  }
  ```
### 3.  Upload an assignment.
- **URL**: `user/upload`
- **Method**: `POST`
- **Request Body**:
  ```json
  {
    "id" : "string",
    "userId" : "string",
    "task" : "string",
    "adminId" : "string"
  }
  ```
### 4. Get all admins
- **URL**: `user/admins`
- **Method**: `GET`


### Admin APIs

### 1.Register a new admin
- **URL**: `admin/register`
- **Method**: `POST`
- **Request Body**:
  ```json
  {
    "id": "string",
    "username": "string",
    "password": "string"
  }
  ```
### 2. Login Admin
- **URL**: `admin/login`
- **Method**: `POST`
- **Request Body**:
  ```json
  {
    "id": "string",
    "username": "string",
    "password": "string"
  }
  ```
### 3. View assignments tagged to the admin.
- **URL**: ` /admin/assignments?adminId={id}`
- **Method**: `GET`

### 4. Accept an assignment.
- **URL**: `/admin/assignments/{id}/accept`
- **Method**: `POST`

### 5. Reject an assignment.
- **URL**: `/admin/assignments/{id}/reject`
- **Method**: `POST`


## Database Schema

### Users Collection:
- `id`: String(PK)
- `username`: String 
- `password`: String (hashed)
- `isAdmin`: Boolean 

### Assignments Collection:
- `id`: String
- `userId`: String
- `task`: String
- `adminId`: String
- `status`: String(e.g.," Accepted", "Rejected","Pending")
- `submissionTime`: LocalDateTime

