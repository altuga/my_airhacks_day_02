# Build
mvn clean package && docker build -t com.airhacks/restclient .

# RUN

docker rm -f restclient || true && docker run -d -p 8080:8080 -p 4848:4848 --name restclient com.airhacks/restclient 