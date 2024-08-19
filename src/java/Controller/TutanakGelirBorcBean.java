/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import static Various.ErrorFinder.DetectError;
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

    private String mesaj;

    @Inject
    private TutanakGelirBean gelirBean;

    @Inject
    private TutanakBorcBean borcBean;

    public void GelirBorcEkle() {
        try {
            gelirBean.tutanakGelirEkle();
            borcBean.create();
            mesaj = gelirBean.getDao().getMesaj();
        } catch (Exception ex) {
            mesaj = DetectError(ex);
        }
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

}
