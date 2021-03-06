/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 1997-2010 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package com.sun.faces.test.servlet30.nesteddatatables;

import java.util.Vector;
import java.io.Serializable;
import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

public class TestBean implements Serializable {

    Vector _services = new Vector();

    public TestBean() {

        System.err.println("Constructing a TestBean");

        Service service1 = new Service("Service 1");
        //        service1.addPort(new Port("80"));

        _services.addElement(service1);

        Service service2 = new Service("Service 2");
        //service1.addPort(new Port("90"));

        _services.addElement(service2);
    }

    public Vector getServices() {
        return _services;
    }

    public void setServices(Vector services) {
        _services = services;
    }

    public String addService() {

        System.err.println("addService");

        _services.add(new Service("New Service"));

        return "OK";
    }

    public String deleteService() {

        System.err.println("deleteService");

        FacesContext facesContext = FacesContext.getCurrentInstance();
        Service service = (Service) facesContext.getExternalContext().getRequestMap().get("service");

        _services.remove(service);

        return "OK";
    }

    public String addPortNumber() {

        System.err.println("addPortNumber");

        FacesContext facesContext = FacesContext.getCurrentInstance();
        Service service = (Service) facesContext.getExternalContext().getRequestMap().get("service");

        service.addPort(new Port());

        return "OK";
    }

    public String deletePortNumber() {

        System.err.println("deletePortNumber");

        FacesContext facesContext = FacesContext.getCurrentInstance();
        Service service = (Service) facesContext.getExternalContext().getRequestMap().get("service");
        Port port = (Port) facesContext.getExternalContext().getRequestMap().get("portNumber");

        service.deletePort(port);

        return "OK";
    }

    public String getCurrentStateTable() {
        StringBuffer out = new StringBuffer();
        Iterator inner, outer = _services.iterator();
        Service curService;
        Port curPort;

        out.append("<table border=\"1\">\n");
        while (outer.hasNext()) {
            curService = (Service) outer.next();
            out.append("  <tr>\n");
            inner = curService.getPorts().iterator();
            out.append("<td>service: " + curService.getName() + "</td>");
            while (inner.hasNext()) {
                curPort = (Port) inner.next();
                out.append(" <td>port: " + curPort.getPortNumber() + "</td>\n");
            }
            out.append("</tr>\n");
        }
        out.append("</table>\n");
        return out.toString();

    }

    public String printTree() {
        Iterator inner, outer = _services.iterator();
        Service curService;
        Port curPort;
        while (outer.hasNext()) {
            curService = (Service) outer.next();
            System.out.println("service: " + curService + " " +
                    curService.getName());
            inner = curService.getPorts().iterator();
            while (inner.hasNext()) {
                curPort = (Port) inner.next();
                System.out.println("\tport: " + curPort + " " +
                        curPort.getPortNumber());
            }
        }
        return null;
    }

}
