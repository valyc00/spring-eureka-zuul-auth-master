# spring-eureka-zuul-auth

This projects built to develop rest api based service with authentication
Contains of :
- Eureka Server : As a service registry, and give names to IP address of each service so that no need to hardcode the IP Address
- Zuul Gateway : Act as an Eureka client, and as a proxy or gateway to handle multiple service with different ports. 
				It can maps each service entities only with its prefix that is already registered on Eureka
- Auth Service : Act as an Eureka Client, mostly used to register user authenticate user, the service has these endpoints :
				- /user/signup : register user
				- /user/detail : get user detail
				- /login : login registered user
- Product Service : Act as an Eureka Client, mostly used to create product and get product detail, the service has these endpoints :
				- /product/create : create product
				- /product/detail/{id} : get product detail by its id
				
				

curl  -i -X POST -H "Content-Type: application/json" \
-d '{"username":"admin","password":"admin"}' \
http://localhost:9100/login


curl  -i -X POST -H "Content-Type: application/json" \
-d '{"username":"admin","password":"admin"}' \
http://localhost:8762/auth/login



TOKEN=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2MDMxODE3MjUsImV4cCI6MTYwMzI2ODEyNX0.4q7WDFkMt6W-vSy7-rVaYH2-9yNMxOSUDZSEi9PWgNRx5qOUIvPYW3H9dJlXICGlRuJxC9VVj3pvWAEjkxQ2gQ
curl -H 'Accept: application/json' -H "Authorization: Bearer ${TOKEN}" http://localhost:8762/test				