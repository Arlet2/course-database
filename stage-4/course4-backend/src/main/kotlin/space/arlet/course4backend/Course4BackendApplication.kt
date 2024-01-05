package space.arlet.course4backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ComponentScans
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
class Course4BackendApplication

fun main(args: Array<String>) {
    runApplication<Course4BackendApplication>(*args)
}