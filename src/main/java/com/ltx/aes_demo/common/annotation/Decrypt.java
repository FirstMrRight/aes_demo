package com.ltx.aes_demo.common.annotation;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * @author Liu-PC
 */

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Mapping
@Documented
public @interface Decrypt {

    /**
     * 出参是否加密，默认加密
     * @return
     */
    boolean test() default true;
}
