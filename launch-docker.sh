docker build -t charactergenerator:latest . 

docker run -p 8080:8080 -e MAILGUN_TOKEN=$MAILGUN_TOKEN -e MAILGUN_DOMAIN=$MAILGUN_DOMAIN charactergenerator

 