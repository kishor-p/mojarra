<%--

    DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.

    Copyright (c) 1997-2010 Oracle and/or its affiliates. All rights reserved.

    The contents of this file are subject to the terms of either the GNU
    General Public License Version 2 only ("GPL") or the Common Development
    and Distribution License("CDDL") (collectively, the "License").  You
    may not use this file except in compliance with the License.  You can
    obtain a copy of the License at
    https://glassfish.java.net/public/CDDL+GPL_1_1.html
    or packager/legal/LICENSE.txt.  See the License for the specific
    language governing permissions and limitations under the License.

    When distributing the software, include this License Header Notice in each
    file and include the License file at packager/legal/LICENSE.txt.

    GPL Classpath Exception:
    Oracle designates this particular file as subject to the "Classpath"
    exception as provided by Oracle in the GPL Version 2 section of the License
    file that accompanied this code.

    Modifications:
    If applicable, add the following below the License Header, with the fields
    enclosed by brackets [] replaced by your own identifying information:
    "Portions Copyright [year] [name of copyright owner]"

    Contributor(s):
    If you wish your version of this file to be governed by only the CDDL or
    only the GPL Version 2, indicate your decision by adding "[Contributor]
    elects to include this software in this distribution under the [CDDL or GPL
    Version 2] license."  If you don't indicate a single choice of license, a
    recipient has the option to distribute your version of this file under
    either the CDDL, the GPL Version 2 or to extend the choice of license to
    its licensees as provided above.  However, if you add GPL Version 2 code
    and therefore, elected the GPL Version 2 license, then the option applies
    only if the new code is made subject to such option by the copyright
    holder.

--%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSP view</title>
    <%@ taglib uri="http://java.sun.com/jsf/core"  prefix="f" %>
    <%@ taglib uri="http://java.sun.com/jsf/html"  prefix="h" %>
  </head>

  <body>
<f:view>

<p>HTML Template Text</p>

<p><h:outputText value="#{processAsJspxBean.prop}" /></p>

<h:form prependId="false">

<h:commandButton value="reload" />

</h:form>

                  <code>
                    <br/>
                    &amp;lt;context-param&amp;gt;
                    <br/>
                     
&amp;nbsp;&amp;nbsp;&amp;lt;param-name&amp;gt;javax.faces.PARTIAL_STATE_SAVING 

&amp;lt;/param-name&amp;gt;
                    <br/>
                     
&amp;nbsp;&amp;nbsp;&amp;lt;param-value&amp;gt;true&amp;lt;/param-value&amp;gt 

;
                    <br/>
                    &amp;lt;/context-param&amp;gt;
                  </code>      


<jsp:text>
  some text
</jsp:text>

<jsp:plugin 
   type="applet" 
   code="Blink.class" 
   codebase="."
   name="Arthur van Hoff"
   align="baseline"
   width="300"
   height="200"
   hspace="20"
   vspace="20"
   jreversion="1.6">
  <jsp:params>
    <jsp:param name="lbl" value="This is the next best thing to sliced bread! Toast, toast, toast, butter, jam, toast, marmite, toast." /> 
  </jsp:params>
  <jsp:fallback>
No JDK 1.3 support for APPLET!!
  </jsp:fallback>
</jsp:plugin>

</f:view>

    <hr>
  </body>
</html>
