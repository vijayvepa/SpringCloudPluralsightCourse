# Spring Cloud Consumer

Consumes messages from rabbitmq or kafka

## Dependencies

The following dependencies are used 

```groovy
	compile('org.springframework.boot:spring-boot-starter-actuator')
	compile('org.springframework.cloud:spring-cloud-starter-stream-rabbit')
```

## Annotations

The following annotations are used: 

- `@EnableBinding` with `Sink` class sets it up as a streams application.

- `@StreamListener` with `Sink.INPUT` sets it up as a consumer. This method needs to take a parameter which is the payload type. (Names don't matter.)


```java
@EnableBinding(Sink.class)
public class SpringCloudStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamApplication.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void log(String msg){
		System.out.println(msg);
	}
}

``` 

## Properties

The following properties setup the rabbit connection:

```properties
spring.rabbitmq.host=127.0.0.1
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
```

The following properties setup the queue name.

```properties
spring.cloud.stream.bindings.input.destination=fastpasstoll
```