package com.ramji_mourya.empire.user_license_notifier.admin.service;

import com.ramji_mourya.empire.user_license_notifier.admin.entity.AdminEntity;

public interface AdminService {
    AdminEntity registerAdmin(AdminEntity adminEntity);
    String loginAdmin(AdminEntity adminEntity);
}
