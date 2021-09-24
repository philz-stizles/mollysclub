package com.devdezyn.mollysclub.shared.utils;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;
}
