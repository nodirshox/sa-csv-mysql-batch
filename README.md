## Batch Job using Spring Boot

### Team members

1. Javokhir Buvanazarov (614693)

2. Nodirbek Ergashev (614644)

### Instruction

1. Copy this command and paste in terminal (project folder)
   ```
   docker-compose up -d
   ```

2. Go to Postman and create [POST] request to following URL
   ```
   http://localhost:3000/api/auth/login
   ```
   Body
   ```
    {
        "email": "admin@gmail.com",
        "password": "123"
    }
   ```

3. Copy 'accessToken' from response and create new [POST] request in following URL. Go to Authorization tab and select 'Bearer Token' and paste token in input
   ```
   http://localhost:3000/api/cron-job/start
   ```

4. Read all rows from MySQL. Create new [GET] request in following URL and add 'Bearer Token'
   ```
   http://localhost:3000/api/cron-job/data
   ```

5. Stop the server
   ```
   docker-compose down
   ```