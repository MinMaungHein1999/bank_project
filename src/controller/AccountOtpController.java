package controller;

import model.Account;
import service.AccountService;
import view.otp.OTPConfirmationForm;

import javax.swing.*;

public class AccountOtpController extends AbstractOtpController{

    private Account accountToConfirm;
    private AccountService accountService;

    public AccountOtpController(Account account){
        super();
        System.out.println( "In AccountOtpController: " +account.getCustomer().getEmail());
        this.accountToConfirm = account;
        this.accountService = new AccountService();
        sendOtpCode();
    }

    @Override
    public void sendOtpCode() {
        super.getOtpService().sendOtp(this.accountToConfirm.getCustomer().getEmail(), "Bank Account Confirmation");
    }

    @Override
    public void confirmBtnAction() {
        if(super.getOtpService().getOtpCode().equals(super.getOtpFromForm())){
            this.accountService.confirmAccount(this.accountToConfirm);
            JOptionPane.showMessageDialog(super.getOtpConfirmationForm(), "Otp Confirmation Successful!!");
        }else{
            super.getOtpConfirmationForm().setMessage("Invalid OTP Code!!!");
        }
    }
}
