/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import static Various.ErrorFinder.DetectError;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
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

    private String mesaj = "2";

    @Inject
    private TutanakGelirBean gelirBean;

    @Inject
    private TutanakBorcBean borcBean;

    public void GelirBorcEkle() {
        mesaj = gelirBean.getDao().getMesaj();
        try {
            gelirBean.tutanakGelirEkle();
            borcBean.create();
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
