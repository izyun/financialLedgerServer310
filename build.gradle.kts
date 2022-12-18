plugins {
	java
	war
	id("org.springframework.boot") version "3.0.0"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	//HTML과 JAVA 연동하는 view 템플릿엔진
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	//자바 언어로 만들어진 웹서비스
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	//getter, setter, 생성자 등 많이 쓰는 코드를 단축시켜주는 어노테이션 모음
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	//tomcat
	providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
	implementation ("org.apache.tomcat.embed:tomcat-embed-jasper")
	implementation("javax.servlet:jstl:1.2")
	//JSON 포맷으로 데이터 받고, 전달하기
	implementation("org.json:json:20190722")
	//DB 연동
	implementation("mysql:mysql-connector-java")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")


}

tasks.withType<Test> {
	useJUnitPlatform()
}
