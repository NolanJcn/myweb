package com.jcn.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MyPic {

    @NonNull
    private Integer picId;

    @NonNull
    private String picName;

    @NonNull
    private String picUrl;

    @NonNull
    private Integer typeId;

}
