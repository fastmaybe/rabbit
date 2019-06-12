package com.rabbit.demo.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

public class FastJsonHttpMessageConverterEx extends FastJsonHttpMessageConverter {
    public FastJsonHttpMessageConverterEx(){
        //在这里配置fastjson特性(全局设置的)
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");    //自定义时间格式
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteMapNullValue);  //正常转换null值
        fastJsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect);     //关闭循环引用
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteNullBooleanAsFalse);
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteNullStringAsEmpty);
        this.setFastJsonConfig(fastJsonConfig);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return super.supports(clazz);
    }
}
