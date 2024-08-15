/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Eren
 */
public class Engel {

    private Integer engel_tip_id;
    private String engel_tip;

    public Engel(Integer engel_tip_id, String engel_tip) {
        this.engel_tip_id = engel_tip_id;
        this.engel_tip = engel_tip;
    }

    public Engel(String engel_tip) {
        this.engel_tip = engel_tip;
    }

    public Engel() {
    }

    public Integer getEngel_tip_id() {
        return engel_tip_id;
    }

    public void setEngel_tip_id(Integer engel_tip_id) {
        this.engel_tip_id = engel_tip_id;
    }

    public String getEngel_tip() {
        return engel_tip;
    }

    public void setEngel_tip(String engel_tip) {
        this.engel_tip = engel_tip;
    }

}
