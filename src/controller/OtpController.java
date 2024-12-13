package controller;

import model.Employee;
import service.EmployeeConfirmService;
import service.OtpService;
import view.otp.OTPConfirmationForm;

import javax.swing.*;

public class OtpController {
    private OTPConfirmationForm otpConfirmationForm;
    private OtpService otpService;
    private EmployeeConfirmService employeeConfirmService;
    private Employee employee;

    public OtpController(Employee employee){
        this.employee = employee;
        this.otpService = new OtpService();
        this.employeeConfirmService = new EmployeeConfirmService();
        this.otpService.sendOtp(employee.getEmail(), "Employee Account Confirmation");
        this.otpConfirmationForm = new OTPConfirmationForm();
        this.otpConfirmationForm.setConfirmButtonListener(e -> confirmBtnAction());
    }

    public void confirmBtnAction(){
        String otpCode =this.otpConfirmationForm.getOtp();
        if(this.otpService.getOtpCode().equals(otpCode)){
            System.out.println(employee.toString());
            this.employeeConfirmService.confirm(this.employee);
            JOptionPane.showMessageDialog(this.otpConfirmationForm, "Otp Confirmation Successful!!");
            new LoginController();
        }else{
            this.otpConfirmationForm.setMessage("Invalid OTP Code!!!");
        }
    }

}
