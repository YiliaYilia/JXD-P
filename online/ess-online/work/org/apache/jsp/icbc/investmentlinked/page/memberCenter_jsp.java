/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.42
 * Generated at: 2014-04-15 05:49:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.icbc.investmentlinked.page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import cn.com.sinosoft.ess.protal.payment.CryptoUtil;
import cn.com.sinosoft.core.utils.PropertityUtil;

public final class memberCenter_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("/WEB-INF/tlds/dict.tld", Long.valueOf(1397242678135L));
    _jspx_dependants.put("/WEB-INF/tlds/fn.tld", Long.valueOf(1397242676826L));
    _jspx_dependants.put("/WEB-INF/tlds/fmt.tld", Long.valueOf(1397242678139L));
    _jspx_dependants.put("/icbc/investmentlinked/page/../../../common/page/common.jsp", Long.valueOf(1397430122165L));
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	PropertityUtil.init("config/pwd.properties");
	String viewPersonalInfo = PropertityUtil.get("viewPersonalInfo");
	String md5Str = PropertityUtil.get("md5");

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
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/common/css/niceValidate/jquery.validator.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/common/js/jquery-1.8.0.min.js\"></script>\r\n");
      out.write("<!-- \r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/common/js/jquery.validator.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/common/js/zh_CN.js\"></script>\r\n");
      out.write(" -->\r\n");
      out.write("<!--  -->\r\n");
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
      out.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/css/login.css\">\r\n");
      out.write("\r\n");
      out.write("<script type='text/javascript'>\r\n");
      out.write("</script>");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t//跳转至登录页面\r\n");
      out.write("\tvar userId = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.userId == null ? 0 : sessionScope.userId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\tif( userId == \"0\"){\r\n");
      out.write("\t\tself.parent.location = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/page/memberLogin.jsp\";\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html>\r\n");
      out.write("<head lang=\"en\">\r\n");
      out.write("<title>工银安盛人寿保险有限公司</title>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/css/membercenter.css\">\r\n");
      out.write("\t<SCRIPT src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/js/hover/memberCenter.js\" type=\"text/javascript\"></SCRIPT>\r\n");
      out.write("<body style=\"margin:0 auto;\">\r\n");
      out.write("\t<DIV id=\"baseWrapper\">\r\n");
      out.write("\t\t<div id=\"content-whole-mid\">\r\n");
      out.write("\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "head.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t<div class=\"content\" style=\"background-color:#ffffff;\">\r\n");
      out.write("\t\t\t\t<div class=\"title\">\r\n");
      out.write("\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/\" style=\"margin-left:15px;\">在线商城首页</a>\r\n");
      out.write("\t\t\t\t\t<font color=\"#7f7f7f\">&gt;</font>\r\n");
      out.write("\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/page/memberCenter.jsp\">会员中心</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div style=\"float:right;width:250px;display:block;height:30px;\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"leftpanel00\">\r\n");
      out.write("\t\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "leftPanel0.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"detail\">\r\n");
      out.write("\t\t\t\t\t<!-- 嵌入客户信息 页 -->\r\n");
      out.write("\t\t\t\t\t<iframe id=\"member_info_include\" name=\"member_info_include\" src=\"\" onload=\"javascript:dyniframesize('member_info_include');\"\r\n");
      out.write("\t\t\t\t\t\tmarginwidth=\"0\" marginheight=\"0\" frameborder=\"0\" scrolling=\"no\" width=\"700px\" height=\"100%\"></iframe>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"leftpanel01\">\r\n");
      out.write("\t\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "leftPanel01.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<DIV id=\"homeBanner\"\r\n");
      out.write("\t\t\tstyle=\"margin-top:30px;padding: 10px 0px 9px 13px; width: 960px;  overflow: hidden;margin-left:4px;\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "homeBanner.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t</DIV>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<DIV style=\"margin:23px auto 0px; padding: 0px 0px 23px; width: 985px;\">\r\n");
      out.write("\t</DIV>\r\n");
      out.write("\t<div id=\"footerWrapper\" style=\"width: 100%; height:67px;float:left; \">\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function dyniframesize(down) {\r\n");
      out.write("\tvar pTar = null;\r\n");
      out.write("\tif (document.getElementById) {\r\n");
      out.write("\t\tpTar = document.getElementById(down);\r\n");
      out.write("\t} else {\r\n");
      out.write("\t\teval('pTar = ' + down + ';');\r\n");
      out.write("\t}\r\n");
      out.write("\tif (pTar && !window.opera) {\r\n");
      out.write("\t\t// begin resizing iframe\r\n");
      out.write("\t\tpTar.style.display = \"block\";\r\n");
      out.write("\t\tif (pTar.contentDocument && pTar.contentDocument.body.offsetHeight) {\r\n");
      out.write("\t\t\t// ns6 syntax\r\n");
      out.write("\t\t\tpTar.height = pTar.contentDocument.body.offsetHeight + 20;\r\n");
      out.write("\t\t\t// pTar.width = pTar.contentDocument.body.scrollWidth+20;\r\n");
      out.write("\t\t} else if (pTar.Document && pTar.Document.body.scrollHeight) {\r\n");
      out.write("\t\t\t// ie5+ syntax\r\n");
      out.write("\t\t\tpTar.height = pTar.Document.body.scrollHeight;\r\n");
      out.write("\t\t\t// pTar.width = pTar.Document.body.scrollWidth;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("$(document).ready(function() {\r\n");
      out.write("\t\tvar userId = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.userId == null ? 0 : sessionScope.userId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\tif( userId != \"0\"){\r\n");
      out.write("\t\t\t\tvar iframe_url = \"");
      out.print(viewPersonalInfo);
      out.write("\";\r\n");
      out.write("\t\t\t\t\t\t\tiframe_url = iframe_url\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"?userId=\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.userId == null ? \"\" : sessionScope.userId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("\t\t\t\t\t\t\tiframe_url = iframe_url\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"&userName=\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.userName == null ? \"\" : sessionScope.userName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("\t\t\t\t\t\t\tiframe_url = iframe_url\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"&userType=\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.userType == null ? \"\" : sessionScope.userType}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("\t\t\t\t\t\t\tiframe_url = iframe_url\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"&channel=\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.channel == null ? \"\" : sessionScope.channel}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("\t\t\t\t\t\t\tiframe_url = iframe_url\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"&signature=\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.signature == null ? \"\" : sessionScope.signature}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#member_info_include\").attr(\"src\", iframe_url);\r\n");
      out.write("\t\t\t\t\t\t\t//$(\"#member_info_include\").attr(\"src\", \"http://84.238.29.87:8080/icbc/esrv/eservice/ViewPersonalInfoServlet?userId=24552&userName=sinosoft&userType=1&channel=1&signature=3C57F723DE279C1F59F4B7D661DCB009\");\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t//$(\"#member_info_include\").attr(\"width\", \"690px\");\r\n");
      out.write("\t\t\t\t\t\t\t//$(\"#member_info_include\").attr(\"height\", \"460px\");\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\t//跳转至登录页面\r\n");
      out.write("\t\t\t//self.parent.location = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/icbc/investmentlinked/page/memberLogin.jsp\";\r\n");
      out.write("\t\t}\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
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
    // /icbc/investmentlinked/page/../../../common/page/common.jsp(7,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("ctx");
    // /icbc/investmentlinked/page/../../../common/page/common.jsp(7,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
