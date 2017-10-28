package com.shop.serviceImpl;


import com.shop.service.MailSenderService;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by ooo on 6/9/2017.
 */
@Service
public class MailSenderServiceImpl implements MailSenderService {


        private final String EMAIL_FROM = "schmidbohdan@gmail.com";
        private final String EMAIL_PASSWORD = "qwe1324tre";

        @Override
        public void sendMail(String theme, String mailBody, String email) {

            Properties properties = System.getProperties();
            properties.setProperty("mail.smtp.starttls.enable", "true");
            properties.setProperty("mail.smtp.auth", "true");
            properties.setProperty("mail.smtp.port", "465");
            properties.setProperty("mail.smtp.host", "smtp.gmail.com");
            properties.setProperty("mail.smtp.socketFactory.port", "465");
            properties.setProperty("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            Session session = Session.getDefaultInstance(properties,
                    new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(EMAIL_FROM, EMAIL_PASSWORD);
                        }
                    });
            try {
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(EMAIL_FROM));

                message.addRecipient(Message.RecipientType.TO, new InternetAddress(
                        email));
                message.setSubject(theme, "UTF-8");
                String htmlMsg = "<body style=\"-ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; background: #f5f5f5; margin: 0\" bgcolor=\"white\">\n" +
                        "  <style type=\"text/css\">\n" +
                        "    body {\n" +
                        "      background-color: #f5f5f5; margin: 0 !important; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\n" +
                        "      }\n" +
                        "      img {\n" +
                        "      display: block; -ms-interpolation-mode: bicubic; max-width: 100%;\n" +
                        "      }\n" +
                        "      .u-linkClean:hover {\n" +
                        "      text-decoration: none !important;\n" +
                        "      }\n" +
                        "      .u-linkClean:focus {\n" +
                        "      text-decoration: none !important;\n" +
                        "      }\n" +
                        "      .u-linkClean:active {\n" +
                        "      text-decoration: none !important;\n" +
                        "      }\n" +
                        "  </style>\n" +
                        "  <!-- Use a container table for body background colors https://www.campaignmonitor.com/dev-resources/will-it-work/guidelines/\n" +
                        "    -->\n" +
                        "  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                        "    <tr>\n" +
                        "      <td bgcolor=\"#f5f5f5\" width=\"10\"></td>\n" +
                        "      <td align=\"center\" bgcolor=\"#f5f5f5\">\n" +
                        "        <!-- TRUNK CLUB HEADER -->\n" +
                        "        <table align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                        "          <tr>\n" +
                        "            <td align=\"center\" width=\"580\">\n" +
                        "              <h1 style=\"color: #1EFF29\">Welcom to Eco Car Company</h1>\n" +
                        "            </td>\n" +
                        "          </tr>\n" +
                        "        </table>\n" +
                        "        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                        "          <tr class=\"u-hiddenPrint\">\n" +
                        "            <td bgcolor=\"#ffffff\" colspan=\"3\" height=\"40\"></td>\n" +
                        "          </tr>\n" +
                        "          <tr>\n" +
                        "            <td bgcolor=\"#ffffff\" width=\"70\"></td>\n" +
                        "            <td bgcolor=\"#ffffff\" width=\"440\">\n" +
                        "              <div class=\"Text\" style=\"color: #333333; text-align: left\" align=\"left\">\n" +
                        "                <div class=\"Text-body\" style=\"font-family: 'Sentinel SSm A', 'Sentinel SSm B', 'Cambria', 'Georgia', serif; font-size: 14px; font-style: normal; font-weight: 400; line-height: 21px; margin: 21px 0 0\">Hi Really Good Emails,</div>\n" +
                        "                <div class=\"Text-body\" style=\"font-family: 'Sentinel SSm A', 'Sentinel SSm B', 'Cambria', 'Georgia', serif; font-size: 14px; font-style: normal; font-weight: 400; line-height: 21px; margin: 21px 0 0\">I just wanted to remind you that you only have twenty-four hours left to\n" +
                        "                  <span class=\"Link\" style=\"color: #2a80b9; text-decoration: none\">\n" +
                        "                      <a href=\"https://www.trunkclub.com/my/trunk_previews/1571761?utm_campaign=preview_reminder&utm_medium=email&utm_source=trunk_preview\"\n" +
                        "                      style=\"color: #2a80b9; text-decoration: none\">preview and edit</a>\n" +
                        "                      </span>the trunk I sent you before the limited reservation expires.</div>\n" +
                        "                <div class=\"Text-body\" style=\"font-family: 'Sentinel SSm A', 'Sentinel SSm B', 'Cambria', 'Georgia', serif; font-size: 14px; font-style: normal; font-weight: 400; line-height: 21px; margin: 21px 0 0\">You can add the items you want to have shipped (and ignore the ones you don’t). Click “Send Trunk”, and we’ll ship your trunk with only the items you’ve selected.</div>\n" +
                        "                <div class=\"Text-body\" style=\"font-family: 'Sentinel SSm A', 'Sentinel SSm B', 'Cambria', 'Georgia', serif; font-size: 14px; font-style: normal; font-weight: 400; line-height: 21px; margin: 21px 0 0\">Thanks!</div>\n" +
                        "                <div class=\"Text-body\" style=\"font-family: 'Sentinel SSm A', 'Sentinel SSm B', 'Cambria', 'Georgia', serif; font-size: 14px; font-style: normal; font-weight: 400; line-height: 21px; margin: 21px 0 0\">Kenneth</div>\n" +
                        "              </div>\n" +
                        "              <hr class=\"Rule Rule--horizontal\" style=\"background: transparent; border: 1px solid #f4f4f4; height: 0; margin: 15px 0; overflow: hidden; width: 100%\">\n" +
                        "              <div class=\"Text Text--center\" style=\"color: #333333; text-align: center\" align=\"center\">\n" +
                        "                <a class=\"Button\" href=\"http://localhost:8080/\" style=\"background: #1EFF29; border-radius: 4px; color: white; display: inline-block; font-family: 'HelveticaNeue', 'Helvetica Neue', 'Helvetica', 'Helvetica', 'Helvetica', 'Arial', sans-serif; font-size: 11px; font-weight: 400; letter-spacing: 0.2em; line-height: 12px; margin: 12px auto; min-width: 10em; padding: 13px 12px 11px; text-align: center; text-decoration: none; text-transform: uppercase\">Home</a>\n" +
                        "              </div>\n" +
                        "            </td>\n" +
                        "            <td bgcolor=\"#ffffff\" width=\"70\"></td>\n" +
                        "          </tr>\n" +
                        "          <tr>\n" +
                        "            <td bgcolor=\"#ffffff\" colspan=\"3\" height=\"40\"></td>\n" +
                        "          </tr>\n" +
                        "        </table>\n" +
                        "        <!-- TRUNK CLUB FOOTER -->\n" +
                        "        <table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"u-hiddenPrint\">\n" +
                        "          <tr>\n" +
                        "            <td align=\"center\" width=\"580\">\n" +
                        "              <div class=\"Footer\" style=\"margin: 30px 0\">\n" +
                        "                <div class=\"Footer-p\" style=\"color: #707070; font-family: 'HelveticaNeue', 'Helvetica Neue', 'Helvetica', 'Helvetica', 'Helvetica', 'Arial', sans-serif; font-size: 11px; letter-spacing: 0.025em; line-height: 16px; margin: 0 0 9px; text-align: center\"\n" +
                        "                  align=\"center\">© 2016 Trunk Club. All rights reserved.\n" +
                        "                  <br> <span class=\"Link Link--lightGrey\" style=\"color: #707070; text-decoration: none\">325 W Ohio St, Chicago, IL 60654</span>\n" +
                        "\n" +
                        "                </div>\n" +
                        "                <div class=\"Footer-p\" style=\"color: #707070; font-family: 'HelveticaNeue', 'Helvetica Neue', 'Helvetica', 'Helvetica', 'Helvetica', 'Arial', sans-serif; font-size: 11px; letter-spacing: 0.025em; line-height: 16px; margin: 0 0 9px; text-align: center\"\n" +
                        "                  align=\"center\"> <span class=\"Link Link--lightGrey\" style=\"color: #707070; text-decoration: none\">\n" +
                        "                      <a href=\"mailto:service@trunkclub.com\" style=\"color: #707070; text-decoration: none\">service@trunkclub.com</a>\n" +
                        "                    </span>\n" +
                        "\n" +
                        "                  <br> <span class=\"Link Link--lightGrey\" style=\"color: #707070; text-decoration: none\">800‑385‑0100</span>\n" +
                        "\n" +
                        "                </div>\n" +
                        "                <div class=\"Footer-p\" style=\"color: #707070; font-family: 'HelveticaNeue', 'Helvetica Neue', 'Helvetica', 'Helvetica', 'Helvetica', 'Arial', sans-serif; font-size: 11px; letter-spacing: 0.025em; line-height: 16px; margin: 0 0 9px; text-align: center\"\n" +
                        "                  align=\"center\">\n" +
                        "                  <a href=\"\" title=\"Trunk Club\">\n" +
                        "                    <img alt=\"TC\" border=\"0\" class=\"Footer-monogram\" height=\"30\" src=\"https://res.cloudinary.com/trunk-club/image/upload/e_colorize,co_rgb:cccccc,f_auto/design_kit/tc-monogram-s.png\" width=\"30\" style=\"-ms-interpolation-mode: bicubic; display: inline-block; max-width: 100%\">\n" +
                        "                  </a>\n" +
                        "                </div>\n" +
                        "              </div>\n" +
                        "            </td>\n" +
                        "          </tr>\n" +
                        "        </table>\n" +
                        "      </td>\n" +
                        "      <td bgcolor=\"#f5f5f5\" width=\"10\"></td>\n" +
                        "    </tr>\n" +
                        "  </table>\n" +
                        "</body>" + mailBody ;
                message.setContent(htmlMsg, "text/html");
                synchronized (this) {
                    Transport.send(message);
                }
            } catch (MessagingException mex) {
                mex.printStackTrace();
                System.out.println("You have some problems with connection!");
            }


        }
}
