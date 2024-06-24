package com.ramji_mourya.empire.user_license_notifier.admin.service;

import com.ramji_mourya.empire.user_license_notifier.admin.entity.AdminEntity;
import com.ramji_mourya.empire.user_license_notifier.admin.repository.UsersRepo;
import com.ramji_mourya.empire.user_license_notifier.customException.AdminException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class UsersManagementService implements AdminService {

    private final static Logger LOGGER = Logger.getLogger(UsersManagementService.class.getName());

    private final UsersRepo usersRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AdminEntity registerAdmin(AdminEntity registrationRequest) {
        AdminEntity adminEntity = new AdminEntity();
        try {
            adminEntity.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            usersRepo.save(adminEntity);
        } catch (AdminException adminException) {
            LOGGER.config("User Already exist ! Try with different one!");
        }
        return adminEntity;
    }

    @Override
    public String loginAdmin(AdminEntity adminEntity) {
        AdminEntity adminEntity1 = usersRepo.findByEmail(adminEntity.getEmail()).orElseThrow();
        String response = null;
        if (Objects.equals(adminEntity1.getUser_name(), adminEntity.getUser_name()) && Objects.equals(adminEntity1.getPassword(), adminEntity.getPassword())) {
            response = "Admin Logged in Successfully";
        }
        return response;
    }


//    public ReqRes getAllUsers() {
//        ReqRes reqRes = new ReqRes();
//
//        try {
//            List<OurUsers> result = usersRepo.findAll();
//            if (!result.isEmpty()) {
//                reqRes.setOurUsersList(result);
//                reqRes.setStatusCode(200);
//                reqRes.setMessage("Successful");
//            } else {
//                reqRes.setStatusCode(404);
//                reqRes.setMessage("No users found");
//            }
//            return reqRes;
//        } catch (Exception e) {
//            reqRes.setStatusCode(500);
//            reqRes.setMessage("Error occurred: " + e.getMessage());
//            return reqRes;
//        }
//    }


//    public ReqRes getUsersById(Integer id) {
//        ReqRes reqRes = new ReqRes();
//        try {
//            OurUsers usersById = usersRepo.findById(id).orElseThrow(() -> new RuntimeException("User Not found"));
//            reqRes.setOurUsers(usersById);
//            reqRes.setStatusCode(200);
//            reqRes.setMessage("Users with id '" + id + "' found successfully");
//        } catch (Exception e) {
//            reqRes.setStatusCode(500);
//            reqRes.setMessage("Error occurred: " + e.getMessage());
//        }
//        return reqRes;
//    }


//    public ReqRes deleteUser(Integer userId) {
//        ReqRes reqRes = new ReqRes();
//        try {
//            Optional<OurUsers> userOptional = usersRepo.findById(userId);
//            if (userOptional.isPresent()) {
//                usersRepo.deleteById(userId);
//                reqRes.setStatusCode(200);
//                reqRes.setMessage("User deleted successfully");
//            } else {
//                reqRes.setStatusCode(404);
//                reqRes.setMessage("User not found for deletion");
//            }
//        } catch (Exception e) {
//            reqRes.setStatusCode(500);
//            reqRes.setMessage("Error occurred while deleting user: " + e.getMessage());
//        }
//        return reqRes;
//    }

//    public ReqRes updateUser(Integer userId, OurUsers updatedUser) {
//        ReqRes reqRes = new ReqRes();
//        try {
//            Optional<OurUsers> userOptional = usersRepo.findById(userId);
//            if (userOptional.isPresent()) {
//                OurUsers existingUser = userOptional.get();
//                existingUser.setEmail(updatedUser.getEmail());
//                existingUser.setUserName(updatedUser.getUserName());
//                existingUser.setCity(updatedUser.getCity());
//                existingUser.setRole(updatedUser.getRole());
//
//                // Check if password is present in the request
//                if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
//                    // Encode the password and update it
//                    existingUser.setPassword(updatedUser.getPassword());
//                }
//
//                OurUsers savedUser = usersRepo.save(existingUser);
//                reqRes.setOurUsers(savedUser);
//                reqRes.setStatusCode(200);
//                reqRes.setMessage("User updated successfully");
//            } else {
//                reqRes.setStatusCode(404);
//                reqRes.setMessage("User not found for update");
//            }
//        } catch (Exception e) {
//            reqRes.setStatusCode(500);
//            reqRes.setMessage("Error occurred while updating user: " + e.getMessage());
//        }
//        return reqRes;
//    }


//    public ReqRes getMyInfo(String email){
//        ReqRes reqRes = new ReqRes();
//        try {
//            Optional<OurUsers> userOptional = usersRepo.findByEmail(email);
//            if (userOptional.isPresent()) {
//                reqRes.setOurUsers(userOptional.get());
//                reqRes.setStatusCode(200);
//                reqRes.setMessage("successful");
//            } else {
//                reqRes.setStatusCode(404);
//                reqRes.setMessage("User not found for update");
//            }
//
//        }catch (Exception e){
//            reqRes.setStatusCode(500);
//            reqRes.setMessage("Error occurred while getting user info: " + e.getMessage());
//        }
//        return reqRes;
//
//    }
}
