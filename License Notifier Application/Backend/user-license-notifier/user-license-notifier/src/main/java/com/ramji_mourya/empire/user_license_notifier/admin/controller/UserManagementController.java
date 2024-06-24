package com.ramji_mourya.empire.user_license_notifier.admin.controller;

import com.ramji_mourya.empire.user_license_notifier.admin.entity.AdminEntity;
import com.ramji_mourya.empire.user_license_notifier.admin.service.UsersManagementService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "api/v1/adminDetails")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class UserManagementController {

    private final UsersManagementService usersManagementService;
//    private final LicenseService licenseService;
    @PostMapping("/addNewAdmin")
    //http://localhost:1579/api/v1/admin_Details/addNewAdmin
    public ResponseEntity<AdminEntity> registerAdmin(final @RequestBody @Valid AdminEntity adminEntity){
        return ResponseEntity.ok(usersManagementService.registerAdmin(adminEntity));
    }

    //http://localhost:1579/api/v1/admin_Details/adminLogin
    @PostMapping("/adminLogin")
    public ResponseEntity<String> login(final @RequestBody AdminEntity adminEntity)
    {
        usersManagementService.loginAdmin(adminEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//
//    @PostMapping("/auth/refresh")
//    public ResponseEntity<ReqRes> refreshToken(@RequestBody ReqRes req){
//        return ResponseEntity.ok(usersManagementService.refreshToken(req));
//    }

//    @GetMapping("/get-all-users")
//    public ResponseEntity<ReqRes> getAllUsers(){
//        return ResponseEntity.ok(usersManagementService.getAllUsers());
//
//    }

//    @GetMapping("/admin/get-users/{userId}")
//    public ResponseEntity<ReqRes> getUSerByID(@PathVariable Integer userId){
//        return ResponseEntity.ok(usersManagementService.getUsersById(userId));
//
//    }

//    @PutMapping("/admin/update/{userId}")
//    public ResponseEntity<ReqRes> updateUser(@PathVariable Integer userId, @RequestBody OurUsers reqres){
//        return ResponseEntity.ok(usersManagementService.updateUser(userId, reqres));
//    }

//    @GetMapping("/admin_user/get-profile")
//    public ResponseEntity<ReqRes> getMyProfile(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String email = authentication.getName();
//        ReqRes response = usersManagementService.getMyInfo(email);
//        return  ResponseEntity.status(response.getStatusCode()).body(response);
//    }

//    @DeleteMapping("/admin/delete/{userId}")
//    public ResponseEntity<ReqRes> deleteUSer(@PathVariable Integer userId){
//        return ResponseEntity.ok(usersManagementService.deleteUser(userId));
//    }

}
