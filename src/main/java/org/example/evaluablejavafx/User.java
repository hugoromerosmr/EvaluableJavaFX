package org.example.evaluablejavafx;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
@AllArgsConstructor
public class User implements Serializable {
    private String email;
    private String platform;
    private Boolean admin;
    private Long software;

}
