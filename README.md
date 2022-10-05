## Batch Job using Spring Boot

1. Copy this command and paste in terminal (project folder)

> docker-compose up -d

2. Go to Postman and create [POST] request to following URL

> http://localhost:3000/users

Body
```json
{
    "email": "admin@gmail.com",
    "password": "123"
}
```

3. Copy 'accessToken' from response and create new [GET] request in following URL. Go to Authorization tab and select 'Bearer Token' and paste token in input

> http://localhost:3000/load-csv

4. Read all rows from MySQL. Create new [GET] request in following URL and add 'Bearer Token'

> http://localhost:3000/students

5. Stop the server

> docker-compose down