# Simple Spring Security OAuth2

## Run application :

		mvn clean tomcat7:run

## Flow

1. User sends a `GET` request to server with five parameters: `grant_type`,  `username`, `password`, `client_id`, `client_secret` :

		http://localhost:8080/springmvc-rest-oauth2/oauth/token?grant_type=password&client_id=app&client_secret=123456&username=arip&password=passw0rd

2. Server validates the user with help of spring security, and if the user is authenticated, OAuth generates a access token and send sends back to user in following format :
		
		{
			"access_token":"0bf72545-b386-4f75-a5f0-73f7f3d2c11e",
			"token_type":"bearer",
			"refresh_token":"36e924a8-3bbd-4fff-84c1-295cc5851619",
			"expires_in":99,
			"scope":" trust  write read"
		}

3. Access protected resources by passing this access token as a parameter:

		http://localhost:8080/springmvc-rest-oauth2/api/user?access_token=0bf72545-b386-4f75-a5f0-73f7f3d2c11e

4. If the token is not expired and is a valid token, the requested resources will be returned :

		[{
			"id":"10108665","name":"Arip Hidayat",
			"username":"arip",
			"email":"ariphidayat@hotmail.com",
			"address":"Karet Karya 1 Setiabudi"
		}]

5. In case the token is expired, user needs to get a new token using its refreshing token that was accepted in step(2). A new access token request after expiration looks something like this :

		http://localhost:8080/springmvc-rest-oauth2/oauth/token?grant_type=refresh_token&client_id=app&client_secret=123456&refresh_token=36e924a8-3bbd-4fff-84c1-295cc5851619

6. If the refresh token success will be return new access and refresh token :

		{
			"access_token":"2a4e43df-0cdf-4966-91b3-7e3b44e5945c",
			"token_type":"bearer",
			"refresh_token":"36e924a8-3bbd-4fff-84c1-295cc5851619",
			"expires_in":99,
			"scope":" trust  write read"
		}



## P.S.


You can access protected resources by passing token by header parameter as `Authorization`. for example :

	curl -H "Authorization: Bearer 0bf72545-b386-4f75-a5f0-73f7f3d2c11e" http://localhost:8080/springmvc-rest-oauth2/api/user