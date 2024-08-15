/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Various;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

/**
 *
 * @author Eren
 */
public class ErrorFinder {

    public static String DetectError(Exception ex) {
        //Hatayı yakalamak için
        FacesContext context = FacesContext.getCurrentInstance();
        StringBuilder errorMessage = new StringBuilder(ex.getMessage());
        StackTraceElement[] stackTrace = ex.getStackTrace();

        //Hatanın hangi satırda olduğunu görmek için
        for (StackTraceElement element : stackTrace) {
            errorMessage.append(" (at ").append(element.getFileName())
                    .append(":").append(element.getLineNumber()).append(")");
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage.toString(), null));
        }
        return errorMessage.toString();
    }

}
