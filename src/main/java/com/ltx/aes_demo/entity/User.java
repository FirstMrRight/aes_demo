package com.ltx.aes_demo.entity;

import lombok.*;

/**
 * @author Liutx
 * @date 2021/1/3 11:16
 * @Description
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String userName;

    private Integer age;

    private String sex;
}
