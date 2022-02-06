/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author windows
 */
public class Usuarios extends tipoUsuario{
    
    public Usuarios(String CED_USU, String NOM_USU, String APE_USU, String DIR_USU, String TEL_USU, float SAL_USU, int DES_USU, float CRE_USU) {
        this.CED_USU = CED_USU;
        this.NOM_USU = NOM_USU;
        this.APE_USU = APE_USU;
        this.DIR_USU = DIR_USU;
        this.TEL_USU = TEL_USU;
        this.SAL_USU = SAL_USU;
        this.DES_USU = DES_USU;
        this.CRE_USU = CRE_USU;
    }

    public Usuarios() {
    }

    public String getCED_USU() {
        return CED_USU;
    }

    public void setCED_USU(String CED_USU) {
        this.CED_USU = CED_USU;
    }

    public String getNOM_USU() {
        return NOM_USU;
    }

    public void setNOM_USU(String NOM_USU) {
        this.NOM_USU = NOM_USU;
    }

    public String getAPE_USU() {
        return APE_USU;
    }

    public void setAPE_USU(String APE_USU) {
        this.APE_USU = APE_USU;
    }

    public String getDIR_USU() {
        return DIR_USU;
    }

    public void setDIR_USU(String DIR_USU) {
        this.DIR_USU = DIR_USU;
    }

    public String getTEL_USU() {
        return TEL_USU;
    }

    public void setTEL_USU(String TEL_USU) {
        this.TEL_USU = TEL_USU;
    }

    public float getSAL_USU() {
        return SAL_USU;
    }

    public void setSAL_USU(float SAL_USU) {
        this.SAL_USU = SAL_USU;
    }

    public int getDES_USU() {
        return DES_USU;
    }

    public void setDES_USU(int DES_USU) {
        this.DES_USU = DES_USU;
    }

    public float getCRE_USU() {
        return CRE_USU;
    }

    public void setCRE_USU(float CRE_USU) {
        this.CRE_USU = CRE_USU;
    }
    
}
