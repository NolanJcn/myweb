package com.jcn.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PicType {

    @NonNull
    private Integer typeId;

    @NonNull
    private String typeName;

    @NonNull
    private Integer sortId;
}
