package cstk.chisato.pojo;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {

    private Integer userId;

    private String username;

    private String password;

    /**
     * 状态
     * 0：正常
     * 1：禁用
     * 2：锁定
     * 3：过期
     */
    private Character state;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
