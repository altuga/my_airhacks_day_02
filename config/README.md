# Build
mvn clean package && docker build -t com.airhacks/config .

# RUN

docker rm -f config || true && docker run -d -p 8080:8080 -p 4848:4848 --name config com.airhacks/config 