/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import java.io.Serializable;

/**
 *
 * @author Eren
 */
@Named(value = "tutanakGelirBorcBean")
@SessionScoped
public class TutanakGelirBorcBean implements Serializable {

    public TutanakGelirBorcBean() {
    }

     @Inject
    private TutanakGelirBean gelirBean;

    @Inject
    private TutanakBorcBean borcBean;
    
    public void GelirBorcEkle(){
    gelirBean.tutanakGelirEkle();
    borcBean.create();
    }
}
