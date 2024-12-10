package service;

import mailer.EmailSender;
import util.OtpGenerator;

public class OtpService {

    private String toEmail;
    private String subject;
    private String otpCode;
    private EmailSender emailSender;

    public OtpService() {
        this.otpCode = OtpGenerator.generateOTP(5);
    }

    public void sendOtp(String toEmail, String subject) {
        this.toEmail = toEmail;
        this.subject = subject;
        String emailBody = generateHtmlTemplate(this.otpCode);
        this.emailSender = new EmailSender(this.subject, emailBody, this.toEmail);
        this.emailSender.start();
    }

    private String generateHtmlTemplate(String otpCode) {
        return """
                <html>
                <body style="font-family: Arial, sans-serif; line-height: 1.6; background-color: #f9f9f9; margin: 0; padding: 0;">
                    <div style="max-width: 600px; margin: 20px auto; background: #ffffff; border: 1px solid #ddd; border-radius: 8px; padding: 20px;">
                        <h2 style="text-align: center; color: #4CAF50;">Your OTP Code</h2>
                        <p style="font-size: 16px; color: #333;">
                            Hello,
                        </p>
                        <p style="font-size: 16px; color: #333;">
                            Use the following OTP code to complete your process:
                        </p>
                        <div style="text-align: center; margin: 20px 0;">
                            <span style="font-size: 24px; font-weight: bold; color: #4CAF50;">%s</span>
                        </div>
                        <p style="font-size: 16px; color: #333;">
                            If you did not request this code, please ignore this email.
                        </p>
                        <p style="font-size: 16px; color: #333;">
                            Thank you,<br>
                            JSE-1 Banking
                        </p>
                    </div>
                    <footer style="text-align: center; font-size: 12px; color: #aaa; margin-top: 20px;">
                        &copy; 2024 JSE-1 Banking. All rights reserved.
                    </footer>
                </body>
                </html>
                """.formatted(otpCode);
    }

    public String getOtpCode() {
        return otpCode;
    }

    public void setOtpCode(String otpCode) {
        this.otpCode = otpCode;
    }
}
