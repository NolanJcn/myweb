package com.jcn.entity;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MyAdmin {

    @NonNull
    private Integer id;
    @NonNull
    private String loginAcct;
    @NonNull
    private String loginPass;
    @NonNull
    private String userName;
    @NonNull
    private String email;
    @NonNull
    private String createTime;

}

