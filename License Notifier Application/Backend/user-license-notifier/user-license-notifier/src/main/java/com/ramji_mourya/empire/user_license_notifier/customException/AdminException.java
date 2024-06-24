package com.ramji_mourya.empire.user_license_notifier.customException;

public class AdminException extends RuntimeException {
  private final String errorMessage;

    public AdminException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
