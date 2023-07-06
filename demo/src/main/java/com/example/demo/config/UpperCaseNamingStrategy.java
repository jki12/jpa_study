package com.example.demo.config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

public class UpperCaseNamingStrategy extends PhysicalNamingStrategyStandardImpl {

    protected Identifier getIdentifier(String name, boolean quoted, JdbcEnvironment jdbcEnvironment) {
        return new Identifier(name.toUpperCase(), quoted); // 파라미터로 넘어온 name값을 대문자화 시킵니다.
    }
}
