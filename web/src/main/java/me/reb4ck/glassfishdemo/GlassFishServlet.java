package me.reb4ck.glassfishdemo;

import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import me.reb4ck.glassfishdemo.converter.UserEntityConverter;
import me.reb4ck.glassfishdemo.service.UserService;
import me.reb4ck.glassfishdemo.service.annotation.DBUserServiceQualifier;

import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@SuppressWarnings("all")
@WebServlet(name = "registerUser", value = "/register-user")
public final class GlassFishServlet extends HttpServlet {
    private static final String MESSAGE = "User successfully registered!";
    @Inject
    @DBUserServiceQualifier
    private UserService entityPersistenceService;
    @Inject
    private UserEntityConverter entityConverter;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + MESSAGE + "</h1>");
        out.println("</body></html>");

        entityPersistenceService.saveEntity(entityConverter.getUser(request, response).get());
    }
}