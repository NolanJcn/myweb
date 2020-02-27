package com.jcn.vo;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ToString
public class LoginVo {

    @NonNull
    private String acct;

    @NonNull
    @Length(min=32)
    private String password;
}
