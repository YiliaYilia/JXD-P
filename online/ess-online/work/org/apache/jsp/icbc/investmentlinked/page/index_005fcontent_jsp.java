/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.42
 * Generated at: 2014-04-18 06:46:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.icbc.investmentlinked.page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_005fcontent_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("/WEB-INF/tlds/dict.tld", Long.valueOf(1397242678135L));
    _jspx_dependants.put("/WEB-INF/tlds/fn.tld", Long.valueOf(1397242676826L));
    _jspx_dependants.put("/WEB-INF/tlds/fmt.tld", Long.valueOf(1397242678139L));
    _jspx_dependants.put("/icbc/investmentlinked/page/../../../common/page/common.jsp", Long.valueOf(1397566400044L));
    _jspx_dependants.put("/WEB-INF/tlds/c.tld", Long.valueOf(1397242678131L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

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

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/css/login.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/common/css/niceValidate/jquery.validator.css\">\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/common/js/jquery-1.8.0.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/common/js/validate/jquery.validate.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/common/js/validate/additional-methods.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/common/js/validate/messages_zh.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/icbc/investmentlinked/js/jquery.lightbox_me.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write(" <HEAD>\r\n");
      out.write("<META http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<TITLE> 工银安盛人寿保险有限公司</TITLE>\r\n");
      out.write("<META name=\"description\" content=\"工银安盛人寿官方网站提供最新公司动态，为您提供有关工银安盛人寿近期新闻信息、活动资讯、产品服务等的第一手资讯\">\r\n");
      out.write("<META name=\"GENERATOR\" content=\"MSHTML 10.00.9200.16750\">\t\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/style/css.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/js/jscode.js\"></script>\r\n");
      out.write("</HEAD>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"container\"  >\r\n");
      out.write("\t<div id=\"slider\">\r\n");
      out.write("\t \t<!-- 11111111111111 -->\r\n");
      out.write("\t \t<div id=\"slide1\"  style=\"margin-top:5px;margin-right:10px; width:920px;  height:288px;background-image:url('../images/content_2_bg.jpg');\">\r\n");
      out.write("\t\t\t<div style=\"float: left; margin: 0 0 0 -15px; display: inline\">\r\n");
      out.write("\t\t\t\t<div style=\" height: 227px; width: 329px; margin: 0 9px 0 0\">\r\n");
      out.write("\t\t\t\t\t<div style=\"color: rgb(199, 0, 11); margin-left:15px;margin-top:15px; width:245px; height: 30px; text-align: left;\">\r\n");
      out.write("\t\t\t\t\t\t\t<b>丨为您推荐</b>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"news_index\">\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<LI>\r\n");
      out.write("\t\t\t\t\t\t\t\t<A href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/productCesuan?productcode=NPACA\" target=\"_self\"><DIV style=\"width: 440px; height:227px; margin-left: 20px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<DIV style=\"color: rgb(199, 0, 11);\">&nbsp;</DIV>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  <DIV style=\"margin-top:-25px; width: 440px; height:227px;background-image:url('../images/content_2.jpg');\" onmouseover=\"div_show('div4')\" onmouseout=\"div_hide('div4')\"></DIV>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t <div id=\"div4\" style=\"font-size: 16px; width: 440px; height:95px; margin-top:-95px;margin-left:0px;background-image:url('../images/interlayer_01.png') ;display:none;\"><font color=\"white\" >&nbsp;<br>盛世丰年年金保险（分红型）</font></DIV>\r\n");
      out.write("\t\t\t\t\t\t\t\t</DIV></A>\r\n");
      out.write("\t\t\t\t\t\t\t</LI>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div style=\"float: left; width: 413px; height:111px; margin: 50px 0 0 150px;background-image:url('../images/content_bg_2.jpg');\">\r\n");
      out.write("\t\t\t\t<div style=\"float: left; width:88px; height:88px; margin: 15px 0 15px 10px\">\r\n");
      out.write("\t\t\t\t\t<a href=\"#\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/images/content1.jpg\"/></a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div style=\"float:left; height:88px;width:295px;margin: 15px 0 15px 10px;\">\r\n");
      out.write("\t\t\t\t\t<div style=\" font-family:'宋体';font-size: 14px; color:#252525; float:left;width:295;display: inline；\">\r\n");
      out.write("\t\t\t\t\t<a href=\"#\">盛世盈门年金保险（分红型）</a></div>\r\n");
      out.write("\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t<div style=\" margin-top:13px; font-family:'宋体';font-size: 10px; color: #666;float:left;width:295;display: inline；\">多年辛苦打拼，成功登顶事业巅峰，明日功成身退，依然不改品质生活，盛世盈门，助您即刻规划未来，财富管理、养老规划、资产传承一举实现！</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"float: left; width: 413px; height:111px; margin: 5px 9px 0 150px;background-image:url('../images/content_bg_2.jpg');\">\r\n");
      out.write("\t\t\t\t<div style=\"float: left; width:88px; height:88px; margin: 15px 0 15px 10px\">\r\n");
      out.write("\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/productCesuan?productcode=JEB\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/images/content2.jpg\"/></a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div style=\"float:left; height:88px;width:300px;margin: 15px 0 15px 10px;\">\r\n");
      out.write("\t\t\t\t\t<div style=\" font-family:'宋体';font-size: 14px; color:#252525; float:left;width:300;display: inline；\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/productCesuan?productcode=JEB\">盛世宝贝两全保险（分红型）</a></div>\r\n");
      out.write("\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t<div style=\" margin-top:15px; font-family:'宋体';font-size: 10px; color: #666;float:left;width:300;display: inline；\">为您提供少儿教育金及身故保障，帮助智慧老爸老妈铺就宝贝成才之路。让您的关爱陪伴孩子的成长，让您的远见成就孩子的未来。</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t \t<!-- 2222222222222 -->\r\n");
      out.write("\t\t<div id=\"slide2\" style=\"display:none；margin-top:5px; margin-right:10px;  width:920px; height:288px;background-image:url('../images/content_2_bg.jpg');\">\r\n");
      out.write("\t\t\t<div style=\"float: left; margin: 0 0 0 -15px; display: inline\">\r\n");
      out.write("\t\t\t\t<div style=\" height: 227px; width: 329px; margin: 0 9px 0 0\">\r\n");
      out.write("\t\t\t\t\t<div style=\"color: rgb(199, 0, 11); margin-left:15px;margin-top:15px; width:245px; height: 30px; text-align: left;\">\r\n");
      out.write("\t\t\t\t\t\t\t<b>丨为您推荐</b>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"news_index\">\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<LI>\r\n");
      out.write("\t\t\t\t\t\t\t\t<A href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/productCesuan?productcode=NPACA\" target=\"_self\"><DIV style=\"width: 440px; height:227px; margin-left: 20px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<DIV style=\"color: rgb(199, 0, 11);\">&nbsp;</DIV>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  <DIV style=\"margin-top:-25px; width: 440px; height:227px;background-image:url('../images/content_2.jpg');\" onmouseover=\"div_show('div5')\" onmouseout=\"div_hide('div5')\"></DIV>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t <div id=\"div5\" style=\"font-size: 16px; width: 440px; height:95px; margin-top:-95px;margin-left:0px;background-image:url('../images/interlayer_01.png') ;display:none;\"><font color=\"white\" >&nbsp;<br>盛世丰年年金保险（分红型）</font></DIV>\r\n");
      out.write("\t\t\t\t\t\t\t\t</DIV></A>\r\n");
      out.write("\t\t\t\t\t\t\t</LI>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"float: left; width: 410px; height:73px; margin: 50px 0 0 150px;background-image:url('../images/content_bg_3.jpg');\">\r\n");
      out.write("\t\t\t\t<div style=\"float: left; width:65px; height:65px; display:block;margin:5px 5px;\">\r\n");
      out.write("\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/productCesuan?productcode=BCIB\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/images/content3_1.jpg\"/></a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div style=\"float:left; height:88px;width:295px;margin: 10px 0 15px 10px;\">\r\n");
      out.write("\t\t\t\t\t<div style=\" font-family:'宋体';font-size: 14px; color:#252525; float:left;width:295;display: inline；\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/productCesuan?productcode=BCIB\">御立方二号保障计划</a></div>\r\n");
      out.write("\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t<div style=\" margin-top:13px; font-family:'宋体';font-size:10px; color: #666;float:left;width:295;display: inline；\">重大疾病很可怕？更可怕的是没有御立方二号的保护！40种重大疾病保障，面面俱到；最多3次重大疾病...</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"float: left; width: 410px; height:73px; margin: 5px 9px 0 150px;background-image:url('../images/content_bg_3.jpg');\">\r\n");
      out.write("\t\t\t\t<div style=\"float: left;width:65px; height:65px; display:block;margin:5px 5px;\">\r\n");
      out.write("\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/productCesuan?productcode=AA\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/images/content3_2.jpg\"/></a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div style=\"float:left; height:88px;width:300px;margin: 10px 0 15px 10px;\">\r\n");
      out.write("\t\t\t\t\t<div style=\" font-family:'宋体';font-size: 14px; color:#252525; float:left;width:300;display: inline；\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/productCesuan?productcode=AA \">e+安行航空意外伤害保险</a></div>\r\n");
      out.write("\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t<div style=\" margin-top:15px; font-family:'宋体';font-size: 10px; color: #666;float:left;width:300;display: inline；\">适合经常搭乘飞机出行的商旅人士，千万保额护航，畅享安心之旅。</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"float: left; width: 410px; height:73px; margin: 5px 9px 0 150px;background-image:url('../images/content_bg_3.jpg');\">\r\n");
      out.write("\t\t\t\t<div style=\"float: left;width:65px; height:65px; display:block;margin:5px 5px;\">\r\n");
      out.write("\t\t\t\t\t<a href=\"#\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/images/content3_3.jpg\"/></a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div style=\"float:left; height:88px;width:300px;margin: 10px 0 15px 10px;\">\r\n");
      out.write("\t\t\t\t\t<div style=\" font-family:'宋体';font-size: 14px; color:#252525; float:left;width:300;display: inline；\">\r\n");
      out.write("\t\t\t\t\t<a href=\"#\">盛世盈门年金保险（分红型）</a></div>\r\n");
      out.write("\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t<div style=\" margin-top:15px; font-family:'宋体';font-size: 10px; color: #666;float:left;width:300;display: inline；\">多年辛苦打拼，成功登顶事业巅峰，明日功成身退，依然不改品质生活，盛世盈门，助您即刻规划未来，...</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t \t<!-- 33333333333333 -->\r\n");
      out.write("\t\t<div id=\"slide3\" style=\"display:none；margin-top:5px; margin-right:10px; width:920px;  height:288px;background-image:url('../images/content_2_bg.jpg');\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div style=\"float: left; margin: 0 0 0 -15px; display: inline\">\r\n");
      out.write("\t\t\t\t<div style=\" height: 227px; width: 329px; margin: 0 9px 0 0\">\r\n");
      out.write("\t\t\t\t\t<div style=\"color: rgb(199, 0, 11); margin-left:15px;margin-top:15px; width:245px; height: 30px; text-align: left;\">\r\n");
      out.write("\t\t\t\t\t\t<b>丨为您推荐</b>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"news_index\">\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<LI>\r\n");
      out.write("\t\t\t\t\t\t\t\t<A href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/productCesuan?productcode=NPACA\" target=\"_self\"><DIV style=\"width: 320px; height:227px; margin-left: 20px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<DIV style=\"color: rgb(199, 0, 11);\">&nbsp;</DIV>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  <DIV style=\"margin-top:-25px; width: 329px; height:227px;background-image:url('../images/content_2.jpg');\" onmouseover=\"div_show('div6')\" onmouseout=\"div_hide('div6')\"></DIV>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t <div id=\"div6\" style=\"font-size: 16px; width: 329px; height:95px; margin-top:-95px;margin-left:0px;background-image:url('../images/interlayer_01.png') ;display:none;\"><font color=\"white\" >&nbsp;<br>盛世丰年年金保险（分红型）</font></DIV>\r\n");
      out.write("\t\t\t\t\t\t\t\t</DIV></A>\r\n");
      out.write("\t\t\t\t\t\t\t</LI>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"float: left; width: 260px; height:113px; margin: 50px 0 0 50px;background-image:url('../images/content_right_bg.jpg');\">\r\n");
      out.write("\t\t\t\t<div style=\"float: left; width:88px; height:88px; margin: 15px 0 15px 10px\">\r\n");
      out.write("\t\t\t\t\t<a href=\"#\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/images/content1.jpg\"/></a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div style=\"float:left; height:88px;width:100px;margin: 15px 0 15px 10px;\">\r\n");
      out.write("\t\t\t\t\t<div style=\" font-family:'宋体';font-size: 14px; color:#252525; float:left;width:100;line-height:18px;\"><a href=\"#\">盛世盈门年金保险（分红型）</a></div>\r\n");
      out.write("\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t<div style=\" margin-top:10px; font-family:'宋体';font-size: 10px; color: #666;float:left;width:100;\">多年辛苦打拼，成功登顶事业巅峰明日功成身退...</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"float: left; width: 258px; height:113px; margin: 50px 9px 0 10px;background-image:url('../images/content_right_bg.jpg');\">\r\n");
      out.write("\t\t\t\t<div style=\"float: left; width:88px; height:88px; margin: 15px 0 15px 10px\">\r\n");
      out.write("\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/productCesuan?productcode=BCIB\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/images/content2.jpg\"/></a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div style=\"float:left; height:88px;width:100px;margin: 15px 0 15px 10px;\">\r\n");
      out.write("\t\t\t\t\t<div style=\" font-family:'宋体';font-size: 14px; color:#252525; float:left;width:100;line-height:18px;\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/productCesuan?productcode=BCIB\">御立方二号保障计划</a></div>\r\n");
      out.write("\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t<div style=\" margin-top:10px; font-family:'宋体';font-size: 10px; color: #666;float:left;width:100;\">重大疾病很可怕？更可怕的是没有御立方二号的保...</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"float: left; width: 258px; height:113px; margin: 5px 0 0 50px;background-image:url('../images/content_right_bg.jpg');\">\r\n");
      out.write("\t\t\t\t<div style=\"float: left; width:88px; height:88px; margin: 15px 0 15px 10px\">\r\n");
      out.write("\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/productCesuan?productcode=JEB\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/images/content3.jpg\"/></a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div style=\"float:left; height:88px;width:100px;margin: 15px 0 15px 10px;\">\r\n");
      out.write("\t\t\t\t\t<div style=\" font-family:'宋体';font-size: 14px; color:#252525; float:left;width:100;line-height:18px;\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/productCesuan?productcode=JEB\">盛世宝贝两全保险（分红型）</a></div>\r\n");
      out.write("\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t<div style=\" margin-top:10px; font-family:'宋体';font-size: 10px; color: #666;float:left;width:100;\">为您提供少儿教育金及身故保障帮助智慧老爸老...</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"float: left; width: 258px; height:113px; margin: 5px 9px 0 10px;background-image:url('../images/content_right_bg.jpg');\">\r\n");
      out.write("\t\t\t\t<div style=\"float: left; width:88px; height:88px; margin: 15px 0 15px 10px\">\r\n");
      out.write("\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/productCesuan?productcode=AA\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/images/content4.jpg\"/></a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div style=\"float:left; height:88px;width:100px;margin: 15px 0 15px 10px;\">\r\n");
      out.write("\t\t\t\t\t<div style=\" font-family:'宋体';font-size: 14px; color:#252525; float:left;width:100;line-height:18px;\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/productCesuan?productcode=AA \">e+安行航空意外伤害保险</a></div>\r\n");
      out.write("\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t<div style=\" margin-top:10px; font-family:'宋体';font-size: 10px; color: #666;float:left;width:100;\">适合经常搭乘飞机出行的商旅人士，千万保额护航...</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div  style=\"width:985px;height:0px ;float:left;position:absolute;z-index:999;top:100px;\">\r\n");
      out.write("\t    <div style=\"margin-left:15px;float:left;\"><a href=\"\" class=\"previous\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/images/button_left.jpg\"/></a></div>\r\n");
      out.write("\t    <div style=\" margin-right:15px;float:right;\"><a href=\"\" class=\"next\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/images/button_right.jpg\"/></a></div>\r\n");
      out.write("\t</div>    \r\n");
      out.write("</div> \r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /icbc/investmentlinked/page/../../../common/page/common.jsp(6,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("ctx");
    // /icbc/investmentlinked/page/../../../common/page/common.jsp(6,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }
}