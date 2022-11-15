package com.zte.config;


import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;

//@Configuration
public class MybatisPlusConfig {

    //@Bean
    public MybatisPlusInterceptor getMybatisPlusInterceptor(){
        PaginationInnerInterceptor innerInterceptor = new PaginationInnerInterceptor();

        MybatisPlusInterceptor interceptors = new MybatisPlusInterceptor();

        interceptors.addInnerInterceptor(innerInterceptor);

        return interceptors;
    }


}
