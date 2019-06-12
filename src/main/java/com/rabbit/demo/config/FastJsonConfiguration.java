package com.rabbit.demo.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class FastJsonConfiguration implements WebMvcConfigurer {
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        WebMvcConfigurer.super.configureMessageConverters(converters);
//
//        FastJsonHttpMessageConverter converter=new FastJsonHttpMessageConverter();
//
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect,
//                SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.WriteNullBooleanAsFalse);
//
//        converter.setFastJsonConfig(fastJsonConfig);
//        converters.add(converter);
//
//    }

    @Bean
    public FastJsonHttpMessageConverterEx fastJsonHttpMessageConverterEx(){
        return new FastJsonHttpMessageConverterEx();
    }

}
