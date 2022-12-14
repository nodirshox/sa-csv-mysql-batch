## Batch Job using Spring Boot

### Team members

1. Javokhir Buvanazarov (614693)

2. Nodirbek Ergashev (614644)

### Instruction

1. Copy this command and paste in terminal (project folder)
   ```
   docker-compose up -d
   ```

2. Wait 20-30 seconds until server up. 

3. Go to Postman and create [POST] request to following URL
   ```
   http://localhost:3000/api/auth/login
   ```
   Body (raw -> JSON)
   ```
    {
        "email": "admin@gmail.com",
        "password": "123"
    }
   ```

4. Copy 'accessToken' from response and create [POST] request in following URL. Go to Authorization tab and select 'Bearer Token' and paste token in input
   ```
   http://localhost:3000/api/cron-job/start
   ```

5. Read all rows from MySQL. Create [GET] request in following URL and add token into 'Bearer Token'
   ```
   http://localhost:3000/api/cron-job/data
   ```

6. Stop the server
   ```
   docker-compose down
   ```