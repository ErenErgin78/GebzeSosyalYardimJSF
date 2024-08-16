/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Eren
 */
public class Yardim {

    private Integer yardim_tip_id;
    private String yardim_tip;

    public Yardim(Integer yardim_tip_id, String yardim_tip) {
        this.yardim_tip_id = yardim_tip_id;
        this.yardim_tip = yardim_tip;
    }

    public Yardim(String yardim_tip) {
        this.yardim_tip = yardim_tip;
    }

    public Yardim() {
    }

    public Integer getYardim_tip_id() {
        return yardim_tip_id;
    }

    public void setYardim_tip_id(Integer yardim_tip_id) {
        this.yardim_tip_id = yardim_tip_id;
    }

    public String getYardim_tip() {
        return yardim_tip;
    }

    public void setYardim_tip(String yardim_tip) {
        this.yardim_tip = yardim_tip;
    }

}
