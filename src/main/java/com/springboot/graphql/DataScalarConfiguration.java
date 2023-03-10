package com.springboot.graphql;

import graphql.language.StringValue;
import graphql.schema.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import graphql.Internal;
import graphql.language.StringValue;
import graphql.language.Value;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;

import java.time.DateTimeException;

@Configuration
public class DataScalarConfiguration {

    @Bean
    public GraphQLScalarType dateScalar() {
        return GraphQLScalarType.newScalar()
                .name("Date")
                .description("Java 8 LocalDateTime as Scalar")
                .coercing(new Coercing<LocalDate, String>() {
                    @Override
                    public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
                        if (dataFetcherResult instanceof Timestamp) return dataFetcherResult.toString();
                        else throw new CoercingSerializeException("Expected a Timestamp object.");
                    }

                    @Override
                    public LocalDate parseValue(Object input) throws CoercingParseValueException {
                        try {
                            if (input instanceof String) return LocalDate.parse((String) input, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                            else throw new CoercingParseValueException("Expected a String");
                        } catch (DateTimeParseException e) {
                            throw new CoercingParseValueException(String.format("Not a valid date: %s", input), e);
                        }
                    }

                    @Override
                    public LocalDate parseLiteral(Object input) throws CoercingParseLiteralException {
                        if (input instanceof StringValue) {
                            try {
                                return LocalDate.parse(((StringValue) input).getValue());
                            } catch (DateTimeParseException e) {
                                throw new CoercingParseLiteralException();
                            }
                        } else throw new CoercingParseLiteralException("Expected a StringValue");
                    }
                }).build();
    }

}