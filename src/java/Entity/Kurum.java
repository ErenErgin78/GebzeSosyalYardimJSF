/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author korog
 */
public class Kurum {
    private Integer kurum_id;
    private String kurum;

    public Integer getKurum_id() {
        return kurum_id;
    }

    public void setKurum_id(Integer kurum_id) {
        this.kurum_id = kurum_id;
    }

    public String getKurum() {
        return kurum;
    }

    public void setKurum(String kurum) {
        this.kurum = kurum;
    }

    public Kurum(Integer kurum_id, String kurum) {
        this.kurum_id = kurum_id;
        this.kurum = kurum;
    }

    public Kurum() {
    }
   
            
}
