package com.shop.service;

/**
 * Created by ooo on 6/9/2017.
 */
public interface MailSenderService  {

    void sendMail(String theme, String mailBody, String email);

}
