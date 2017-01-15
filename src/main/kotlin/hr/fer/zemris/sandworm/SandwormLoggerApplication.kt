package hr.fer.zemris.sandworm

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters

@SpringBootApplication
@EntityScan(
        basePackageClasses = arrayOf(
                SandwormLoggerApplication::class,
                Jsr310JpaConverters::class
        )
)
open class SandwormLoggerApplication

fun main(args: Array<String>) {
    SpringApplication.run(SandwormLoggerApplication::class.java, *args)
}
