/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import static Various.ErrorFinder.DetectError;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import java.io.Serializable;

/**
 *
 * @author Administrator
 */
@Named(value = "yakinlarKaydetBean")
@SessionScoped
public class YakinlarKaydetBean implements Serializable {

    public YakinlarKaydetBean() {
    }

    private String mesaj;

    @Inject
    private KisiBean kisiBean;

    @Inject
    private KisiYakinlarBean kisiYakinlarBean;

    @Inject
    private KisiDetayBean kisiDetayBean;

    @Inject
    private EgitimDurumBean egitimDurumBean;
    
    @Inject
    private TutanakSosyalGuvenceBean tutanakSosyalGuvenceBean;
    
    @Inject
    private KisiEngelBean kisiEngelBean;
    
    @Inject
    private MeslekBean meslekBean;
}
