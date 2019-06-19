package br.com.ufpe.course

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver
import java.util.Locale.US

@SpringBootApplication
class CourseApplication

	fun main(args: Array<String>) {
		runApplication<CourseApplication>(*args)
	}

	@Bean
	fun localeResolver() = AcceptHeaderLocaleResolver()
		.also { it.defaultLocale = US }