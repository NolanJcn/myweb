package com.jcn.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PicSort {

    @NonNull
    private Integer sortId;

    @NonNull
    private String sortName;
}
