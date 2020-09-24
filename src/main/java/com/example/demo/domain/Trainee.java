package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name= "trainee")
public class Trainee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "名字不能为空")
    private String name;

    @NotEmpty(message = "办公室不能为空")
    private String office;

    @NotEmpty(message = "邮箱不能为空")
    @Email(message = "邮箱地址不合法")
    private String email;

    @NotEmpty(message = "github用户名不能为空")
    private String github;

    @NotEmpty(message = "zoomId不能为空")
    private String zoomId;

    @JsonIgnore
    @Builder.Default
    private boolean grouped = false;

}
