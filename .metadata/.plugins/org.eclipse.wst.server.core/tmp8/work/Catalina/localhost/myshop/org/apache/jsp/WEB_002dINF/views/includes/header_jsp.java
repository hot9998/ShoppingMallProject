/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.31
 * Generated at: 2020-05-20 15:17:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.includes;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/WEB-INF/lib/spring-security-taglibs-5.0.7.RELEASE.jar", Long.valueOf(1585576883816L));
    _jspx_dependants.put("jar:file:/E:/programming/Spring/ShoppingMallProject/.metadata/.plugins/org.eclipse.wst.server.core/tmp8/wtpwebapps/MyShop/WEB-INF/lib/spring-security-taglibs-5.0.7.RELEASE.jar!/META-INF/security.tld", Long.valueOf(1532606274000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1584130702153L));
    _jspx_dependants.put("jar:file:/E:/programming/Spring/ShoppingMallProject/.metadata/.plugins/org.eclipse.wst.server.core/tmp8/wtpwebapps/MyShop/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsec_005fauthentication_0026_005fproperty_005fnobody;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsec_005fauthentication_0026_005fproperty_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.release();
    _005fjspx_005ftagPool_005fsec_005fauthentication_0026_005fproperty_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<!-- Bootstrap core CSS -->\r\n");
      out.write("<link href=\"/myshop/resources/vendor/bootstrap/css/bootstrap.min.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("<!-- Custom styles for this template -->\r\n");
      out.write("<link href=\"/myshop/resources/css/shop-homepage.css\" rel=\"stylesheet\">\r\n");
      out.write("<!-- Bootstrap core JavaScript -->\r\n");
      out.write("<script src=\"/myshop/resources/vendor/jquery/jquery.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"/myshop/resources/vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js\"></script>\r\n");
      out.write("<script src=\"/myshop/resources/js/member.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js\"\r\n");
      out.write("\tcrossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- Navigation -->\r\n");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark fixed-top\">\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<a class=\"navbar-brand\" href=\"/myshop\">Myshop</a>\r\n");
      out.write("\t\t<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\"\r\n");
      out.write("\t\t\tdata-target=\"#navbarResponsive\" aria-controls=\"navbarResponsive\"\r\n");
      out.write("\t\t\taria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("\t\t\t<span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("\t\t</button>\r\n");
      out.write("\t\t<div class=\"collapse navbar-collapse\" id=\"navbarResponsive\">\r\n");
      out.write("\t\t\t<ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" href=\"/myshop\"><i\r\n");
      out.write("\t\t\t\t\t\tclass=\"fas fa-home\"></i> 홈 </a></li>\r\n");
      out.write("\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\"\r\n");
      out.write("\t\t\t\t\thref=\"/myshop/board/list\"><i class=\"fas fa-align-justify\"></i>\r\n");
      out.write("\t\t\t\t\t\t게시판</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" href=\"/myshop/map\"><i\r\n");
      out.write("\t\t\t\t\t\tclass=\"fa fa-map\"></i>` 지도</a></li>\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_sec_005fauthorize_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_sec_005fauthorize_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</nav>\r\n");
      out.write("<!-- #joinModal -->\r\n");
      out.write("<div class=\"modal fade\" id=\"joinModal\" tabindex=\"-1\" role=\"dialog\"\r\n");
      out.write("\taria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("\t<div class=\"modal-dialog\">\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t<div\r\n");
      out.write("\t\t\t\tclass=\"modal-header justify-content-center font-weight-light my-4\">\r\n");
      out.write("\t\t\t\t<h3 class=\"modal-title\" id=\"myModalLabel\">회원가입</h3>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t<form id=\"joinForm\" action=\"/myshop/user/join\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.parameterName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.token }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"> <input type=\"hidden\" name=\"addr\"\r\n");
      out.write("\t\t\t\t\t\tid=\"addr\"> <input type=\"hidden\" name=\"idcheck\"\r\n");
      out.write("\t\t\t\t\t\tid=\"idcheck\" value=\"0\">\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"small mb-1\" for=\"joinid\">ID</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<input class=\"form-control input-group-prepend joinInput\"\r\n");
      out.write("\t\t\t\t\t\t\t\tname=\"userid\" id=\"joinid\" type=\"text\" placeholder=\"아이디를 입력하세요\" />\r\n");
      out.write("\t\t\t\t\t\t\t<button type=\"button\" id=\"idcheckBtn\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"btn btn-outline-info input-group-append\">중복체크</button>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"small mb-1\" for=\"joinpw\">Password</label> <input\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"form-control joinInput\" name=\"userpw\" id=\"joinpw\"\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"password\" placeholder=\"패스워드를 입력하세요\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"small mb-1\" for=\"userpw\">Password 확인</label> <input\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"form-control joinInput\" id=\"pwdcheck\" type=\"password\"\r\n");
      out.write("\t\t\t\t\t\t\tplaceholder=\"패스워드를 입력하세요\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"small mb-1\" for=\"username\">이름</label> <input\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"form-control joinInput\" name=\"username\" id=\"username\"\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"text\" placeholder=\"이름을 입력하세요\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"small mb-1\" for=\"tel\">휴대전화</label> <input\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"form-control joinInput\" name=\"tel\" id=\"tel\" type=\"tel\"\r\n");
      out.write("\t\t\t\t\t\t\tmaxlength=\"13\" placeholder=\"전화번호를 입력하세요\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"small mb-1\" for=\"email\">이메일</label> <input\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"form-control joinInput\" name=\"email\" id=\"email\"\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"email\" placeholder=\"이메일을 입력하세요\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"small mb-1\">우편번호</label> <input\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"form-control joinInput\" style=\"width: 30%\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\tname=\"zipcode\" id=\"zipcode\" readonly=\"readonly\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"small mb-1\">주소</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<input class=\"form-control input-group-prepend joinInput\"\r\n");
      out.write("\t\t\t\t\t\t\t\ttype=\"text\" id=\"addrView\" readonly=\"readonly\">\r\n");
      out.write("\t\t\t\t\t\t\t<button type=\"button\" id=\"addrBtn\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"btn btn-outline-primary input-group-apeend\">주소\r\n");
      out.write("\t\t\t\t\t\t\t\t검색</button>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"small mb-1\" for=\"addrDetail\">상세주소</label> <input\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"form-control joinInput\" name=\"addrDetail\" id=\"addrDetail\"\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"text\" placeholder=\"상세주소를 입력하세요\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"small mb-1\" for=\"role\">관리자 코드</label> <input\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"form-control joinInput\" name=\"admincode\" id=\"admincode\"\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"text\" placeholder=\"관리자가 되려면 코드를 입력하세요\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group mt-4 mb-0\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary float-right\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"joinBtn\">회원가입</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- /.modal-content -->\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- /.modal-dialog -->\r\n");
      out.write("</div>\r\n");
      out.write("<!-- /#joinModal -->\r\n");
      out.write("<!-- #loginModal -->\r\n");
      out.write("<div class=\"modal fade\" id=\"loginModal\" tabindex=\"-1\" role=\"dialog\"\r\n");
      out.write("\taria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("\t<div class=\"modal-dialog\">\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t<div\r\n");
      out.write("\t\t\t\tclass=\"modal-header justify-content-center font-weight-light my-4\">\r\n");
      out.write("\t\t\t\t<h3 class=\"modal-title\" id=\"myModalLabel\">로그인</h3>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t<form id=\"loginForm\" action=\"/myshop/login\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.parameterName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.token }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"small mb-1\" for=\"userid\">ID</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<input class=\"form-control input-group-prepend\" name=\"username\"\r\n");
      out.write("\t\t\t\t\t\t\t\tid=\"loginid\" type=\"text\" placeholder=\"아이디를 입력하세요\" />\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"small mb-1\" for=\"userpw\">Password</label> <input\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"form-control\" name=\"password\" id=\"loginpw\" type=\"password\"\r\n");
      out.write("\t\t\t\t\t\t\tplaceholder=\"패스워드를 입력하세요\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"custom-control custom-checkbox\">\r\n");
      out.write("\t\t\t\t\t\t\t<input class=\"custom-control-input\" name=\"remember-me\"\r\n");
      out.write("\t\t\t\t\t\t\t\tid=\"remember-me\" type=\"checkbox\" /> <label\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"custom-control-label\" for=\"remember-me\">자동 로그인</label>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group mt-4 mb-0\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary float-right\" id=\"loginBtn\">로그인</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t<!-- 네이버 로그인 창 -->\r\n");
      out.write("\t\t\t\t<div id=\"naver_id_login float-left\" style=\"text-align: center\">\r\n");
      out.write("\t\t\t\t\t<a class=\"float-left\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"> <img width=\"223\" src=\"/myshop/resources/img/login.PNG\" /></a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- /.modal-content -->\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- /.modal-dialog -->\r\n");
      out.write("</div>\r\n");
      out.write("<!-- /#loginModal -->\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_sec_005fauthorize_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  sec:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_sec_005fauthorize_005f0 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    boolean _jspx_th_sec_005fauthorize_005f0_reused = false;
    try {
      _jspx_th_sec_005fauthorize_005f0.setPageContext(_jspx_page_context);
      _jspx_th_sec_005fauthorize_005f0.setParent(null);
      // /WEB-INF/views/includes/header.jsp(41,4) name = access type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_sec_005fauthorize_005f0.setAccess("isAnonymous()");
      int _jspx_eval_sec_005fauthorize_005f0 = _jspx_th_sec_005fauthorize_005f0.doStartTag();
      if (_jspx_eval_sec_005fauthorize_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n");
        out.write("\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\"\r\n");
        out.write("\t\t\t\t\t\thref=\"javascript:join()\">회원가입</a></li>\r\n");
        out.write("\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\"\r\n");
        out.write("\t\t\t\t\t\thref=\"javascript:login()\">로그인</a></li>\r\n");
        out.write("\t\t\t\t");
      }
      if (_jspx_th_sec_005fauthorize_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.reuse(_jspx_th_sec_005fauthorize_005f0);
      _jspx_th_sec_005fauthorize_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_sec_005fauthorize_005f0, _jsp_getInstanceManager(), _jspx_th_sec_005fauthorize_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_sec_005fauthorize_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  sec:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_sec_005fauthorize_005f1 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    boolean _jspx_th_sec_005fauthorize_005f1_reused = false;
    try {
      _jspx_th_sec_005fauthorize_005f1.setPageContext(_jspx_page_context);
      _jspx_th_sec_005fauthorize_005f1.setParent(null);
      // /WEB-INF/views/includes/header.jsp(47,4) name = access type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_sec_005fauthorize_005f1.setAccess("isAuthenticated()");
      int _jspx_eval_sec_005fauthorize_005f1 = _jspx_th_sec_005fauthorize_005f1.doStartTag();
      if (_jspx_eval_sec_005fauthorize_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_sec_005fauthorize_005f2(_jspx_th_sec_005fauthorize_005f1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_sec_005fauthorize_005f3(_jspx_th_sec_005fauthorize_005f1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t<li class=\"nav-item\">\r\n");
        out.write("\t\t\t\t\t\t<form id=\"logoutForm\" action=\"/myshop/logout\" method=\"post\">\r\n");
        out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.parameterName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
        out.write("\"\r\n");
        out.write("\t\t\t\t\t\t\t\tvalue=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.token }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
        out.write("\">\r\n");
        out.write("\t\t\t\t\t\t</form> <a class=\"nav-link\" href=\"javascript:logout()\">로그아웃</a>\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t");
      }
      if (_jspx_th_sec_005fauthorize_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.reuse(_jspx_th_sec_005fauthorize_005f1);
      _jspx_th_sec_005fauthorize_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_sec_005fauthorize_005f1, _jsp_getInstanceManager(), _jspx_th_sec_005fauthorize_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_sec_005fauthorize_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_sec_005fauthorize_005f1, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  sec:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_sec_005fauthorize_005f2 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    boolean _jspx_th_sec_005fauthorize_005f2_reused = false;
    try {
      _jspx_th_sec_005fauthorize_005f2.setPageContext(_jspx_page_context);
      _jspx_th_sec_005fauthorize_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sec_005fauthorize_005f1);
      // /WEB-INF/views/includes/header.jsp(48,5) name = access type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_sec_005fauthorize_005f2.setAccess("hasRole(\"ROLE_USER\")");
      int _jspx_eval_sec_005fauthorize_005f2 = _jspx_th_sec_005fauthorize_005f2.doStartTag();
      if (_jspx_eval_sec_005fauthorize_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\"\r\n");
        out.write("\t\t\t\t\t\t\thref=\"/myshop/user/update\"><i class=\"far fa-address-book\"></i>\r\n");
        out.write("\t\t\t\t\t\t\t\t마이 페이지</a></li>\r\n");
        out.write("\t\t\t\t\t\t<li class=\"nav-item\"><a\r\n");
        out.write("\t\t\t\t\t\t\thref=\"/myshop/product/cart?userid=");
        if (_jspx_meth_sec_005fauthentication_005f0(_jspx_th_sec_005fauthorize_005f2, _jspx_page_context))
          return true;
        out.write("\"\r\n");
        out.write("\t\t\t\t\t\t\tclass=\"nav-link\"><i class=\"fas fa-shopping-cart\"></i> 장바구니</a></li>\r\n");
        out.write("\t\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\"\r\n");
        out.write("\t\t\t\t\t\t\thref=\"/myshop/product/order/list?userid=");
        if (_jspx_meth_sec_005fauthentication_005f1(_jspx_th_sec_005fauthorize_005f2, _jspx_page_context))
          return true;
        out.write("\"><i\r\n");
        out.write("\t\t\t\t\t\t\t\tclass=\"fas fa-clipboard-list\"></i> 주문 내역</a></li>\r\n");
        out.write("\t\t\t\t\t");
      }
      if (_jspx_th_sec_005fauthorize_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.reuse(_jspx_th_sec_005fauthorize_005f2);
      _jspx_th_sec_005fauthorize_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_sec_005fauthorize_005f2, _jsp_getInstanceManager(), _jspx_th_sec_005fauthorize_005f2_reused);
    }
    return false;
  }

  private boolean _jspx_meth_sec_005fauthentication_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_sec_005fauthorize_005f2, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  sec:authentication
    org.springframework.security.taglibs.authz.AuthenticationTag _jspx_th_sec_005fauthentication_005f0 = (org.springframework.security.taglibs.authz.AuthenticationTag) _005fjspx_005ftagPool_005fsec_005fauthentication_0026_005fproperty_005fnobody.get(org.springframework.security.taglibs.authz.AuthenticationTag.class);
    boolean _jspx_th_sec_005fauthentication_005f0_reused = false;
    try {
      _jspx_th_sec_005fauthentication_005f0.setPageContext(_jspx_page_context);
      _jspx_th_sec_005fauthentication_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sec_005fauthorize_005f2);
      // /WEB-INF/views/includes/header.jsp(53,41) name = property type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_sec_005fauthentication_005f0.setProperty("principal.username");
      int _jspx_eval_sec_005fauthentication_005f0 = _jspx_th_sec_005fauthentication_005f0.doStartTag();
      if (_jspx_th_sec_005fauthentication_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fsec_005fauthentication_0026_005fproperty_005fnobody.reuse(_jspx_th_sec_005fauthentication_005f0);
      _jspx_th_sec_005fauthentication_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_sec_005fauthentication_005f0, _jsp_getInstanceManager(), _jspx_th_sec_005fauthentication_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_sec_005fauthentication_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_sec_005fauthorize_005f2, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  sec:authentication
    org.springframework.security.taglibs.authz.AuthenticationTag _jspx_th_sec_005fauthentication_005f1 = (org.springframework.security.taglibs.authz.AuthenticationTag) _005fjspx_005ftagPool_005fsec_005fauthentication_0026_005fproperty_005fnobody.get(org.springframework.security.taglibs.authz.AuthenticationTag.class);
    boolean _jspx_th_sec_005fauthentication_005f1_reused = false;
    try {
      _jspx_th_sec_005fauthentication_005f1.setPageContext(_jspx_page_context);
      _jspx_th_sec_005fauthentication_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sec_005fauthorize_005f2);
      // /WEB-INF/views/includes/header.jsp(56,47) name = property type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_sec_005fauthentication_005f1.setProperty("principal.username");
      int _jspx_eval_sec_005fauthentication_005f1 = _jspx_th_sec_005fauthentication_005f1.doStartTag();
      if (_jspx_th_sec_005fauthentication_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fsec_005fauthentication_0026_005fproperty_005fnobody.reuse(_jspx_th_sec_005fauthentication_005f1);
      _jspx_th_sec_005fauthentication_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_sec_005fauthentication_005f1, _jsp_getInstanceManager(), _jspx_th_sec_005fauthentication_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_sec_005fauthorize_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_sec_005fauthorize_005f1, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  sec:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_sec_005fauthorize_005f3 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    boolean _jspx_th_sec_005fauthorize_005f3_reused = false;
    try {
      _jspx_th_sec_005fauthorize_005f3.setPageContext(_jspx_page_context);
      _jspx_th_sec_005fauthorize_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sec_005fauthorize_005f1);
      // /WEB-INF/views/includes/header.jsp(59,5) name = access type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_sec_005fauthorize_005f3.setAccess("hasRole(\"ROLE_ADMIN\")");
      int _jspx_eval_sec_005fauthorize_005f3 = _jspx_th_sec_005fauthorize_005f3.doStartTag();
      if (_jspx_eval_sec_005fauthorize_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\"\r\n");
        out.write("\t\t\t\t\t\t\thref=\"/myshop/admin/list\"><i class=\"fas fa-address-card\"></i>\r\n");
        out.write("\t\t\t\t\t\t\t\t회원 관리</a></li>\r\n");
        out.write("\t\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\"\r\n");
        out.write("\t\t\t\t\t\t\thref=\"/myshop/product/category/list\"><i class=\"fas fa-tags\"></i>\r\n");
        out.write("\t\t\t\t\t\t\t\t카테고리 관리</a></li>\r\n");
        out.write("\t\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\"\r\n");
        out.write("\t\t\t\t\t\t\thref=\"/myshop/product/order/admin/list\"><i\r\n");
        out.write("\t\t\t\t\t\t\t\tclass=\"fas fa-clipboard-list\"></i> 주문 관리</a></li>\r\n");
        out.write("\t\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\"\r\n");
        out.write("\t\t\t\t\t\t\thref=\"/myshop/product/register\"><i\r\n");
        out.write("\t\t\t\t\t\t\t\tclass=\"fas fa-balance-scale\"></i> 상품 등록</a></li>\r\n");
        out.write("\t\t\t\t\t");
      }
      if (_jspx_th_sec_005fauthorize_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.reuse(_jspx_th_sec_005fauthorize_005f3);
      _jspx_th_sec_005fauthorize_005f3_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_sec_005fauthorize_005f3, _jsp_getInstanceManager(), _jspx_th_sec_005fauthorize_005f3_reused);
    }
    return false;
  }
}
