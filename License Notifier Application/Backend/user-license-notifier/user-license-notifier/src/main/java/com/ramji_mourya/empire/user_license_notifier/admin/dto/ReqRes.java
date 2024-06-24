package com.ramji_mourya.empire.user_license_notifier.admin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ramji_mourya.empire.user_license_notifier.admin.entity.AdminEntity;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqRes {

    private int statusCode;
    private String error;
    private String message;
//    private String token;
//    private String refreshToken;
//    private String expirationTime;
    private String user_Name;
    private String city;
    private String role;
    private String email_Address;
    private String password;
    private AdminEntity adminEntity;
    private List<AdminEntity> adminEntityList;

}
