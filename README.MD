# Kafka Stream Demo
### Installation
* Install zookeeper and kafka:
    * `docker-compose -f docker-compose.yml up -d`
* Subscribe 3 topics: _student-admission_,_student-class_,_log_:
    * Open 3 terminals for each topic
    * `docker exec -it kafka /bin/bash`
    * `cd /opt/kafka/bin`
    * `./kafka-console-consumer.sh --topic TOPIC_NAME_HERE --bootstrap-server localhost:9092`
* Run project and input data and see how kafka work

### Stop docker
* docker-compose down

### Let explore kafka
* _https://kafka.apache.org/_