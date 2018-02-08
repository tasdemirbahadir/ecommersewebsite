package com.btasdemir.dmall.backoffice.web.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "loginController")
@ELBeanName(value = "loginController")
@Join(path = "/login", to = "/login.jsf")
public class LoginController {

}
