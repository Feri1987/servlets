package com.home.Utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Enumeration;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Denis
 */
public class ClassDoSometh {

    public static final String PATH = System.getProperty("catalina.base") + File.separator + "temp" + File.separator + "temp.txt";

    public void getRequestInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuilder builder = new StringBuilder();

        try (FileWriter writer = new FileWriter(PATH, false)) {
            response.getWriter().println("File directory: " + PATH);
            Enumeration<String> headers = request.getHeaderNames();
            while (headers.hasMoreElements()) {
                String header = headers.nextElement();
                builder.append(header)
                        .append(": ")
                        .append(request.getHeader(header))
                        .append("\n");
            }

            Enumeration<String> params = request.getParameterNames();
            while (params.hasMoreElements()) {
                String param = params.nextElement();
                builder.append("\n")
                        .append("Parameter ")
                        .append(param)
                        .append(": ")
                        .append(request.getParameter(param));
            }

            ServletContext servletContext = request.getServletContext();
            builder.append("\nRequestURL: ")
                    .append(request.getRequestURL().toString())
                    .append("\nRequestURI: ")
                    .append(request.getRequestURI())
                    .append("\nContextPath: ")
                    .append(request.getContextPath())
                    .append("\nServletPath: ")
                    .append(request.getServletPath())
                    .append("\nQueryString: ")
                    .append(request.getQueryString())
                    .append("\nServerName: ")
                    .append(request.getServerName())
                    .append("\nServerPort: ")
                    .append(request.getServerPort())
                    .append("\nRemoteAddr: ")
                    .append(request.getRemoteAddr())
                    .append("\nRemoteHost: ")
                    .append(request.getRemoteHost())
                    .append("\nRemotePort: ")
                    .append(request.getRemotePort())
                    .append("\nRemoteUser: ")
                    .append(request.getRemoteUser())
                    .append("\nRealPath: ")
                    .append(servletContext.getRealPath(""))
                    .append("\n");
            writer.write(builder.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Timestamp getTime() {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        return time;
    }

}
