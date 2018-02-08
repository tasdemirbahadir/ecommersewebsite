package com.btasdemir.dmall.backoffice.web.controller.redirect;

import org.ocpsoft.rewrite.annotation.Join;

import com.btasdemir.dmall.backoffice.web.controller.CategoryListController;

@Join(path = "/manage/", to = "/category-list.jsf")
public class Redirect2CategoryListController extends CategoryListController {

}
