package org.activiti.springdatajpa

import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
import static com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT

@SpringBootApplication
class ActivitiSpringDataJpaApplication extends WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter {

    static void main(String[] args) {
        SpringApplication.run ActivitiSpringDataJpaApplication, args
    }

    @Bean
    public javax.validation.Validator localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    ObjectMapper objectMapper() {
        new ObjectMapper()
                .enableDefaultTyping(JAVA_LANG_OBJECT, JsonTypeInfo.As.PROPERTY)
                .configure(FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(new Hibernate4Module()
                    .enable(Hibernate4Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS)
                    .disable(Hibernate4Module.Feature.USE_TRANSIENT_ANNOTATION))
//                .registerModule(new SimpleModule("TaskEntitySerializer", new Version(1,0,0,null)).addSerializer(new JsonSerializer<TaskEntity>() {
//            @Override
//            void serialize(TaskEntity value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
//                gen.writeStartObject()
//
//                BeanUtils.getPropertyDescriptors(TaskEntity).each { pd ->
//                    if(pd.getReadMethod() != null) {
//                        gen.writeFieldName(pd.name)
//                        try {
//                            gen.writeObject(pd.getReadMethod().invoke(value))
//                        } catch (Exception e) {
//                            gen.writeNull()
//                        }
//                    }
//                }
//
//                gen.writeEndObject()
//            }
//
//            @Override
//            Class<TaskEntity> handledType() {
//                TaskEntity
//            }
//        }))
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters)
        converters.add(new MappingJackson2HttpMessageConverter(objectMapper()));
    }
}
