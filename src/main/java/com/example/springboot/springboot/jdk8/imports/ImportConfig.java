package com.example.springboot.springboot.jdk8.imports;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(Model1.class)
@Configuration
public class ImportConfig {
}
