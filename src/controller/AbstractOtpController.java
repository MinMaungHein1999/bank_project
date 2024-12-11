package controller;

import model.Employee;
import service.EmployeeConfirmService;
import service.OtpService;
import view.otp.OTPConfirmationForm;

import javax.swing.*;

public abstract class AbstractOtpController {
    private OTPConfirmationForm otpConfirmationForm;
    private OtpService otpService;

    public AbstractOtpController() {
        this.otpService = new OtpService();
        this.otpConfirmationForm = new OTPConfirmationForm();
        this.otpConfirmationForm.setConfirmButtonListener(e -> confirmBtnAction());
    }

    protected String getOtpFromForm() {
        return this.otpConfirmationForm.getOtp();
    }

    protected OtpService getOtpService() {
        return otpService;
    }

    protected OTPConfirmationForm getOtpConfirmationForm() {
        return this.otpConfirmationForm;
    }


    public abstract void sendOtpCode();

    public abstract void confirmBtnAction();
}
